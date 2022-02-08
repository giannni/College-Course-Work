/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 *
 * @author Gianni
 */
public class Assignments 
{
    private String assignmentName;
    private double time;
    private String dueDate;
    
    Assignments nextAssignment = new Assignments();
    
    public String getAssignmentName()
    {
        return this.assignmentName;
    }

    public double getTimeToComplete()
    {
        return this.time;
    }
    
    public String getDueDate()
    {
        return this.dueDate;
    }

    public boolean setAssignmentName(String name)
    {
        this.assignmentName = name;
        return true;
    }

    public boolean setTimeToComplete(double times)
    {
        this.time = times;
        return true;
    }
    
    public boolean setDueDate(String name)
    {
        this.dueDate = name;
        return true;
    }
}
