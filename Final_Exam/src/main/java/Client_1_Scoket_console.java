
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.net.UnknownHostException;


public class Client_1_Scoket_console 
{
    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException, ClassNotFoundException 
    {
        Scanner scanner = new Scanner(System.in);
         String serverAddress = "172.31.31.142";
        
       InetAddress host=InetAddress.getLocalHost();
       Socket socket=null;
       ObjectOutputStream oos=null;
       ObjectInputStream ois=null;
       
       
       
       for(int i=0;i>-1;i++)
       {
           socket=new Socket(serverAddress,8873);
           oos=new ObjectOutputStream (socket.getOutputStream());
           System.out.println("Sending message to socket server ");
           
         
                System.out.print("Enter your message For Server : ");
                String message = scanner.nextLine();
               
                oos.writeObject("Client 1 "+message );
                 if("exit".equals(message))
                {
                    break;
                }
               
           
           
           
           ois=new ObjectInputStream (socket.getInputStream());
           String receivedMessage = (String) ois.readObject();
           System.out.println("Message " + receivedMessage);
           
        
       }
          ois.close();
          oos.close();
          Thread.sleep(1000);       
        
        
    }
}
