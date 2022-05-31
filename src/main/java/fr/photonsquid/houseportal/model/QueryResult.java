package fr.photonsquid.houseportal.model;

import java.util.Objects;

public class QueryResult {
    private String pwd_hashed;
    private String token;

    public QueryResult() {
    }

    public QueryResult(String pwd_hashed, String token) {
        this.pwd_hashed = pwd_hashed;
        this.token = token;
    }

    public String getPwd_hashed() {
        return this.pwd_hashed;
    }

    public void setPwd_hashed(String pwd_hashed) {
        this.pwd_hashed = pwd_hashed;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public QueryResult pwd_hashed(String pwd_hashed) {
        setPwd_hashed(pwd_hashed);
        return this;
    }

    public QueryResult token(String token) {
        setToken(token);
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
        return Objects.equals(pwd_hashed, queryResult.pwd_hashed) && Objects.equals(token, queryResult.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pwd_hashed, token);
    }

    @Override
    public String toString() {
        return "{" +
                " pwd_hashed='" + getPwd_hashed() + "'" +
                ", token='" + getToken() + "'" +
                "}";
    }

}
