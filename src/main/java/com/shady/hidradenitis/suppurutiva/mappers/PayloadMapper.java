package com.shady.hidradenitis.suppurutiva.mappers;

import com.shady.hidradenitis.suppurutiva.auth.Payload;

import java.util.Map;

public interface PayloadMapper {
    Map<String, Object> map(Payload payload);
    Payload map(String base64EncodedPayload);
}
