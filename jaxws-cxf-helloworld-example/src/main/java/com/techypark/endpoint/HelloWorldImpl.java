package com.techypark.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wordpress.techypark.com.services.helloworld.HelloWorldPortType;
import com.wordpress.techypark.com.types.helloworld.Greeting;
import com.wordpress.techypark.com.types.helloworld.ObjectFactory;
import com.wordpress.techypark.com.types.helloworld.Person;

public class HelloWorldImpl implements HelloWorldPortType {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(HelloWorldImpl.class);

    @Override
    public Greeting sayHello(Person request) {
        LOGGER.info(
                "Endpoint received person=[firstName:{},lastName:{}]",
                request.getFirstName(), request.getLastName());

        String greeting = "Hi, " + request.getFirstName() + " "
                + request.getLastName() + "!";

        ObjectFactory factory = new ObjectFactory();
        Greeting response = factory.createGreeting();
        response.setGreeting(greeting);

        LOGGER.info("Endpoint sending greeting=[{}]",
                response.getGreeting());
        return response;
    }
}
