package com.shady.hidradenitis.suppurutiva.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shady.hidradenitis.suppurutiva.auth.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Component
public class PayloadMapperImpl implements PayloadMapper {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Map<String, Object> map(Payload payload) {
        Map<String, Object> mapped = new HashMap<>();
        try {
            for(Field field: payload.getClass().getFields()) {
                mapped.put(field.getName(), field.get(payload));
            }
        } catch(IllegalAccessException e) {
            System.out.println("gaah!");
        }
        return mapped;
    }

    @Override
    public Payload map(String jsonPayload, Class<? extends Payload> type) {
         Payload payload = null;
        try {
            payload = objectMapper.readValue(jsonPayload, type);
        } catch(Exception e) {
            e.printStackTrace();

            throw new IllegalArgumentException();
        }
        return payload;
    }
}
