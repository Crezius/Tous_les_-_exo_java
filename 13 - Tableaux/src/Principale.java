import java.util.Scanner;

public class Principale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
 	
	public static void premiere_partie() {

		// tableau contenant les futurs valeurs converti
		float[] devise = new float[4];
		
		// tableau contenant les valeurs de conversion des devises
		float[] conversion = {(float) 1.17, (float) 132.6, (float) 0.89};
		
		// Instanciation d'un objet qui réagira aux évènements du clavier
		Scanner clavier = new Scanner(System.in);
		
		// ouverture du try
		try {
			// recupération des valeur d'entrée dans un string
			String text = clavier.nextLine();
			
			// conversion de la valeur en entrée en float
			float somme = Float.parseFloat(text);
			
			// ajout de la premiere valeur en euro dans le tableau
			devise[0] = somme;
			
			// boucle de remplissage du tableau devise 
			for(int i=1; i<devise.length; i++) {
				// conversion des valeurs, ajout dans le tableau
				devise[i] = somme * conversion[i-1];
			}
			
			// affichage des valeurs du tableau 
			for(Float f: devise)System.out.println(f+"\t");
			
			// si erreur de format il y a, affichage d'un message d'erreur il y aura
		} catch (NumberFormatException e) {
			System.out.println("Veuillez entrer un nombre");
		}
		
		clavier.close();
		
	}
	
	public static void deuxieme_partie() {
		// utilisation d'un double, car un int serait trop petit
		double[] mon_tableau = new double[200];
		
		// remplace la première valeur du tableau par 2
		mon_tableau[0] = 2;
		
		// boucle de carre 
		for(int i=1; i<200; i++) {
			// ajout calcul de la valeur à  l'adresse i en fonction de i-1
			mon_tableau[i] = mon_tableau[i-1]*2;
		}
		
		// affichage du tableau
		for(double i: mon_tableau) System.out.println(i);
		
	}
	
	public static void troisieme_partie() {
		
		// création du tableau avec les valeur
		String[][] mon_tableau = {{"","Gibson", "Gretsch", "Seagull", "Godin"}, {"Mick", "18", "1", "27", "12"}, {"Keith", "4", "25", "0", "2"}, {"Brian", "25", "41", "36", "2"}, {"Ronnie", "1", "2", "2", "1"}};
		
		// boucle for imbriquées pour parcour le tableau à double entrée
		for(int i = 0; i < mon_tableau.length; i++) {
			for(int j = 0; j < mon_tableau.length; j++) {
				//affichage du tableau
				System.out.print(mon_tableau[i][j]+"\t");
			}
			// retour à la ligne pour afficher la ligne suivante
			System.out.print("\n");
		}
	}

	public static void quatrieme_partie() {

		// création d'un tableau à double entrées
		int[][] mon_tableau = new int[100][2];
		
		// initialisation de la première colonne pour préparer le calcul 
		//0 pour la première ligne(paire) et 1 un pour la deuxieme(impaire)
		mon_tableau[0][0] = 0;
		mon_tableau[0][1] = 1;
		
		// boucle de remplissage du tableau 
		for(int i = 1; i < 100; i++) {
			// case i est égal à la case i-1 +2 
			mon_tableau[i][0] = mon_tableau[i-1][0] + 2;
			mon_tableau[i][1] = mon_tableau[i-1][1] + 2;
		}
		
		// affichage du tableau à double entrée -> double boucles imbriquées
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 100; j++) {
				System.out.print(mon_tableau[j][i]+"\t");
			}
			System.out.println("\n");
		}
	}
}
