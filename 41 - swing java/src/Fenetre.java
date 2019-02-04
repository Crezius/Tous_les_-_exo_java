import java.awt.Color; 

import javax.swing.JFrame;

import javax.swing.JPanel;

 

public class Fenetre extends JFrame {

	Panneau pan = new Panneau ();
	
  public Fenetre(){             

    this.setTitle("Ma première fenêtre Java");

    this.setSize(500, 500);

    this.setLocationRelativeTo(null);               

 

    //Instanciation d'un objet JPanel

    JPanel pan = new JPanel();

    //Définition de sa couleur de fond

    pan.setBackground(Color.ORANGE);        

    //On prévient notre JFrame que notre JPanel sera son content pane

//    this.setContentPane(pan); 
    
    this.setContentPane(new Panneau());

    this.setVisible(true);
    
    while(true) {
    	go();
    }

  }       
  
  
  private void go(){

	    for(int i = -50; i < pan.getWidth(); i++){

	      int x = pan.getPosX(), y = pan.getPosY();

	      x++;

	      y++;

	      System.out.println("x : "+x+" y : "+y);
	      pan.setPosX(x);

	      pan.setPosY(y);

	      pan.repaint();  

	      try {

	        Thread.sleep(100);

	      } catch (InterruptedException e) {

	        e.printStackTrace();

	      }

	    }

	  }       

}