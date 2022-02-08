import javax.swing.*;
import java.awt.*;

public class Hello 
{
    public  static void main()
    {
       // Version 1
       // System.out.println("Hello World");
        
       /* Version 2
       JFrame frame = new JFrame("My First Program");
       frame.setSize(250,100);
       frame.setLayout(new FlowLayout());
       JLabel myLabel = new JLabel("Hello World!");
       myLabel.setFont(new Font("Serif", Font.BOLD, 30));
       frame.add(myLabel);
       frame.setVisible(true);
       */

        //version 3
        JFrame frame = new JFrame("My First Program");
        frame.setSize(900,500);
        frame.setLayout(new FlowLayout());
        ImageIcon myPicture = new ImageIcon("blimp.png");
        JLabel myLabel = new JLabel(myPicture);
        frame.add(myLabel);
        frame.setVisible(true);  
        */
    }
}
