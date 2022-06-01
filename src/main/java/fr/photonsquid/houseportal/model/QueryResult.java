package fr.photonsquid.houseportal.model;

import java.util.Objects;

public class QueryResult {
    private String token, pwd_hashed;

    public QueryResult() {
    }

    public QueryResult(String token, String pwd_hashed) {
        this.token = token;
        this.pwd_hashed = pwd_hashed;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPwd_hashed() {
        return this.pwd_hashed;
    }

    public void setPwd_hashed(String pwd_hashed) {
        this.pwd_hashed = pwd_hashed;
    }

    public QueryResult token(String token) {
        setToken(token);
        return this;
    }

    public QueryResult pwd_hashed(String pwd_hashed) {
        setPwd_hashed(pwd_hashed);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof QueryResult)) {
            return false;
        }
        QueryResult queryResult = (QueryResult) o;
        return Objects.equals(token, queryResult.token) && Objects.equals(pwd_hashed, queryResult.pwd_hashed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, pwd_hashed);
    }

    @Override
    public String toString() {
        return "{" +
                " token='" + getToken() + "'" +
                ", pwd_hashed='" + getPwd_hashed() + "'" +
                "}";
    }

}
