import javax.swing.JFrame;

public class GUI extends JFrame {

	
	public GUI(int pLarg, int pHaut, boolean resizable
			, String pTitre) {
		
		this.setResizable(resizable);
		this.setSize(pLarg, pHaut);
		this.setContentPane(new Panneau());
		
		this.setVisible(true);

	}
	
}
