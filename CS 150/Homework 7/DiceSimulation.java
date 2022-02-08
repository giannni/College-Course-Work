
/**
 * A program that simulates rolling a pair of dice 9,000 times and counts the number of times doubles are rolled for each of the different possible pairs of doubles. 
 * 
 * @author Gianni Esposito 
 * @version 1/31/17
 */
import java.util.Random;
import javax.swing.*;
import java.awt.*;
public class DiceSimulation
{
    public static void main()
    {
        final int number = 3000;   //the number of times to roll the dice
               
        Random generator = new Random();
        int die1Value;             
        int die2Value;            
        int count = 0;            
        int snakeEyes = 0;       
        int twos = 0;           
        int threes = 0;        
        int fours = 0;        
        int fives = 0;       
        int sixes = 0;      
                
        while (count < number)
        {
            die1Value = generator.nextInt(6) + 1; 
            die2Value = generator.nextInt(6) + 1;
            if (die1Value == die2Value)
            {
                if (die1Value == 1)
                { 
                    snakeEyes = snakeEyes + 1; 
                }
                else if (die1Value == 2)
                { 
                    twos = twos + 1; 
                }
                else if (die1Value == 3)
                { 
                    threes = threes + 1; 
                }
                else if (die1Value == 4)
                { 
                    fours = fours + 1; 
                }
                else if (die1Value == 5)
                { 
                    fives = fives + 1; 
                }
                else if (die1Value == 6)
                { 
                    sixes = sixes + 1; 
                }
            }
            count++;
        }

        do
        {
            die1Value = generator.nextInt(6) + 1; 
            die2Value = generator.nextInt(6) + 1;
            if (die1Value == die2Value)
            {
                if (die1Value == 1)
                { 
                    snakeEyes = snakeEyes + 1; 
                }
                else if (die1Value == 2)
                { 
                    twos = twos + 1; 
                }
                else if (die1Value == 3)
                {   
                    threes = threes + 1; 
                }
                else if (die1Value == 4)
                {    
                    fours = fours + 1; 
                }
                else if (die1Value == 5)
                { 
                    fives = fives + 1; 
                }
                else if (die1Value == 6)
                { 
                    sixes = sixes + 1; 
                }
            }
            count++;
        }   while (count < number);

        for (count=0; count < number; count++)
        {
            die1Value = generator.nextInt(6) + 1; 
            die2Value = generator.nextInt(6) + 1;
            if (die1Value == die2Value)
            {
                if (die1Value == 1)
                { 
                    snakeEyes = snakeEyes + 1; 
                }
                else if (die1Value == 2)
                { 
                    twos = twos + 1; 
                }
                else if (die1Value == 3)
                {    
                    threes = threes + 1; 
                }
                else if (die1Value == 4)
                { 
                    fours = fours + 1; 
                }
                else if (die1Value == 5)
                { 
                    fives = fives + 1; 
                }
                else if (die1Value == 6)
                { 
                    sixes = sixes + 1; 
                }
            }
        }
        JOptionPane.showMessageDialog(null,"You rolled snake eyes " + snakeEyes + "\n You rolled double twos " + twos + "\n You rolled double threes " + threes + "\n You rolled double fours " + fours + "\n You rolled double fives " + fives + "\n You rolled double sixes " + sixes);
        
    }
}
