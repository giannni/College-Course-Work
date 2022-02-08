
import java.util.Stack;
import javax.swing.*;
import java.util.*;

public class SmartString
{
    private StringBuilder theString;
    private Stack <String> undoStack = new Stack <String>();
    private static final String INSERT ="I ";
    private static final String DELETE = "D ";
    
    public SmartString()
    {
        theString = new StringBuilder();
    }
    
    public SmartString(String theString)
    {
        this.theString = new StringBuilder(theString);
    }
    
    public void insert (int position, String subString)
    {
        if (theString.length() > position) {
            theString.insert(position,subString);
        }
        else {
            theString.insert(theString.length(), subString);
        }
        undoStack.push(DELETE + position + " " + subString.length());   
    }
    
    private void undoInsert (int position, String subString)
    {
        String newString = subString.substring(1);
        if (theString.length() > position) {
            theString.insert(position,newString);
        }
        else {
            theString.insert(theString.length(), newString);
        }
    }
    
    public void delete (int position, int length)
    {     
        String deletedString = "";
        if (theString.length() >= position+length) {       
            deletedString = theString.substring(position,position+length);
            theString.delete(position,position+length);
        }
        else {
            deletedString = theString.substring(position,theString.length());
            theString.delete(position,theString.length());
        }
        undoStack.push(INSERT + position + " " + deletedString);   
    }
    
    private void undoDelete (int position, int length)
    {     
        if (theString.length() >= position+length) {       
            theString.delete(position,position+length);
        }
        else {
            theString.delete(position,theString.length());
        }
    }
    
    public void undo ()
    {
        Scanner myScanner;
        String lastCommand = "";
        if (undoStack.empty()) {
             JOptionPane.showMessageDialog(null,"Nothing to undo","Error",JOptionPane.ERROR_MESSAGE);
        }
        else {
             lastCommand = undoStack.pop();
             myScanner = new Scanner(lastCommand).useDelimiter(" ");
             switch (lastCommand.charAt(0)) {
                 case 'D' :  myScanner.next();
                             undoDelete(myScanner.nextInt(),myScanner.nextInt());
                             break;
                 case 'I' :  myScanner.next();
                             undoInsert(myScanner.nextInt(),myScanner.nextLine());
              }
        }
    }   
    
    public String toString()
    {
        return theString.toString();
    }
}