package model;

/**
 * Created by Admin on 2017/8/25.
 */
public class User {
    private int id;
    private String uid;
    private String pwd;

    public User() {
    }

    public User(int id, String uid, String pwd) {

        this.id = id;
        this.uid = uid;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
