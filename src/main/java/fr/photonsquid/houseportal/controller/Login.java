package fr.photonsquid.houseportal.controller;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.photonsquid.houseportal.User;
import fr.photonsquid.houseportal.model.Credentials;
import fr.photonsquid.houseportal.model.RegisterCredentials;
import fr.photonsquid.houseportal.model.Session;

@Path("/")
public class Login implements LoginInterface {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("houseportal");
    private static final EntityManager em = emf.createEntityManager();
    private Session session;

    public Login() {
        session = new Session();
    }

    @POST
    @Produces("application/json")
    @Path("/login")
    public Response login(Credentials cr) {

        String email = cr.getEmail();
        String pwd = cr.getPwd();

        try {
            Query query = em.createQuery("FROM User u WHERE u.email = :id");
            query.setParameter("id", email);
            User user = (User) query.getSingleResult();
            PasswordAuthentication pa = new PasswordAuthentication();
            if (pa.authenticate(pwd.toCharArray(), user.getPwd_hashed())) {
                session.createSession(user.getId());
                return Response.ok("{" +
                        "\"token\": \"" + user.getToken() + "\",\n" +
                        "\"bearer\": \"" + session.getBearer() +
                        "\"}", MediaType.APPLICATION_JSON).build();
            } else {
                return Response.status(401).build();
            }

        } catch (NoResultException e) {
            return Response.status(403).build();
        }
    }

    @POST
    @Produces("application/json")
    @Path("/register")
    public Response register(RegisterCredentials cr) {

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

            em.getTransaction().begin();
            em.persist(newUser);
            em.getTransaction().begin();

            String bearer = UUID.randomUUID().toString();
            return Response.ok("{" +
                    "\"token\": \"" + newUser.getToken() + "\",\n" +
                    "\"bearer\": \"" + bearer +
                    "\"}", MediaType.APPLICATION_JSON).build();

        } catch (NoResultException e) {
            return Response.status(403).build();
        }
    }

    @GET
    @Produces("application/json")
    @Path("/isactive")
    public Response isactive(BearerCredentials cr) {
        if (session.checkSession(cr.getBearer()) > 0) {
            return Response.ok("{\"active\": true}", MediaType.APPLICATION_JSON).build();
        } else {
            return Response.status(403).build();
        }
    }

    @GET
    @Produces("application/json")
    @Path("/device")
    public Response getDevices(BearerCredentials cr) {
        int id = session.checkSession(cr.getBearer());

        if (id < 0) {
            return Response.status(403).build();
        }

        try {
            Query query = em.createQuery("FROM Device d WHERE u.u_id = :id");
            query.setParameter("id", id);
            return Response.ok(query.getResultList(), MediaType.APPLICATION_JSON).build();

        } catch (NoResultException e) {
            return Response.status(403).build();
        }
    }

    @GET
    @Produces("application/json")
    @Path("/device/{id}")
    public Response getDeviceInfo(BearerCredentials cr, @PathParam("id") int deviceId) {
        int id = session.checkSession(cr.getBearer());

        if (id < 0) {
            return Response.status(403).build();
        }

        try {
            Query query = em.createQuery("FROM Device d WHERE u.u_id = :id and d.d_id = :deviceId");
            query.setParameter("id", id);
            query.setParameter("deviceId", deviceId);
            return Response.ok(query.getSingleResult(), MediaType.APPLICATION_JSON).build();

        } catch (NoResultException e) {
            return Response.status(403).build();
        }
    }

}
