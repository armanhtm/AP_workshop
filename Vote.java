/**
 * @author arman hatami
 * Coursera User ID:  123456
 * Last modified:     1/1/2019
 * this class define the vote with its adjectives
 */

package election;

import java.util.Objects;

public class Vote {
    private Person person;
    private String date;

    /**
     * constructor method
     *
     * @param person the person who wants to vote
     * @param date   the time that vote is made by the person
     */
    public Vote(Person person, String date) {
        this.person = person;
        this.date = date;
    }

    /**
     * it returns the person
     *
     * @return person the person who has voted
     */
    public Person getPerson() {
        return person;
    }

    /**
     * it returns the date
     *
     * @return date the date vote was made by hte person
     */
    public String getDate() {
        return date;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vote)) return false;
        Vote vote = (Vote) o;
        return Objects.equals(getPerson(), vote.getPerson()) &&
                Objects.equals(getDate(), vote.getDate());
    }

    public int hashCode() {
        return Objects.hash(getPerson(), getDate());
    }
}
