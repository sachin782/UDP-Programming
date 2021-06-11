package udpprograms;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
public class DSender{  
  public static void main(String[] args) throws Exception {  
    DatagramSocket ds = new DatagramSocket(); 
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter message");
    String str = sc.nextLine();  
    InetAddress ip = InetAddress.getLocalHost();    
    DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 3000);  
    ds.send(dp);
    System.out.println("Packet sent  successfully.");
    ds.close();  
  }  
}  
