import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class BorderExample extends JFrame implements MouseListener 
{

    BevelBorder bevel;
    LineBorder pinkLine, greenLine;
    JLabel labelOne, labelTwo;

  
    public static void main() 
    {
        BorderExample frame = new BorderExample();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 100);
        frame.createGUI();
        frame.setVisible(true);
    }
    
    public void createGUI() 
    { 
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      Container window = getContentPane();
      window.setLayout(new FlowLayout());
      //window.setLayout(new GridLayout(1,2));
      
      bevel = new BevelBorder(BevelBorder.RAISED);
      pinkLine = new LineBorder(Color.pink,3);
      greenLine = new LineBorder(Color.green,5);

      labelOne = new JLabel("This is button one");
      labelTwo = new JLabel("This is button two");

      labelOne.addMouseListener(this);
      labelOne.setBorder(pinkLine);
      window.add(labelOne);
      
      labelTwo.addMouseListener(this);
      labelTwo.setBorder(bevel);  
      window.add(labelTwo);  
    }
      
    public void mouseEntered(MouseEvent e) {
      ((JLabel) e.getComponent()).setBorder(bevel);
      repaint();
    }
    
    public void mouseExited(MouseEvent e) {
      ((JLabel) e.getComponent()).setBorder(pinkLine);
      repaint();
    }
    
    public void mousePressed(MouseEvent e) {
        ((JLabel) e.getComponent()).setBorder(greenLine);
        repaint();
    }
    
    public void mouseReleased(MouseEvent e) {
      ((JLabel) e.getComponent()).setBorder(bevel);
      repaint();
    }
    
    public void mouseClicked(MouseEvent e) {
	   //Event listener implementation goes here...
	   //Toolkit.getDefaultToolkit().beep();
    }
}
