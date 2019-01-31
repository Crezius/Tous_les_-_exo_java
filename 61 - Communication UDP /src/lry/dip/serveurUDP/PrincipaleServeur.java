package lry.dip.serveurUDP;

public class PrincipaleServeur {

	public static void main(String[] args) {
		ServeurSocketUDP serveur = new ServeurSocketUDP();
		 
		serveur.lancerServeur(6924);
		serveur.recevoirRequete();
		
		serveur.afficher();
		
		serveur.envoyerReponse("yop, j'ai reçu le message", 5348, serveur.getDataRec().getAddress().toString());
		serveur.arreterServeur();


	}
	
}
