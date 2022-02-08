
/**
 * Application Class.
 *
 * @author Gianni Esposito
 * @version v1.0
 */
import java.util.*;
import javax.swing.*;
public class Application extends Exception
{
   public static void main()
   {
        try
        {
            double gpa;
            String userInput;
            userInput = JOptionPane.showInputDialog(null,"Enter your gpa:");
            gpa = Double.parseDouble(userInput);
            if( gpa >= 2.5 )
            {
                 JOptionPane.showMessageDialog(null, "Your GPA qualifies you to apply for the job.");
            }
            else
            {
                throw new LowGpaException();
            }
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Did not enter a double value.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
   }
}
