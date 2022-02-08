import javax.swing.*;

public class LeapYear
{
    public static void main()
    {
        String inputYear;
        int year;
        
        inputYear = JOptionPane.showInputDialog("Enter a year");
        year = Integer.parseInt(inputYear);
        
        if ((year % 100) == 0)
        {
            if ((year % 400) == 0)
            {
                JOptionPane.showMessageDialog(null,year + " is a leap year");
            }
            else
            {
                JOptionPane.showMessageDialog(null,year + " is not a leap year");
            }
        }
        else
        {
            if ((year % 4) == 0)
            {
                JOptionPane.showMessageDialog(null,year + " is a leap year");
            }
            else 
            {
                JOptionPane.showMessageDialog(null,year + " is not a leap year");
            }
        }
    }
}
