package udpprograms;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;
import java.util.Scanner;
public class ServerTime {
    public static void main(String[] args) throws Exception {  
    DatagramSocket ds = new DatagramSocket(); 
    Scanner sc = new Scanner(System.in);
    String em = "";
    System.out.println("Press Enter to get system date and time.");
    em = sc.nextLine();
    String str = new Date().toString();
    InetAddress ip = InetAddress.getLocalHost();  
    DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 4000);  
    ds.send(dp);
    System.out.println("Process completed  successfully.");
    ds.close();  
  }  
}
