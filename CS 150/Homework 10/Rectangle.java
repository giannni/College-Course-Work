
/**
 * Class for Rectangle
 * 
 * @author Gianni Esposito
 * @version 3/26/17
 */
import javax.swing.*;
import java.awt.*;
public class Rectangle extends TwoDShape
{
    public Rectangle(double width, double height, double length)
    {
        super("Rectangle", width, height, length);
    }

    public double area()
    {
        return getWidth() * getLength();
    }
    
    public void printType()
    {
        JOptionPane.showMessageDialog(null,"The shape is a Rectangle");
    }
    
    public String toString()
    {
         return super.toString();
    }
}
