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
public class Class 
{
    private String className;
    
    Class  nextClass = new Class();
    
    public String getName()
    {
        return this.className;
    }

    public boolean setName(String name)
    {
        this.className = name;
        return true;
    }
}
