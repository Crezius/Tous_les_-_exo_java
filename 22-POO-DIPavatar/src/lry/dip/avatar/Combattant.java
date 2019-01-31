package lry.dip.avatar;

public class Combattant extends Personnage {

/*********************************** ATTRIBUTS ***********************************/

	private int 		force;
	private int 		precision;
	private Arme 		arme;
	private Protection 	casque;
	private Protection 	bouclier;	
	
	private boolean test_alter = true;
	
/********************************** CONSTRUCTEUR *********************************/
	
	
	protected Combattant(int pArme , int pProt1, int pProt2, int force, int precision) {
		super();
		this.force = force;
		this.precision = precision;
		
		arme = new Arme(pArme);
		casque = new Protection(pProt1);
		bouclier = new Protection(pProt2);	
	}
	
/******************************* GETTERS / SETTERS *******************************/
	
	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public Arme getArme() {
		return arme;
	}

	public void setArme(Arme arme) {
		this.arme = arme;
	}

	public Protection getCasque() {
		return casque;
	}

	public void setCasque(Protection casque) {
		this.casque = casque;
	}

	public Protection getBouclier() {
		return bouclier;
	}

	public void setBouclier(Protection bouclier) {
		this.bouclier = bouclier;
	}
	

/*********************************** METHODES ************************************/
	
	public int taper(int pForce, Arme gourdin) {
		int degat = (pForce + gourdin.getForce()) / gourdin.getPrecision() + this.getPrecision();
		
		return degat;
	}
	
	
	public void deplacerVers(Villageois villageois) {

		// alterne entre un déplacement verticale et un déplacement horizontale
		if(test_alter) {
			if(villageois.getPosH() > this.getPosH() && (this.getPosH() + 1) <= Principale.TAILLE_PLATEAU) {
				this.setPosH(this.getPosH() + 1);
								
			} else if(villageois.getPosH() < this.getPosH() && (this.getPosH() - 1) >= 0){
				this.setPosH(this.getPosH() - 1);
				
			} 
		}
		
		else if(!test_alter){
			System.out.println("test deplacer : "+(villageois.getPosL() > this.getPosL() && (this.getPosL() + 1) <= Principale.TAILLE_PLATEAU));
			if(villageois.getPosL() > this.getPosL() && (this.getPosL() + 1) <= Principale.TAILLE_PLATEAU) {
				this.setPosL(this.getPosL() + 1);
				
			} else if(villageois.getPosL() < this.getPosL() && (this.getPosL() - 1) >= 0){
				this.setPosL(this.getPosL() - 1);
				
			}
		}
		
		// inverse la valeur du boolean test_alter
		test_alter = !test_alter;
		
	}
	
	public boolean adjacent(Villageois villageois) {
		boolean adjacent = false;
		
		int differenceH = villageois.getPosH() - this.getPosH();
		int differenceV = villageois.getPosL() - this.getPosL();
		
		if((differenceH == 1 || differenceH == -1) || (differenceV == 1 || differenceV == -1)) adjacent = true;
		
		return adjacent;
	}
	
	
}
