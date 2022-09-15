/**
 * The <code>Student</code> class creates the student objects
 * @author Tasnim Harun
 *      email: tasnim.harun@stonybrook.edu
 *      Stony Brook ID: 112692494
 * <dt><b>Assignment:</b></dt>
 *      Homework #6 for CSE 214, Recitation 04, Fall 2021
 */
import java.util.List;
import java.io.Serializable;

public class Student implements Serializable{
    //private static final long SerialVersionUID = 10l;
    private String webID;
    private List<Course> courses;

    /**
     * Constructs an instance of <Code>Student</Code> class
     * Default constructor which sets webID and courses to null
     *<dt><b>Postcondition:</b><dd>
     *     This <CODE>Student</CODE> has been initialized as a student.
     */
    public Student(){
        webID = null;
        courses = null;
    }

    /**
     * Returns the webID of the student
     * @return
     *      The string webID of the student
     */
    public String getWebID() {
        return webID;
    }

    /**
     * Returns the list of courses the student is taking
     * @return
     *      List of courses of the student
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * Changes the value of the webID of the student
     * @param webID
     *      String webID of the student
     */
    public void setWebID(String webID) {
        this.webID = webID;
    }

    /**
     * Changes the list of courses the student is taking
     * @param courses
     *      List of Course objects
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
