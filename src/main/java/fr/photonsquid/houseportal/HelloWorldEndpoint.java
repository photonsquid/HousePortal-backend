package fr.photonsquid.houseportal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello/{name}")
public class HelloWorldEndpoint {
    @GET
    @Produces("application/json")
    public Response doGet(@PathParam("name") String name) {
        try {
            // String url = "jdbc:mariadb://localhost:3307/houseportal";
            // String username = "chap";
            // String password = "x8e71nbo51x4";
            String url = "jdbc:mariadb://remotemysql.com:3306/SdAs1aN50C";
            String username = "SdAs1aN50C";
            String password = "naiiOEOa80";

            Connection con = DriverManager.getConnection(url, username, password);

            String requete = "SELECT * FROM users WHERE username = '" + name + "'";
            ResultSet results = con.createStatement().executeQuery(requete);
            if (results.next()) {
                String json = "{\"name\": \"" +
                        results.getString("name") + "\", \"mail\": \""
                        + results.getString("mail")
                        + "\"}";
                return Response.ok(json, MediaType.APPLICATION_JSON).build();
            } else {
                return Response.status(401, "Unknown user " + name).build();
            }
        } catch (SQLException e) {
            System.out.println("errr");
            System.out.println(e.getMessage());
            return Response.serverError().build();
        }
    }
}
