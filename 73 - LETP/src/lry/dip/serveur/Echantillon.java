package lry.dip.serveur;

import java.io.Serializable;

public class Echantillon implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public final static String AJOUTER 	= "Ajouter";
	public final static String SUPPRIMER 	= "Supprimer";
	public final static String ALL 	= "All";



	private String titre;
	private String nom;
	private String prenom;
	private String adresse;
	private String type;
	private int id;

	
	public Echantillon(String titre, String nom, String prenom, String adresse, String type, int id) {
		super();
		this.titre = titre;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.type = type;
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAJOUTER() {
		return AJOUTER;
	}

	public String getSUPPRIMER() {
		return SUPPRIMER;
	}

	
	

	@Override
	public String toString() {
		return "Echantillon [titre="
				+ titre + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", type=" + type + ", id="
				+ id + "]";
	}

	public void afficher() {
		System.out.println(toString());
	}
	
	
	
	
}
