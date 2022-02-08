
/**
 * Class for TwoDShape
 * 
 * @author Gianni Esposito
 * @version 3/26/17
 */
public  abstract class TwoDShape
{
    private double width;
    private double height;
    private double length;
    private String type;
    
    private static int shapeCount;
    
    public TwoDShape()
    {
        this.width = 0.0;
        this.height = 0.0;
        this.length = 0.0;
        type = "unknown";
        shapeCount++;
    }
    
    public TwoDShape(String type, double width, double height, double length)
    {
        this.type = type;
        this.width = width;
        this.height = height;
        this.length = length;
        shapeCount++;
    }
    
    public String getType()
    {
        return type;
    }

    public double getWidth()
    {
        return width;
    }
    
    public double getHeight()
    {
        return height;
    }
    
    public double getLength()
    {
        return length;
    }
    
    public String toString()
    {
        return "The shape type is " + type + "\n" +
                  "Width is " + width + " Height is " + height + " Length is " + length;
    }
    
    public void setWidth( double width)
    {
        this.width = width;
    }
    
    public void setHeight( double height)
    {
        this.height = height;
    }
    
    public void setLength( double length)
    {
        this.length = length;
    }
    
    public void printShapeCount()
    {
        System.out.println("Number of shapes created is " + shapeCount);
    }
    
    public abstract double area();
}
