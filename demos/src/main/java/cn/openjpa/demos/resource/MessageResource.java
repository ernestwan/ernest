package cn.openjpa.demos.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cn.openjpa.demos.jpa.domain.Message;
import cn.openjpa.demos.jpa.service.MessageService;
import cn.openjpa.demos.jpa.service.ServiceFactory;
import cn.openjpa.demos.utils.HttpStatus;
import cn.openjpa.demos.utils.JsonConverter;

@Path("demos/messages")
public class MessageResource {

	private final MessageService messageService;
	
	@Inject
	public MessageResource() {
		messageService = (MessageService) ServiceFactory.getService(MessageService.class);
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Message> messaes = messageService.findAll();
        if (null != messaes) {
			return Response.status(HttpStatus.OK).entity(JsonConverter.serialize(messaes)).build(); 
		} // 否则没找到数据
		return Response.status(HttpStatus.NO_CONTENT).build();
    }
	
}
