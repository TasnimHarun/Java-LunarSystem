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

public class CourseNameComparator implements Comparator<Course>, Serializable {
    //private static final long SerialVersionUID = 10l;
    /**
     * Function which compares two course departments and course numbers
     * @param left
     *      One of the Course objects being compared
     * @param right
     *      Second Course object being compared
     * @return
     *      Returns 0 if the two Course objects are equal
     *      Returns -1 if left is less than right
     *      Returns 1 is left is greater than right
     */
    public int compare(Course left, Course right){
        if(left.getDepartment().compareTo(right.getDepartment()) < 0){
            return -1;
        }else if(left.getDepartment().equals(right.getDepartment())){
            if(left.getNumber() > right.getNumber()){
                return 1;
            }else if(left.getNumber() == right.getNumber()){
                return 0;
            }else{
                return -1;
            }
        }else
            return 1;
    }
}