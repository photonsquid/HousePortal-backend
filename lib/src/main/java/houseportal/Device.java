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
public class Device implements Serializable {

    @ManyToMany(mappedBy="devices",fetch = FetchType.EAGER)
	private Collection<User> users;

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private int ip_address;

    private String name,type;


    public Device() {
    }

    public Device(int ip_address, String name, String type) {
        this.ip_address = ip_address;
        this.name = name;
        this.type = type;
        this.users = new ArrayList<User>();
    }

    public Collection<User> getUsers() {
        return this.users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIp_address() {
        return this.ip_address;
    }

    public void setIp_address(int ip_address) {
        this.ip_address = ip_address;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Device)) {
            return false;
        }
        Device device = (Device) o;
        return Objects.equals(users, device.users) && id == device.id && ip_address == device.ip_address && Objects.equals(name, device.name) && Objects.equals(type, device.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users, id, ip_address, name, type);
    }

    @Override
    public String toString() {
        return "{" +
            " users='" + getUsers() + "'" +
            ", id='" + getId() + "'" +
            ", ip_address='" + getIp_address() + "'" +
            ", name='" + getName() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }



    
}
