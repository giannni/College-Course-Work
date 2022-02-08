
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SmartStringApplication extends JFrame 
{ 
    JButton addButton = new JButton("Add substring");
    JButton removeButton = new JButton("Remove substring");
    JButton undoButton = new JButton("Undo");
    JButton listButton = new JButton("List");
    JPanel buttonPane = new JPanel();
    
    SmartString myString = new SmartString("Dr Vermilyer");
   
    public static void main()
    {
        SmartStringApplication demo = new SmartStringApplication();
        demo.setSize(520,120);
        demo.setDefaultCloseOperation(EXIT_ON_CLOSE);
        demo.setTitle("Smart String Application");
        demo.createGUI();  
        demo.setVisible(true);
    }
    
    public void createGUI()
    {
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        
        addButton.addActionListener(new AddAction());
        removeButton.addActionListener(new RemoveAction());
        listButton.addActionListener(new ListAction());  
        undoButton.addActionListener(new UndoAction());

        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        buttonPane.add(addButton);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPane.add(removeButton);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPane.add(undoButton);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPane.add(listButton);
        window.add(buttonPane);
    }
  
    private class AddAction implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {   
            String text = JOptionPane.showInputDialog("Enter the text you wish to add");
            int insertionPoint = Integer.parseInt(JOptionPane.showInputDialog("Enter the insertion position"));
            myString.insert(insertionPoint,text);
            JOptionPane.showMessageDialog(null,"Current string value: " + myString,
                "Smart String Application",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private class RemoveAction implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {    
            int  startPosition = Integer.parseInt(JOptionPane.showInputDialog("Enter the starting deletion position"));
            int  length = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of characters to delete"));
            myString.delete(startPosition,length);
            JOptionPane.showMessageDialog(null,"Current string value: " + myString,
                "Smart String Application",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private class UndoAction implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {   
            myString.undo();
            JOptionPane.showMessageDialog(null,"Current string value: " + myString,
                "Smart String Application",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private class ListAction implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {   
            JOptionPane.showMessageDialog(null,"Current string value: " + myString,
                "Smart String Application",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}