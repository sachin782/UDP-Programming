package udpprograms;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
public class ServerSort {
     public static void main(String args[])throws Exception
    {
        DatagramSocket ds = new DatagramSocket(4000); 
        byte buf[] = new byte[1024];
        DatagramPacket d1 = new DatagramPacket(buf,1024);   
        int a[] =  new int[10];
        String s1,s2;
        for(int i = 0;i<10;i++)
        {
            ds.receive(d1);
            s1 = new String(d1.getData(),0,d1.getLength()); 
            a[i] = Integer.parseInt(s1);
        }
        Arrays.sort(a);
        InetAddress ip = InetAddress.getLocalHost(); 
        for(int i=0;i<10;i++)
        {
          s2 = Integer.toString(a[i]);
          DatagramPacket d2 = new DatagramPacket(s2.getBytes(),s2.length(),ip,3000);
          ds.send(d2);
        }
        ds.close();  
        System.out.println("Process completed");
    }
}
