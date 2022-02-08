import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.util.TimerTask;
import java.util.Timer;

public class StreamPacket 
{ 
	DatagramPacket dgram;
    DatagramSocket dgramSock;
    Timer transmitTimer; 
    int pktNo;

    public StreamPacket() {}

    public StreamPacket(DatagramSocket ds, int port, byte buf[], 
                            InetAddress ip, int pktNo) 
    {
        dgramSock = ds;
        this.pktNo = pktNo;
	    dgram = new DatagramPacket(buf, buf.length, ip, port); 
    }

    public void TransmitPacket() throws IOException
    {
	    dgramSock.send(dgram); 
    }

    public void RetransmitPacket() throws IOException
    {
	    dgramSock.send(dgram); 
    }

    class TransmitTimerTask extends TimerTask 
    {
        public void run() 
        { 
            try {
                RetransmitPacket();
            }
            catch (IOException e) {
                System.out.println("Packet " + pktNo + " failed on retransmit");
            }
        }
    }

    public void StartTransmitTimer () throws IOException 
    {
        TimerTask task = new TransmitTimerTask();
        transmitTimer = new Timer("Timer");

        long delay = 1000L;
        transmitTimer.schedule(task, delay);
    }

    public void CancelTransmitTimer() {
        transmitTimer.cancel(); 
    }
} 
