/**
 * The <code>LunarSystem</code> class is the main driver code
 * @author Tasnim Harun
 *      email: tasnim.harun@stonybrook.edu
 *      Stony Brook ID: 112692494
 * <dt><b>Assignment:</b></dt>
 *      Homework #6 for CSE 214, Recitation 04, Fall 2021
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;

/**
 * This is the main driver code which gives a user a list of options to choose from and allows them
 * modify the Student and Course objects based on their choices. The students are stored in a HashMap
 * called database to keep track of all the data.
 */
public class LunarSystem {
    private static HashMap<String, Student> database = new HashMap<String, Student>();
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Lunar System, " +
                "a second place course registration system for second rate courses at a second class school.");
        String filename = "Lunar.ser";
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream is = new ObjectInputStream(file);
            database = (HashMap<String, Student>) is.readObject();
            if(database.isEmpty()){
                System.out.println("No data found");
                is.close();
            }else {
                System.out.println("Previous data loaded");
                is.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("no data found");
        }

        //HashMap<String, Student> please = new HashMap<String, Student>();
        Student student = new Student();
        LinkedList<Course> c = new LinkedList<Course>();
        System.out.println("Menu: " + '\n'
        + "L) Login" + '\n'
        + "X) Save and Quit" + '\n'
        + "Q) Quit without saving");
        char in = Character.toUpperCase(input.next().charAt(0));
        while(in == 'L') {
            System.out.println("Enter webID: ");
            String ID = input.next();
            if (ID.equals("REGISTRAR")) {
                System.out.println("Login as registrar");
                System.out.println("Welcome ");
                System.out.println("Options: ");
                System.out.println("R) Register a student" + '\n'
                        + "D) De-register a student" + '\n'
                        + "E) View course enrollment" + '\n'
                        + "L) Logout");
                char input2 = Character.toUpperCase(input.next().charAt(0));
                while(input2 != 'L') {
                    switch (input2) {
                        case 'R':
                            System.out.println("Enter a webID for a new student: ");
                            String sID = input.next();
                            Student std = new Student();
                            std.setWebID(sID);
                            if(database.containsKey(sID)){
                                System.out.println("This student has already been registered");
                            }else {
                                database.put(std.getWebID(), std);    //adds to the hash map
                                System.out.println(std.getWebID() + " registered");
                            }
                            break;
                        case 'D':
                            System.out.println("Enter webID of student to de-register: ");
                            String dID = input.next();
                            if(database.containsKey(dID)) {
                                database.remove(dID);
                                System.out.println(dID + " de-registered");
                            }else{
                                System.out.println("Student is not registered");
                            }
                            break;
                        case 'E':
                            System.out.println("Enter department name and course number: ");
                            String dName = input.next();
                            int number = input.nextInt();
                            Iterator databaseIt = database.entrySet().iterator();
                            while(databaseIt.hasNext()){
                                Map.Entry element = (Map.Entry)databaseIt.next();
                                Student tempS = (Student)element.getValue();
                                for(int i = 0; i<tempS.getCourses().size(); i++){
                                    String department = tempS.getCourses().get(i).getDepartment();
                                    int courseNum = tempS.getCourses().get(i).getNumber();
                                    if(department.equals(dName) && courseNum == number){
                                        System.out.println(element.getKey() + " "
                                                + tempS.getCourses().get(i).getSemester());
                                    }
                                }
                            }
                            break;
                    }
                    System.out.println("Options: ");
                    System.out.println("R) Register a student" + '\n'
                            + "D) De-register a student" + '\n'
                            + "E) View course enrollment" + '\n'
                            + "L) Logout");
                    input2 = Character.toUpperCase(input.next().charAt(0));
                }
                System.out.println("Registrar logged out");
            } else {
                if(database.containsKey(ID)){
                    student = database.get(ID);
                    System.out.println("Welcome " + student.getWebID());
                    System.out.println("Options: " + '\n'
                            + "A) Add a class" + '\n'
                            + "D) Drop a class" + '\n'
                            + "C) View your classes sorted by course name/department" + '\n'
                            + "S) View your classes sorted by semester");
                    System.out.println("Please select an option: ");
                    char input3 = Character.toUpperCase(input.next().charAt(0));
                    while(input3 != 'L'){
                        switch(input3) {
                            case 'A':
                                //System.out.println(student.getCourses());
                                System.out.println("Enter course name: ");
                                String name = input.next();
                                int num = input.nextInt();
                                System.out.println("Enter the semester: ");
                                String semester = input.next();
                                //System.out.println(semester.length());
                                //System.out.println(semester.substring(3).compareTo("25"));
                                Course course = new Course();
                                course.setSemester(semester);
                                if (course.getSemester() == null) {
                                    break;
                                }
                                course.setDepartment(name);
                                if(course.getDepartment() == null){
                                    break;
                                }
                                course.setNumber(num);
                                if(course.getNumber() == 0){
                                    break;
                                }
                                if (student.getCourses() == null) {
                                    c.clear();
                                    c.add(course);
                                    //System.out.println(c.toString());
                                    database.get(ID).setCourses(c);
                                } else {
                                    database.get(ID).getCourses().add(course);
                                }
                                System.out.println(course.getDepartment() + " " +
                                        course.getNumber() + " has been added in " + course.getSemester());
                                //database.get(ID).setCourses(student.getCourses());
                                break;
                            case 'D':
                                System.out.println("Enter department name and course number: ");
                                String dept = input.next();
                                int cNum = input.nextInt();
                                if(student.getCourses() == null){
                                    System.out.println("Student has no courses");
                                }else {
                                    for (int i = 0; i < student.getCourses().size(); i++) {
                                        if (student.getCourses().get(i).getDepartment().equals(dept)) {
                                            if (student.getCourses().get(i).getNumber() == cNum) {
                                                Course gone = student.getCourses().remove(i);
                                                System.out.println(dept + cNum + " removed from "
                                                        + gone.getSemester());
                                            }
                                        }
                                    }
                                    System.out.println("No such class found");
                                }
                                break;
                            case 'C':
                                if (database.get(ID).getCourses() == null) {
                                    System.out.println("Student has no courses");
                                }else{
                                    //System.out.println(database.get(ID).getWebID());
                                    //System.out.println(database.get(ID).getCourses());
                                    CourseNameComparator cComp = new CourseNameComparator();
                                    for (int i = 0; i < database.get(ID).getCourses().size() - 1; i++) {
                                        for (int j = 0; j < database.get(ID).getCourses().size() - i - 1; j++) {
                                            Course left = database.get(ID).getCourses().get(j);
                                            Course right = database.get(ID).getCourses().get(j + 1);
                                            if (cComp.compare(left, right) == 1) {
                                            //System.out.println("Entered if statement");
                                                database.get(ID).getCourses().set(j, right);
                                                database.get(ID).getCourses().set(j + 1, left);
                                            }
                                        }
                                    }
                                    for(int i = 0; i<database.get(ID).getCourses().size(); i++) {
                                        System.out.println(database.get(ID).getCourses().get(i));
                                    }
                                }
                                break;
                            case 'S':
                                if(database.get(ID).getCourses() == null){
                                    System.out.println("Student has no courses");
                                }else {
                                    SemesterComparator sComp = new SemesterComparator();
                                    for (int i = 0; i < student.getCourses().size() - 1; i++) {
                                        for (int j = 0; j < student.getCourses().size() - i - 1; j++) {
                                            Course left = student.getCourses().get(j);
                                            Course right = student.getCourses().get(j + 1);
                                            if (sComp.compare(left, right) == -1) {
                                                //System.out.println("Entered if statement");
                                                student.getCourses().set(j, right);
                                                student.getCourses().set(j + 1, left);
                                            }
                                        }
                                    }
                                    for(int i = 0; i<student.getCourses().size(); i++) {
                                        System.out.println(student.getCourses().get(i));
                                    }
                                }
                                //System.out.println("Sorted by semester hope");
                                break;
                                }
                                System.out.println("Options: " + '\n'
                                        + "A) Add a class" + '\n'
                                        + "D) Drop a class" + '\n'
                                        + "C) View your classes sorted by course name/department" + '\n'
                                        + "S) View your classes sorted by semester" + '\n'
                                        + "L) Logout");
                                System.out.println("Please select an option: ");
                                input3 = Character.toUpperCase(input.next().charAt(0));
                            }
                        }else{
                            System.out.println("Student not registered");
                        }
                    }
            System.out.println("Logged out");
            System.out.println("Menu: " + '\n'
                    + "L) Login" + '\n'
            + "X) Save and quit" + '\n'
            + "Q) Quit without saving");
            in =  Character.toUpperCase(input.next().charAt(0));
        }
        switch(in) {
            case 'X':
                FileOutputStream fileOut = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(database);
                System.out.println("Saved");
                out.close();
            break;
            case 'Q':
                database.clear();
                FileOutputStream fileOut2 = new FileOutputStream(filename);
                ObjectOutputStream out2 = new ObjectOutputStream(fileOut2);
                out2.writeObject(database);
                System.out.println("Data deleted");
                break;
            default:
                System.out.println("invalid input");
        }
    }
}
