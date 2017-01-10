package com.techypark.endpoint;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wordpress.techypark.com.services.helloworld.HelloWorldService;

@Configuration
public class EndpointConfig {
  
  public static final String SERVICE_URL = "/helloworld";

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus,
                new HelloWorldImpl());
        
        endpoint.setServiceName(helloWorldService().getServiceName());
        endpoint.setWsdlLocation(helloWorldService().getWSDLDocumentLocation().toString());
        endpoint.publish(SERVICE_URL);
        return endpoint;
    }
    
    @Bean
    public HelloWorldService helloWorldService(){
      return new HelloWorldService();
    }
}
