package udpprograms;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
public class ClientReverse {
     public static void main(String args[])throws Exception
    {
        DatagramSocket ds = new DatagramSocket(3000); 
        InetAddress ip = InetAddress.getLocalHost();  
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        String s1 = Integer.toString(n);
        DatagramPacket d1 = new DatagramPacket(s1.getBytes(),s1.length(),ip,4000);
        ds.send(d1);
        byte buf[] = new byte[1024];
        DatagramPacket d2 = new DatagramPacket(buf,1024);
        ds.receive(d2);  
        String s2= new String(d2.getData(), 0, d2.getLength()); 
        int r = Integer.parseInt(s2);  
        System.out.println("Reverse of  "+n+" is "+r);
        ds.close();  
    }
}
