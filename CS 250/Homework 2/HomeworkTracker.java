/**
 *
 * @author Gianni Esposito
 */
import java.util.*;
public class HomeworkTracker 
{
   public static ArrayList<String> classNames = new ArrayList<>();
   public static ArrayList<String> assignmentNames = new ArrayList<>();
   public static ArrayList<String> dueDates = new ArrayList<>();
   public static ArrayList<Integer> timeToCompletes = new ArrayList<>();
   
   public static ArrayList<Class> nextClass = new ArrayList<Class>();
   public static ArrayList<Assignments> nextAssignment = new ArrayList<Assignments>();
   
   public static void main(String[] args) 
   {
        Scanner sc = new Scanner(System.in);
        Scanner sss = new Scanner(System.in);
        do 
        {
            System.out.println("Please enter your class name: ");
            classNames.add(sc.next());
            System.out.println("Please enter your assignment name: ");
            assignmentNames.add(sc.next());
            System.out.println("Please enter your assignment due date: ");
            dueDates.add(sc.next());
            System.out.println("Please enter the time in minutes it will take to complete the assignment: ");
            timeToCompletes.add(sc.nextInt());
            
            System.out.println("Classes: " + classNames 
            + "\nAssignments: " + assignmentNames 
            + "\nDue Dates:" + dueDates 
            + "\nTime to complete each assignment: " + timeToCompletes);
            
            Integer minIndexes = minIndex(timeToCompletes);
            Integer minNumber = findMinNumber(timeToCompletes);
            System.out.println("You should do assigment number " + (minIndexes + 1) + " because it will take only " + minNumber + " minutes.");
            
            sumOfTimes();
            removeIndexes();
            
            System.out.println("Leave the space blank to end list or type anything to continue.");
            String lines = " ";
            lines = sss.nextLine();
            if(!lines.isEmpty()) 
            {
                System.out.println("Continuing.");
            } 
            else
            {
                System.out.println("Nothing was entered.");
                System.out.println("Classes: " + classNames 
                + "\nAssignments: " + assignmentNames 
                + "\nDue Dates:" + dueDates 
                + "\nTime to complete each assignment: " + timeToCompletes);
                System.out.println("You should do assigment number " + (minIndexes + 1) + " because it will take only " + minNumber + " minutes.");
                sumOfTimes();
                break;
                 
            }
            
        }while (true);
   }
   
   
   public static void removeIndexes()
   {
       Scanner ss = new Scanner(System.in);
       System.out.println("Please enter an assigment number that you would like to remove or leave blank if none.");
       String line = " ";
       line = ss.nextLine();
       Integer i = null;
       if(line.isEmpty()) 
       {
            System.out.println("Nothing was entered.");
       } 
       else 
       {
           i = Integer.valueOf(line);
           classNames.remove((int)i);
           assignmentNames.remove((int)i);
           dueDates.remove((int)i);
           timeToCompletes.remove((int)i);
       }
   }
   
   public static void sumOfTimes()
   {
       double sums = timeToCompletes.stream().mapToInt(Integer::intValue).sum();
            
       System.out.println("0 days, " + sums / 60 + " hour(s) to complete all given assignments.");
   }
   
   public static Integer minIndex(ArrayList<Integer> timeToCompletes) 
   {
       return timeToCompletes.indexOf(Collections.min(timeToCompletes)); 
   }
   
   public static Integer findMinNumber(ArrayList<Integer> timeToCompletes)
   {
       Integer min = Integer.MAX_VALUE;
       
       for(Integer number : timeToCompletes)
       {
           if(number < min)
           {
               min = number;
           }
       }
       return min;
   }
}