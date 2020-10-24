/**
 * @author arman hatami
 * Coursera User ID:  123456
 * Last modified:     1/1/2019
 * Main class to use Voting Class
 */

package election;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        VotingSystem football = new VotingSystem();
        // create an instance of VotingSystem
        football.createVoting(0, "who is the best football player?");
        // adding 2 option to the poll
        football.getVotinglist().get(0).createPoll("jalal");
        football.getVotinglist().get(0).createPoll("karim");
        // create 3 people for voting
        Person A = new Person("Arman", "Hatami");
        Person B = new Person("Asad", "Hashemi");
        Person C = new Person("Omid", "ghanbari");
        ArrayList<String> AvoteList = new ArrayList<String>();
        ArrayList<String> BvoteList = new ArrayList<String>();
        ArrayList<String> CvoteList = new ArrayList<String>();
        AvoteList.add("jalal");
        AvoteList.add("hashem");
        // submitting the vote of A
        football.vote(0, A, AvoteList);
        BvoteList.add("karim");
        BvoteList.add("ali");
        football.vote(0, B, BvoteList);
        CvoteList.add("jalal");
        football.vote(0, C, CvoteList);
        football.printListOfVotings();
        football.printVoting(0);
        football.printResult(0);
        football.getVotinglist().get(0).printVotes();
    }
}
