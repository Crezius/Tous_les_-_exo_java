package lry.dip.tcp.serveur;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
	
	/**************************** ATTRIBUT ****************************/

	private ServerSocket serveur;
	
	private Inet4Address ipServeur;
	private Inet4Address ipClient;
	
	private int portServeur;
	private int portClient;
	
	private OutputStream fluxOut;
	private InputStream	 fluxIn;
	
	private PrintWriter reponse;
	
	private Socket client;

	private InputStreamReader fluxInReader;
	private BufferedReader bufferedReader;

	
	/************************** CONSTRUCTEUR **************************/	
	
	public Serveur() {
		this.serveur 	= null;
		this.ipServeur 	= null;
		this.ipClient 	= null;
		this.portClient = 0;
		this.portServeur 	= 0;
		this.fluxOut 	= null;
		this.fluxIn		= null;
		this.reponse	= null;
		this.client		= null;
		this.fluxInReader	= null;
		this.bufferedReader	= null;
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

	public Inet4Address getIpClient() {
		return ipClient;
	}

	public void setIpClient(Inet4Address ipClient) {
		this.ipClient = ipClient;
	}

	public int getPortServeur() {
		return portServeur;
	}

	public void setPortServeur(int portServeur) {
		this.portServeur = portServeur;
	}

	public int getPortClient() {
		return portClient;
	}

	public void setPortClient(int portClient) {
		this.portClient = portClient;
	}

	public OutputStream getFluxOut() {
		return fluxOut;
	}

	public void setFluxOut(OutputStream fluxOut) {
		this.fluxOut = fluxOut;
	}

	public InputStream getFluxIn() {
		return fluxIn;
	}

	public void setFluxIn(InputStream fluxIn) {
		this.fluxIn = fluxIn;
	}

	public PrintWriter getReponse() {
		return reponse;
	}

	public void setReponse(PrintWriter reponse) {
		this.reponse = reponse;
	}

	public Socket getClient() {
		return client;
	}

	public void setClient(Socket client) {
		this.client = client;
	}

	public InputStreamReader getFluxInReader() {
		return fluxInReader;
	}

	public void setFluxInReader(InputStreamReader fluxInReader) {
		this.fluxInReader = fluxInReader;
	}

	public BufferedReader getBufferedReader() {
		return bufferedReader;
	}

	public void setBufferedReader(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}

	/***************************** METHODE ****************************/	
	
	public void lancerServeur(int pPort, String pIP) {
        
        //On crée notre datagramme
        try {
        	portServeur = pPort;
        	
        	ipServeur = (Inet4Address) Inet4Address.getByName(pIP);
        	
        	serveur = new ServerSocket( portServeur, 1 , ipServeur);
        	
        	
        	System.out.println("Serveur lancé\nport : "+serveur.getLocalPort()+"\nadresse : "+ipServeur);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public void envoyerReponse(String message) {
       
		this.reponse.println(message);
					
	}
	
	public void recevoirRequete() {		
		String data;
		
		try {	
			
			fluxOut = client.getOutputStream();
			
			reponse = new PrintWriter(this.client.getOutputStream(), true);
			
			fluxIn = client.getInputStream();
			
			fluxInReader = new InputStreamReader(fluxIn);
			
			bufferedReader = new BufferedReader(fluxInReader);
			
			while((data = bufferedReader.readLine()) != null) {
				System.out.println(data);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void afficher() {
		System.out.println(toString());
	}
	
	public void deconnecter() {
		try {
			client.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void attendreClient() {
		try {
			System.out.println("Attente d'un client");
			client = serveur.accept();
			
			System.out.println(client.getInetAddress()+" s'est connecté");
			
        	ipClient = (Inet4Address) Inet4Address.getByName(client.getInetAddress().getHostAddress());
			
        	recevoirRequete();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
