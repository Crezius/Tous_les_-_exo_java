package lry.dip.client;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import lry.dip.serveur.Echantillon;

public class Client {
	
	private int portServeur;
	private Inet4Address ip;
	private Socket serveur;
	private ObjectOutputStream 	fluxOut;
	private ObjectInputStream	fluxIn;
	
	private Thread ecoute;
	
	private ArrayList<Echantillon> init_tableau = new ArrayList<Echantillon>();
	
	
	
	public Client(int portServeur, String ip) {
		super();
		this.portServeur = portServeur;
		
		try {
			this.ip = (Inet4Address) Inet4Address.getByName(ip);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		connecter();
		
		ecouter();
	}
	
	
	
	
	public int getPortServeur() {
		return portServeur;
	}

	public void setPortServeur(int portServeur) {
		this.portServeur = portServeur;
	}

	public Inet4Address getIp() {
		return ip;
	}

	public void setIp(Inet4Address ip) {
		this.ip = ip;
	}

	public Socket getServeur() {
		return serveur;
	}

	public void setServeur(Socket serveur) {
		this.serveur = serveur;
	}

	public ObjectOutputStream getFluxOut() {
		return fluxOut;
	}

	public void setFluxOut(ObjectOutputStream fluxOut) {
		this.fluxOut = fluxOut;
	}

	public ObjectInputStream getFluxIn() {
		return fluxIn;
	}

	public void setFluxIn(ObjectInputStream fluxIn) {
		this.fluxIn = fluxIn;
	}

	public Thread getEcoute() {
		return ecoute;
	}

	public void setEcoute(Thread ecoute) {
		this.ecoute = ecoute;
	}

	public ArrayList<Echantillon> getInit_tableau() {
		return init_tableau;
	}

	public void setInit_tableau(ArrayList<Echantillon> init_tableau) {
		this.init_tableau = init_tableau;
	}
	
	
	

	public void connecter() {
	
		try {
			serveur = new Socket(ip ,this.portServeur);
			
			fluxOut = new ObjectOutputStream(serveur.getOutputStream());
			fluxIn 	= new ObjectInputStream(serveur.getInputStream());

		} 
		catch (Exception e) {
			
			portServeur++;
			
			if(portServeur < 3005) {
				
				connecter();
				
			} else {
				
				e.printStackTrace();
				
			}
		} 
	}

				
	@SuppressWarnings("unchecked")
	
	public void ecouter() {
		
		ecoute = new Thread() {
		
			public void run() {
				
				int test = 0;
				
				boolean tache = true;
				Echantillon echantillon;
				
				while(tache) {
					
					try {
						
						Object object = fluxIn.readObject();
								
						
						System.err.println("et c'est le test : "+test);
						System.out.println("object instanceof Echantillon : "+(object instanceof Echantillon));

						test++;
						
						if(object instanceof Echantillon) {
							
							
							
							echantillon = (Echantillon) object;
							
							echantillon.afficher();
							
							if(echantillon.getType().equals(Echantillon.AJOUTER)) {
								
								System.err.println("Coucou");
								echantillon.afficher();
								ajouterEchantillonTab(echantillon);
								
							} else if(echantillon.getType().equals(Echantillon.SUPPRIMER)){
								
								supprimerEchantillonTab(echantillon);
								
							} else if(echantillon.getType().equals("")) {
								init_tableau.add(echantillon);
							}
							
						} 
							
					} catch (ClassNotFoundException e) {
						deconnecter();
						tache = false;
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						deconnecter();
						tache = false;
						e.printStackTrace();
						
					}
					
				}
			}
		};
		
		ecoute.start();
	}

		
	public void deconnecter()
	{
		try {
			serveur.close();
			fluxIn.close();
			fluxOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void envoyerRequeteAjouter(Echantillon echantillon)  {
	
		echantillon.setType(Echantillon.AJOUTER);
		try {
			fluxOut.writeObject(echantillon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	} 
	
	public void envoyerRequeteRemplir()  {
		
		Echantillon echantillon = new Echantillon("", "", "", "", "ALL", 0);
		
		try {
			fluxOut.writeObject(echantillon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void envoyerRequeteSupprimer(Echantillon echantillon) {
		
		echantillon.afficher();
		echantillon.setType(Echantillon.SUPPRIMER);
		try {
			fluxOut.writeObject(echantillon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void remplirTab(ArrayList<Echantillon> tab) {
		
		tab.clear();
		
		try {
			for(Echantillon echantillon: init_tableau) {
					
				tab.add(echantillon);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ajouterEchantillonTab(Echantillon echantillon) {
		GUI.getTable().addData(echantillon);
	}
	
	public void supprimerEchantillonTab(Echantillon echantillon) {
		
		int indice = 0;
		boolean trouve  = false;
		
		while(indice < GUI.getTable().getData().size() && !trouve) {
			if(GUI.getTable().getData().get(indice).getId()==echantillon.getId()) {
				GUI.getTable().removeData(indice);
				
				trouve = true;
			}
		}
		
		
		
	}
	
}