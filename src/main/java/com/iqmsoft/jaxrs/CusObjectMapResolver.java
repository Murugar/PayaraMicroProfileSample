package com.iqmsoft.jaxrs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;



@Provider
public class CusObjectMapResolver implements ContextResolver<ObjectMapper>{
    private static ObjectMapper mapper;

    static ObjectMapper getMapper(){
        if (mapper == null){
            mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            return mapper;
        }
        return mapper;
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return getMapper();
    }
    
}
