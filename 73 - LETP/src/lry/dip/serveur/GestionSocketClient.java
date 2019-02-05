package lry.dip.serveur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GestionSocketClient  {
	
	private boolean tache = true;
	private Socket 	priseClient;
	private int		numiClient;
	private Inet4Address 	IPClient;
	private int 	portClient;
	private ObjectOutputStream 	fluxOut;
	private ObjectInputStream	fluxIn;
	
	private Serveur serveur;
	
	private Thread ecoute;
	
	public GestionSocketClient(Socket priseClient, int numiClient, Inet4Address iPClient, int portClient,
			ObjectOutputStream fluxOut, ObjectInputStream fluxIn, Serveur serveur) {
		super();
		this.priseClient = priseClient;
		this.numiClient = numiClient;
		IPClient = iPClient;
		this.portClient = portClient;
		this.fluxOut = fluxOut;
		this.fluxIn = fluxIn;
		this.serveur = serveur;
		
		
		recuperationDonnees(PrincipaleServeurTCP.conn.getTab_ech());
		
		ecouter();
	}

	public boolean isTache() {
		return tache;
	}

	public void setTache(boolean tache) {
		this.tache = tache;
	}

	public Socket getPriseClient() {
		return priseClient;
	}

	public void setPriseClient(Socket priseClient) {
		this.priseClient = priseClient;
	}

	public int getNumiClient() {
		return numiClient;
	}

	public void setNumiClient(int numiClient) {
		this.numiClient = numiClient;
	}

	public Inet4Address getIPClient() {
		return IPClient;
	}

	public void setIPClient(Inet4Address iPClient) {
		IPClient = iPClient;
	}

	public int getPortClient() {
		return portClient;
	}

	public void setPortClient(int portClient) {
		this.portClient = portClient;
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

	public void ecouter() {
				
		
		ecoute = new Thread() {
		
			int indice = 0;
			public void run() {
			
				Echantillon echantillon;
				
				while(tache) {
					System.err.println("Yop : "+indice++);
					try {
						
						Object object = fluxIn.readObject();
								
						if(object instanceof Echantillon) {
							
							echantillon = (Echantillon) object;
							
							if(echantillon.getType().equals(Echantillon.ALL)) {
								
								recuperationDonnees(PrincipaleServeurTCP.conn.getTab_ech());

							} else {
								serveur.requeteClient(echantillon);
								
								System.out.println("Message : "+echantillon.toString());
							}
							
						}
							
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						deconnecter();
						e.printStackTrace();
					}
					
				}
			}
			
		};
		
		ecoute.start();
	}
	
	public void envoiReponse(Echantillon echantillon) {
		try {
			System.out.println("test : "+echantillon.toString());
			fluxOut.writeObject(echantillon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void recuperationDonnees(ArrayList<Echantillon> tab_ech) {
		
		try {
			
			for(Echantillon echantillon : tab_ech) {
				echantillon.setType("");
				fluxOut.writeObject(echantillon);
				fluxOut.flush();
			}
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deconnecter() {
		try {
			fluxOut.close();
			fluxIn.close();
			priseClient.close();
			
			tache = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
