import java.awt.*;
import javax.swing.*;

//public class DrawingApplication extends JFrame
public class DrawingApplication 
{
    public static void main ()
    {
        JFrame frame = new JFrame();
        frame.setSize(800,300);
        frame.setTitle("Draw squares");
        
        Drawing myDrawing;
        myDrawing = new Drawing();
        frame.add(myDrawing);
        
        frame.setVisible(true);
    }
}
