package ceit.aut.ac.ir.model;
import java.io.Serializable;
/**
 * @author Arman Hatami
 * @version 1.0
 * to save notes with extra info
 */
// TODO: Phase2: uncomment this code
public class Note implements Serializable {

    private String title;
    private String content;
    private String date;

    /**
     * constructor method
     * @param title
     * @param content
     * @param date
     */
    public Note(String title, String content, String date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

}

