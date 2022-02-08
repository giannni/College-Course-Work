/**
 * Determine the human age for a dog.
 *
 * @author Gianni Esposito
 * @version 4/28/17
 */

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class DogYears extends JFrame implements ChangeListener
{
    private JRadioButton small, medium, large;
    private JTextField output;
    private JLabel ageLabel;
    private JSlider age;
    private JPanel pane;

    public static void main() 
    {
        DogYears myApplication = new DogYears();
        myApplication.setSize(380,150);
        myApplication.setTitle("Dog Age");
        myApplication.showGui();
        myApplication.setVisible(true);
    }

    public void showGui()
    {
        pane = new JPanel(new GridBagLayout());
        setContentPane(pane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        small = new JRadioButton("Small Sized Dog");
        medium = new JRadioButton("Medium Sized Dog");
        large = new JRadioButton("Large Sized Dog");
        ButtonGroup sizes = new ButtonGroup();
        sizes.add(small);
        sizes.add(medium);
        sizes.add(large);
        small.setSelected(true);
        pane.add(small, c);
        pane.add(medium, c);
        pane.add(large, c);

        output = new JTextField();
        c.gridwidth = 3;
        c.gridy = 3;
        output.setText("The 0 year old dog is 0 years old in human years");
        pane.add(output, c);

        ageLabel = new JLabel("How old is the dog? ");
        age = new JSlider(JSlider.HORIZONTAL, 0, 20, 0);
        age.setMajorTickSpacing(5);
        age.setMinorTickSpacing(1);
        age.setPaintTicks(true);
        age.setPaintLabels(true);
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridy = 1;
        pane.add(ageLabel, c);
        c.gridwidth = 2;
        pane.add(age, c);

        age.addChangeListener(this);
        small.addChangeListener(this);
        medium.addChangeListener(this);
        large.addChangeListener(this);

        pack();
        setVisible(true);
    }

    private int calculateAge(int size, int years, int age)
    {
        if (years == 0)
            return 0;
        else if (years == 1)
                return age+14;
        else if (years == 2)
            return age+24;
        else if (size == 1)
            return calculateAge(size, years-1, age+4);
        else if (size == 2)
            return calculateAge(size, years-1, age+5);
        else
            return calculateAge(size, years-1, age+6);
    }
    
    public void stateChanged(ChangeEvent e) 
    {
        int dAge = age.getValue();
        int size = 1;
        if(medium.isSelected())
            size = 2;
        else if (large.isSelected())
            size = 3;

        String text = "The " + dAge + " year old dog is " + calculateAge(size, dAge, 0) + " in human years";

        output.setText(text);
    }
}
