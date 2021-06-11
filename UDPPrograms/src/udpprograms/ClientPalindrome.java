package udpprograms;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
public class ClientPalindrome {
    public static void main(String args[])throws Exception
    {
        DatagramSocket ds = new DatagramSocket(3000); 
        InetAddress ip = InetAddress.getLocalHost();  
        System.out.print("Enter string: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        DatagramPacket d1 = new DatagramPacket(s.getBytes(),s.length(),ip,4000);
        ds.send(d1);
        byte buf[] = new byte[1024];
        DatagramPacket d2 = new DatagramPacket(buf,1024);
        ds.receive(d2);  
        String str = new String(d2.getData(), 0, d2.getLength());  
        System.out.println("String "+s+" is "+str);
        ds.close();  
    }
}
