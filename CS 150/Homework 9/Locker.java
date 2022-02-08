
/**
 * Write a description of class Locker here.
 * 
 * @author Gianni Esposito 
 * @version (a version number or a date)
 */
public class Locker
{
    private boolean opened;
    private int changedAmount;

    public Locker(boolean opened, int changedAmount) 
    {
        this.opened = opened;
        this.changedAmount = changedAmount;
    }

    public boolean isOpened() 
    {
        return opened;
    }

    public void setOpened(boolean opened) 
    {
        this.opened = opened;
    }

    public int getChangedAmount() 
    {
        return changedAmount;
    }

    public void setChangedAmount(int changedAmount) 
    {
        this.changedAmount = changedAmount;
    }
}
