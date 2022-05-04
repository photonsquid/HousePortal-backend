package houseportal;

import java.io.Serializable;
import java.util.*;

import javax.jws.soap.SOAPBinding.Style;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User implements Serializable{

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

    private String username,mail,name,surname,pwd_hashed,oauth_token;


    @ManyToMany(fetch = FetchType.EAGER)
	private Collection<Device> devices ;

    public User() {
    }

    public User(String username, String mail,String name,String surname,String pwd_hashed,String oauth_token ) {
        this.username = username;
        this.name=name;
        this.surname=surname;
        this.pwd_hashed=pwd_hashed;
        this.oauth_token=oauth_token;
        this.mail = mail;
        this.devices = new ArrayList<Device>();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPwd_hashed() {
        return this.pwd_hashed;
    }

    public void setPwd_hashed(String pwd_hashed) {
        this.pwd_hashed = pwd_hashed;
    }

    public String getOauth_token() {
        return this.oauth_token;
    }

    public void setOauth_token(String oauth_token) {
        this.oauth_token = oauth_token;
    }

    public Collection<Device> getDevices() {
        return this.devices;
    }

    public void setDevices(Collection<Device> devices) {
        this.devices = devices;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User users = (User) o;
        return id == users.id && Objects.equals(username, users.username) && Objects.equals(mail, users.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, mail);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", mail='" + getMail() + "'" +
            "}";
    }

}
