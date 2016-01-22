package cn.jersey.grizzly.helloworld;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import cn.jersey.grizzly.helloworld.jpa.User;

@Path("second")
public class SecondResource extends PersistanceResource{

	public static final String CLICHED_MESSAGE = "Hello second!";

	public SecondResource(String unit, EntityManagerFactory emf, boolean managed,
            PersistenceContextType scope) {
		
		
        super(unit, emf, managed, scope);
       
    }
	
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        return CLICHED_MESSAGE;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/names")
    public Response getJson() {
        JSONObject json = new JSONObject();
        json.put("name", "sd");
        json.put("age", 23);
        return Response.status(200).entity(json.toString()).build();
    }
	
    @SuppressWarnings("unchecked")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/users")
    public Response getUsers() {
        
    	EntityManager em = begin();
        Query q = em.createQuery("select u from User u");
        JSONObject json = new JSONObject();
        for (User u: (List<User>) q.getResultList()) {
        	json.put("name", u.getName());
        	json.put("password", u.getPassword());
        }
        commit();
        return Response.status(200).entity(json.toString()).build();
    }
    
}
