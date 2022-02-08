package project.pkg4;
/**
 *
 * @author Gianni Esposito
 */
import java.io.Serializable;

public class ObjectData implements Serializable {

    private String first;
    private String last;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        String value = "First name : " + first + "\nLast name : " + last;
        return value;
    }
}
