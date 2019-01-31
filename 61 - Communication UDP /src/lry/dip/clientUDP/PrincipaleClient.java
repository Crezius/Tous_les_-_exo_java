package lry.dip.clientUDP;

public class PrincipaleClient {

	public static void main(String[] args) {
		ClientSocketUDP client = new ClientSocketUDP();
		 
		client.envoyerRequete("test", 2000, "192.168.3.23");
		client.recevoirReponse();
	}
	
}
