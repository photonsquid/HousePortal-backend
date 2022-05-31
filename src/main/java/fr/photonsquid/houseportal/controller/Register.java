package fr.photonsquid.houseportal.controller;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.photonsquid.houseportal.User;
import fr.photonsquid.houseportal.model.RegisterCredentials;

@Path("/register")
public class Register {
    @POST
    @Produces("application/json")
    public Response doPost(RegisterCredentials cr) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        entityManagerFactory = Persistence.createEntityManagerFactory("houseportal");
        entityManager = entityManagerFactory.createEntityManager();

        String email = cr.getEmail();
        String username = cr.getUsername();
        String pwd = cr.getPwd();

        PasswordAuthentication pa = new PasswordAuthentication();

        try {

            User newUser = new User();
            newUser.setEmail(email);
            newUser.setUsername(username);
            newUser.setPwd_hashed(pa.hash(pwd.toCharArray()));
            newUser.setToken(UUID.randomUUID().toString());

            entityManager.getTransaction().begin();
            entityManager.persist(newUser);
            entityManager.getTransaction().begin();

            String bearer = UUID.randomUUID().toString();
            return Response.ok("{" +
                    "\"token\": \"" + newUser.getToken() + "\",\n" +
                    "\"bearer\": \"" + bearer +
                    "\"}", MediaType.APPLICATION_JSON).build();

        } catch (NoResultException e) {
            return Response.status(403).build();
        }
    }

}
