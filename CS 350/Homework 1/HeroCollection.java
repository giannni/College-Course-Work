
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Date;
import java.util.Calendar;
import javax.swing.*;

public class HeroCollection
{
    LinkedList <Hero> heroList;

    public HeroCollection()
    {
        heroList = new LinkedList <Hero> ();
    }

    public void add(String name, Calendar birthday)
    {
        Hero newHero = new Hero(name,birthday);  
        Hero currentHero = new Hero();
        ListIterator iterator = heroList.listIterator();
        while (iterator.hasNext()) {
            currentHero = (Hero) iterator.next();
            if (birthday.compareTo(currentHero.getDate()) <= 0) {
                //  The newItem should come BEFORE item in the list so move the iterator back
                //  one space so that it points to the correct insertion point and end loop
                iterator.previous();
                break;
            } 
        }
        iterator.add(newHero);      
    }
    
    
    public void remove(Calendar date)
    {
        Hero item = new Hero("",date);

        if (heroList.contains(item)) {    
            ListIterator iterator = heroList.listIterator();
            while (iterator.hasNext())
            {
                item = (Hero) iterator.next();   
                if (date.compareTo(item.getDate()) == 0) {
                    iterator.remove();
                    JOptionPane.showMessageDialog(null,"Hero has been removed","Error",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        else { 
            JOptionPane.showMessageDialog(null,"There is no hero born on this date.","Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void list()
    {
        Iterator myIterator = heroList.iterator();
        String q = new String("");
        while (myIterator.hasNext()) {
            q += "\n" + myIterator.next();
        }
        JOptionPane.showMessageDialog(null,"Heroes:\n" + q);
    }
}
