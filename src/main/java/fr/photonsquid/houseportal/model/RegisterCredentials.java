package fr.photonsquid.houseportal.model;

import java.util.Objects;

public class RegisterCredentials extends Credentials {
    private String username;

    public RegisterCredentials() {
    }

    public RegisterCredentials(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public RegisterCredentials username(String username) {
        setUsername(username);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RegisterCredentials)) {
            return false;
        }
        RegisterCredentials registerCredentials = (RegisterCredentials) o;
        return Objects.equals(username, registerCredentials.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }

    @Override
    public String toString() {
        return "{" +
                " username='" + getUsername() + "'" +
                "}";
    }

}
