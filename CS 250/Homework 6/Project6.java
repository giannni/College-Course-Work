
package project6;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Project6 
{
    public static void questions() throws FileNotFoundException, IOException
    {
        Scanner input = new Scanner(System.in);
        //question 1
        FileInputStream q1 = new FileInputStream("question1.txt");
        BufferedReader readq1 = new BufferedReader(new InputStreamReader(q1));
        FileInputStream a1 = new FileInputStream("answer1.txt");
        BufferedReader reada1 = new BufferedReader(new InputStreamReader(a1));
        //question 2
        FileInputStream q2 = new FileInputStream("question2.txt");
        BufferedReader readq2 = new BufferedReader(new InputStreamReader(q2));
        FileInputStream a2 = new FileInputStream("answer2.txt");
        BufferedReader reada2 = new BufferedReader(new InputStreamReader(a2));
        //question 3
        FileInputStream q3 = new FileInputStream("question3.txt");
        BufferedReader readq3 = new BufferedReader(new InputStreamReader(q3));
        FileInputStream a3 = new FileInputStream("answer3.txt");
        BufferedReader reada3 = new BufferedReader(new InputStreamReader(a3));
        //total score of user
        int totalScore = 0;
        
        
            String line;
            while ((line = readq1.readLine()) != null) {
                //print question.
                System.out.println(line);
                //ask for answer, take user input and compare it to answer.
                System.out.println("Please enter your answer: ");
                String answer1 = input.next();
                String correctAnswer1 = reada1.readLine();
                //compare the user input and answer
                if (answer1.equals(correctAnswer1)) {
                    System.out.println("Correct answer. \n");
                    totalScore++;
                } else {
                    System.out.println("Wrong answer. \n");
                    break;
                }
            }

            String line2;
            while ((line2 = readq2.readLine()) != null) {
                //print question.
                System.out.println(line2);
                //ask for answer, take user input and compare it to answer.
                System.out.println("Please enter your answer: ");
                String answer2 = input.next();
                String correctAnswer2 = reada2.readLine();
                //compare the user input and answer
                if (answer2.equals(correctAnswer2)) {
                    System.out.println("Correct answer. \n");
                    totalScore++;
                } else {
                    System.out.println("Wrong answer. \n");
                    break;
                }
            }

            String line3;
            while ((line3 = readq3.readLine()) != null) {
                //print question.
                System.out.println(line3);
                //ask for answer, take user input and compare it to answer.
                System.out.println("Please enter your answer: ");
                String answer3 = input.next();
                String correctAnswer3 = reada3.readLine();
                //compare the user input and answer
                if (answer3.equals(correctAnswer3)) {
                    System.out.println("Correct answer. \n");
                    totalScore++;
                } else {
                    System.out.println("Wrong answer. \n");
                    break;
                }
            }
            
            //display and save total score to file
            System.out.println("Total Score: " + totalScore + " \n");
            
            try (PrintWriter out = new PrintWriter(new FileWriter("scores.txt", true));) 
            {
                out.println("Score: " + totalScore);
                out.close();
            }
            
            
            //display high scores
            try (BufferedReader in = new BufferedReader(new FileReader("scores.txt"))) 
            {
                System.out.println("High Scores:");
                String high;
                while ((high = in.readLine()) != null) {
                    System.out.println(high);
                }
            }
            
            /*//option to replay the game
            System.out.println("Would you like to replay? (yes or no)");
            String lines;
            lines = input.next();
            if (lines.equals("yes")) {
                System.out.println("Replaying.");
            } else {
                return;
            }*/
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        Scanner reader = new Scanner(System.in);
        do 
        {
            questions();
            System.out.println("\nDo you want to replay the game? (Yes or No)");
        } while (reader.nextLine().toLowerCase().equals("yes"));
    }
}
