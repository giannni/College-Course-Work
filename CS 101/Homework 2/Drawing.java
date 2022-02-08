
/**
 * Implement a drawing.
 * 
 * @author Gianni Esposito
 * @version 
 */
import java.awt.*;
import javax.swing.*;
public class Drawing extends JPanel
{
   public void paintComponent(Graphics g)
   {
       super.paintComponent(g);
       //Sets background color
       this.setBackground(Color.white);
       //Sets color of rectangle and draws it
       Color rectcolor = new Color(6,171,0);
       g.setColor(rectcolor);
       //x,y,w,h
       g.fillRect(170,20,200,110);
       //left leg
       g.setColor(Color.black);
       g.fillRect(200,130,5,100);
       //right leg
       g.setColor(Color.black);
       g.fillRect(325,130,5,100);
       //London Text
       Font myFont = new Font ("Sans Serif", Font.BOLD, 20);
       g.setFont(myFont);
       g.setColor(Color.white);
       g.drawString("London",230,40);
       //A 40 Text
       g.setFont(myFont);
       g.setColor(Color.yellow);
       g.drawString("A 40",310,40);
       //Islip Text
       g.setFont(myFont);
       g.setColor(Color.white);
       g.drawString("Islip",170,100);
       //Stanton St John Text
       g.setFont(myFont);
       g.setColor(Color.white);
       g.drawString("Stanton St John",170,120);
       //B 4027 Text
       g.setFont(myFont);
       g.setColor(Color.yellow);
       g.drawString("B 4027",210,100);
       //Draws road and sets color
       g.setColor(Color.white);
       Polygon road = new Polygon();
       //Left tip of road
       road.addPoint(230,70);
       road.addPoint(238,77);
       road.addPoint(238,63);
       g.fillPolygon(road);
       //Road left side
       g.setColor(Color.white);
       g.fillRect(238,63,110,14);
       //Top tip of road
       g.setColor(Color.white);
       Polygon road1 = new Polygon();
       road1.addPoint(350,40);
       road1.addPoint(358,47);
       road1.addPoint(342,47);
       g.fillPolygon(road1);
       //Road right side
       g.setColor(Color.white);
       g.fillRect(342,47,16,80);
   }
}
