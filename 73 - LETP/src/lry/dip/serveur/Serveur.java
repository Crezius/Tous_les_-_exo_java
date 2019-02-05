package lry.dip.serveur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Serveur implements Runnable {
	
	/**************************** ATTRIBUT ****************************/

	private ServerSocket serveur;
	
	private Inet4Address ipServeur;
	
	private int portServeur;
	private int nbClient;
	

	private ArrayList<GestionSocketClient> tab_client = new ArrayList<>();
	
	/************************** CONSTRUCTEUR **************************/	
	
	public Serveur(int pPort, String pIP) {
		this.serveur 	= null;
		
		try {
			
			this.ipServeur 	= (Inet4Address) Inet4Address.getByName(pIP);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		this.portServeur 	= pPort;

	}
	
	/************************** GETTER/SETTER *************************/	
	
	public ServerSocket getServeur() {
		return serveur;
	}

	public void setServeur(ServerSocket serveur) {
		this.serveur = serveur;
	}

	public Inet4Address getIpServeur() {
		return ipServeur;
	}

	public void setIpServeur(Inet4Address ipServeur) {
		this.ipServeur = ipServeur;
	}

	public int getPortServeur() {
		return portServeur;
	}

	public void setPortServeur(int portServeur) {
		this.portServeur = portServeur;
	}


	/***************************** METHODE ****************************/	
	
	public void lancerServeur() {
        
        //On créé notre datagramme
        try {
        	
        	serveur = new ServerSocket( portServeur, 1, ipServeur);
        	
        	
        	System.out.println("Serveur lancé\nport : "+serveur.getLocalPort()+"\nadresse : "+ipServeur);

		} catch (Exception e) {
			
			portServeur++;
			
			if(portServeur < 3005) {
				lancerServeur();
			} else {
				e.printStackTrace();
			}
			// TODO Auto-generated catch block
		}
	}
	
	public void arreterServeur() {
		try {
			serveur.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void run() {
		
		lancerServeur();
		
		try {
			
			while(true) {
				Socket client = serveur.accept();
				
				ajouterClient(client);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void requeteClient(Echantillon echantillon) {
		
		if(echantillon.getType().equals(Echantillon.AJOUTER)) {
			
			if(PrincipaleServeurTCP.conn.ajouter(echantillon)){
				echantillon.setId(PrincipaleServeurTCP.conn.maxID());
				echantillon.setType(Echantillon.AJOUTER);
				envoyerTous(echantillon);
			}
			
		} else if(echantillon.getType().equals(Echantillon.SUPPRIMER)) {
			System.out.println("test Suppresion : "+echantillon.getType());
			if(PrincipaleServeurTCP.conn.supprimer(echantillon)){
				System.out.println("Suppression : "+echantillon.getId());
				echantillon.setType(Echantillon.SUPPRIMER);
				envoyerTous(echantillon);
			}
		}	
	}
	

	
	public void ajouterClient(Socket client) {		
		
		try {	
						
			ObjectOutputStream fluxOut = new ObjectOutputStream(client.getOutputStream());
			
			
			ObjectInputStream fluxIn = new ObjectInputStream(client.getInputStream());
			
			tab_client.add(new GestionSocketClient(client, nbClient++, (Inet4Address) client.getInetAddress(), client.getPort(), fluxOut, fluxIn, this));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void supprimerClient() {
		
		for(GestionSocketClient client : tab_client) client.deconnecter();
		
	}
	
	
	public void envoyerTous(Echantillon echantillon) {
		
		for(GestionSocketClient client : tab_client) {
			client.envoiReponse(echantillon);
		}
		
	}
	
	
	
	public void afficher() {
		System.out.println(toString());
	}


}
