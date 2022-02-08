
/**
 * Class for ShapeTesting
 * 
 * @author Gianni Esposito
 * @version 3/26/17
 */
import javax.swing.*;
import java.awt.*;
public class Application
{
    public static void main ( String [] args)
    {
        ShapeMaker sf = new ShapeMaker();      
        PolyReport pr =  new PolyReport();
        TwoDShape shape;
        
        for ( int i = 0 ; i < 2; i++)
        {
            shape = sf.getShape();
            pr.outputDetails(shape);
            pr.outputArea(shape);
            System.out.println();
        }
    }
}
