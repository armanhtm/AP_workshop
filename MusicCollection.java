/**
 * @author Arman Hatami
 * Coursera User ID:  123456
 * Last modified:     1/1/2019
 * this class defines genre of music and we have methods to work with data in each genre.
 */

package music_organizer;

import java.util.ArrayList;


public class MusicCollection {
    // An ArrayList for storing the file names of music files.
    public ArrayList<Song> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicCollection
     */
    public MusicCollection() {
        files = new ArrayList<Song>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     *
     * @param song the song that we want to add
     */
    public void addFile(Song song) {
        files.add(song);
        System.out.println(song.getName() + " was added successfully" + "\n___________________");
    }

    /**
     * Return the number of files in the collection.
     *
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles() {
        return files.size();
    }

    /**
     * List a file from the collection.
     *
     * @param index The index of the file to be listed.
     */
    public void listFile(int index) {
        if (validIndex(index))
            files.get(index).printInfo();
    }

    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles() {
        for (Song song : files) {
            song.printInfo();
            System.out.println("___________________");
        }
    }

    /**
     * Remove a file from the collection.
     *
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index) {
        if (validIndex(index)) {
            String temp = files.get(index).getName();
            files.remove(index);
            System.out.println(
                    temp + " was removed successfully" + "\n___________________");
        }

    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     *
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index) {
        if (validIndex(index))
            player.startPlaying(files.get(index).getName());
    }

    /**
     * Stop the player.
     */
    public void stopPlaying() {
        player.stop();
    }


    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     *
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index) {
        if (index < 0 || index > files.size())
            return false;
        return true;
    }
}
