
import java.io.File;
import java.util.Scanner;
import javax.swing.*;

public class GraphTest
{
     public static void main () 
     {
        File graphFile;
        String userInput;
        Scanner fileScanner;
        int numberNodes, person, friend;
        AdjGraph g = new AdjGraph();
        
        try {
           userInput = JOptionPane.showInputDialog("Enter the graph input file name");
           graphFile = new File(userInput);
           fileScanner = new Scanner(graphFile);
           numberNodes = Integer.parseInt(fileScanner.nextLine());
           g = new AdjGraph (numberNodes);
           
           for (int i=0; i<numberNodes; i++) {
               String name = fileScanner.nextLine();
               g.setLabel(i,name);
           }
           
           while (fileScanner.hasNext()) {
               person = fileScanner.nextInt();
               friend = fileScanner.nextInt();
               g.addEdge(person,friend);
               g.addEdge(friend,person);
           }
        }
        catch (Exception e ) {
            JOptionPane.showMessageDialog(null,"Input File Error",
                "Error",JOptionPane.ERROR_MESSAGE);
        }

        g.print();
        int node = g.recommendFriend(0);
        System.out.println(g.getLabel(0) + " should invite " + 
            g.getLabel(node) + " to be a friend");      
     }
}
