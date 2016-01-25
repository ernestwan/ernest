package cn.openjpa.demos.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cn.openjpa.demos.jpa.domain.User;
import cn.openjpa.demos.jpa.server.ServiceFactory;
import cn.openjpa.demos.jpa.service.UserService;

@Path("demos")
public class UserResource {

	private final UserService userService;
	
	public UserResource() {
		userService = (UserService) ServiceFactory.getService(UserService.DEFAULT_UNIT);
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/users")
    public Response getJson() {
        List<User> u = userService.findAll();
		return Response.status(200).entity(u.toString()).build();
    }
	
}
