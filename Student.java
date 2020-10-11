package second_workshop;

/**
 * The Student class represents a student in a student
 * administration system.
 * It holds the student details relevant in our context.
 *
 * @author Arman Hatami
 * @version 0.0
 */
public class Student {

    private String firstName;
    private String lastName;
    private String id;
    private int grade;

    /**
     * Create a new student with a given name and ID number.
     *
     * @param fName first name of student
     * @param lname last name of student
     * @param sID   student ID
     */
    public Student(String fName, String lname, String sID) {
        firstName = fName;
        lastName = lname;
        id = sID;
        grade = 0;
    }

    /**
     * get the first name of student
     *
     * @return firstName field
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setting the student first name
     *
     * @param fName set first name of a student
     */
    public void setFirstName(String fName) {
        firstName = fName;
    }

    /**
     * Print the student’s last name and ID number to the
     * output terminal.
     */
    public void print() {
        System.out.println(firstName + " " + lastName + ", student ID: "
                                   + id + ", grade: " + grade);
    }

    /**
     * return student's grade
     *
     * @return grade field
     */
    public int getgrade() {
        return grade;
    }

    /**
     * set the student grade
     *
     * @param grd student's grade
     */
    public void setgrade(int grd) {
        if (grd >= 0 && grd <= 20)
            grade = grd;
        else
            System.out.println("grade is invalid");
    }
}
