package com.shady.hidradenitis.suppurutiva.mappers;

import com.shady.hidradenitis.suppurutiva.auth.User;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class PayloadMapperTest {

    public static final String USERNAME = "mustehssun";
    public static final String PASSWORD = "fruit salad";

    @Test
    public void testMap() {
        User payload = new User();
        payload.name = "mustehssun";
        payload.password = "fruit salad";

        PayloadMapper mapper = new PayloadMapperImpl();

        Map<String, Object> map = mapper.map(payload);
        assert(map.get("name").equals(USERNAME));
        assert(map.get("password").equals(PASSWORD));
    }
}
