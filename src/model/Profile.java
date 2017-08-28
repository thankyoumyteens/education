package model;

/**
 * Created by Admin on 2017/8/28.
 */
public class Profile {
    private int id;
    private String uid;
    private String nickname;
    private String name;
    private String gender;
    private String address;
    private String mail;
    private String idCard;
    private String schoolCard;
    private String qqAccount;
    private String wechatAccount;
    private String weiboAccount;

    public Profile() {
    }

    public Profile(int id, String uid, String nickname, String name, String gender, String address, String mail, String idCard, String schoolCard, String qqAccount, String wechatAccount, String weiboAccount) {
        this.id = id;
        this.uid = uid;
        this.nickname = nickname;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.mail = mail;
        this.idCard = idCard;
        this.schoolCard = schoolCard;
        this.qqAccount = qqAccount;
        this.wechatAccount = wechatAccount;
        this.weiboAccount = weiboAccount;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSchoolCard() {
        return schoolCard;
    }

    public void setSchoolCard(String schoolCard) {
        this.schoolCard = schoolCard;
    }

    public String getQqAccount() {
        return qqAccount;
    }

    public void setQqAccount(String qqAccount) {
        this.qqAccount = qqAccount;
    }

    public String getWechatAccount() {
        return wechatAccount;
    }

    public void setWechatAccount(String wechatAccount) {
        this.wechatAccount = wechatAccount;
    }

    public String getWeiboAccount() {
        return weiboAccount;
    }

    public void setWeiboAccount(String weiboAccount) {
        this.weiboAccount = weiboAccount;
    }
}
