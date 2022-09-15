/**
 * The <code>Student</code> class creates the student objects
 * @author Tasnim Harun
 *      email: tasnim.harun@stonybrook.edu
 *      Stony Brook ID: 112692494
 * <dt><b>Assignment:</b></dt>
 *      Homework #6 for CSE 214, Recitation 04, Fall 2021
 */
import java.util.*;
import java.io.Serializable;

public class SemesterComparator implements Comparator<Course> , Serializable{
    //private static final long SerialVersionUID = 10l;
    /**
     * Function which compares two course semester
     * @param left
     *      One of the Course objects being compared
     * @param right
     *      Second Course object being compared
     * @return
     *      Returns 0 if the two Course semesters are equal
     *      Returns -1 if left is less than right
     *      Returns 1 is left is greater than right
     */
    public int compare(Course left, Course right){
        char fl = left.getSemester().charAt(0); //stores the F or S
        char fr = right.getSemester().charAt(0);
        String yl = left.getSemester().substring(1);    //stores the year of left course
        String yr = right.getSemester().substring(1);
        if(yl.equals(yr)){  //same year
            if(fl == fr)
                return 0;
            else if(fl == 'F'){
                return 1;
            }else{
                return -1;
            }
        }else if(yl.compareTo(yr) > 0){
            return -1;
        }else{
            return 1;
        }
    }
}
