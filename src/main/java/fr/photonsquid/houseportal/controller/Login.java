package fr.photonsquid.houseportal.controller;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.photonsquid.houseportal.model.Credentials;

@Path("/login")
public class Login {
    @POST
    @Produces("application/json")
    public Response doPost(Credentials cr) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        entityManagerFactory = Persistence.createEntityManagerFactory("houseportal");
        entityManager = entityManagerFactory.createEntityManager();

        String username = cr.getUsername();
        String pwd = cr.getPwd();

        try {
            Query query = entityManager
                    .createQuery("Select u.pwd_hashed FROM User u WHERE u.username = :id");
            query.setParameter("id", username);
            String hashedPwd = (String) query.getSingleResult();
            PasswordAuthentication pa = new PasswordAuthentication();
            if (pa.authenticate(pwd.toCharArray(), hashedPwd)) {
                String bearer = UUID.randomUUID().toString();
                return Response.ok("{\"bearer\": \"" + bearer + "\"}", MediaType.APPLICATION_JSON).build();
            } else {
                return Response.status(401).build();
            }

        } catch (NoResultException e) {
            return Response.status(403).build();
        }
    }

}
