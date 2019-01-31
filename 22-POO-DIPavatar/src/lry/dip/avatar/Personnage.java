package lry.dip.avatar;

public abstract class Personnage {

	private final int MAX_VIE = 100;
	
	/*********************************** ATTRIBUTS ***********************************/
	private boolean etatPerso 	= true;
	private int 	viePerso 	= MAX_VIE;
	private int 	posH 		= 0;
	private int 	posL 		= 0;
	
/******************************* GETTERS / SETTERS *******************************/

	public boolean isEtatPerso() {
		return etatPerso;
	}

	public void setEtatPerso(boolean etatPerso) {
		this.etatPerso = etatPerso;
	}

	public int getViePerso() {
		return viePerso;
	}

	public void setViePerso(int viePerso) {
		this.viePerso = viePerso;
	}

	public int getPosH() {
		return posH;
	}

	public void setPosH(int posH) {
		this.posH = posH;
	}

	public int getPosL() {
		return posL;
	}

	public void setPosL(int posL) {
		this.posL = posL;
	}
	
/*********************************** METHODES ************************************/
	
	public boolean deplacer(int pHaut, int pLarge) {
		boolean bool = true;
		return bool;
	} 
	
	public boolean reveiller() {
		boolean bool = true;
		return bool;
	}
	
	public void parler(String pPhrase) {
		
	}
	
	
	
}	
