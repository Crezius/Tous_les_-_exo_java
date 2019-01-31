package lry.dip.serveurUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;

public class ServeurSocketUDP {

	/**************************** ATTRIBUT ****************************/

	private Inet4Address ipServeur;
	private Inet4Address ipClient;
	
	private int portServeur;
	private int portClient;
	
	private DatagramSocket serveurSocket;
	private DatagramPacket dataSend;
	private DatagramPacket dataRec;
	
	private byte[] bufferSend;
	private byte[] bufferRec;
	
	/************************** CONSTRUCTEUR **************************/	
	
	public ServeurSocketUDP() {
		
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

	public DatagramSocket getServeurSocket() {
		return serveurSocket;
	}

	public void setServeurSocket(DatagramSocket serveurSocket) {
		this.serveurSocket = serveurSocket;
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
	
	public void lancerServeur(int pPort) {
        
        //On crée notre datagramme
        try {
        	portServeur = pPort;
        	
        	serveurSocket = new DatagramSocket(pPort); 
        	
            //On s'occupe maintenant de l'objet paquet
            bufferRec = new byte[8192];

            dataRec = new DatagramPacket(bufferRec, bufferRec.length);              

            //Cette méthode permet de récupérer le datagramme envoyé par le client

            //Elle bloque le thread jusqu'à ce que celui-ci ait reçu quelque chose.

            serveurSocket.receive(dataRec);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void arreterServeur() {
		serveurSocket.close();
	}
	
	public void envoyerReponse(String message, int pPort, String pId) {
        
        try {
        	System.out.println(pId.substring(1));
        	pId = pId.substring(1);
        	ipClient = (Inet4Address) Inet4Address.getByName(pId);
        	portClient = dataRec.getPort();
        	bufferSend = message.getBytes();
            dataSend = new DatagramPacket(bufferSend, bufferSend.length, ipClient, pPort);
            
            //On lui affecte les données à envoyer
            dataSend.setData(bufferSend);
            
            //On envoie au serveur
        	
			serveurSocket.send(dataSend);
			arreterServeur();
		} catch (IOException e) {
			serveurSocket.close();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void recevoirRequete() {		
		System.out.println(new String(dataRec.getData())+" : reception");
		System.out.println(dataRec.getPort()+" "+dataRec.getAddress()+" : reception"); 
		
	}

	@Override
	public String toString() {
		return "ServeurSocketUDP [ipServeur=" + ipServeur + ", ipClient=" + ipClient + ", portServeur=" + portServeur
				+ ", portClient=" + portClient + ", serveurSocket=" + serveurSocket + ", dataSend=" + dataSend
				+ ", dataRec=" + dataRec + ", bufferSend=" + Arrays.toString(bufferSend) + ", bufferRec="
				+ Arrays.toString(bufferRec) + "]";
	}
	
	public void afficher() {
		System.out.println(toString());
	}
}
