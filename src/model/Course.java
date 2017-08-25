package model;

/**
 * Created by Admin on 2017/8/25.
 */
public class Course {
    private int id;
    private int category;
    private String title;
    private String img;
    private String link;

    public Course() {
    }

    public Course(int id, int category, String title, String img, String link) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.img = img;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
