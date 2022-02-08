
/**
 * Class for ShapeMaker
 * 
 * @author Gianni Esposito
 * @version 3/26/17
 */
public class ShapeMaker
{
    public ShapeMaker()
    {
        
    }

    public TwoDShape getShape()
    {
        
        int shapeType = (int)(2 * Math.random() + 1);
        double width = (10 * Math.random() );
        double height = (10 * Math.random() );
        double length = (10 * Math.random() );
        if ( shapeType == 1 )
        {
            String type;
            int triangleType = (int)(3 * Math.random() + 1);
            if (triangleType == 1)
               type = "Scalene";
            else
            if (triangleType == 2)
               type = "Isoceles";
            else
               type = "Equliateral";
            return new Triangle(type, width, height, length);
        }
        else
            return new Rectangle( width, height, length);
    }   
}
