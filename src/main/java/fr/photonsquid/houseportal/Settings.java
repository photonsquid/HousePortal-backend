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
public class Settings implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String theme, u_id;

    public Settings() {
    }

    public Settings(int id, String theme, String u_id) {
        this.id = id;
        this.theme = theme;
        this.u_id = u_id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return this.theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getU_id() {
        return this.u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public Settings id(int id) {
        setId(id);
        return this;
    }

    public Settings theme(String theme) {
        setTheme(theme);
        return this;
    }

    public Settings u_id(String u_id) {
        setU_id(u_id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Settings)) {
            return false;
        }
        Settings settings = (Settings) o;
        return id == settings.id && Objects.equals(theme, settings.theme) && Objects.equals(u_id, settings.u_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, theme, u_id);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", theme='" + getTheme() + "'" +
                ", u_id='" + getU_id() + "'" +
                "}";
    }

}
