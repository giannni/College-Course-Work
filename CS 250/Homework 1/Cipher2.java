 /**
 * Encrypt words using caesar cipher and base64 encrypting.
 *
 * @author Gianni Esposito
 * @version 1.0
 */
import java.util.*;
public class Cipher
{
    private static String caesarCipher(String m, int shift)
    {
        String s = "";
        
        int size = m.length();
        
        for(int i = 0; i < size; i++)
        {   
            char letter = (char)(m.charAt(i) + shift);
            
            if (letter > 'z')
                s += (char)(m.charAt(i) - (26-shift));
                else
                s += (char)(m.charAt(i) + shift);
        }
        return s;
    }
    
    static String[] words;
    public static void main()
    {
      Scanner in = new Scanner(System.in);
      System.out.print("Enter the words you would like to encrypt: ");
      String line = in.nextLine();
      String[] values = line.split(" ");
      words = Arrays.asList(values).toArray(new String[0]);
      System.out.print("Enter size of shift you would like to use: ");
      int shift = in.nextInt();
      System.out.println("Caeser cipher = " + caesarCipher(line, shift));
      byte[] encodedBytes = Base64.getEncoder().encode(line.getBytes());
      System.out.println("Base64 encryption = " + new String(encodedBytes));
    }
}
