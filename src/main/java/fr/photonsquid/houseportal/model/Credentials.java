package fr.photonsquid.houseportal.model;

import java.util.Objects;

public class Credentials {
    private String email;
    private String pwd;

    public Credentials() {
    }

    public Credentials(String id, String pwd) {
        this.email = id;
        this.pwd = pwd;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String id) {
        this.email = id;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Credentials id(String id) {
        setEmail(id);
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
        return Objects.equals(email, credentials.email) && Objects.equals(pwd, credentials.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, pwd);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getEmail() + "'" +
                ", pwd='" + getPwd() + "'" +
                "}";
    }

}
