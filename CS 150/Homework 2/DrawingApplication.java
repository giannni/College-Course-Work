import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import javax.swing.*;

public class DrawingApplication extends JFrame
{
    public static void main ()
    {
       DrawingApplication frame = new DrawingApplication();
       frame.setSize(700,600);
       frame.setTitle("Draw Houses");
       
       Drawing myDrawing;
       myDrawing = new Drawing(); 
       
       frame.add(myDrawing);
       frame.setVisible(true);
        
       frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}