package lry.dip.serveur;

public class PrincipaleServeurTCP {

	public static Connect conn = new Connect("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/base_carnet?autoReconnect=true&useSSL=false", "me", "mdp");

	
	public static void main(String[] args) {
		
		
		
		Serveur serveur = new Serveur(3000, "127.0.0.1");
		
		Thread t_serveur = new Thread(serveur);
		
		t_serveur.start();
						
	}
}
