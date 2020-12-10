package etudiant.net;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*; 


/**
 * @author Eya Zaoui, RT2-1
 * 
 * This class implements a Client UI program. 
 * Here, we handle validity of user input and create User Interface.
 * The connection establishment and termination with the server is defined in Client class.
 * 
 */

public class ClientUI extends JFrame implements ActionListener {
	
	//UI Preparation
	
	private static final long serialVersionUID = 1L;
	
	
		JButton sendBtn;  
	    JLabel l1,l2;
	    JTextArea txt;
	    JTextField tf;
		Client client;
		
		ClientUI(String s){
			super(s);
			setLayout(null);  
			setVisible(true);
	        setSize(600,350); 
	        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			sendBtn=new JButton("Envoyer");  
	        sendBtn.setBounds(250,240,100,30);  
	        sendBtn.addActionListener(this);
	        add(sendBtn);  
	        l1=new JLabel("Bonjour. " + 
	        		"Si vous voulez quitter, terminez la connexion d'abord en tapant \"Exit\". ");
	        l1.setBounds(50, 50,500,20 );
	        l2= new JLabel("Entrez un ID d'etudiant (un numero de 7 chiffres):");
	        l2.setBounds(50, 70, 500, 20);
	        add(l1); add(l2);
	        txt = new JTextArea();
	        txt.setBounds(50, 130, 500, 100);
	        txt.setWrapStyleWord(true);
	        txt.setLineWrap(true);
	        txt.setEditable(false);
	        add(txt);
	        tf=new JTextField();  
	        tf.setBounds(50,100,500,20);
	        tf.setBorder(BorderFactory.createLineBorder(Color.black));
	        add(tf);
	        
	        //creating a Client and connecting to Server
	        try {
	        	
				client = new Client();
				
			} catch (IOException e) {
				txt.setText("Verifier que le serveur est en marche.\nVous pouvez quitter.");
				System.out.println(e);
				sendBtn.setEnabled(false);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			}
			
			
		}

		public static void main(String[] args) {
			
			new ClientUI("Programme Client"); //launching program
			
		}

		
		//defining send Button action:
		
		@SuppressWarnings("unused")
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Handle input format:
			
			int id=0; 
			String request = tf.getText();	
			String resultStr = "";
			if (!request.equalsIgnoreCase("exit")) {
				
				if (request == null || request.length() != 7) {
					
					resultStr = "Requete invalide.";
					
				} else {
					
					try {
						id = Integer.parseInt(request);
					} catch (NumberFormatException ex) {
						txt.setText("Requete invalide.");
						return;
					}
					
					//If valid, write to socket :
					client.pwSocket.println(request);
					client.pwSocket.flush();
					
					//Read the server response :
					try {
						resultStr = client.brSocket.readLine();
					} catch (IOException e1) {
						System.out.println(e1);
						txt.setText("Une erreur est survenue.");
						return;
					}
				}
				
				
				txt.setText("Resultat: "+ resultStr);
				
				
			} else {
				//Closing connection:
				
				txt.setText("Fin de connexion. Vous pouvez quitter.");
				
				try {
					
					client.endConnection(); 
					
				} catch (IOException e1) {
					
					System.out.println(e1);
					txt.setText("Une erreur est survenue.");
					
				}
				
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
				sendBtn.setEnabled(false);
		        
			}
		}

	


}
