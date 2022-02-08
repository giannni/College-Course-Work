/**
 * Class for PolyReport
 * 
 * @author Gianni Esposito
 * @version 3/26/17
 */
import java.lang.reflect.*;
import javax.swing.*;
import java.awt.*;
public class PolyReport
{
    public PolyReport()
    {
 
    }

    public void outputDetails( TwoDShape shape)
    {
        JOptionPane.showMessageDialog(null, shape.toString());

    }
    
    public void outputArea(TwoDShape shape)
    {     
       JOptionPane.showMessageDialog(null,   "The area for the " + shape.getType() + " is " + shape.area());
    }
    
}
