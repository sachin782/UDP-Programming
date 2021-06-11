package udpprograms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class ChatClient {
    public static void main(String args[])throws Exception
    {
        DatagramSocket d = new DatagramSocket(3000); 
        InetAddress ip = InetAddress.getLocalHost();  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1="",str2="";
        while(!str1.equals("stop"))
        {
          byte buf[]=new byte[1024];
          DatagramPacket dp = new DatagramPacket(buf, buf.length);
          d.receive(dp);
          str1 = new String(dp.getData(), 0, dp.getLength());
          System.out.println("Server:"+str1);
          System.out.print("Client:");
          str2 = br.readLine();
          InetAddress address = InetAddress.getLocalHost();
          DatagramPacket dr = new DatagramPacket(str2.getBytes(), str2.length(), address, 4000);
          d.send(dr);
         }
        d.close();
    }
}
