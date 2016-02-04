package cn.openjpa.demos.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import cn.openjpa.demos.bean.UserBean;
import cn.openjpa.demos.jpa.domain.User;
import cn.openjpa.demos.jpa.service.ServiceFactory;
import cn.openjpa.demos.jpa.service.UserService;
import cn.openjpa.demos.utils.HttpStatus;
import cn.openjpa.demos.utils.JsonConverter;

@Path("demos/users")
public class UserResource {

	private final UserService userService;
	
	public UserResource() {
		userService = (UserService) ServiceFactory.getService(UserService.class);
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<User> users = userService.findAll();
        if (null != users) {
			return Response.status(HttpStatus.OK).entity(JsonConverter.serialize(users)).build(); 
		} // 否则没找到数据
		return Response.status(HttpStatus.NO_CONTENT).build();
    }
	
	@GET
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") int id) {
		User u = userService.find(id);
		if (null != u) {
			return Response.status(HttpStatus.OK).entity(JsonConverter.serialize(u)).build(); 
		} // 否则没找到数据
		return Response.status(HttpStatus.NO_CONTENT).build();
    }
	
	@POST
	@Consumes("application/json")
	public Response createUser(UserBean userJson) throws JSONException{
		
		User u = new User(userJson.getUsername());
		if (userService.create(u)) {
			
			return Response.created(null).build(); 
		}
		return Response.status(HttpStatus.NO_CONTENT).build(); 
	}
	
	@PUT
	@Path("{id}")
	public Response updateUser(@PathParam("id") int id) {
		if (userService.update(id)) {
			return Response.status(HttpStatus.OK).build(); 
		}
		return Response.status(HttpStatus.NO_CONTENT).build(); 
	}
	
}
