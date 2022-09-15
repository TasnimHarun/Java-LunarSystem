/**
 * The <code>Course</code> class creates the course objects
 * @author Tasnim Harun
 *      email: tasnim.harun@stonybrook.edu
 *      Stony Brook ID: 112692494
 * <dt><b>Assignment:</b></dt>
 *      Homework #6 for CSE 214, Recitation 04, Fall 2021
 */
import java.io.Serializable;
public class Course implements Serializable{
    //private static final long SerialVersionUID = 10l;
    private String department;
    private int number;
    private String semester;

    /**
     * This is the default constructor which an instance of the Course object
     * and sets all the variables to default values.
     */
    public Course() {
        this.department = null;
        this.number = 0;
        this.semester = null;
    }

    /**
     * Gets the department string of the course
     * @return
     *      String department name of the course
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Gets the integer course number
     * @return
     *      Integer number of the course
     */
    public int getNumber() {
        return number;
    }

    /**
     * Gets the string semester of the course
     * @return
     *      String semester of the course
     */
    public String getSemester() {
        return semester;
    }

    public void checkDepartment(String department) throws InvalidDepartment{
        if(department.length() != 3){
            throw new InvalidDepartment("Not an acceptable department name. " +
                    "Please enter three letters");
        }
    }
    /**
     * Changes the string department of the course
     * @param department
     *      String department of the course
     */
    public void setDepartment(String department) {
        try{
            checkDepartment(department);
            this.department = department;
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void checkNumber(int num) throws InvalidCNum{
        if(num < 100 || num > 500){
            throw new InvalidCNum("Not an acceptable course number");
        }
    }

    /**
     * Changes the integer number of the course
     * @param number
     *      Integer number of the course
     */
    public void setNumber(int number) {
        try {
            checkNumber(number);
            this.number = number;
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void checkSemester(String semester) throws SemesterOutRangeException{
        if(semester.length() != 5){
            throw new SemesterOutRangeException("Invalid semester");
        }
    }
    public void checkSemesterYear(String semester) throws SemesterOutRangeException{
        if(semester.substring(1,3).equals("20")){
            if(semester.substring(3).compareTo("10") < 0 || semester.substring(3).compareTo("25") > 0){
                throw new SemesterOutRangeException("Invalid semester");
            }
        }else{
            throw new SemesterOutRangeException("Invalid semester");
        }
    }

    /**
     * Changes the string semester of the course
     * @param semester
     *      String semester value of the course
     */
    public void setSemester(String semester) {
        try {
           checkSemester(semester);
           checkSemesterYear(semester);
            this.semester = semester;
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Print function which prints out contents of the course
     * @return
     *      Statement with the course information
     */
    public String toString(){
        return getDepartment() + " " + getNumber() + " " + getSemester();
    }
}
