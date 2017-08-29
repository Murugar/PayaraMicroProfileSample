package com.iqmsoft.jaxrs;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;


@ApplicationScoped
public class ObjMapProducerForCDI {
    private final ObjectMapper mapper;

    public ObjMapProducerForCDI() {
        mapper = CusObjectMapResolver.getMapper();
    }

    @Produces
    public ObjectMapper inject(){
        return this.mapper;
    }
    
}
