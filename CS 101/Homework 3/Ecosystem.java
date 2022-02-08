/*
 * Determine biome based on amount of rainfall in inches.
 * 
 * @author Gianni Esposito 
 * @version 12/15/16
 */
import javax.swing.*;
public class Ecosystem extends JFrame
{
    public static void main()
    {
        String userInput;
        int rainfall;
        final int RAIN_FOREST=60, DECIDUOUS_FOREST=30, GRASSLAND=10, UPPER_LIMIT=100, LOWER_LIMIT=0;
        
        userInput = JOptionPane.showInputDialog(null,"Enter the amount of rainfall.","Biome Program",JOptionPane.QUESTION_MESSAGE);
        
        if (userInput != null)
        {
            rainfall = Integer.parseInt(userInput);
            if ((rainfall > UPPER_LIMIT) || (rainfall < LOWER_LIMIT))
            {
                JOptionPane.showMessageDialog(null,"Rainfall is too extreme.","Input error",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
               if (rainfall >= RAIN_FOREST) 
               {
                   JOptionPane.showMessageDialog(null,"It is probably a rain forest.");    
               }
               else if (rainfall >= DECIDUOUS_FOREST)
               {
                   JOptionPane.showMessageDialog(null,"It is probably a temperate deciduous forest.");   
               }
               else if (rainfall >= GRASSLAND)
               {
                   JOptionPane.showMessageDialog(null,"It is probably a grassland.");
               }
               else
               {
                   JOptionPane.showMessageDialog(null,"It is probably a desert.");
               }
            }
        }
    }
}
