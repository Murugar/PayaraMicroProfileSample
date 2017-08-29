package com.iqmsoft.jaxrs;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import static com.iqmsoft.util.DateTimeConverters.*;

import java.io.IOException;
import java.time.LocalDate;


public class LocalDateDeserializer extends JsonDeserializer<LocalDate>{

    @Override
    public LocalDate deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        return str2LocalDate(jp.getText());
    }
    
}
