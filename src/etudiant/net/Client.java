package etudiant.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Eya Zaoui, RT2-1
 * 
 * This class defines a Java Client socket.
 * We create a socket and establish a connection with the Server.
 * 
 */

public class Client {
	private static int port = 59876; //same port as server program.
	   
    public PrintWriter pwSocket = null;
    public BufferedReader brSocket = null;
    private Socket socket = null;
    
   public Client() throws IOException{
	 //get the localhost IP address
       InetAddress serverAddress = InetAddress.getLocalHost();
       
     //establish socket connection to server
       socket = new Socket(serverAddress.getHostName(), port);
		
       
      //instantiating streams
			pwSocket = new PrintWriter(socket.getOutputStream());
			brSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
   
   public void endConnection() throws IOException {
	 //write to socket "Exit"
		pwSocket.println("Exit");
		pwSocket.flush();
		try {
			
			Thread.sleep(1000); //ensuring server reception
			
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		
    //close resources
		brSocket.close();
		pwSocket.close();
		socket.close();
   }


}
