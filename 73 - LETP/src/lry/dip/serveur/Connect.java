package lry.dip.serveur;
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
	
	private ArrayList<Echantillon> tab_ech = new ArrayList<>();
	
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
	
	public ArrayList<Echantillon> getTab_ech() {
		return tab_ech;
	}
	
	public void setTab_ech(ArrayList<Echantillon> tab_ech) {
		this.tab_ech = tab_ech;
	}

/**************** Méthodes ****************/
	
	// connect à la BDD
	public void connectBDD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			setConnexion(DriverManager.getConnection( url, user, pass));
			
			tab_ech = remplirTab();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Y a un p'tit problème dans ta connection\nTa base n'existe pas");
		}
		
	}
	
	
	
	public boolean ajouter(Echantillon echantillon) {
		
		try {
			
			String sql = "INSERT INTO contacts(titre, nom, prenom, adresse) VALUES (?, ?, ?, ?)";
			 
			preparedState = connexion.prepareStatement(sql);
			
			preparedState.setString(1, echantillon.getTitre());
			preparedState.setString(2, echantillon.getNom());
			preparedState.setString(3, echantillon.getPrenom());
			preparedState.setString(4, echantillon.getAdresse());
			
			System.out.println(preparedState);
			
			preparedState.executeUpdate();
						
			ajouter_tab(echantillon);
			
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			
			return false;
		}
	}
	
	public ArrayList<Echantillon> remplirTab() {
		
		ArrayList<Echantillon> tab = new ArrayList<>();
		
		// vide le tableau pour pouvoir le remplir correctement;
		
		try {
			
			String sql = "SELECT * FROM contacts";
			 
			state = connexion.createStatement();

			result = state.executeQuery(sql);
			
			while(result.next()) {
				tab.add(new Echantillon(result.getString("titre"), result.getString("nom"),
						result.getString("prenom"), result.getString("adresse"), "", result.getInt("id")));
			}
			
		}catch(SQLException e) {
			
		}
		
		return tab;
	}
	
	public void selectData() {
				
		// vide le tableau pour pouvoir le remplir correctement;
		
		try {
			
			String sql = "SELECT * FROM contacts";
			 
			state = connexion.createStatement();

			result = state.executeQuery(sql);
			
			while(result.next()) {
				System.out.println(result.getInt("id")+" "+ result.getString("titre")+" "+result.getString("nom")+" "+
						result.getString("prenom")+" "+result.getString("adresse"));
			}
			
		}catch(SQLException e) {
			
		}
		
	}
	
	public boolean supprimer(Echantillon echantillon) {
		
		try {
			
			String sql = "DELETE FROM contacts WHERE id = ?";
			 
			preparedState = connexion.prepareStatement(sql);
			
			preparedState.setInt(1, echantillon.getId());

			
			preparedState.executeUpdate();
			
			supprimer_tab(echantillon);
			
			return true;
			
		}catch(SQLException e) {
			
			return false;
			
		}
	}
	
	public int maxID() {
		 int max = 0;
		 
		 String sql = "SELECT MAX(id) FROM contacts";
		 
		 try {
			 
			state = connexion.createStatement();
			
			result = state.executeQuery(sql);
			
			while(result.next()) {
				max = result.getInt(1);
			}
			
			return max++;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return 0;
		}
	}
	
	
	public void ajouter_tab(Echantillon echantillon) {
		
		echantillon.setId(maxID());
		echantillon.setType("");
		
		tab_ech.add(echantillon);

	}
	
	public void supprimer_tab(Echantillon echantillon) {
		
		int indice = 0;
		boolean trouve = false;
		
		while(indice < tab_ech.size() && !trouve) {
			if(tab_ech.get(indice).getId()==echantillon.getId()) {
				tab_ech.remove(indice);
				trouve = true;
			}
		}
		
	}
	
	
}
