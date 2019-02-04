package lry.dip.avatar;

public class Villageois extends Personnage{

/*********************************** ATTRIBUTS ***********************************/

	private int rapidite;
	private int endurance;
	
/********************************** CONSTRUCTEUR *********************************/
	
	protected Villageois(int rapidite, int endurance) {
		super();
		this.rapidite = rapidite;
		this.endurance = endurance;
		this.setPosH(Principale.TAILLE_PLATEAU - 1);
		this.setPosL(Principale.TAILLE_PLATEAU - 1);
	}
	

/******************************* GETTERS / SETTERS *******************************/

	public int getRapidite() {
		return rapidite;
	}


	public void setRapidite(int rapidite) {
		this.rapidite = rapidite;
	}


	public int getEndurance() {
		return endurance;
	}


	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}


/*********************************** METHODES ************************************/

	public void endurer(int degat) {
		
		// test à -10pv par frappe
		this.setViePerso(this.getViePerso() - 10);
		System.out.println(this.getViePerso());
	}
	
	public void deplacer(Combattant mechant) {
		int choix, deplacementL, deplacementH;
		choix = (int)(Math.random() * 2);
		
		if(choix == 0) {
			deplacementH = (-1) + (int)(Math.random() * 3);
			if((getPosH() + deplacementH) > Principale.TAILLE_PLATEAU || (getPosH() + deplacementH) < 0 ||
			  ((getPosH() + deplacementH) == mechant.getPosH() && getPosL() == mechant.getPosL())) {
				deplacer(mechant);
			} else {
				setPosH(getPosH() + deplacementH);
			}

		} else {
			deplacementL = (-1) + (int)(Math.random() * 3);

			if((getPosL() + deplacementL) > Principale.TAILLE_PLATEAU || (getPosL() + deplacementL) < 0 ||
					  ((getPosL() + deplacementL) == mechant.getPosL() && getPosH() == mechant.getPosH())) {
				deplacer(mechant);
			} else {
				setPosL(getPosL() + deplacementL);

				
			}
		}
		
		
		
	}
	
	
}
