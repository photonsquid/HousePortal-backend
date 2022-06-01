package fr.photonsquid.houseportal.controller;

import javax.ws.rs.core.Response;

import fr.photonsquid.houseportal.model.Credentials;
import fr.photonsquid.houseportal.model.RegisterCredentials;

public interface LoginInterface {
    public Response login(Credentials cr);

    public Response register(RegisterCredentials cr);

    public Response isactive(BearerCredentials cr);
}
