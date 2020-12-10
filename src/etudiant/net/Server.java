package etudiant.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Eya Zaoui, RT2-1
 * 
 * This class defines a Java Server socket.
 * 
 *
 */

public class Server  {
    
    //static ServerSocket variable
    private static ServerSocket serverSock;
    //socket server port on which it will listen
    private static int port = 59876;
    
    private Connection con;
    private PreparedStatement statement;
    private ResultSet result;
    
    
    public static void main(String args[]) throws IOException, SQLException {
    	String message = "";
    	String response ="";
    	String sql = "";
        PrintWriter pwSocket = null;
        BufferedReader brSocket = null;
        Server mserver = new Server();
        Etudiant et = null ;
		

        //create the server socket and client socket objects
        serverSock = new ServerSocket(port);
        Socket clientSocket = null;
        
        //initiating database connection
        System.out.println("Base de donnees des etudiants:");
        try {
			mserver.mySQLAcess();
		}  catch (SQLException e1) {
		    System.out.println("Echec de connexion a la base de donnee.");
		    System.out.println(e1);
		    return;
		}
        
        
		//waiting for client connection
		    System.out.println("Attente de connexion...");
            clientSocket = serverSock.accept();
            System.out.println("Un client s'est connecté.");
            
            
        //instantiating streams
            try {
    			pwSocket = new PrintWriter(clientSocket.getOutputStream());
    			brSocket = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    		} catch (IOException e) {
    		    System.out.println(e);
    		    return;
    		}
			
          //keeps listening until receiving 'exit' call or program terminates
			message = brSocket.readLine();
            while (!message.equalsIgnoreCase("exit")) {
            	
            	// look for student by ID number
				System.out.println("ID Reçu: " + message);
				sql = "select * from etudiant where id = "+message;
				mserver.statement = mserver.con.prepareStatement(sql);
		 	    mserver.result = mserver.statement.executeQuery();
		 	    
		 	    if(mserver.result.next()) {
		 	    	
					System.out.println("Une correspondance est trouvée.");
		 	    	et = new Etudiant(mserver.result.getInt(1),mserver.result.getString(2),
		 	    			mserver.result.getDate(3).toString(),mserver.result.getString(4),
		 	    			mserver.result.getString(5),mserver.result.getString(6));
		 	    	response = et.toString();
		 	    	
		 	    } else {
		 	    	response = "Pas de resultat.";
					System.out.println(response);
		 	    }
				
				pwSocket.println(response);
				pwSocket.flush();
				
				message = brSocket.readLine();
			}
            
		//close the connection
	    System.out.println("Arrêt du serveur.");
		brSocket.close();
        pwSocket.close();
        clientSocket.close();
        serverSock.close();
    }
    
    
    private void mySQLAcess() throws SQLException {
    	//Accessing mySql database running on localhost:3306
    	 String dbUrl = "jdbc:mysql://localhost:3306/";
    	 String dbName = "etudiants";
    	 String dbUsername = "root";
    	 String dbPassword = ""; //no password by default
    	 
    	 //Making connection with the DB and setting Timezone for Date fetching.
    	 try {
			this.con = DriverManager.getConnection(dbUrl+dbName+"?serverTimezone=UTC",dbUsername,
					 dbPassword);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Verifier que votre MySql Server est ACTIF.");
			System.out.println("Verifiez que vous avez importer la BD sur votre MySql server avec "
					+ "les URL, username et mot de passe appropriés.");
			System.out.println("Verifier que vous avez mysql-connector-javaxx dans le Build Path "
					+ "(voir READ_ME.txt)");
			System.exit(0);
			return;
		}
    	 
    	 this.statement = con.prepareStatement("select * from etudiant");
    	 this.result = statement.executeQuery();
    	 
    	 //Database content
    	 while(result.next()) {
    		 System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getDate(3)+" "
    				 +result.getString(4)+" "+result.getString(5)+" "+result.getString(6));
    	 }
    	 

    }
    
}