package fr.photonsquid.houseportal.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class Login {
    @GET
    @Produces("application/json")
    public Response doGet(@PathParam("username") String username, @PathParam("password") String pwd) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("WebStore");
            entityManager = entityManagerFactory.createEntityManager();

            List<String> ids = entityManager.createQuery(
                    "SELECT FROM users u WHERE u.username LIKE :custName", String.class)
                    .setParameter("custName", username)
                    .getResultList();
            for (String id : ids) {
                System.out.println(id);
            }
            return Response.ok("{bearer: kjhsdfglhsdfjgk}", MediaType.APPLICATION_JSON).build();

        } finally {
            if (entityManager != null)
                entityManager.close();
            if (entityManagerFactory != null)
                entityManagerFactory.close();
        }
    }
}
