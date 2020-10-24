/**
 * @author arman hatami
 * Coursera User ID:  123456
 * Last modified:     1/1/2019
 * this class defines a person with its adjectives
 */

package election;

public class Person {
    private String firstName;
    private String lastName;

    /**
     * constructor method
     *
     * @param fName first name of person
     * @param lName last name of person
     */
    public Person(String fName, String lName) {
        firstName = fName;
        lastName = lName;
    }

    /**
     * it returns the first name
     *
     * @return firstName the first name of person
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * it returns the last name
     *
     * @return lastName the last name of person
     */
    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
