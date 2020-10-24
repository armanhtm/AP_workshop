/**
 * @author arman hatami
 * Coursera User ID:  123456
 * Last modified:     1/1/2019
 * this Class controls all the parts of voting process
 */


package election;

import java.util.ArrayList;

public class VotingSystem {
    private ArrayList<Voting> votingList = new ArrayList<Voting>();

    /**
     * it adds a new voting to
     */
    public void createVoting(int type, String question) {
        votingList.add(new Voting(type, question));
    }

    /**
     * it prints list of all polls
     */
    public void printListOfVotings() {
        int i = 0;
        for (Voting voting : votingList) {
            System.out.println(i + ": " + voting.getQuestion() + "\n____________________");
            i++;
        }
    }

    /**
     * it prints all choices of a voting
     */
    public void printVoting(int pollNumber) {
        if (pollNumber >= votingList.size() || pollNumber < 0)
            System.out.println("invalid entry");
        else {
            int i = 0;
            System.out.println(votingList.get(pollNumber).getQuestion());
            for (String nominee : votingList.get(pollNumber).getPolls()) {
                i++;
                System.out.println(i + ": " + nominee);
            }
        }
    }

    /**
     * it submit a person vote
     */
    public void vote(int pollNumber, Person person, ArrayList<String> votedList) {
        if (pollNumber >= votingList.size() || pollNumber < 0)
            System.out.println("invalid entry");
        else
            votingList.get(pollNumber).vote(person, votedList);
    }

    /**
     * it calls the printResult method in voting class
     */
    public void printResult(int pollNumber) {
        if (pollNumber >= votingList.size() || pollNumber < 0)
            System.out.println("invalid entry");
        else
            votingList.get(pollNumber).printResult();
    }

    /**
     * it return votingList
     *
     * @return votingList Arraylist of all polls
     */
    public ArrayList<Voting> getVotinglist() {
        return votingList;
    }

}
