
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Hero 
{
    private String name;
    private Calendar date;

    public Hero()
    {
        name = "";
        date = null;
    }

    public Hero (String name, Calendar date)
    {
        this.name = name;
        this.date = date;
    }
    
    public String getName ()
    {
        return name;
    }
    
    public Calendar getDate ()
    {
        return date;
    }
    
    public String toString ()
    {
        Date newDate = date.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        String dateString = formatter.format(newDate);
        return  dateString + "   " + name;
    }
    
    public boolean equals(Object o)
    {
        return ((Hero)o).date.equals(date);
    }
}
