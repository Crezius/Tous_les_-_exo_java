import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Panneau extends JPanel {

  private int posX = -50;
  private int posY = -50;

  public void paintComponent(Graphics g) {
	  
	    Graphics2D g2d = (Graphics2D)g;

    // On décide d'une couleur de fond pour notre rectangle
    g.setColor(Color.white);
    // On dessine celui-ci afin qu'il prenne tout la surface
    
//  g.fillRect(posX, posY, this.getWidth(), this.getHeight());
    // On redéfinit une couleur pour notre rond
    g.setColor(Color.red);
    // On le dessine aux coordonnées souhaitées
    g.fillOval(posX, posY, 50, 50);
    
    g.setColor(Color.GREEN);
    
    g.fillOval(posX, posY, this.getWidth()/2, this.getHeight()/2);
    
    g.setColor(Color.BLUE);
    
    g.drawOval(posX-5, posY-5, this.getWidth()/2 -100 , this.getHeight()/2 - 100);
    
    GradientPaint gp;
    gp = new GradientPaint(posX, 0, Color.RED, posY*2, posX, Color.magenta, true);
    g2d.setPaint(gp);
    g2d.fillRect(posY, 0, posX, this.getHeight());     
    
  }

  public int getPosX() {
    return posX;
  }

  public void setPosX(int posX) {
    this.posX = posX;
  }

  public int getPosY() {
    return posY;
  }

  public void setPosY(int posY) {
    this.posY = posY;
  }
}