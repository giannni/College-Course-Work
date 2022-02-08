import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Penguin extends JFrame implements ChangeListener
{
    private JSlider mySlider;
    private JPanel panel;
    private Icon icon;
    private JLabel label;
    
    public static void main()
    {
        Penguin myApplication = new Penguin();
        myApplication.setSize(750,380);
        myApplication.setTitle("Penquins");
        myApplication.createGUI();
        myApplication.setVisible(true);
    }
    
    private void createGUI()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        
        icon = new ImageIcon("penguin.png");
        
        mySlider = new JSlider(1,10,1);
        mySlider.addChangeListener(this);
        window.add(mySlider);
        
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(700,300));
        panel.setBackground(Color.white);
        window.add(panel);
    }
    
    public void stateChanged(ChangeEvent e)
    {
        int numberOfPenquins;
        numberOfPenquins = mySlider.getValue();
        panel.removeAll();
        for (int i=0; i<numberOfPenquins; i++) {
            label = new JLabel(icon);
            panel.add(label);
        }
        panel.revalidate();
        panel.repaint();
    }
}
