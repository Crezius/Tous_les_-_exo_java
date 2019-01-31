import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestBDD {
	
/****************** Variable ******************/
	
	
	private String driver;
	private String url;
	private String user;
	private String pass;
	
	private Connection connexion;
	
/**************** Constructeur ****************/
	
	public TestBDD(String driver, String url, String user, String pass) {
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
			String sql = "SELECT * FROM data";
			Statement state = connexion.createStatement();
			state.executeQuery(sql);
			} catch (SQLException e) {
				String sql = "CREATE TABLE data( id SERIAL NOT NULL, nom VARCHAR(10) NOT NULL, tatoo INTEGER NOT NULL, naiss DATE NOT NULL, taill DOUBLE NOT NULL, PRIMARY KEY(id));";
				Statement state = connexion.createStatement();
				state.executeQuery(sql);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Y a un p'tit problème dans ta connection\nTa base n'existe pas");
		}
		
	}
	
	// affiche les élément de la table data
	public void selectData() {
		try {
			String sql = "SELECT * FROM data"
					+ "";
						
			Statement state = connexion.createStatement();
			
			
			ResultSet result = state.executeQuery(sql);
			
			while(result.next()) {
				System.out.println(result.getString("nom")+" "+result.getInt("tatoo")+" "
						+ ""+result.getDate("naiss")+" "+result.getDouble("taill")+" "+result.getInt("id"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// ajoute un élément à la table data
	public void insertData(String pNom, int pTatoo, Date pNaiss, double pTaille ) {
		
		java.sql.Date date = new java.sql.Date(pNaiss.getTime());
		System.out.println(date);

		
		try {
			String sql = "INSERT INTO data(nom, tatoo, naiss, taill) VALUES (?, ?, ?, ?)";
			
			System.out.println(sql);
			
			PreparedStatement state = connexion.prepareStatement(sql);
			
			state.setString(1,  pNom);
			state.setInt(2, pTatoo);
			state.setDate(3, date);
			state.setDouble(4, pTaille);
			
			System.out.println(state);
						
			state.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// supprime tous les élément de la table data
	public void deleteData(){
		try {
			String sql = "DELETE FROM data";

			Statement state = connexion.createStatement();
					
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
			

			PreparedStatement state = connexion.prepareStatement(sql);
			
			state.setString(1,  pNom);
			state.setInt(2, pTatoo);
			state.setDate(3, date);
			state.setDouble(4, pTaille);
			state.setString(5,  ancienNom);
						
			state.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
