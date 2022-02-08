//
//  ViewController.swift
//  location
//
//  Created by g on 2/17/20.
//  Copyright © 2020 Gianni Esposito. All rights reserved.
//

import UIKit
import CoreLocation
import MapKit
let manager = CLLocationManager()
class ViewController: UIViewController, CLLocationManagerDelegate
{
    @IBOutlet weak var latitude: UILabel!
    @IBOutlet weak var longitude: UILabel!
    @IBOutlet weak var mapView: MKMapView!
    
    @IBOutlet weak var romanoButton: UIButton!
    @IBOutlet weak var commonsButton: UIButton!
    @IBOutlet weak var villageButton: UIButton!
    @IBOutlet weak var athleticComplex: UIButton!
    
    override func viewDidLoad()
    {
        super.viewDidLoad()
        romanoButton.layer.cornerRadius = 8
        commonsButton.layer.cornerRadius = 8
        villageButton.layer.cornerRadius = 8
        athleticComplex.layer.cornerRadius = 8
        manager.delegate = self
        manager.desiredAccuracy = kCLLocationAccuracyNearestTenMeters
        manager.requestWhenInUseAuthorization()
        /* update one time
        manager.requestLocation() */
        //update all the time
        manager.startUpdatingLocation()
        setUpMapView()
    }
    
    func locationManager(_ manager: CLLocationManager, didUpdateLocations locations: [CLLocation])
    {
        //uses your location
        if let location = locations.first
        {
            latitude.text = "Latitude: " + "\(location.coordinate.latitude)"
            longitude.text = "Longitude: " + "\(location.coordinate.longitude)"
            latitude.adjustsFontSizeToFitWidth = true
            longitude.adjustsFontSizeToFitWidth = true
        }
    }
    
    @IBAction func setRomano(_ sender: Any)
    {
        let location = CLLocationCoordinate2D(latitude: 41.041601, longitude: -73.936839)
        let span = MKCoordinateSpan(latitudeDelta: 0.001, longitudeDelta: 0.001)
        let region = MKCoordinateRegion(center: location, span: span)
        mapView.setRegion(region, animated: true)
        let annotation = MKPointAnnotation()
        annotation.coordinate = location
        annotation.title = "Romano Center"
        mapView.addAnnotation(annotation)
        mapView.mapType = .satellite
        latitude.text = "Latitude: " + "\(location.latitude)"
        longitude.text = "Longitude: " + "\(location.longitude)"
        latitude.adjustsFontSizeToFitWidth = true
        longitude.adjustsFontSizeToFitWidth = true
    }
    
    @IBAction func setCommons(_ sender: Any)
    {
        let location = CLLocationCoordinate2D(latitude: 41.040608, longitude: -73.937851)
        let span = MKCoordinateSpan(latitudeDelta: 0.001, longitudeDelta: 0.001)
        let region = MKCoordinateRegion(center: location, span: span)
        mapView.setRegion(region, animated: true)
        let annotation = MKPointAnnotation()
        annotation.coordinate = location
        annotation.title = "McNelis Commons"
        mapView.addAnnotation(annotation)
        mapView.mapType = .satellite
        latitude.text = "Latitude: " + "\(location.latitude)"
        longitude.text = "Longitude: " + "\(location.longitude)"
        latitude.adjustsFontSizeToFitWidth = true
        longitude.adjustsFontSizeToFitWidth = true
    }
    
    @IBAction func setVillage(_ sender: Any)
    {
        let location = CLLocationCoordinate2D(latitude: 41.043571, longitude: -73.938123)
        let span = MKCoordinateSpan(latitudeDelta: 0.001, longitudeDelta: 0.001)
        let region = MKCoordinateRegion(center: location, span: span)
        mapView.setRegion(region, animated: true)
        let annotation = MKPointAnnotation()
        annotation.coordinate = location
        annotation.title = "Aquinas Village"
        mapView.addAnnotation(annotation)
        mapView.mapType = .satellite
        latitude.text = "Latitude: " + "\(location.latitude)"
        longitude.text = "Longitude: " + "\(location.longitude)"
        latitude.adjustsFontSizeToFitWidth = true
        longitude.adjustsFontSizeToFitWidth = true
    }
    
    @IBAction func setAthletic(_ sender: Any)
    {
        let location = CLLocationCoordinate2D(latitude: 41.036860, longitude: -73.932690)
        let span = MKCoordinateSpan(latitudeDelta: 0.001, longitudeDelta: 0.001)
        let region = MKCoordinateRegion(center: location, span: span)
        mapView.setRegion(region, animated: true)
        let annotation = MKPointAnnotation()
        annotation.coordinate = location
        annotation.title = "Spartan Field"
        mapView.addAnnotation(annotation)
        mapView.mapType = .satellite
        latitude.text = "Latitude: " + "\(location.latitude)"
        longitude.text = "Longitude: " + "\(location.longitude)"
        latitude.adjustsFontSizeToFitWidth = true
        longitude.adjustsFontSizeToFitWidth = true
    }
    
    func locationManager(_ manager: CLLocationManager, didFailWithError error: Error) {
        print("Failed to find users location: \(error.localizedDescription)")
    }
    
    func setUpMapView()
    {
        mapView.showsUserLocation = true
        mapView.isZoomEnabled = true
        mapView.showsScale = true
    }
}

