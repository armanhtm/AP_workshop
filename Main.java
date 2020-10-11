/**
 * @author Arman Hatami
 * Coursera User ID:  123456
 * Last modified:     1/1/2019
 * ***************************************************************************
 */

package second_workshop;

public class Main {
    public static void main(String[] args) {
        Student firstStudent = new Student("john", "lynn", "97130008");
        Student secondStudent = new Student("jim", "brooks", "91730007");
        Lab logicCircuit = new Lab(2, "yekshanbe");
        Faculty computerEngineering = new Faculty(1);
        computerEngineering.addCourse(logicCircuit);
        Student[] students = new Student[] { firstStudent, secondStudent };
        logicCircuit.setStudents(students);
        firstStudent.setgrade(19);
        secondStudent.setgrade(17);
        logicCircuit.print();
        logicCircuit.calculateAvg();
        System.out.println(logicCircuit.getAvg());
        System.out.println(logicCircuit.getCapacity());

    }
}
