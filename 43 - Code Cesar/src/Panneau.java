import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Panneau extends JPanel {

	
	private JLabel indication 		= new JLabel("Coder / Decoder votre texte ci-dessous : ");
	private JLabel indCle 			= new JLabel("clé : ");

	private JComboBox<Integer> key 	= new JComboBox<>();
	
	private JTextArea message 		= new JTextArea(20, 1);
	
	private JTextField adresseIp	= new JTextField();
	
	private JButton btn_coder 		= new JButton("CODER");
	private JButton btn_decoder 	= new JButton("DECODER");
	private JButton btn_ouvrir 		= new JButton("OUVRIR");
	private JButton btn_enregistrer = new JButton("ENREGISTRER");
	private JButton btn_send		= new JButton("ENVOYER");

	
	
	public Panneau() {
		
		
		
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints  grid = new GridBagConstraints ();
				
		this.setBackground(Color.GRAY);
		
		grid.fill = GridBagConstraints.HORIZONTAL;
		
		grid.gridx = 0;
		grid.gridy = 0;
		grid.gridwidth = 2;
		grid.gridheight = 1;

		this.add(indCle, grid);
		
		grid.gridx = 2;
		grid.gridy = 0;
		grid.gridwidth = 3;
		grid.gridheight = 1;

		this.add(key, grid);
		
		grid.gridx = 0;
		grid.gridy = 1;
		grid.gridwidth = 5;
		grid.gridheight = 1;
		grid.weightx = 0.5;


		this.add(indication, grid);

		grid.gridx = 0;
		grid.gridy = 2;
		grid.gridwidth = 5;
		grid.gridheight = 4;
		grid.weighty = 1;

		this.add(message, grid);
		
		grid.gridx = 0;
		grid.gridy = 6;
		grid.gridwidth = 2;
		grid.gridheight = 1;

		this.add(btn_coder, grid);
		
		grid.gridx = 2;
		grid.gridy = 6;
		grid.gridwidth = 3;
		grid.gridheight = 1;

		this.add(btn_decoder, grid);
		
		grid.gridx = 0;
		grid.gridy = 7;
		grid.gridwidth = 2;
		grid.gridheight = 1;

		this.add(btn_ouvrir, grid);
		
		grid.gridx = 2;
		grid.gridy = 7;
		grid.gridwidth = 3;
		grid.gridheight = 1;

		this.add(btn_enregistrer, grid);
		
		grid.gridx = 0;
		grid.gridy = 8;
		grid.gridwidth = 5;
		grid.gridheight = 1;

		this.add(adresseIp, grid);
		
		grid.gridx = 0;
		grid.gridy = 9;
		grid.gridwidth = 5;
		grid.gridheight = 1;

		this.add(btn_send, grid);
		
	}



	public JLabel getIndication() {
		return indication;
	}



	public void setIndication(JLabel indication) {
		this.indication = indication;
	}



	public JComboBox<Integer> getKey() {
		return key;
	}



	public void setKey(JComboBox<Integer> key) {
		this.key = key;
	}



	public JTextArea getMessage() {
		return message;
	}



	public void setMessage(JTextArea message) {
		this.message = message;
	}



	public JTextField getAdresseIp() {
		return adresseIp;
	}



	public void setAdresseIp(JTextField adresseIp) {
		this.adresseIp = adresseIp;
	}



	public JButton getBtn_coder() {
		return btn_coder;
	}



	public void setBtn_coder(JButton btn_coder) {
		this.btn_coder = btn_coder;
	}



	public JButton getBtn_decoder() {
		return btn_decoder;
	}



	public void setBtn_decoder(JButton btn_decoder) {
		this.btn_decoder = btn_decoder;
	}



	public JButton getBtn_ouvrir() {
		return btn_ouvrir;
	}



	public void setBtn_ouvrir(JButton btn_ouvrir) {
		this.btn_ouvrir = btn_ouvrir;
	}



	public JButton getBtn_enregistrer() {
		return btn_enregistrer;
	}



	public void setBtn_enregistrer(JButton btn_enregistrer) {
		this.btn_enregistrer = btn_enregistrer;
	}



	public JButton getBtn_send() {
		return btn_send;
	}



	public void setBtn_send(JButton btn_send) {
		this.btn_send = btn_send;
	}
	
	
	
	
	
}
