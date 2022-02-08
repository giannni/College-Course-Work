/**
 * Road Sign program 1
 * 
 * @author Gianni Esposito
 * @version 12/1/16
 */
import java.awt.*;
import javax.swing.*;

public class DrawingApplication extends JFrame
{
    public static void main()
    {
        JFrame myFrame = new JFrame();
        myFrame.setSize(500,300);
        myFrame.setTitle("Sign Program");
     
        Drawing myDrawing;
        myDrawing = new Drawing();
        myFrame.add(myDrawing);
        
        myFrame.setVisible(true);
    }
}
