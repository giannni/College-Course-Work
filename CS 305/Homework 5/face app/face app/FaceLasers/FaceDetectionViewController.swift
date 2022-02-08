import AVFoundation
import UIKit
import Vision

class FaceDetectionViewController: UIViewController
{
  var sequenceHandler = VNSequenceRequestHandler()

  @IBOutlet var faceView: FaceView!
  @IBOutlet var laserView: LaserView!
  @IBOutlet var faceLaserLabel: UILabel!
  
  let session = AVCaptureSession()
  var previewLayer: AVCaptureVideoPreviewLayer!
  
  let dataOutputQueue = DispatchQueue(label: "video data queue", qos: .userInitiated, attributes: [], autoreleaseFrequency: .workItem)

  var faceViewHidden = false
  
  var maxX: CGFloat = 0.0
  var midY: CGFloat = 0.0
  var maxY: CGFloat = 0.0

  override func viewDidLoad()
  {
    super.viewDidLoad()
    configureCaptureSession()
    
    laserView.isHidden = true
    
    maxX = view.bounds.maxX
    midY = view.bounds.midY
    maxY = view.bounds.maxY
    
    session.startRunning()
  }
}

// MARK: - Gesture methods

extension FaceDetectionViewController
{
  @IBAction func handleTap(_ sender: UITapGestureRecognizer)
  {
    faceView.isHidden.toggle()
    laserView.isHidden.toggle()
    faceViewHidden = faceView.isHidden
    
    if faceViewHidden
    {
      faceLaserLabel.text = "Lasers"
    } else {
      faceLaserLabel.text = "Face"
    }
  }
}

// MARK: - Video Processing methods

extension FaceDetectionViewController
{
  func configureCaptureSession()
  {
    // Define the capture device we want to use
    guard let camera = AVCaptureDevice.default(.builtInWideAngleCamera, for: .video, position: .front)
    else
    {
      fatalError("No front video camera available")
    }
    
    do {
      let cameraInput = try AVCaptureDeviceInput(device: camera)
      session.addInput(cameraInput)
    } catch {
      fatalError(error.localizedDescription)
    }
  
    let videoOutput = AVCaptureVideoDataOutput()
    videoOutput.setSampleBufferDelegate(self, queue: dataOutputQueue)
    videoOutput.videoSettings = [kCVPixelBufferPixelFormatTypeKey as String: kCVPixelFormatType_32BGRA]
    
    session.addOutput(videoOutput)
    
    let videoConnection = videoOutput.connection(with: .video)
    videoConnection?.videoOrientation = .portrait
    
    previewLayer = AVCaptureVideoPreviewLayer(session: session)
    previewLayer.videoGravity = .resizeAspectFill
    previewLayer.frame = view.bounds
    view.layer.insertSublayer(previewLayer, at: 0)
  }
}

// MARK: - AVCaptureVideoDataOutputSampleBufferDelegate methods

extension FaceDetectionViewController: AVCaptureVideoDataOutputSampleBufferDelegate
{
  func captureOutput(_ output: AVCaptureOutput, didOutput sampleBuffer: CMSampleBuffer, from connection: AVCaptureConnection)
  {
    guard let imageBuffer = CMSampleBufferGetImageBuffer(sampleBuffer) else
    {
      return
    }

    let detectFaceRequest = VNDetectFaceLandmarksRequest(completionHandler: detectedFace)

    do
    {
      try sequenceHandler.perform([detectFaceRequest],on: imageBuffer,orientation: .leftMirrored)
    }
    catch
    {
      print(error.localizedDescription)
    }
  }
}

extension FaceDetectionViewController
{
  func convert(rect: CGRect) -> CGRect
  {
    let origin = previewLayer.layerPointConverted(fromCaptureDevicePoint: rect.origin)

    let size = previewLayer.layerPointConverted(fromCaptureDevicePoint: rect.size.cgPoint)

    return CGRect(origin: origin, size: size.cgSize)
  }

  func landmark(point: CGPoint, to rect: CGRect) -> CGPoint
  {
    let absolute = point.absolutePoint(in: rect)

    let converted = previewLayer.layerPointConverted(fromCaptureDevicePoint: absolute)

    return converted
  }

  func landmark(points: [CGPoint]?, to rect: CGRect) -> [CGPoint]?
  {
    guard let points = points else {
      return nil
    }

    return points.compactMap { landmark(point: $0, to: rect) }
  }
  
  func updateFaceView(for result: VNFaceObservation) {
    defer {
      DispatchQueue.main.async {
        self.faceView.setNeedsDisplay()
      }
    }

    let box = result.boundingBox
    faceView.boundingBox = convert(rect: box)

    guard let landmarks = result.landmarks else {
      return
    }

    if let leftEye = landmark(
      points: landmarks.leftEye?.normalizedPoints,
      to: result.boundingBox) {
      faceView.leftEye = leftEye
    }

    if let rightEye = landmark(
      points: landmarks.rightEye?.normalizedPoints,
      to: result.boundingBox) {
      faceView.rightEye = rightEye
    }

    if let leftEyebrow = landmark(
      points: landmarks.leftEyebrow?.normalizedPoints,
      to: result.boundingBox) {
      faceView.leftEyebrow = leftEyebrow
    }

    if let rightEyebrow = landmark(
      points: landmarks.rightEyebrow?.normalizedPoints,
      to: result.boundingBox) {
      faceView.rightEyebrow = rightEyebrow
    }

    if let nose = landmark(
      points: landmarks.nose?.normalizedPoints,
      to: result.boundingBox) {
      faceView.nose = nose
    }

    if let outerLips = landmark(
      points: landmarks.outerLips?.normalizedPoints,
      to: result.boundingBox) {
      faceView.outerLips = outerLips
    }

    if let innerLips = landmark(
      points: landmarks.innerLips?.normalizedPoints,
      to: result.boundingBox) {
      faceView.innerLips = innerLips
    }

    if let faceContour = landmark(
      points: landmarks.faceContour?.normalizedPoints,
      to: result.boundingBox) {
      faceView.faceContour = faceContour
    }
  }

  func updateLaserView(for result: VNFaceObservation)
  {
    laserView.clear()
    let yaw = result.yaw ?? 0.0
    if yaw == 0.0
    {
      return
    }

    var origins: [CGPoint] = []

    if let point = result.landmarks?.leftPupil?.normalizedPoints.first
    {
      let origin = landmark(point: point, to: result.boundingBox)
      origins.append(origin)
    }

    if let point = result.landmarks?.rightPupil?.normalizedPoints.first
    {
      let origin = landmark(point: point, to: result.boundingBox)
      origins.append(origin)
    }

    let avgY = origins.map { $0.y }.reduce(0.0, +) / CGFloat(origins.count)
    let focusY = (avgY < midY) ? 0.75 * maxY : 0.25 * maxY
    let focusX = (yaw.doubleValue < 0.0) ? -100.0 : maxX + 100.0
    let focus = CGPoint(x: focusX, y: focusY)
    
    for origin in origins
    {
      let laser = Laser(origin: origin, focus: focus)
      laserView.add(laser: laser)
    }
    
    DispatchQueue.main.async
    {
      self.laserView.setNeedsDisplay()
    }
  }

  func detectedFace(request: VNRequest, error: Error?)
  {
    guard
      let results = request.results as? [VNFaceObservation],
      let result = results.first
    else
    {
        faceView.clear()
        return
    }

    if faceViewHidden
    {
      updateLaserView(for: result)
    }
    else
    {
      updateFaceView(for: result)
    }
  }
}
