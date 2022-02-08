import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.*;

public class LayoutDemo extends JFrame {

    public static void main()
    {
        LayoutDemo demo = new LayoutDemo();
        demo.setSize(300,300);
        demo.createGUI();
        demo.setVisible(true);
    }
    
    public  void createGUI ()  
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        JTabbedPane tp = new JTabbedPane();
        tp.addTab("Flow", new FlowPanel());
        tp.addTab("Border", new BorderPanel());
        tp.addTab("Grid", new GridPanel());
        tp.addTab("Box", new BoxPanel());
        window.add(tp);    
   }
}