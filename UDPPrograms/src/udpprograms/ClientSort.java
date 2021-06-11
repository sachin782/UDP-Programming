package udpprograms;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
public class ClientSort {
    public static void main(String args[])throws Exception
    {
         DatagramSocket ds = new DatagramSocket(3000); 
        InetAddress ip = InetAddress.getLocalHost();  
        Scanner sc = new Scanner(System.in);
        int a [] = new int[10];
        int b [] = new int[10];
        String s1,s2;
        System.out.println("Enter array: ");
        for(int i = 0;i < 10;i++)
        {
            a[i] = sc.nextInt();
            s1 = Integer.toString(a[i]);
            DatagramPacket d1 = new DatagramPacket(s1.getBytes(),s1.length(),ip,4000);
            ds.send(d1);
        }      
        byte buf[] = new byte[1024];
        DatagramPacket d2 = new DatagramPacket(buf,1024);
        for(int i = 0;i<10;i++)
        {
         ds.receive(d2);  
         s2= new String(d2.getData(),0,d2.getLength()); 
         b[i] = Integer.parseInt(s2);
        }
        System.out.println("Sorted array:");
        for(int i = 0;i < 10;i++)
            System.out.print(b[i]+"\t");
        System.out.println();
        ds.close();  
    }
}
