package model;

/**
 * Created by Admin on 2017/8/25.
 */
public class User {
    private int id;
    private int delFlag;
    private int accessLevel;
    private String uid;
    private String pwd;

    public User() {
    }

    public User(int id, int delFlag, int accessLevel, String uid, String pwd) {
        this.id = id;
        this.delFlag = delFlag;
        this.accessLevel = accessLevel;
        this.uid = uid;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
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
