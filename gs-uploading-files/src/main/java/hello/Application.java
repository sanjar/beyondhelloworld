package hello;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import hello.storage.StorageProperties;
import hello.storage.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Application {

	public static void main(String[] args) {
		System.setProperty("server.connection-timeout","60000");
		System.setProperty("maxSwallowSize", "-1");
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
            storageService.deleteAll();
            storageService.init();
		};
	}
	
	@Bean
	public TomcatEmbeddedServletContainerFactory containerFactory() {
	    return new TomcatEmbeddedServletContainerFactory() {
	        protected void customizeConnector(Connector connector) {
	            super.customizeConnector(connector);
	            if (connector.getProtocolHandler() instanceof AbstractHttp11Protocol) {
	                ((AbstractHttp11Protocol <?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
	            }
	        }
	    };

	}
}
