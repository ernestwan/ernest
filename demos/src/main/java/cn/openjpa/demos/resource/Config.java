package cn.openjpa.demos.resource;

import org.glassfish.jersey.server.ResourceConfig;

import cn.openjpa.demos.utils.JsonMoxyConfigurationContextResolver;

public class Config extends ResourceConfig {
	
	public static final String BASE_URI = "http://0.0.0.0";
	public static final String PORT = ":8080";
	
	public Config() {
		register(UserResource.class);
		register(CorsFilter.class);
		register(MessageResource.class);
		register(JsonMoxyConfigurationContextResolver.class);
	}
	
}
