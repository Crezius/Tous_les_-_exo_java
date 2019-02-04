package lry.dip.mesure;

import java.util.ArrayList;

public class Temperature {
	
/*********************************** ATTRIBUTS ***********************************/
	
	private double celsius;
	private double kelvin;
	private double farenheit;
	
	// Instanciation d'un Tableau de Température
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

	// test si la conversion est valide et converti un inch dans les 2 autres unités
	public boolean convFar(Double farenheit) {
		boolean conv_valide = false;
		
		// Créé un instance de Tempétrature 
		Temperature temperature = new Temperature();
		
		// Remplace les valeur de température par celles entrées au clavier mais converti
		temperature.setFarenheit(farenheit);
		temperature.setCelsius(farenheitToCelsius(farenheit));
		temperature.setKelvin(farenheitToKelvin(farenheit));

		
		remplirTab(temperature);
		
		return conv_valide;
	}
	
	// test si la conversion est valide et converti un inch dans les 2 autres unités
	public boolean convCel(Double celsius) {
		boolean conv_valide = false;
		
		// idem , voir ci-dessus
		Temperature temperature = new Temperature();
		
		temperature.setCelsius(celsius);
		temperature.setFarenheit(celsiusToFarenheit(celsius));
		temperature.setKelvin(celsiusToKelvin(celsius));

		
		remplirTab(temperature);
		
		return conv_valide;
	}
	
	// test si la conversion est valide et converti un inch dans les 2 autres unités
	public boolean convKel(Double kelvin) {
		boolean conv_valide = false;
		
		//idem, voir ci-dessus
		Temperature temperature = new Temperature();
		
		temperature.setKelvin(kelvin);
		temperature.setCelsius(kelvinToCelsius(kelvin));
		temperature.setFarenheit(kelvinToFarenheit(kelvin));

		
		remplirTab(temperature);
		
		return conv_valide;
	}
	
	public void remplirTab(Temperature temperature) {
		this.tab_conv.add(temperature);
	}
	
	public void afficherTab() {
		
		// Parcour le tableau tab_conv
		for(Temperature c: tab_conv) {
			
			// Affiche les valeurs de chaque éléments du tableau
			System.out.println("Celsius : "+c.getCelsius()+"\tKelvin : "+c.getKelvin()+"\tFarenheit : "+c.getFarenheit()+"\n");
		}
	}
	
	
}