package com.kg.servletforward;

public class User {

    private int userid;
    private String firstName;

    User() {
    }

    User(int userid, String firstName) {
        this.userid = userid;
        this.firstName = firstName;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "User [userid=" + userid + ", firstName=" + firstName + "]";
    }
}