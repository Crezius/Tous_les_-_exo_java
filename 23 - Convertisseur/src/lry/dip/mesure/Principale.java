package lry.dip.mesure;

import java.util.Scanner;

public class Principale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Temperature tmp 	= new Temperature();
		Distance 	dist 	= new Distance();
		
		
		System.out.println((double)(9/5));
		// Cr�ation d'un double et d'un String pour r�cup�rer les valeurs clavier
		String texte;
		double valeur;
		
		boolean ok = true;
		
		// Instanciation d'un lecteur d'entr�es clavier
		Scanner clavier = new Scanner(System.in);
		
		// Entier incr�menter de 1 pour �viter les boucles infinits
		int tour = 0;
			
		
		// juste un p'tit test de remplissage et lecture des tableaux de r�sultats
		while(ok) {
			
			// R�cup�ration des entr�es clavier
			System.out.println("Distance / Temperature : (d / t)");
			texte  = clavier.nextLine();
			
			// Ouverture d'une zone de test 
			try {
				
				
				switch(texte) {
					case "d":
						// R�cup�ration des entr�es clavier
						System.out.println("Que veux tu jeune padawan ?  (metre / inch / mile)");
						texte  = clavier.nextLine();
						
						switch(texte) {
							case "metre":
								// R�cup�ration des entr�es clavier
								texte  = clavier.nextLine();
								
								// conversion des entr�es clavier en double
								valeur = Double.parseDouble(texte);
								
								// appel de la methode de conversion 
								dist.convMetre(valeur);
								
								// affichage du resultat 
								dist.afficherTab();
								break;
							case "inch":
								// R�cup�ration des entr�es clavier
								texte  = clavier.nextLine();
								
								// conversion des entr�es clavier en double
								valeur = Double.parseDouble(texte);
								
								// appel de la methode de conversion 
								dist.convInch(valeur);
								
								// affichage du resultat 
								dist.afficherTab();
								break;
							case "mile":
								// R�cup�ration des entr�es clavier
								texte  = clavier.nextLine();
								
								// conversion des entr�es clavier en double
								valeur = Double.parseDouble(texte);
								
								// appel de la methode de conversion 
								dist.convMile(valeur);
								
								// affichage du resultat 
								dist.afficherTab();
								break;
							default:
								System.out.println("Et baaa Bien jou� Nils, tu t'es plant� !");
								break;
						}
						break;
					case "t":
						
						// R�cup�ration des entr�es clavier
						System.out.println("Que veux tu jeune padawan ?  (celsius / kelvin / farenheit)");
						texte  = clavier.nextLine();
						
						switch(texte) {
							case "celsius":
								// R�cup�ration des entr�es clavier
								texte  = clavier.nextLine();
								
								// conversion des entr�es clavier en double
								valeur = Double.parseDouble(texte);
								
								// appel de la methode de conversion 
								tmp.convCel(valeur);
								
								// affichage du resultat 
								tmp.afficherTab();
								break;
							case "kelvin":
								// R�cup�ration des entr�es clavier
								texte  = clavier.nextLine();
								
								// conversion des entr�es clavier en double
								valeur = Double.parseDouble(texte);
								
								// appel de la methode de conversion 
								tmp.convKel(valeur);
								
								// affichage du resultat 
								tmp.afficherTab();
								break;
							case "farenheit":
								System.out.println("alors d�j� bravo  et maintenant choisi une valeur");
								
								// R�cup�ration des entr�es clavier
								texte  = clavier.nextLine();
								
								// conversion des entr�es clavier en double
								valeur = Double.parseDouble(texte);
								
								// appel de la methode de conversion 
								tmp.convFar(valeur);
								
								// affichage du resultat 
								tmp.afficherTab();
								break;
							default:
								System.out.println("Et baaa Bien jou� Nils, tu t'es plant� !");
								break;
						}
					
						break;
					case "f" :
						System.out.println("F�licitation tu as trouv� la sortie");
						ok = false;
						break;
					default:
						System.out.println("Tu t'es plant� mec");
						break;
				}
			
			// Si il y a erreur lors de la conversion
			} catch(NumberFormatException e) {
				
				// Retourne un message d'erreur et n'incr�mente pas tour de 1
				System.out.println("Et c'est la fin !");
			}
			
			
		}		

		
		
		// p'tit test de conversion 
//		System.out.println("Choix de la conversion (1 - 12) : ");
//		String texte  = clavier.nextLine();
//		
//		
//		
//		
//		
//		
//		try {
//			int choix = Integer.parseInt(texte);
//		
//			System.out.println("Choix de la valeur : ");
//			texte  = clavier.nextLine();
//			
//			valeur = Integer.parseInt(texte);
//			
//			switch(choix) {
//			
//			case 1:
//				
//				System.out.println("Celsius vers Farenheit : "+ tmp.celsiusToFarenheit(valeur));
//				break;
//			case 2:
//				
//				System.out.println("Celsius vers Kelvin : "+ tmp.celsiusToFarenheit(valeur));
//				break;
//			case 3:
//				System.out.println("Farenheit vers Kelvin : "+ tmp.farenheitToKelvin(valeur));
//				
//				break;
//			case 4:
//				System.out.println("Farenheit vers Celsius : "+ tmp.farenheitToKelvin(valeur));
//				break;
//			case 5:
//				System.out.println("Kelvin vers Celsius : "+ tmp.kelvinToCelsius(valeur));
//				break;
//			case 6:
//				System.out.println("Kelvin vers Farenheit : "+ tmp.kelvinToCelsius(valeur));
//				break;
//			case 7:
//				System.out.println("Metre vers Inch : "+ dist.metreToInch(valeur));
//				break;
//			case 8:
//				System.out.println("Metre vers Mile : "+ dist.metreToMile(valeur));
//				break;
//			case 9:
//				System.out.println("Inch vers Metre : "+ dist.inchToMetre(valeur));
//				break;
//			case 10:
//				System.out.println("Inch vers Mile : "+ dist.inchToMile(valeur));
//				break;
//			case 11:
//				System.out.println("Mile vers Metre : "+ dist.mileToMetre(valeur));
//				break;
//			case 12:
//				System.out.println("Mile vers Inch : "+ dist.mileToInch(valeur));
//				break;
//			default:
//				System.out.println("Erreur : s�lectionnez un nombre entre 1 - 12");
//				break;
//			}
//
//		} catch(NumberFormatException e) {
//			System.out.println("Mais tape un nombre $^*#{% !!");
//		}
//		
		

	}

}
