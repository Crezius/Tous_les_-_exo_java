package lry.dip.client;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import lry.dip.serveur.Echantillon;

public class GUI extends JFrame {


	private static final long serialVersionUID = 1L;
	
/******************** Variables ************************/
	
	private JMenuBar	menuBar = new JMenuBar();
	private JMenu	 	menuFichier = new JMenu("Fichier");	
	
	private JMenuItem itemAjouter 	= new JMenuItem("Ajouter");
	private JMenuItem itemSupprimer = new JMenuItem("Supprimer");
	private JMenuItem itemQuitter 	= new JMenuItem("Quitter");
	
	private static ModeleTable table = new ModeleTable();
	
	
	private static JTable tableau = new JTable(table);
	
	
	private int pLarg, pHaut;
	
	private boolean resizable;
	
	private String pTitre;
	
	/*
	 * Ceci n'est pas un exercice, git à pros le contrôle du monde 
	 * Je vous demande de résister par tous les moyens
	 * L'avenir de la Terre est entre vos mains gadget
	 * */

	
/******************** Constructeur ************************/

	public GUI(int pLarg, int pHaut, boolean resizable, String pTitre) throws HeadlessException {
		super();
		this.pLarg = pLarg;
		this.pHaut = pHaut;
		this.resizable = resizable;
		this.pTitre = pTitre;
		
		
		
		fenetre();
	}

/******************** Getter / Setter ************************/

	
	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JMenu getMenuFichier() {
		return menuFichier;
	}

	public void setMenuFichier(JMenu menuFichier) {
		this.menuFichier = menuFichier;
	}

	public JMenuItem getItemAjouter() {
		return itemAjouter;
	}

	public void setItemAjouter(JMenuItem itemAjouter) {
		this.itemAjouter = itemAjouter;
	}

	public JMenuItem getItemSupprimer() {
		return itemSupprimer;
	}

	public void setItemSupprimer(JMenuItem itemSupprimer) {
		this.itemSupprimer = itemSupprimer;
	}

	public JMenuItem getItemQuitter() {
		return itemQuitter;
	}

	public void setItemQuitter(JMenuItem itemQuitter) {
		this.itemQuitter = itemQuitter;
	}

	public static ModeleTable getTable() {
		return table;
	}

	public static void setTable(ModeleTable table) {
		GUI.table = table;
	}

	public static JTable getTableau() {
		return tableau;
	}

	public static void setTableau(JTable tableau) {
		GUI.tableau = tableau;
	}

	public int getpLarg() {
		return pLarg;
	}

	public void setpLarg(int pLarg) {
		this.pLarg = pLarg;
	}

	public int getpHaut() {
		return pHaut;
	}

	public void setpHaut(int pHaut) {
		this.pHaut = pHaut;
	}

	public boolean isResizable() {
		return resizable;
	}

	public void setResizable(boolean resizable) {
		this.resizable = resizable;
	}

	public String getpTitre() {
		return pTitre;
	}

	public void setpTitre(String pTitre) {
		this.pTitre = pTitre;
	}

/************************ Fonctions *************************/
	
	public void fenetre() {

		//paramètrage de la fenêtre
		this.setResizable(resizable);
		this.setSize(pLarg, pHaut);
		this.setLayout(new BorderLayout());
		
		
		// ajout de la liste déroulante dans la barre de menu
		menuBar.add(menuFichier);
		
		// ajout des élément de la liste déroulante
		menuFichier.add(itemAjouter);
		menuFichier.add(itemSupprimer);
		menuFichier.add(itemQuitter);
		
	
		// ajout de le bar de menu en haut de la fenêtre
		this.add(menuBar, BorderLayout.NORTH);
		
		// initialisation du tableau
		tableau = new JTable(table);
		
		// rendre le tableau scrollable
		this.add(new JScrollPane(tableau), BorderLayout.CENTER);
		
		// Action du bouton d'ajout
		itemAjouter.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {	
				
				// création d'un panneau
				Panneau panneau = new Panneau();
				
				// affichage d'un JOptionPane 
				int rep = JOptionPane.showConfirmDialog(null, panneau, "Ajouter", JOptionPane.OK_CANCEL_OPTION);
						if(rep == JOptionPane.YES_OPTION) {
						}
							
						// si les zone de texte ne son pas vide 
						if(!panneau.getTitre().getSelectedItem().toString().equals("") && !panneau.getNom().getText().equals("") && !panneau.getPrenom().getText().equals("") && !panneau.getAdresse().getText().equals("")) {
								System.out.println("test");
								// ajout de l'échantillon dans le tableau
								Principale.client.envoyerRequeteAjouter(new Echantillon(panneau.getTitre().getSelectedItem().toString(), panneau.getNom().getText(),
										panneau.getPrenom().getText(), panneau.getAdresse().getText(), "", 0));
								
							}
						else {
							// sinon affichage d'un pop-up d'erreur
							JOptionPane.showMessageDialog(null, "Entrée(s) erronée(s)", "Erreur", JOptionPane.ERROR_MESSAGE);
						}
						//traitement si l�usager a appuy� sur non.
			}
		} );
		
		// action du bouton supprimer
		itemSupprimer.addActionListener( new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {	
			// supprimer l'élément sélectionné	
			
			System.out.println("tableau.getSelectedRow()"+tableau.getSelectedRow());
			System.out.println("table.getData()"+table.getData().size());

			
			Principale.client.envoyerRequeteSupprimer(table.getData().get(tableau.getSelectedRow()));	
			}
		} );
		
		// action du bouton quitter
		itemQuitter.addActionListener(e -> {
			// ferme le logiciel
			
			System.exit(0);
			Principale.client.deconnecter();
		});
		
		// ajout de la barre de menu en haut de la fenêtre
		this.add(menuBar, BorderLayout.NORTH);
		
		// ajout du tableau au centre de la fenêtre 
		this.add(tableau, BorderLayout.CENTER);

		// rend la fenêtre visible
		this.setVisible(true);
	}
	
	public void actionPerformed() {
		
	}

}
