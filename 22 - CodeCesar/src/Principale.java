import java.util.Scanner;

public class Principale {

	public static void main(String[] args) {

		// cr�ation des variables
		boolean quitter = false;
		boolean ok = false;
		String texte;
		char car;
		int cle;
		int ascii;
		
		
		// Instanciation de ma class Cesar
		Cesar cesar = new Cesar("", "", 5);
		
		// Instanciation d'un objet de lecture des �v�nements clavier
		Scanner clavier = new Scanner(System.in);

		// Tant que le choix de fonction est erron� ...
		while(!quitter) {
			do {
				System.out.println("Coder / D�coder : c/d\n");
				
				// R�cup�ration des informations du clavier
				texte = clavier.nextLine();
				
			} while (texte.isEmpty());
			// R�cup�ration du premier caract�re
			car = texte.charAt(0);
			
			// R�cup�ration du code ASCII du caract�re
			ascii = (int)car;
			
			// S�lection entre coder et d�coder ou erreur avec retour au d�but de la boucle
			switch(ascii){
				case 99:
					// R�cup�ration de la chaine de caract�re � encoder
					System.out.println("Entrez la phrase � encoder");
					texte = clavier.nextLine();
					
					
					//Tant que la cl� de cryptage est erron� ...
					do {
						// Entr� une nouvelle cl� de cryptage
						System.out.println("la cle de cryptage");
						cle = clavier.nextInt();
						cesar.setCle(cle);
						
						// si la cl� est valide 
						if(cle > 0 && cle < 25) {
							
							// boolean ok passe � true
							ok = true;
						} else {
							System.out.println("Cl� erron�e");
						}
					} while(!ok);

					
					cesar.coder_Cesar(texte);
					quitter = true;
					
					break;
					
				case 100:
					do {
						
						do {
							System.out.println("D�cryptage de mon fichier texte ? : o/n");
							
							// R�cup�ration des informations du clavier
							texte = clavier.nextLine();
						
						} while (texte.isEmpty());

					// R�cup�ration du premier caract�re
					car = texte.charAt(0);
					} while(car != 'o' && car != 'n');
					
					// R�cup�ration du code ASCII du caract�re
					ascii = (int)car;
					
					switch(ascii) {
						case 111:
							cesar.decoder_Cesar(null);
							break;
						case 110:
							// C'est la m�me bro
							System.out.println("Entrez la phrase � d�coder");
							texte = clavier.nextLine();
							
							
							do {
								System.out.println("la cle de cryptage");
								cle = clavier.nextInt();
								cesar.setCle(cle);
								if(cle > 0 && cle < 25) {
									ok = true;
								} else {
									System.out.println("Cl� erron�e");
								}
							} while(!ok);
							
							cesar.decoder_Cesar(texte);

						default:
							System.out.println("Erreur d'entr�e");
							break;
					}

					quitter = true;
					
					break;
				default:
					System.out.println("Erreur d'entr�e");
					break;
			}
		}
		
		clavier.close();
		System.out.println("\nFin du programme");
	}
}
