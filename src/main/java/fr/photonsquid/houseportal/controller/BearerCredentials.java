package fr.photonsquid.houseportal.controller;

import java.util.Objects;

public class BearerCredentials {
    private String bearer;

    public BearerCredentials() {
    }

    public BearerCredentials(String bearer) {
        this.bearer = bearer;
    }

    public String getBearer() {
        return this.bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public BearerCredentials bearer(String bearer) {
        setBearer(bearer);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BearerCredentials)) {
            return false;
        }
        BearerCredentials bearerCredentials = (BearerCredentials) o;
        return Objects.equals(bearer, bearerCredentials.bearer);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bearer);
    }

    @Override
    public String toString() {
        return "{" +
                " bearer='" + getBearer() + "'" +
                "}";
    }

}