package lry.dip.design;

import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Temperature {
	
/*********************************** ATTRIBUTS ***********************************/
	
	private double celsius;
	private double kelvin;
	private double farenheit;
	
	// Instanciation d'un Tableau de Temp�rature
	ArrayList<Temperature> tab_conv = new ArrayList<Temperature>();
	
	


/********************************** CONSTRUCTEUR *********************************/

	protected Temperature() {

	}	
	
/******************************* GETTERS / SETTERS *******************************/

	public double getCelsius() {
		return celsius;
	}
	public void setCelsius(double celsius) {
		this.celsius = celsius;
	}
	public double getKelvin() {
		return kelvin;
	}
	public void setKelvin(double kelvin) {
		this.kelvin = kelvin;
	}
	public double getFarenheit() {
		return farenheit;
	}
	public void setFarenheit(double farenheit) {
		this.farenheit = farenheit;
	}

	
/*********************************** METHODES ************************************/

	public double celsiusToKelvin(double celsius) {
		return celsius + 273.15;
	}
	
	public double celsiusToFarenheit(double celsius) {
		return celsius*(9/5)+32;
	}
	
	public double kelvinToCelsius(double kelvin) {
		return kelvin - 273.15;
	}
	
	public double kelvinToFarenheit(double kelvin) {
		return kelvin*(9/5) - 459.67;
	}
	
	public double farenheitToCelsius(double Farenheit) {
		return Farenheit*(5/9) + 32;
	}
	
	public double farenheitToKelvin(double Farenheit) {
		return Farenheit*(5/9) + 459.67;
	}
	
	// le Test boolean des fonction conv... suivante n'est pas encore fonctionnel

	// test si la conversion est valide et converti un inch dans les 2 autres unit�s
	public String convFar(Double farenheit) {
		
		
		// Remplace les valeur de temp�rature par celles entr�es au clavier mais converti
		setFarenheit(farenheit);
		setCelsius(farenheitToCelsius(farenheit));
		setKelvin(farenheitToKelvin(farenheit));

		
		remplirTab(this);
		
		ajouterEchantillon(getCelsius(), getKelvin(), getFarenheit());
		
		return "Celsius : "+getCelsius()+"    Kelvin : "+getKelvin();
	}
	
	// test si la conversion est valide et converti un inch dans les 2 autres unit�s
	public String convCel(Double celsius) {
		
		setCelsius(celsius);
		setFarenheit(celsiusToFarenheit(celsius));
		setKelvin(celsiusToKelvin(celsius));

		remplirTab(this);
		
		ajouterEchantillon(getCelsius(), getKelvin(), getFarenheit());
		
		return "Kelvin : "+getKelvin()+"    Farenheit : "+getFarenheit();
	}
	
	// test si la conversion est valide et converti un inch dans les 2 autres unit�s
	public String convKel(Double kelvin) {
		
		
		setKelvin(kelvin);
		setCelsius(kelvinToCelsius(kelvin));
		setFarenheit(kelvinToFarenheit(kelvin));

		remplirTab(this);
		
		ajouterEchantillon(getCelsius(), getKelvin(), getFarenheit());
		
		return "Celsius : "+String.valueOf(getCelsius())+"    Farenheit : "+String.valueOf(getFarenheit());
	}
	
	public void remplirTab(Temperature temperature) {
		this.tab_conv.add(temperature);
	}
	
	public void afficherTab() {
		
		// Parcour le tableau tab_conv
		for(Temperature c: tab_conv) {
			
			// Affiche les valeurs de chaque �l�ments du tableau
			System.out.println("Celsius : "+c.getCelsius()+"\tKelvin : "+c.getKelvin()+"\tFarenheit : "+c.getFarenheit()+"\n");
		}
	}
	
	public void ajouterEchantillon(Double celsius, Double kelvin, Double farenheit) {
		try {
				String sql = "INSERT INTO Temperature(celsius, kelvin, farenheit) VALUES (?, ?, ?)";
				
				System.out.println(sql);
				
				PreparedStatement preparedState = Principale.conn.getConnexion().prepareStatement(sql);
				
					
				preparedState.setDouble(1, celsius);
				preparedState.setDouble(2, kelvin);
				preparedState.setDouble(3, farenheit);
	
											
				preparedState.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}