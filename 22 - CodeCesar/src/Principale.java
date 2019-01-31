import java.util.Scanner;

public class Principale {

	public static void main(String[] args) {

		// création des variables
		boolean quitter = false;
		boolean ok = false;
		String texte;
		char car;
		int cle;
		int ascii;
		
		
		// Instanciation de ma class Cesar
		Cesar cesar = new Cesar("", "", 5);
		
		// Instanciation d'un objet de lecture des évènements clavier
		Scanner clavier = new Scanner(System.in);

		// Tant que le choix de fonction est erroné ...
		while(!quitter) {
			do {
				System.out.println("Coder / Décoder : c/d\n");
				
				// Récupération des informations du clavier
				texte = clavier.nextLine();
				
			} while (texte.isEmpty());
			// Récupération du premier caractère
			car = texte.charAt(0);
			
			// Récupération du code ASCII du caractère
			ascii = (int)car;
			
			// Sélection entre coder et décoder ou erreur avec retour au début de la boucle
			switch(ascii){
				case 99:
					// Récupération de la chaine de caractère à encoder
					System.out.println("Entrez la phrase à encoder");
					texte = clavier.nextLine();
					
					
					//Tant que la clé de cryptage est erroné ...
					do {
						// Entré une nouvelle clé de cryptage
						System.out.println("la cle de cryptage");
						cle = clavier.nextInt();
						cesar.setCle(cle);
						
						// si la clé est valide 
						if(cle > 0 && cle < 25) {
							
							// boolean ok passe à true
							ok = true;
						} else {
							System.out.println("Clé erronée");
						}
					} while(!ok);

					
					cesar.coder_Cesar(texte);
					quitter = true;
					
					break;
					
				case 100:
					do {
						
						do {
							System.out.println("Décryptage de mon fichier texte ? : o/n");
							
							// Récupération des informations du clavier
							texte = clavier.nextLine();
						
						} while (texte.isEmpty());

					// Récupération du premier caractère
					car = texte.charAt(0);
					} while(car != 'o' && car != 'n');
					
					// Récupération du code ASCII du caractère
					ascii = (int)car;
					
					switch(ascii) {
						case 111:
							cesar.decoder_Cesar(null);
							break;
						case 110:
							// C'est la même bro
							System.out.println("Entrez la phrase à décoder");
							texte = clavier.nextLine();
							
							
							do {
								System.out.println("la cle de cryptage");
								cle = clavier.nextInt();
								cesar.setCle(cle);
								if(cle > 0 && cle < 25) {
									ok = true;
								} else {
									System.out.println("Clé erronée");
								}
							} while(!ok);
							
							cesar.decoder_Cesar(texte);

						default:
							System.out.println("Erreur d'entrée");
							break;
					}

					quitter = true;
					
					break;
				default:
					System.out.println("Erreur d'entrée");
					break;
			}
		}
		
		clavier.close();
		System.out.println("\nFin du programme");
	}
}
