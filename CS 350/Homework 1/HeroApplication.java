
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import javax.swing.border.Border;

public class HeroApplication extends JFrame 
{ 
    JButton addButton = new JButton("Add Hero");
    JButton removeButton = new JButton("Remove Hero");
    JButton displayButton = new JButton("Display Heroes");
    JPanel buttonPanel = new JPanel();
    
    HeroCollection myHeros = new HeroCollection();
   
    public static void main()
    {
        HeroApplication  demo = new HeroApplication();
        demo.setSize(400,100);
        demo.setDefaultCloseOperation(EXIT_ON_CLOSE);
        demo.setTitle("Heroes");
        demo.createGUI();  
        demo.setVisible(true);
    }
    
    public void createGUI()
    {
        Container window = getContentPane();
        window.setLayout(new BoxLayout(window, BoxLayout.X_AXIS));
        
        // Create dimensions for spacing object
        Dimension minSize = new Dimension(10, 20);
        Dimension prefSize = new Dimension(10, 20);
        Dimension maxSize = new Dimension(Short.MAX_VALUE, 100);    
        
        addButton.addActionListener(new AddAction());
        removeButton.addActionListener(new RemoveAction());      
        displayButton.addActionListener(new DisplayAction());
        
        window.add(new Box.Filler(minSize, prefSize, maxSize));
        window.add(addButton);    
        window.add(new Box.Filler(minSize, prefSize, maxSize));
        window.add(removeButton); 
        window.add(new Box.Filler(minSize, prefSize, maxSize));
        window.add(displayButton);
        window.add(new Box.Filler(minSize, prefSize, maxSize));
    }
  
    private class AddAction implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {   
            String name = JOptionPane.showInputDialog("Enter the name of the hero");
            String dateString = JOptionPane.showInputDialog("Enter the birthday of " + name + " as MM/DD/YYYY");
            String pattern = "MM/dd/yyyy";
            SimpleDateFormat format = new SimpleDateFormat(pattern);

            try {
                Date date = format.parse(dateString);
                Calendar theDate = Calendar.getInstance();
                theDate.setTime(date);
                myHeros.add(name,theDate);
            }
            catch (ParseException e) {
                JOptionPane.showMessageDialog(null,"Incorrect format for birthday","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private class RemoveAction implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {    
            // ask for the hero birthday and remove that hero
            String dateString = JOptionPane.showInputDialog("Enter the birthday of the hero to be deleted as MM/DD/YYYY");
            String pattern = "MM/dd/yyyy";
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            try {
                Date date = format.parse(dateString);       
                Calendar theDate = Calendar.getInstance();
                theDate.setTime(date);
                myHeros.remove(theDate);
            }
            catch (ParseException e) {
                JOptionPane.showMessageDialog(null,"Incorrect format for birthday","Error",JOptionPane.ERROR_MESSAGE);
            }     
        }
    }
    
    private class DisplayAction implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {   
            myHeros.list();
        }
    }
}