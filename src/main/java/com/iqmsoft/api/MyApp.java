package com.iqmsoft.api;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.iqmsoft.jaxrs.CusObjectMapResolver;


@ApplicationPath("api")
public class MyApp extends ResourceConfig{

    public MyApp() {
        super( JacksonFeature.class, 
                CusObjectMapResolver.class);

        packages("com.iqmsoft.api");
    }
	
}
