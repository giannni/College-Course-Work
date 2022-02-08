
/**
 * Class for Triangle
 * 
 * @author Gianni Esposito
 * @version 3/26/17
 */
import javax.swing.*;
import java.awt.*;
public class Triangle extends TwoDShape
{
    private String style;
    
    public Triangle(String type, String style, double width, double height, double length)
    {
        super(type, width, height, length);
        this.style = style;
    }
    
    public Triangle(String style, double width, double height, double length)
    {
        super("Triangle", width, height, length);
        this.style = style;
    }

    public double area()
    {
        return getWidth() * getHeight() / 2.0 ;
    }
    
    public void printStyle()
    {
        JOptionPane.showMessageDialog(null,"The triangle is " + style);
    }
    
    public String getStyle()
    {
        return style;
    }
    
    public String  toString()
    {
        return super.toString() + "\n" +
                      "The triangle is " + style;
        
    }
    

}
