package lry.dip.tcp.client;

public class PrincipaleClientTCP {

	
	public static void main(String[] args) {
		
		Client serveur = new Client();
		
		serveur.lancerServeur(3000, "192.168.3.24");
		
		serveur.attendreClient();
		
		serveur.envoyerReponse("Coucou, j'ai bien reçu le message");
		
		serveur.deconnecter();
		
		serveur.arreterServeur();
		
	}
}
