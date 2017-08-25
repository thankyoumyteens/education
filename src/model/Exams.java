package model;

/**
 * Created by Admin on 2017/8/25.
 */
public class Exams {
    private int id;
    private String title;
    private String link;

    public Exams() {
    }

    public Exams(int id, String title, String link) {
        this.id = id;
        this.title = title;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
