import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class Application
{
   public static void main()
   {
       String aLine = "", theString = ""; 
       String pattern = "money to bank", pattern2 = "free cash", pattern3 = "get cash now";
       int location, location2, location3;
       File inFile;
       Scanner inputFile;
       // build a string from a file
       try 
       {
           inFile = new File("data.txt");
           inputFile = new Scanner(inFile);
           while (inputFile.hasNext()) {
              aLine = inputFile.nextLine();
              theString += aLine;
           }
       }
       catch (IOException e) 
       {
           JOptionPane.showMessageDialog(null,"Input File Error","Error",JOptionPane.ERROR_MESSAGE);
           System.exit(-1);
       }
             
       
       do 
       { 
          location = KMP.KMP(theString,pattern);
          if (location >= 0) 
          {
              JOptionPane.showMessageDialog(null, "Spam found using pattern 1.","Spam Found", JOptionPane.ERROR_MESSAGE);
              break;
          }
          else
          {
              JOptionPane.showMessageDialog(null, "File is safe.", "Safe file", JOptionPane.INFORMATION_MESSAGE);
              break;
          }  
       } while (pattern != null);
       
       do
       {
          location2 = KMP.KMP(theString,pattern2);
          if (location2 >= 0) 
          {
              JOptionPane.showMessageDialog(null, "Spam found using pattern 2.","Spam Found", JOptionPane.ERROR_MESSAGE);
              break;
          }
          else
          {
              JOptionPane.showMessageDialog(null, "File is safe.", "Safe file", JOptionPane.INFORMATION_MESSAGE);
              break;
          }
       }while (pattern2 != null);
       
       do
       {
          location3 = KMP.KMP(theString,pattern3);
          if (location3 >= 0) 
          {
              JOptionPane.showMessageDialog(null, "Spam found using pattern 3.","Spam Found", JOptionPane.ERROR_MESSAGE);
              break;
          }
          else
          {
              JOptionPane.showMessageDialog(null, "File is safe.", "Safe file", JOptionPane.INFORMATION_MESSAGE);
              break;
          }
       }while (pattern3 != null);
   }
}