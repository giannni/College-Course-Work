
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.io.*;

public class Application extends JFrame
{
    JButton getFileButton = new JButton("Select Input File");
    JButton totalWordsButton = new JButton("Total Words");
    JButton uniqueWordsButton = new JButton("Unique Words");
    JButton findWordButton = new JButton("Find Word");
    JButton firstWordButton = new JButton("First Word");
    JButton lastWordButton = new JButton("Last Word");
    JPanel buttonPanel1 = new JPanel(); 
    JPanel buttonPanel2 = new JPanel();
    JPanel buttonPanel3 = new JPanel();
    
    public static void main ()
    {                 
        Application demo = new Application();
        demo.setSize(300,200);
        demo.setDefaultCloseOperation(EXIT_ON_CLOSE);
        demo.setTitle("Text Analysis");
        demo.createGUI();  
        demo.setVisible(true);
     }
     
    public void createGUI()
    {
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        getFileButton.addActionListener(new GetFileAction());
        window.add(getFileButton);
        totalWordsButton.addActionListener(new TotalWordsAction());
        buttonPanel1.add(totalWordsButton);
        uniqueWordsButton.addActionListener(new UniqueWordsAction());
        buttonPanel1.add(uniqueWordsButton);
        window.add(buttonPanel1);
        Border emptyBorder = BorderFactory.createEmptyBorder(0, 30, 0, 30);
        buttonPanel2.setBorder(emptyBorder);
        findWordButton.addActionListener(new FindWordAction());
        buttonPanel2.add(findWordButton);
        window.add(buttonPanel2);
        firstWordButton.addActionListener(new FirstWordAction());
        buttonPanel3.add(firstWordButton);
        lastWordButton.addActionListener(new LastWordAction());
        buttonPanel3.add(lastWordButton);
        window.add(buttonPanel3);
    }
  
    private class GetFileAction implements ActionListener 
    {
        public void actionPerformed(ActionEvent event)
        {   
           File file = null;
           try {
              JFileChooser myChooser = new JFileChooser();
              int returnFlag = myChooser.showDialog(Application.this, "Select input file");
              if (returnFlag == JFileChooser.APPROVE_OPTION) {
                 file = myChooser.getSelectedFile();
               }
               else {
                  System.out.println("Input file not selected.");
                  System.exit(0);
              }
              BufferedReader input = new BufferedReader(new FileReader(file));
        
              // Put words into binary search tree
              String delimeters = " \n\t.,!?;:";
              for (int lines=1; true; lines++ ) {
                  // get words
                  String lineText = input.readLine();
                  if (lineText == null) return;
                  lineText = lineText.toLowerCase();  

                 Enumeration e = new StringTokenizer(lineText, delimeters);
                 String word;
                 while (e.hasMoreElements()) {
                    word = (String) e.nextElement();
                    // enter the word
                 }
              }
           }
           catch (IOException e) {
              System.out.println("File Error");
           }
        }
    } 
     
    private class TotalWordsAction implements ActionListener 
    {
        public void actionPerformed(ActionEvent event)
        {      
        }
    } 
       
    private class UniqueWordsAction implements ActionListener 
    {
        public void actionPerformed(ActionEvent event)
        { 
        }
    } 
        
    private class FindWordAction implements ActionListener 
    {
        public void actionPerformed(ActionEvent event)
        {     
        }
    } 
        
    private class FirstWordAction implements ActionListener 
    {
        public void actionPerformed(ActionEvent event)
        {    
        }
    } 
        
    private class LastWordAction implements ActionListener 
    {
        public void actionPerformed(ActionEvent event)
        { 
        }
    } 
}