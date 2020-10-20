/**
 * @author Arman Hatami
 * Coursera User ID:  123456
 * Last modified:     1/1/2019
 * this the main class where we define 4 types of songs and we can process commands
 */

package music_organizer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MusicCollection pop = new MusicCollection();
        MusicCollection jazz = new MusicCollection();
        MusicCollection rock = new MusicCollection();
        MusicCollection country = new MusicCollection();
        MusicCollection playlist = new MusicCollection();
        //temp song class for using in while loop
        Song song = new Song();

        Scanner input = new Scanner(System.in);
        String select;
        String genre = null;
        String name;
        String address;
        String year;
        while (true) {
            System.out.println("1.add a new song ");
            System.out.println("2.remove a song ");
            System.out.println("3.play a song");
            System.out.println("4.stop playing");
            System.out.println("5.show songs list");
            System.out.println("6.show number of my songs");
            System.out.println("7.add song to playlist");
            System.out.println("8.exit");
            select = input.nextLine();
            switch (select) {
                case "1":
                    System.out.println("enter the genre : ");
                    genre = input.nextLine();
                    System.out.println("enter the name of singer : ");
                    name = input.nextLine();
                    song.setName(name);
                    System.out.println("enter the file address : ");
                    address = input.nextLine();
                    song.setAddress(address);
                    System.out.println("enter the year of publish: ");
                    year = input.nextLine();
                    song.setYear(year);
                    switch (genre) {
                        case "pop":
                            pop.addFile(song);
                            break;
                        case "jazz":
                            jazz.addFile(song);
                            break;
                        case "rock":
                            rock.addFile(song);
                            break;
                        case "country":
                            country.addFile(song);
                            break;
                        default:
                            System.out.println("genre was not found");
                    }
                    break;
                case "2":
                    System.out.println("enter the genre : ");
                    genre = input.nextLine();
                    System.out.println("enter the name of artist : ");
                    name = input.nextLine();
                    switch (genre) {
                        case "pop":
                            for (Song song1 : pop.files)
                                if (song1.getName().equals(name)) {
                                    pop.removeFile(pop.files.indexOf(song1));
                                    break;
                                }
                            break;
                        case "jazz":
                            for (Song song1 : jazz.files)
                                if (song1.getName().equals(name)) {
                                    jazz.removeFile(jazz.files.indexOf(song1));
                                    break;
                                }
                            break;
                        case "rock":
                            for (Song song1 : rock.files)
                                if (song1.getName().equals(name)) {
                                    rock.removeFile(rock.files.indexOf(song1));
                                    break;
                                }
                            break;
                        case "country":
                            for (Song song1 : country.files)
                                if (song1.getName().equals(name)) {
                                    country.removeFile(country.files.indexOf(song1));
                                    break;
                                }
                            break;
                        case "playlist":
                            for (Song song1 : playlist.files)
                                if (song1.getName().equals(name)) {
                                    playlist.removeFile(playlist.files.indexOf(song1));
                                    break;
                                }
                            break;
                        default:
                            System.out.println("not found");
                    }
                    break;
                case "3":
                    System.out.println("enter the name of genre : ");
                    genre = input.nextLine();
                    System.out.println("enter the name of artist : ");
                    name = input.nextLine();
                    switch (genre) {
                        case "pop":
                            for (Song song1 : pop.files)
                                if (song1.getName().equals(name)) {
                                    pop.startPlaying(pop.files.indexOf(song1));
                                    break;
                                }
                            break;
                        case "rock":
                            for (Song song1 : rock.files)
                                if (song1.getName().equals(name)) {
                                    rock.startPlaying(rock.files.indexOf(song1));
                                    break;
                                }
                            break;
                        case "jazz":
                            for (Song song1 : jazz.files)
                                if (song1.getName().equals(name)) {
                                    jazz.startPlaying(jazz.files.indexOf(song1));
                                    break;
                                }
                            break;
                        case "country":
                            for (Song song1 : country.files)
                                if (song1.getName().equals(name)) {
                                    country.startPlaying(country.files.indexOf(song1));
                                    break;
                                }
                            break;
                        case "playlist":
                            for (Song song1 : playlist.files)
                                if (song1.getName().equals(name)) {
                                    playlist.startPlaying(playlist.files.indexOf(song1));
                                    break;
                                }
                            break;
                        default:
                            System.out.println("not found");
                    }
                    break;
                case "4":
                    if (!genre.isEmpty()) {
                        switch (genre) {
                            case "pop":
                                pop.stopPlaying();
                                break;
                            case "rock":
                                rock.stopPlaying();
                                break;
                            case "jazz":
                                jazz.stopPlaying();
                                break;
                            case "country":
                                country.stopPlaying();
                                break;
                            case "playlist":
                                playlist.stopPlaying();
                                break;
                        }
                    }
                    else
                        System.out.println("nothing is playing");
                    break;

                case "5":
                    System.out.println("enter the genre : ");
                    genre = input.nextLine();
                    switch (genre) {
                        case "pop":
                            pop.listAllFiles();
                            break;
                        case "jazz":
                            jazz.listAllFiles();
                            break;
                        case "country":
                            country.listAllFiles();
                            break;
                        case "rock":
                            rock.listAllFiles();
                            break;
                        case "playlist":
                            playlist.listAllFiles();
                            break;
                        default:
                            System.out.println("genre not found");
                    }
                    break;
                case "6":
                    System.out.println("pop : " + pop.getNumberOfFiles() +
                                               "\njazz : " + jazz.getNumberOfFiles() + "\nrock : "
                                               + rock.getNumberOfFiles() + "\ncountry : " + country
                            .getNumberOfFiles() + "\nplaylist : " + playlist.getNumberOfFiles()
                                               + "\n___________________");
                    break;
                case "7":
                    System.out.println("enter the name of singer : ");
                    name = input.nextLine();
                    song.setName(name);
                    System.out.println("enter the file address : ");
                    address = input.nextLine();
                    song.setAddress(address);
                    System.out.println("enter the year of publish: ");
                    year = input.nextLine();
                    song.setYear(year);
                    playlist.addFile(song);
                    break;
                case "8":
                    return;
            }
        }
    }
}
