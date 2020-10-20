/**
 * @author Arman Hatami
 * Coursera User ID:  123456
 * Last modified:     1/1/2019
 * this is song class were we can define adjectives for each song
 */

package music_organizer;

public class Song {
    private String singerName;
    private String addressFile;
    private String publishYear;

    /**
     * setting the name of artist
     *
     * @param name The name of artist
     */
    public void setName(String name) {
        singerName = name;
    }

    /**
     *setting the file address for the song
     *
     * @param address the address where this file is located
     */
    public void setAddress(String address) {
        addressFile = address;
    }

    /**
     *setting the publish year for the song
     *
     * @param year The date this song was released
     */
    public void setYear(String year) {
        publishYear = year;
    }

    /**
     *printing the info of this song in order
     */
    public void printInfo() {
        System.out.println("singer name : " + singerName + "\npublished in : " + publishYear
                                   + "\nlocated in : " + addressFile + "\n___________________");

    }

    /**
     * returning the name of artist
     *
     * @return singerName The name of artist
     */
    public String getName() {
        return singerName;
    }

}
