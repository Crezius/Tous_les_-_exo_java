/**
 * @author Sebastien Maudet - IUT RT La Roche sur Yon
 * Cette application a été développée dans un environnement JAVA 8 sous eclipse
 * Application graphique "Convertisseur d'unités"
 * Convertir des unités de température (Celsius / Kelvin / Farenheit)
 * Convertir des unités de distance (Mètre / Inch / Mille marin)
*/

package lry.dip.design;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.text.NumberFormatter;

public class DIP_Panneau extends JPanel
{
	private static final long serialVersionUID = -1453283654327226275L;
	/********************************************* ATTRIBUTS *****************************************************************/
	private BufferedImage monImage = null;

	
	private JFormattedTextField mesTemp, mesDist;
	private JComboBox unitTemp, unitDist;
	private JButton btnConvDist, btnConvTemp, btnDelete;
	private FlowLayout structure;
	private JLabel convTemp, convDist;
	
	private JSeparator ligne;
	private JButton butInfoBox1;
	private JButton butInfoBox2;

	
	/********************************************* CONSTRUCTEUR **************************************************************/
	public DIP_Panneau ()
	{
		//Construction des composants graphiques		
		this.mesTemp = new JFormattedTextField(new NumberFormatter(new DecimalFormat("##.##")));
		this.mesTemp.setPreferredSize(new Dimension(96, 24));
		this.mesTemp.setBorder(BorderFactory.createLineBorder(new Color(50, 100, 200)));
		
		this.mesDist = new JFormattedTextField(new NumberFormatter(new DecimalFormat("##.##")));
		this.mesDist.setPreferredSize(new Dimension(96, 24));
		this.mesDist.setBorder(BorderFactory.createLineBorder(new Color(50, 100, 200)));
		
		this.unitTemp = new JComboBox();
		this.unitTemp.addItem("Celsius");
		this.unitTemp.addItem("Kelvin");
		this.unitTemp.addItem("Farenheit");
		
		this.unitDist = new JComboBox();
		this.unitDist.addItem("Mètre");
		this.unitDist.addItem("Inch");
		this.unitDist.addItem("Mille marin");
		
		this.btnConvDist = new JButton("Convertir");
		this.btnConvTemp = new JButton("Convertir");
		this.btnDelete	 = new JButton("Delete");
		
		this.convTemp = new JLabel();
		this.convTemp.setPreferredSize(new Dimension(300,36));
		this.convTemp.setBorder(BorderFactory.createLineBorder(new Color(50, 100, 200)));
		this.convTemp.setBackground(Color.WHITE);
		this.convTemp.setOpaque(true);
		
		this.butInfoBox1 = new JButton("?");
		this.butInfoBox1.setBounds(20, 20, this.butInfoBox1.getPreferredSize().width, this.butInfoBox1.getPreferredSize().height);
		
		this.butInfoBox2 = new JButton("?");
		this.butInfoBox2.setBounds(20, 20, this.butInfoBox2.getPreferredSize().width, this.butInfoBox2.getPreferredSize().height);
				
		this.convDist = new JLabel();
		this.convDist.setPreferredSize(new Dimension(300,36));
		this.convDist.setBorder(BorderFactory.createLineBorder(new Color(50, 100, 200)));
		this.convDist.setBackground(Color.WHITE);
		this.convDist.setOpaque(true);
		
		this.ligne = new JSeparator();
		this.ligne.setPreferredSize(new Dimension (560,10));
		
		this.structure = new FlowLayout();
		this.setLayout(this.structure);
		
		//Ajout des composants au conteneur
		this.add(this.mesTemp);
		this.add(this.unitTemp);
		this.add(this.btnConvTemp);
		this.add(this.convTemp);
		this.add(this.btnDelete);
		this.add(this.butInfoBox1);
		this.add(this.ligne);
		this.add(this.mesDist);
		this.add(this.unitDist);
		this.add(this.btnConvDist);
		this.add(this.convDist);
		this.add(this.butInfoBox2);
	}
	
	/********************************************* METHODES ******************************************************************/
	//Méthode qui affiche l'image de fond du conteneur
	public void paintComponent(Graphics crayon)
	{
		super.paintComponent(crayon);
		
		//Affichage de l'image contenue dans le conteneur
		try {
//			this.monImage = ImageIO.read(this.getClass().getResource("images/FondUNGrey.png"));
			crayon.drawImage(monImage, 0, 0, this.getWidth(), this.getHeight(), this);
		}
		catch (Exception event) { System.out.println("L'image de fond n'a pas été chargé."); }
	}
	
	/********************************************* GETTEUR - SETTEUR *********************************************************/
	public JButton getBtnConvTemp() { return this.btnConvTemp; }
	public JButton getBtnConvDist() { return this.btnConvDist; }
	public JButton getBtnDelete() { return this.btnDelete;}
	public JComboBox getCombUnitTemp() { return this.unitTemp; }
	public JComboBox getCombUnitDist() { return this.unitDist; }
	public JFormattedTextField getMesTemp() { return this.mesTemp; }
	public JFormattedTextField getMesDist() { return this.mesDist; }
	public JLabel getConvTemp() { return this.convTemp; }
	public JLabel getConvDist() { return this.convDist; }
	public JButton getBtnInfoBox1() { return this.butInfoBox1; }
	public JButton getBtnInfoBox2() { return this.butInfoBox2; }
}
