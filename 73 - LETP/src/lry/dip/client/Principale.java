package lry.dip.client;

import lry.dip.serveur.Connect;

public class Principale {
	
	public static Client client = new Client(3000, "127.0.0.1");

	// fonction main, premi�re fonnction lanc�e lors de l'execution
	public static void main(String[] args) {
		
		GUI gui = new GUI(500, 500, true, "J'aime le chocolat");
		
	}
}
