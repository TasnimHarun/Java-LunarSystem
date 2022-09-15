import java.io.Serializable;

public class SemesterOutRangeException extends Exception implements Serializable {
    //private static final long SerialVersionUID = 10l;
    public SemesterOutRangeException(String message){
        super (message);
    }
}
