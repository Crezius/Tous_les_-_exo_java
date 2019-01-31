import java.util.Scanner;

public class Principale {
	
	


	public static void main(String[] args) {		
		
		// test pour récupérer le code ASCII de l'euro et du dollar
//		char euro = '€', dollar = '$';
//		
//		System.out.println("code euro : "+(int)euro+"\tdollar : "+(int)dollar);
		
		// Affichage du message de demande
		System.out.println("Entrée la somme à convertir : ");
		
		// Instanciation d'un objet qui réagira aux évènements du clavier
		Scanner clavier = new Scanner(System.in);
		
		// ouverture du try
		try {
			// récupération des entrées clavier dans une chaine de caratères
			String text = clavier.nextLine();
			
			// récupération de la devise (dernier caratère de la chaine)
			char devise = text.charAt(text.length()-1);
			
			// test si la devise est l'euro
			if((int)devise == 8364) {
				// affiche la somme en euro et converti en dollar
				System.out.println(text+"\t=\t"+Float.parseFloat(text.substring(0, text.length()-1))*1.17+""+(char)36);
			// sinon si c'est le dollar
			} else if ((int)devise == 36) {
				// affiche la somme en dollar et conveti en euro
				System.out.println(text+"\t=\t"+Float.parseFloat(text.substring(0, text.length()-1))/1.17+""+(char)8364);
			// sinon affiche un message d'erreur
			} else {
				System.out.println("erreur mauvaise devise");
			}
		// catch l'exception et retourne erreur si l'entrée est fausse
		} catch(NumberFormatException e) {
			System.out.println("erreur");
		}
		
		// ferme le clavier
		clavier.close();
	}
	
	
	public static void premiere_partie() {
		
		// Création d'une variable contenant un caractère
		char lettre;
		
		// Instanciation d'un objet qui réagira aux évènements du clavier
		Scanner clavier = new Scanner(System.in);
		
		// création d'une chaine de caratères pour récupérer les entrées clavier
		String texte = clavier.nextLine();
		
		// récupération de la première lettre de la chaine
		lettre = texte.charAt(0);
		
		// affichage de cette lettre
		System.out.println("ma lettre : "+lettre);
		
		//**********************************************************//
		
		// Création d'une variable contenant un caractère
		int nombre = 0;
		
		// récupération d'un entier de l'évènement clavier 
		try {
			String text_test = clavier.nextLine();
			nombre = Integer.parseInt(text_test);
			// affichage de cd nombre
			System.out.println("mon nombre : "+nombre);
		// si ce n'est pas un int , retourne une erreur 
		} catch(NumberFormatException e) {
			System.out.println("Veuillez entrer un nombre");
		}
		
		
		//**********************************************************//
		
		boolean bool;
		
		try {
			String text_test = clavier.nextLine();
			bool = Boolean.parseBoolean(text_test);
			// affichage de ce boolean
			System.out.println("mon boolean : "+bool);
		// si ce n'est pas un boolean , retourne une erreur 
		} catch(NumberFormatException e) {
			System.out.println("Veuillez entrer un boolean");
		}
		
		clavier.close();
	}

	public static void deuxieme_partie() {
		// Instanciation d'un objet qui réagira aux évènements du clavier
		Scanner clavier = new Scanner(System.in);

		// Création d'une variable contenant un caractère
		int nombre = 0;
		
		// récupération d'un entier de l'évènement clavier 
		try {
			String text_test = clavier.nextLine();
			char car = text_test.charAt(0);
			nombre = (int)car;
			// affichage de cd nombre
			System.out.println("mon nombre : "+nombre);
		// si ce n'est pas un int , retourne une erreur 
		} catch(NumberFormatException e) {
			System.out.println("Veuillez entrer un nombre");
		}
		
		//**********************************************************//

		// Création d'une variable contenant un caractère
				
		// récupération d'un entier de l'évènement clavier 
		try {
			nombre = clavier.nextInt();
			char car = (char)nombre;
			// affichage de cd nombre
			System.out.println("mon car : "+car);
		// si ce n'est pas un int , retourne une erreur 
		} catch(NumberFormatException e) {
			System.out.println("Erreur");
		}
		
		clavier.close();
	}

	public static void troisieme_partie() {

		char car;
		
		// Instanciation d'un objet qui réagira aux évènements du clavier
		Scanner clavier = new Scanner(System.in);
		
		// boucle pour tester plusieurs caractère 
		 do {
			// création d'une chaine de caratères pour récupérer les entrées clavier
			String text = clavier.nextLine();
			
			// récupération de la première lettre de la chaine
			car = text.charAt(0);
			
			// cast du caractère en int
			int nombre = (int)car;
			
			// affichage du tout
			System.out.println("ma lettre : "+car+" son code ASCII :"+nombre);
		 } while (car != ' ');
		 
		 clavier.close();
	}

	public static void quatrieme_partie() {
		char car;
		int nombre;
		
		// Instanciation d'un objet qui réagira aux évènements du clavier
		Scanner clavier = new Scanner(System.in);
		
		// boucle tanta que le caratère ne se situe pas entre a-z ou A-Z
		 do {
			// création d'une chaine de caratères pour récupérer les entrées clavier
			String text = clavier.nextLine();
			
			// récupération de la première lettre de la chaine
			car = text.charAt(0);
			
			// cast du caractère en int
			nombre = (int)car;
			
			// affichage du tout
			System.out.println("ma lettre : "+car+" son code ASCII :"+nombre);
		 } while (nombre < 65 ||  (nombre > 90 && nombre < 97) || nombre > 122);
		 
		 clavier.close();
	}
	
	public static void cinquieme_partie() {
		// boucle qui parcour le code ASCII des caractère recherchés
		for (int i = 65; i < 122; i++) {
			// si le caractère se situe entre a-z ou A-Z
			if(i < 91 || i > 96) {
				// affichage du caratère et de son code
				System.out.println("ma lettre : "+(char)i+"\tson code ASCII : "+i);
			}	
		}
	}
	

	
	
	
}
