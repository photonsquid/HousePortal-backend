package fr.photonsquid.houseportal;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username, name, surname, email, pwd_hashed, token, oauth_token;

    public User() {
    }

    public User(int id, String username, String name, String surname, String mail, String pwd_hashed, String token,
            String oauth_token) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = mail;
        this.pwd_hashed = pwd_hashed;
        this.token = token;
        this.oauth_token = oauth_token;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }

    public String getPwd_hashed() {
        return this.pwd_hashed;
    }

    public void setPwd_hashed(String pwd_hashed) {
        this.pwd_hashed = pwd_hashed;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOauth_token() {
        return this.oauth_token;
    }

    public void setOauth_token(String oauth_token) {
        this.oauth_token = oauth_token;
    }

    public User id(int id) {
        setId(id);
        return this;
    }

    public User username(String username) {
        setUsername(username);
        return this;
    }

    public User name(String name) {
        setName(name);
        return this;
    }

    public User surname(String surname) {
        setSurname(surname);
        return this;
    }

    public User mail(String mail) {
        setEmail(mail);
        return this;
    }

    public User pwd_hashed(String pwd_hashed) {
        setPwd_hashed(pwd_hashed);
        return this;
    }

    public User token(String token) {
        setToken(token);
        return this;
    }

    public User oauth_token(String oauth_token) {
        setOauth_token(oauth_token);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return id == user.id && Objects.equals(username, user.username) && Objects.equals(name, user.name)
                && Objects.equals(surname, user.surname) && Objects.equals(email, user.email)
                && Objects.equals(pwd_hashed, user.pwd_hashed) && Objects.equals(token, user.token)
                && Objects.equals(oauth_token, user.oauth_token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, name, surname, email, pwd_hashed, token, oauth_token);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", username='" + getUsername() + "'" +
                ", name='" + getName() + "'" +
                ", surname='" + getSurname() + "'" +
                ", mail='" + getEmail() + "'" +
                ", pwd_hashed='" + getPwd_hashed() + "'" +
                ", token='" + getToken() + "'" +
                ", oauth_token='" + getOauth_token() + "'" +
                "}";
    }

}
