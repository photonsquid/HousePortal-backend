package fr.photonsquid.houseportal.model;

import java.util.Objects;
import java.util.UUID;

import javax.ejb.Stateful;

@Stateful(mappedName = "stateful123")
public class Session implements SessionInterface {
    private String bearer = "";
    private int uid = 0;

    public Session() {
    }

    public Session(String bearer, int uid) {
        this.bearer = bearer;
        this.uid = uid;
    }

    public String getBearer() {
        return this.bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public int getUid() {
        return this.uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Session bearer(String bearer) {
        setBearer(bearer);
        return this;
    }

    public Session uid(int uid) {
        setUid(uid);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Session)) {
            return false;
        }
        Session session = (Session) o;
        return Objects.equals(bearer, session.bearer) && uid == session.uid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bearer, uid);
    }

    @Override
    public String toString() {
        return "{" +
                " bearer='" + getBearer() + "'" +
                ", uid='" + getUid() + "'" +
                "}";
    }

    @Override
    public String createSession(int uid) {
        this.uid = uid;
        this.bearer = UUID.randomUUID().toString();
        return this.bearer;
    }

    @Override
    public void destroySession(String bearer) {
        this.uid = 0;
        this.bearer = "";

    }

    @Override
    public int checkSession(String bearer) {
        if (this.bearer.equals(bearer)) {
            return this.uid;
        }
        return -1;
    }

}