/**
 * @author Arman Hatami
 * Coursera User ID:  123456
 * Last modified:     1/1/2019
 * ***************************************************************************
 */

package second_workshop;

//represent a faculty and set the courses
public class Faculty {
    private Lab[] courses;
    private int courseCounter;
    private int labslimit;

    /**
     * Initialize a faculty
     *
     * @param labslimit modify the limit
     */
    public Faculty(int labslimit) {
        courses = new Lab[labslimit];
        this.labslimit = labslimit;
        courseCounter = 0;
    }

    /**
     * add a course to the faculty
     *
     * @param newCourse the name of new course
     */
    public void addCourse(Lab newCourse) {
        if (courseCounter < labslimit) {
            courses[courseCounter] = newCourse;
            courseCounter++;
        }
        else {
            System.out.println("faculty is full!!!");
        }
    }

    /**
     * initial the whole faculty with an array of courses
     *
     * @param labs array of courses
     */
    public void setCourses(Lab[] labs) {
        if (labs.length <= labslimit && labs.length != 0) {
            courses = labs;
            courseCounter = labs.length;
        }
        else
            System.out.println("this list has more students than Lab capacity");
    }

    /**
     * set the new limit of the faculty
     *
     * @param limit of the Lab
     */
    public void setlimit(int limit) {
        labslimit = limit;
    }

}
