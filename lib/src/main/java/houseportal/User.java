package houseportal;

import java.io.Serializable;
import java.util.*;

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

    private String username,mail;


    @ManyToMany(fetch = FetchType.EAGER)
	private Collection<Device> devices ;

    public User() {
    }

    public User(String username, String mail) {
        this.username = username;
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
        return this.username;
    }

    public void setName(String Name) {
        this.username = Name;
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
