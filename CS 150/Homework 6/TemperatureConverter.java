import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class TemperatureConverter extends JFrame implements ChangeListener
{
    private JLabel inputLabel;
    private JSlider mySlider;
    private JTextField outputField;
    
    public static void main()
    {
        TemperatureConverter myApplication = new TemperatureConverter();
        myApplication.setSize(380,150);
        myApplication.setTitle("Temperature Converter");
        myApplication.createGUI();
        myApplication.setVisible(true);    
    }
    
    private void createGUI()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container myPane = getContentPane();
        myPane.setLayout(new FlowLayout());
        
        inputLabel = new JLabel("Select a temperature in Celsius");
        
        mySlider = new JSlider(0,100,10);
        mySlider.setMajorTickSpacing(20);
        mySlider.setPaintTicks(true);
        mySlider.setPaintLabels(true);
        mySlider.addChangeListener(this);
        
        outputField = new JTextField(30);
        outputField.setHorizontalAlignment(JTextField.CENTER);
        
        myPane.add(inputLabel);
        myPane.add(mySlider);
        myPane.add(outputField);
    }
    
    public void stateChanged (ChangeEvent e)
    {
        long celsius;
        double fahrenheit;
        
        celsius = mySlider.getValue();
        fahrenheit = convertTemperature(celsius);
        
        outputField.setText(Long.toString(celsius) +
          " degrees Celsius is equal to " +
          Double.toString(fahrenheit) +
          " degrees Fahrenheit");
          
    }
    
    private double convertTemperature (long celsius)
    {
        double fahrenheit;
        fahrenheit = (celsius * 9.0 / 5.0) + 32;
        return fahrenheit;
    }
}