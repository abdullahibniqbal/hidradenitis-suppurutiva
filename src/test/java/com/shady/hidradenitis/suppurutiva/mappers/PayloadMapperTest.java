package com.shady.hidradenitis.suppurutiva.mappers;

import com.shady.hidradenitis.suppurutiva.auth.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class PayloadMapperTest {

    public static final String USERNAME = "mustehssun";
    public static final String PASSWORD = "fruit salad";

    @Autowired
    private PayloadMapper mapper;

    @Test
    public void testPayloadToMap() {
        User payload = new User();
        payload.name = USERNAME;
        payload.password = PASSWORD;

        Map<String, Object> map = mapper.map(payload);
        assert(map.get("name").equals(USERNAME));
        assert(map.get("password").equals(PASSWORD));
    }

    @Test
    public void testMapToPayload() {
        String base64EncodedPayload = "{\"password\":\"fruit salad\",\"name\":\"mustehssun\",\"iat\":\"1516239022\"}";

        User mappedUser = (User) mapper.map(base64EncodedPayload, User.class);
        assert(mappedUser.name.equals(USERNAME));
        assert(mappedUser.password.equals(PASSWORD));
    }
}
