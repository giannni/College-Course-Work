
/**
 * Application to display bar code when a zip code is entered.
 * 
 * @author Gianni Esposito 
 * @version v1
 */

import javax.swing.*;
public class PostOffice
{
    public static void main()
    {
        String userInput;
        boolean finishedInput =  false;
        PostalZipCode myMessage;
        do
        {
            userInput = JOptionPane.showInputDialog("Enter your zip code");
            userInput = userInput.toUpperCase();
            if (!userInput.isEmpty())
            {
               int checkDigit = 0;
               for(int i=0; i<userInput.length(); i++)
               {
                    checkDigit = checkDigit + Character.getNumericValue(userInput.charAt(i));
               }     
                myMessage = new PostalZipCode(userInput);
                char b = (char)Integer.toString(myMessage.checkDigit(userInput)).charAt(0) ;
                JOptionPane.showMessageDialog(null, "|" + myMessage.getZipCode()  + myMessage.getBarCode(b) + "|");
            }
            else
            {
                finishedInput =  true;
            }
        }
        while(!finishedInput);
    }
}
