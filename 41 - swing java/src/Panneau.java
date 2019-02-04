import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Panneau extends JPanel { 

	  private int posX = -50;

	  private int posY = -50;
	
  public void paintComponent(Graphics g){

    //Vous verrez cette phrase chaque fois que la méthode sera invoquée

    System.out.println("Je suis exécutée !"); 
    
    Graphics2D g2d = (Graphics2D)g;

    GradientPaint gp, gp2, gp3, gp4, gp5, gp6; 

    gp = new GradientPaint(this.getWidth() *5/6, 0, Color.RED, 20, 0, Color.magenta, true);

    gp2 = new GradientPaint(this.getWidth() *5/6, 0, Color.magenta, 40, 0, Color.blue, true);

    gp3 = new GradientPaint(this.getWidth() *5/6, 0, Color.blue, 60, 0, Color.green, true);

    gp4 = new GradientPaint(this.getWidth() *5/6, 0, Color.green, 80, 0, Color.yellow, true);

    gp5 = new GradientPaint(this.getWidth() *5/6, 0, Color.yellow, 100, 0, Color.orange, true);

    gp6 = new GradientPaint(this.getWidth() *5/6, 0, Color.orange, 120, 0, Color.red, true);


    g2d.setPaint(gp);

    g2d.fillRect(this.getWidth() *0/6, 0, this.getWidth() *1/6, this.getHeight());               

    g2d.setPaint(gp2);

    g2d.fillRect(this.getWidth() *1/6, 0, this.getWidth() *1/6, this.getHeight());

    g2d.setPaint(gp3);

    g2d.fillRect(this.getWidth() *2/6, 0, this.getWidth() *1/6, this.getHeight());

    g2d.setPaint(gp4);

    g2d.fillRect(this.getWidth() *3/6, 0, this.getWidth() *1/6, this.getHeight());

    g2d.setPaint(gp5);

    g2d.fillRect(this.getWidth() *4/6, 0, this.getWidth() *1/6, this.getHeight());

    g2d.setPaint(gp6);

    g2d.fillRect(this.getWidth() *5/6, 0, this.getWidth() *1/6, this.getHeight());

//    g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

    Font font = new Font("Courier", Font.BOLD, 20);
    g.setFont(font);
    g.setColor(Color.RED);
    g.drawString("C'est marrant ça !", 20, 20);
    
    int x1 = this.getWidth()/4;

    int y1 = this.getHeight()/4;
    
    g.setColor(Color.GREEN);
    
    g.fillOval(posX, posY, this.getWidth()/2, this.getHeight()/2);
    
    g.setColor(Color.BLUE);
    
    g.drawOval(x1-5, y1-5, this.getWidth()/2 + 10, this.getHeight()/2 + 10);
    
    

    
    

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