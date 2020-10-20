/**
 * @author Arman Hatami
 * Coursera User ID:  123456
 * Last modified:     1/1/2019
 * this class process player for the songs we have
 */

package music_organizer;

public class MusicPlayer {
    // The current player. It might be null.
    private boolean isPlaying;

    /**
     * Constructor for objects of class MusicFilePlayer
     */
    public MusicPlayer() {
        isPlaying = false;
    }


    /**
     * Start playing the given audio file.
     * The method returns once the playing has been started.
     *
     * @param filename The file to be played.
     */
    public void startPlaying(String filename) {
        System.out.println(filename + " is playing..." + "\n___________________");
        isPlaying = true;
    }

    /**
     *stop playing whatever is playing.
     *
     */
    public void stop() {
        System.out.println("player is stopped!" + "\n___________________");
        isPlaying = false;
    }


}
