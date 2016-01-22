package cn.jersey.grizzly.helloworld;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

public class App {

	private static final URI BASE_URI = URI.create("http://localhost:8080/");
    public static final String ROOT_PATH = "helloworld";
    
    public App() { }
    
    public static void main(String[] args) {
        try {
            System.out.println("\"Hello World\" Jersey Example App");

            final Config resourceConfig = new Config(new Class[]{HelloWorldResource.class, 
            		SecondResource.class, CorsFilter.class});
            resourceConfig.setApplicationName("hello world");
            final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, resourceConfig, false);
            
            server.start();
            System.out.println(String.format(resourceConfig.getApplicationName() + 
            		" started.\npress any key to stop the application"));
            System.in.read();
            server.shutdown();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
