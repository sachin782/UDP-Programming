package udpprograms;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class ServerReverse {
     public static void main(String args[])throws Exception
    {
        DatagramSocket ds = new DatagramSocket(4000); 
        byte buf[] = new byte[1024];
        DatagramPacket d1 = new DatagramPacket(buf,1024);
        ds.receive(d1);  
        String s1= new String(d1.getData(), 0, d1.getLength()),s2;  
        int n = Integer.parseInt(s1);
        int r = 0;
        while(n != 0)
        {
           r = (r * 10) + (n % 10); 
           n = n / 10; 
        }
        s2 = Integer.toString(r);
        InetAddress ip = InetAddress.getLocalHost();  
        DatagramPacket d2 = new DatagramPacket(s2.getBytes(),s2.length(),ip,3000);
        ds.send(d2);
        ds.close();  
        System.out.println("Process completed");
    }
}
