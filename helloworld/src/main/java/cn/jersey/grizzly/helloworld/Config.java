package cn.jersey.grizzly.helloworld;

import org.glassfish.jersey.server.ResourceConfig;

public class Config extends ResourceConfig {
	
	public Config() {
		register(HelloWorldResource.class);
	}
	
	public Config(Class<?>[] clz) {
		if (clz != null && clz.length > 0) {
			for (int i = 0; i < clz.length; i++) {
				register(clz[i]);
			}
		}
	}
	
}
