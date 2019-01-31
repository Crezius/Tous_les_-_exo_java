package lry.dip.design;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Connect {
	
/****************** Variable ******************/
	
	
	private String driver;
	private String url;
	private String user;
	private String pass;
	
	private Statement state;
	private PreparedStatement preparedState;
	private ResultSet result;
	
	private Connection connexion;
	
/**************** Constructeur ****************/
	
	public Connect(String driver, String url, String user, String pass) {
		super();
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pass = pass;
		
		connectBDD();
	}
	
/**************** Getter / Setter ****************/
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public String getUser() {
		return user;
	}
	public String getPass() {
		return pass;
	}
	public Connection getConnexion() {
		return connexion;
	}
	public void setConnexion(Connection connexion) {
		this.connexion = connexion;
	}
	
	
/**************** Méthodes ****************/
	
	// connect à la BDD
	public void connectBDD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			setConnexion(DriverManager.getConnection( url, user, pass));
			
			try {
			String sql = "SELECT * FROM Temperature";
			Statement state = connexion.createStatement();
			state.executeQuery(sql);
			} catch (SQLException e) {
//				String sql = "CREATE TABLE data( id SERIAL NOT NULL, nom VARCHAR(10) NOT NULL, tatoo INTEGER NOT NULL, naiss DATE NOT NULL, taill DOUBLE NOT NULL, PRIMARY KEY(id));";
//				Statement state = connexion.createStatement();
//				state.executeQuery(sql);
			}
			
			try {
				String sql = "SELECT * FROM Distance";
				Statement state = connexion.createStatement();
				state.executeQuery(sql);
				} catch (SQLException e) {
//					String sql = "CREATE TABLE data( id SERIAL NOT NULL, nom VARCHAR(10) NOT NULL, tatoo INTEGER NOT NULL, naiss DATE NOT NULL, taill DOUBLE NOT NULL, PRIMARY KEY(id));";
//					Statement state = connexion.createStatement();
//					state.executeQuery(sql);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Y a un p'tit problème dans ta connection\nTa base n'existe pas");
		}
		
	}
	
	// affiche les élément de la table data
	public void selectDataTemperature() {
		try {
			String sql = "SELECT * FROM Temperature"
					+ "";
						
			state = connexion.createStatement();
			
			
			result = state.executeQuery(sql);
			
			while(result.next()) {
				System.out.println("id : "+result.getInt("id")+"\tCelsius : "+result.getDouble("Celsius")+"\tKelvin : "
						+ ""+result.getDouble("Kelvin")+"\tFarenheit : "+result.getDouble("Farenheit"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectDataDistance() {
		try {
			String sql = "SELECT * FROM Distance"
					+ "";
						
			state = connexion.createStatement();
			
			
			result = state.executeQuery(sql);
			
			while(result.next()) {
				System.out.println("id : "+result.getInt("id")+"\tMètre : "+result.getDouble("metre")+" "
						+ "\tInch : "+result.getDouble("inch")+"\tMille : "+result.getDouble("mille"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	// supprime tous les élément de la table data
	public void deleteData(){
		try {
			System.out.println("\n delete \n");
			
			String sql = "DELETE FROM Temperature;";

			state = connexion.createStatement();
					
			state.executeUpdate(sql);
			
			sql = "DELETE FROM Distance";

			state = connexion.createStatement();
					
			state.executeUpdate(sql);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateData(String ancienNom, String pNom, int pTatoo, Date pNaiss, double pTaille ) {
		java.sql.Date date = new java.sql.Date(pNaiss.getTime());
		System.out.println(date);

		
		try {
			String sql = "UPDATE data SET nom = ?, tatoo = ?, naiss = ?, taill = ? WHERE nom = ?";
			

			preparedState = connexion.prepareStatement(sql);
			
			preparedState.setString(1,  pNom);
			preparedState.setInt(2, pTatoo);
			preparedState.setDate(3, date);
			preparedState.setDouble(4, pTaille);
			preparedState.setString(5,  ancienNom);
						
			preparedState.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
