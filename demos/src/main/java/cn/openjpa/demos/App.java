package cn.openjpa.demos;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import cn.openjpa.demos.jpa.server.DataLoader;
import cn.openjpa.demos.resource.Config;


public class App {

	public static void main(String[] args) {
        try {
        	DataLoader.init();
            final Config resourceConfig = new Config();
            //resourceConfig.setApplicationName("hello world");
            final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(Config.BASE_URI + Config.PORT), resourceConfig, false);
            
            server.start();
            System.out.println(String.format(resourceConfig.getApplicationName() + 
            		" started.\npress any key to stop the application"));
            System.in.read();
            server.shutdown();
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        	DataLoader.release();
		}
    }
	
}
