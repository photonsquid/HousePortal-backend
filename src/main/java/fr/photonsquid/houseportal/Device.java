package fr.photonsquid.houseportal;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "devices")
public class Device implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name, location, status, type;

    public Device() {
    }

    public Device(int id, String name, String location, String status, String type) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.status = status;
        this.type = type;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Device id(int id) {
        setId(id);
        return this;
    }

    public Device name(String name) {
        setName(name);
        return this;
    }

    public Device location(String location) {
        setLocation(location);
        return this;
    }

    public Device status(String status) {
        setStatus(status);
        return this;
    }

    public Device type(String type) {
        setType(type);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Device)) {
            return false;
        }
        Device device = (Device) o;
        return id == device.id && Objects.equals(name, device.name) && Objects.equals(location, device.location)
                && Objects.equals(status, device.status) && Objects.equals(type, device.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, status, type);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", location='" + getLocation() + "'" +
                ", status='" + getStatus() + "'" +
                ", type='" + getType() + "'" +
                "}";
    }

}
