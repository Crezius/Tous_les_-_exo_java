/**
 * @author Sebastien Maudet - IUT RT La Roche sur Yon
 * Cette application a été développée dans un environnement JAVA 8 sous eclipse
 * Application graphique "Convertisseur d'unités"
 * Convertir des unités de température (Celsius / Kelvin / Farenheit)
 * Convertir des unités de distance (Mètre / Inch / Mille marin)
*/

package lry.dip.design;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import lry.dip.design.*;

public class DIP_Interface extends JFrame implements ActionListener
{
	static final long serialVersionUID = -3189544141615373629L;
	/********************************************* ATTRIBUTS *****************************************************************/
	private DIP_Panneau fond;
	private Distance distModel = new Distance();
	private Temperature tempModel = new Temperature();
	private DecimalFormat df;
	


	/********************************************* CONSTRUCTEUR **************************************************************/
	public DIP_Interface (int pLarg, int pHaut, boolean pResize, String pTitre)
	{
		//Construction des modèles de conversion d'unités de température et de distance et ouverture des bases de données
		
		//Construction de la fenêtre de classe DIP_Interface
		this.setSize(pLarg, pHaut);
		this.setResizable(pResize);
		this.setTitle(pTitre);	
//		this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/LogoIUT.png")));
				
		//Construction du conteneur (et) des composants de la fenêtre
		this.fond = new DIP_Panneau();
    	this.add(this.fond);
			
		//Positionnement et affichage de la fenêtre
		this.setLocation(200, 200);
		this.setVisible(true);
		
		//Mise à l'écoute les boutons par le listener
		this.fond.getBtnConvTemp().addActionListener(this);
		this.fond.getBtnConvDist().addActionListener(this);
		this.fond.getBtnInfoBox1().addActionListener(this);
		this.fond.getBtnInfoBox2().addActionListener(this);
		this.fond.getBtnDelete().addActionListener(this);
		
	}
	
	/********************************************* METHODES ******************************************************************/
	//Methode de gestion des actions sur les boutons
	public void actionPerformed(ActionEvent actBtn) throws java.lang.NumberFormatException
	{
		
		System.out.println(fond.getMesTemp().getText());
		try
		{
			System.out.println("actBtn.getSource() : "+actBtn.getSource());
			
			
			if (actBtn.getSource() == this.fond.getBtnConvTemp() && this.fond.getMesTemp().getText() != null)
			{


				switch(fond.getCombUnitTemp().getSelectedItem().toString()) {
					case "Celsius":
						fond.getConvTemp().setText(tempModel.convCel(Double.valueOf(fond.getMesTemp().getText())));
						break;
					case "Kelvin":
						fond.getConvTemp().setText(tempModel.convKel(Double.valueOf(fond.getMesTemp().getText())));
						break;
					case "Farenheit":
						fond.getConvTemp().setText(tempModel.convFar(Double.valueOf(fond.getMesTemp().getText())));
						break;
					default:
						break;
				}
				
				Principale.conn.selectDataTemperature();

				
			} else if (actBtn.getSource() == this.fond.getBtnConvDist() && this.fond.getMesDist().getText() != null) {
				
				switch(fond.getCombUnitDist().getSelectedItem().toString()) {
					case "Mètre":
						fond.getConvDist().setText(distModel.convMetre(Double.valueOf(fond.getMesDist().getText())));
						break;
					case "Inch":
						fond.getConvDist().setText(distModel.convInch(Double.valueOf(fond.getMesDist().getText())));
						break;
					case "Mille marin":
						fond.getConvDist().setText(distModel.convMile(Double.valueOf(fond.getMesDist().getText())));
						break;
					default:
						break;
						
				}
				
				Principale.conn.selectDataDistance();
			} else if(actBtn.getSource() == fond.getBtnDelete()) {

				Principale.conn.deleteData();
			}
			
			
			
			
		} catch(Exception Nex)
		{
			Nex.printStackTrace();
			
		}
		
		
    }
		
	/********************************************* GETTEUR - SETTEUR *********************************************************/
}
