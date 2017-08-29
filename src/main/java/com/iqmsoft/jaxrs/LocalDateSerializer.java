package com.iqmsoft.jaxrs;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import static com.iqmsoft.util.DateTimeConverters.*;

import java.io.IOException;
import java.time.LocalDate;


public class LocalDateSerializer extends JsonSerializer<LocalDate>{
    @Override
    public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeString(localDate2str(value));
        
    }
    
}
