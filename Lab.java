/**
 * @author Arman Hatami
 * Coursera User ID:  123456
 * Last modified:     1/1/2019
 * ***************************************************************************
 */

package second_workshop;

public class Lab {
    private Student[] students;
    private int avg;
    private String day;
    private int capacity;
    private int currentSize;

    /**
     * Initialize a Lab with the capacity and date
     *
     * @param cap capacity of the Lab
     * @param d   specific time of the Lab
     */
    public Lab(int cap, String d) {
        day = d;
        capacity = cap;
        avg = 0;
        currentSize = 0;
        students = new Student[cap];
    }

    /**
     * enrolling method that students can use to join the Lab
     *
     * @param std first name of student
     */
    public void enrollStudent(Student std) {
        if (currentSize < capacity) {
            students[currentSize] = std;
            currentSize++;
        }
        else {
            System.out.println("Lab is full!!!");
        }
    }

    /**
     * printing all information of student who already has enrolled
     */
    public void print() {
        for (Student std : students)
            if (std != null)
                std.print();
    }

    /**
     * returning the whole student array
     *
     * @return students
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     * initialize the student array in lab
     *
     * @param students an array of students
     */
    public void setStudents(Student[] students) {
        if (students.length <= capacity && students.length != 0) {
            this.students = students;
            currentSize = students.length;
        }
        else
            System.out.println("this list has more students than Lab capacity");
    }

    /**
     * returning the avg mark of the Lab
     *
     * @return avg
     */
    public int getAvg() {
        return avg;
    }

    /**
     * calculating the avg of the Lab
     */
    public void calculateAvg() {
        avg = 0;
        for (Student std : students)
            if (std != null)
                avg += std.getgrade();
        if (currentSize != 0)
            avg /= currentSize;
    }

    /**
     * return the date of the Lab
     *
     * @return day field
     */
    public String getDay() {
        return day;
    }

    /**
     * set the date of the Lab
     *
     * @param day of the date
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * return the capacity of the Lab
     *
     * @return capacity field
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * set the new capacity of Lab
     *
     * @param capacity of the Lab
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

