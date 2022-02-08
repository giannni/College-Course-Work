package project.pkg5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Gianni Esposito : Sort(O(n^2)) user inputted arrays and then print(O(n)) the arrays. 
 */

public class Project5 
{
    public static void main(String[] args) 
    {
        List<Integer> ints = new ArrayList<>();
        List<Float> floats = new ArrayList<>();
        List<Double> doubles = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Scanner sss = new Scanner(System.in);
        do 
        {
            System.out.println("Please enter your data type(string,double,integer,float):");
            String type = sc.next();
            
          switch (type) {
              case "string":
                  System.out.println("Please enter your data(string format only):");
                  strings.add(sc.next());
                  break;
              case "integer":
                  System.out.println("Please enter your data(number format only):");
                  ints.add(sc.nextInt());
                  break;
              case "float":
                  System.out.println("Please enter your data(number format only):");
                  floats.add(sc.nextFloat());
                  break;
              case "double":
                  System.out.println("Please enter your data(number format only):");
                  doubles.add(sc.nextDouble());
                  break;
              default:
                  break;
          }
            
            System.out.println("Would you like to add more data? Type yes or no.");
            String answer;
            answer = sss.next();
            if(answer.equals("yes")) 
            {
                System.out.println("Continuing.");
            } 
            else
            {
                System.out.println("\n");
                System.out.println("Finished. \nData has been sorted from lowest to highest.");
                Collections.sort(strings);
                Collections.sort(ints);
                Collections.sort(floats);
                Collections.sort(doubles);
                System.out.println("Strings: " +Arrays.toString(strings.toArray()));
                System.out.println("Integers: " +Arrays.toString(ints.toArray()));
                System.out.println("Floats: " +Arrays.toString(floats.toArray()));
                System.out.println("Doubles: " + Arrays.toString(doubles.toArray()));
                break;
            }
            
        }while (true);
    }
}