package lry.dip.clientUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;

public class ClientSocketUDP {

	
	/**************************** ATTRIBUT ****************************/
	
	private Inet4Address ipServeur;
	private Inet4Address ipClient;
	
	private int portServeur;
	private int portClient;
	
	private DatagramSocket clientSocket;
	private DatagramPacket dataSend;
	private DatagramPacket dataRec;
	
	private byte[] bufferSend;
	private byte[] bufferRec;
		
	/************************** CONSTRUCTEUR **************************/	

	public ClientSocketUDP() {
	}

	/************************** GETTER/SETTER *************************/	
	
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

	public DatagramSocket getClientSocket() {
		return clientSocket;
	}

	public void setClientSocket(DatagramSocket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public DatagramPacket getDataSend() {
		return dataSend;
	}

	public void setDataSend(DatagramPacket dataSend) {
		this.dataSend = dataSend;
	}

	public DatagramPacket getDataRec() {
		return dataRec;
	}

	public void setDataRec(DatagramPacket dataRec) {
		this.dataRec = dataRec;
	}

	public byte[] getBufferSend() {
		return bufferSend;
	}

	public void setBufferSend(byte[] bufferSend) {
		this.bufferSend = bufferSend;
	}

	public byte[] getBufferRec() {
		return bufferRec;
	}

	public void setBufferRec(byte[] bufferRec) {
		this.bufferRec = bufferRec;
	}
	
	/***************************** METHODE ****************************/	
	
	public void envoyerRequete(String message, int pPort, String pId) {
		
		try {
			
			System.out.println("envoyer");
			clientSocket = new DatagramSocket(2000);
		
			bufferSend = message.getBytes();
	
	        //On crée notre datagramme
	
        	ipServeur = (Inet4Address) Inet4Address.getByName(pId);
	
	        dataSend = new DatagramPacket(bufferSend, bufferSend.length, ipServeur, pPort); 
	
	        //On lui affecte les données à envoyer
	
	        dataSend.setData(bufferSend);

	        //On envoie au serveur
	
	        clientSocket.send(dataSend);
	        
	        clientSocket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void recevoirReponse() {
 
		try {
			
			System.out.println("recevoir");

		   //Création de la connexion côté serveur, en spécifiant un port d'écoute
	
			clientSocket = new DatagramSocket(3000);             
			      //On s'occupe maintenant de l'objet paquet
	
		      bufferRec = new byte[8192];
	
		      dataRec = new DatagramPacket(bufferRec, bufferRec.length);
	
	
		      clientSocket.receive(dataRec);
	
		      System.out.println("Reçu de la part de " + dataRec.getAddress() 
	
		                        + " sur le port " + dataRec.getPort() + " : ");

		   
	
		} catch (SocketException e) {
		   e.printStackTrace();
	
		} catch (IOException e) {
		
		   e.printStackTrace();
	
		}
		
	    clientSocket.close();


	}
	
	

}
