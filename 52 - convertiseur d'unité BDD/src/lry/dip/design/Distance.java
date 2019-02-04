package lry.dip.design;

import java.sql.PreparedStatement;
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
		//convertion : m�tre -> inch
		return metre / 0.0254;
	}
	
	public double metreToMile(double metre) {
		//convertion : m�tre -> mile
		return metre / 1609;
	}
	
	public double inchToMetre(double inch) {
		//convertion : inch -> m�tre
		return inch * 0.0254;
	}
	
	
	public double inchToMile(double inch) {
		//convertion : inch -> mile
		return inch / 63360;
	}
	
	public double mileToMetre(double mile) {
		//convertion : mile -> m�tre
		return mile * 1609;
	}
	
	public double mileToInch(double mile) {
		//convertion : mile -> inch
		return mile * 63360;
	}
	
	// le Test boolean des fonction conv... suivante n'est pas encore fonctionnel
	
	// test si la conversion est valide et converti un inch dans les 2 autres unit�s
	public String convMetre(Double metre) {
				
		setMetre(metre);
		setInch(metreToInch(metre));
		setMile(metreToMile(metre));

		
		remplirTab(this);
		
		ajouterEchantillon(getMetre(), getInch(), getMile());
		
		return "Inch : "+getInch()+"    Mille : "+getMile(); // 
	}
	
	// test si la conversion est valide et converti un inch dans les 2 autres unit�s
	public String convInch(Double inch) {
			
		setInch(inch);
		setMetre(mileToMetre(inch));
		setMile(inchToMile(inch));

		
		remplirTab(this);
		
		ajouterEchantillon(getMetre(), getInch(), getMile());
		
		return "Inch : "+getInch()+"    Mille : "+getMile();
	}
	
	// test si la conversion est valide et converti un inch dans les 2 autres unit�s
	public String convMile(Double mile) {
				
		setMile(mile);
		setMetre(mileToMetre(mile));
		setInch(mileToInch(mile));
		
		remplirTab(this);
		
		ajouterEchantillon(getMetre(), getInch(), getMile());
		
		return "Mètre : "+getMetre()+"    Inch : "+getInch();
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
	
	public void ajouterEchantillon(Double metre, Double inch, Double mille) {
		try {
				String sql = "INSERT INTO Distance(metre, inch, mille) VALUES (?, ?, ?)";
				
				System.out.println(sql);
				
				PreparedStatement preparedState = Principale.conn.getConnexion().prepareStatement(sql);
				
					
				preparedState.setDouble(1, metre);
				preparedState.setDouble(2, inch);
				preparedState.setDouble(3, mille);
	
											
				preparedState.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
