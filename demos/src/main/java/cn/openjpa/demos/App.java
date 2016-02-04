package cn.openjpa.demos;

import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import cn.openjpa.demos.jpa.DataLoader;
import cn.openjpa.demos.resource.Config;

public class App {
	
	public static void main(String[] args) throws Exception{
        
    	DataLoader.init(); 
        final Config resourceConfig = new Config();
        final HttpServer server = GrizzlyHttpServerFactory
        		.createHttpServer(URI.create(Config.BASE_URI + Config.PORT), 
        		resourceConfig, false);
        server.start();
        System.out.println("press any key to stop the application");
        System.in.read();
        server.shutdown();
        
    }
	
}
