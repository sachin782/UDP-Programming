package udpprograms;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class ServerPalindrome {
    public static void main(String args[])throws Exception
    {
        DatagramSocket ds = new DatagramSocket(4000); 
        byte buf[] = new byte[1024];
        DatagramPacket d1 = new DatagramPacket(buf,1024);
        ds.receive(d1);  
        String s1= new String(d1.getData(), 0, d1.getLength()),s2="",s3;  
        char c;
        for(int i = s1.length()-1;i>=0;i--)
        {
            c = s1.charAt(i);
            s2 = s2 + c;
        }
        if(s2.equalsIgnoreCase(s1))
            s3 = "Palindrome";
        else
            s3= "Not Palindrome";
        InetAddress ip = InetAddress.getLocalHost();  
        DatagramPacket d2 = new DatagramPacket(s3.getBytes(),s3.length(),ip,3000);
        ds.send(d2);
        ds.close();  
        System.out.println("Process completed");
    }
}
