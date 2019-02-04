package lry.dip.mesure;

import java.util.ArrayList;

public class Distance {
/*********************************** ATTRIBUTS ***********************************/
	
	private double metre;
	private double inch;
	private double mile;

	// Instanciation d'un Tableau de Distance
	ArrayList<Distance> tab_conv = new ArrayList<>();
	
/********************************** CONSTRUCTEUR *********************************/

	protected Distance() {
		this.metre 	= 0;
		this.inch 	= 0;
		this.mile 	= 0;
	}	
	
/******************************* GETTERS / SETTERS *******************************/

	public double getMetre() {
		return metre;
	}
	
	public void setMetre(double metre) {
		this.metre = metre;
	}
	
	public double getInch() {
		return inch;
	}
	
	public void setInch(double inch) {
		this.inch = inch;
	}
	
	public double getMile() {
		return mile;
	}
	
	public void setMile(double mile) {
		this.mile = mile;
	}

/*********************************** METHODES ************************************/

	public double metreToInch(double metre) {
		//convertion : mètre -> inch
		return metre / 0.0254;
	}
	
	public double metreToMile(double metre) {
		//convertion : mètre -> mile
		return metre / 1609;
	}
	
	public double inchToMetre(double inch) {
		//convertion : inch -> mètre
		return inch * 0.0254;
	}
	
	
	public double inchToMile(double inch) {
		//convertion : inch -> mile
		return inch / 63360;
	}
	
	public double mileToMetre(double mile) {
		//convertion : mile -> mètre
		return mile * 1609;
	}
	
	public double mileToInch(double mile) {
		//convertion : mile -> inch
		return mile * 63360;
	}
	
	// le Test boolean des fonction conv... suivante n'est pas encore fonctionnel
	
	// test si la conversion est valide et converti un inch dans les 2 autres unités
	public boolean convMetre(Double metre) {
		boolean conv_valide = false;
		
		Distance distance = new Distance();
		
		distance.setMetre(metre);
		distance.setInch(metreToInch(metre));
		distance.setMile(metreToMile(metre));

		
		remplirTab(distance);
		
		return conv_valide; // 
	}
	
	// test si la conversion est valide et converti un inch dans les 2 autres unités
	public boolean convInch(Double inch) {
		boolean conv_valide = false;
		
		Distance distance = new Distance();
		
		distance.setInch(inch);
		distance.setMetre(mileToMetre(inch));
		distance.setMile(inchToMile(inch));

		
		remplirTab(distance);
		
		return conv_valide;
	}
	
	// test si la conversion est valide et converti un inch dans les 2 autres unités
	public boolean convMile(Double mile) {
		boolean conv_valide = false;
		
		
		Distance distance = new Distance();
		
		distance.setMile(mile);
		distance.setMetre(mileToMetre(mile));
		distance.setInch(mileToInch(mile));
		
		remplirTab(distance);
		
		return conv_valide;
	}
	
	public void remplirTab(Distance distance) {
		this.tab_conv.add(distance);
	}
	
	public void afficherTab() {
		for(Distance c: tab_conv) {
			System.out.println("Metre : "+c.getMetre()+"\tInch : "+c.getInch()+"\tMile : "+c.getMile()+"\n");
		}
	}
	
	public void afficher() {

			System.out.println("Metre : "+this.getMetre()+"\tInch : "+this.getInch()+"\tMile : "+this.getMile()+"\n");
	}
	
	
	
}
