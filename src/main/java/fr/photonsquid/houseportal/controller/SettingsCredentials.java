package fr.photonsquid.houseportal.controller;

import java.util.Objects;

public class SettingsCredentials {
    private String bearer;
    private String value;

    public SettingsCredentials() {
    }

    public SettingsCredentials(String bearer, String value) {
        this.bearer = bearer;
        this.value = value;
    }

    public String getBearer() {
        return this.bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public SettingsCredentials bearer(String bearer) {
        setBearer(bearer);
        return this;
    }

    public SettingsCredentials value(String value) {
        setValue(value);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SettingsCredentials)) {
            return false;
        }
        SettingsCredentials settingsCredentials = (SettingsCredentials) o;
        return Objects.equals(bearer, settingsCredentials.bearer) && Objects.equals(value, settingsCredentials.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bearer, value);
    }

    @Override
    public String toString() {
        return "{" +
                " bearer='" + getBearer() + "'" +
                ", value='" + getValue() + "'" +
                "}";
    }

}