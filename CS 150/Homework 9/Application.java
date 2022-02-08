
/**
 * Write a description of class Application here.
 * 
 * @author Gianni Esposito
 * @version (a version number or a date)
 */
import java.util.Arrays;
import java.util.ArrayList;
public class Application
{
    public static void main(String[] args) 
    {
        Locker[] lockers = new Locker[1000];
        int i = 0;
        for (i = 0; i <1000; i++) 
        {
            lockers[i] = new Locker(true, 0);
        }
        
        for (i = 0; i <lockers.length; i++) 
        {
            if (i % 2 == 0) 
            {
                lockers[i].setOpened(lockers[i].isOpened() ? false : true);
                lockers[i].setChangedAmount(lockers[i].getChangedAmount()+1);
            }
        }
        
        for (i = 0; i <lockers.length; i++) 
        {
            if (i % 3 == 0) 
            {
                lockers[i].setOpened(lockers[i].isOpened() ? false : true);
                lockers[i].setChangedAmount(lockers[i].getChangedAmount()+1);
            }
        }
        
        for (i = 0; i <lockers.length; i++) 
        {
            if (i % 4 == 0) 
            {
                lockers[i].setOpened(lockers[i].isOpened() ? false : true);
                lockers[i].setChangedAmount(lockers[i].getChangedAmount()+1);
            }
        }
        
        int openCounter = 0;
        int closedCounter = 0;
        for (i = 0; i <lockers.length; i++) 
        {
            if (lockers[i].isOpened()) 
            {
                openCounter++;
            } 
            else 
            {
                closedCounter++;
            }
        }
        System.out.println("There are " + openCounter + " lockers open and " + closedCounter + " lockers closed.");
        
        int switchedAmount = lockers[0].getChangedAmount();
        ArrayList<Integer> mostOpened = new ArrayList<>();
        for (i = 0; i <lockers.length; i++) 
        {
            if (lockers[i].getChangedAmount() > switchedAmount) 
            {
                mostOpened.clear();
                switchedAmount = lockers[i].getChangedAmount();
                mostOpened.add(i+1);
            } 
            else if (lockers[i].getChangedAmount() == switchedAmount) 
            {
                mostOpened.add(i+1);
            }
        }
        
        System.out.print("The most opened lockers are: ");
        
        for (Integer g : mostOpened) 
        {
            System.out.print(g + " ");
        }
    }
}





