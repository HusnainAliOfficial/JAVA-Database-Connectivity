
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;




public class Server_1_Socket_Console 
{
    public static ServerSocket server;
    public static int port=8870;
    

    public static void main(String[] args) throws IOException, ClassNotFoundException 
    {
        server=new  ServerSocket(port);
      
        while(true)
        {
              System.out.println("Waiting for client request");
              Socket socket=server.accept();
              
              
              ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
              String message=(String) ois.readObject();
              System.out.println("Message recived  : "+message);
              
              
              
              ObjectOutputStream oos =new ObjectOutputStream(socket.getOutputStream());
              oos.writeObject("Server recived : "+message);
              
              ois.close();
              oos.close();
              socket.close();
              if(message.equalsIgnoreCase("exit"))
              {
                  break;
              }
        }
        System.out.println("Shutting down socket server !");
        server.close();
        
    }
}

