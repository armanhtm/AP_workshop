/**
 * @author arman hatami
 * Coursera User ID:  123456
 * Last modified:     1/1/2019
 * this class define all the process for voting
 */

package election;

import ir.huri.jcal.JalaliCalendar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Voting {
    private int type;
    private String question;
    private ArrayList<Person> voters = new ArrayList<Person>();
    private HashMap<String, HashSet<Vote>> choices = new HashMap<String, HashSet<Vote>>();

    /**
     * constructor method
     *
     * @param type     the type of poll
     * @param question the question of poll
     */
    public Voting(int type, String question) {
        this.type = type;
        this.question = question;
    }

    /**
     * it returns the question
     *
     * @return question the question of the poll
     */
    public String getQuestion() {
        return question;
    }

    /**
     * it adds a option to our poll
     *
     * @param newNominee the name of new option
     */
    public void createPoll(String newNominee) {
        choices.put(newNominee, new HashSet<Vote>());
    }

    /**
     * it submit a person vote for this poll
     *
     * @param person    thw person who wants to vote in this poll
     * @param votedList the list that voter has made
     */
    public void vote(Person person, ArrayList<String> votedList) {
        voters.add(person);
        JalaliCalendar x = new JalaliCalendar();
        String date = x.getYear() + "/" + x.getMonth() + "/" + x.getDay();
        Vote vote = new Vote(person, date);
        HashSet<Vote> temp;
        if (type == 1)
            for (String nominee : choices.keySet()) {
                if (votedList.contains(nominee)) {
                    temp = choices.get(nominee);
                    temp.add(vote);
                    choices.replace(nominee, temp);
                }
            }
        else if (choices.containsKey(votedList.get(0))) {
            temp = choices.get(votedList.get(0));
            temp.add(vote);
            choices.replace(votedList.get(0), temp);
        }
    }

    /**
     * it returns all the voters
     *
     * @return voters arraylist of who has voted
     */
    public ArrayList<Person> getVoters() {
        return voters;
    }

    /**
     * it prints all the voters information
     */
    public void printVotes() {
        for (Person person : voters)
            System.out.println(person.toString());
    }

    /**
     * it calculate who is the winner if there are 2 or more option
     * with same amount of votes it will prints the last one
     */
    public void printResult() {
        String winner = null;
        int votes = 0;
        for (String nominee : choices.keySet())
            if (choices.get(nominee).size() > votes) {
                votes = choices.get(nominee).size();
                winner = nominee;
            }
        System.out.println("the winner of the poll : " + winner);
    }

    /**
     * it returns all the options of the poll
     *
     * @return polls it's an arraylist of all the options in the poll
     */
    public ArrayList<String> getPolls() {
        ArrayList<String> polls = new ArrayList<String>();
        for (String poll : choices.keySet())
            polls.add(poll);
        return polls;
    }
}
