package lry.dip.tcp.serveur;

public class PrincipaleServeurTCP {

	
	public static void main(String[] args) {
		
		Serveur serveur = new Serveur();
		
		serveur.lancerServeur(3000, "192.168.3.24");
		
		serveur.attendreClient();
		
		serveur.envoyerReponse("Coucou, j'ai bien reçu le message");
		
		serveur.deconnecter();
		
		serveur.arreterServeur();
		
	}
}
