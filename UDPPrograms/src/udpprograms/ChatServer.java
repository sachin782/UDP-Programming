package udpprograms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class ChatServer {
    public static void main(String args[])throws Exception
    {
        DatagramSocket d = new DatagramSocket(4000); 
        InetAddress ip = InetAddress.getLocalHost();  
        BufferedReader br =new BufferedReader (new InputStreamReader(System.in));
        String str1="",str2="";
        while(!str2.equals("stop"))
        {
         System.out.print("Server:");
         str1 = br.readLine();
         DatagramPacket ds = new DatagramPacket(str1.getBytes(),str1.length(),ip,3000);
         d.send(ds);
         byte buf[] = new byte[1024];
         DatagramPacket dr = new DatagramPacket(buf,1024);
         d.receive(dr);  
         str2 = new String(dr.getData(), 0, dr.getLength());  
         System.out.println("Client:"+str2);         
        }
        d.close();      
    }
}
