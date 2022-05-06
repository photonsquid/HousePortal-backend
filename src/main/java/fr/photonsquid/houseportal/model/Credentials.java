package fr.photonsquid.houseportal.model;

import java.util.Objects;

public class Credentials {
    private String username;
    private String pwd;

    public Credentials() {
    }

    public Credentials(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Credentials username(String username) {
        setUsername(username);
        return this;
    }

    public Credentials pwd(String pwd) {
        setPwd(pwd);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Credentials)) {
            return false;
        }
        Credentials credentials = (Credentials) o;
        return Objects.equals(username, credentials.username) && Objects.equals(pwd, credentials.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, pwd);
    }

    @Override
    public String toString() {
        return "{" +
                " username='" + getUsername() + "'" +
                ", pwd='" + getPwd() + "'" +
                "}";
    }

}
