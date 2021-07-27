package com.shady.hidradenitis.suppurutiva.auth;

import com.shady.hidradenitis.suppurutiva.mappers.PayloadMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

class AuthTest {
    public static final String USERNAME = "mustehssun";
    public static final String PASSWORD = "password";

    @Test
    public void testSign() {
        User user = createUser(USERNAME, PASSWORD);
        Jwt jwt = getJwtWithMocks();

        assert(jwt.sign(user) != null);
    }

    @Test
    public void testVerify() {
        User user = createUser(USERNAME, PASSWORD);
        Jwt jwt = getJwtWithMocks();

        String signedJwt = jwt.sign(user);

        assert jwt.verify(signedJwt);
        assert jwt.verify("gibberish") == false;
    }

    @Test
    public void testDecode() {
        User user = createUser(USERNAME, PASSWORD);
        String signedJwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6InBhc3N3b3JkIiwibmFtZSI6Im11c3RlaHNzdW4iLCJpYXQiOjE2Mjc0MTE3NTR9.aPSxi9rluSRAuVCNTStNW4QWYNxNJ-3rE7v1oiW1MkI";

        Jwt jwt = getJwtWithMocks();

        User decodedUser = (User) jwt.decode(signedJwt);

        assert decodedUser.name.equals(USERNAME);
        assert decodedUser.password.equals(PASSWORD);
    }

    private Jwt getJwtWithMocks() {
        JwtHmac256Impl jwtImpl = new JwtHmac256Impl();
        jwtImpl.mapper = mockMapper();
        jwtImpl.SECRET = "Cream fruit chat";

        return jwtImpl;
    }

    private PayloadMapper mockMapper() {
        User user = createUser(USERNAME, PASSWORD);
        String payloadInBase64 = "{\"password\":\"password\",\"name\":\"mustehssun\",\"iat\":1627411754}";

        PayloadMapper mockedMapper = Mockito.mock(PayloadMapper.class);
        Mockito.when(mockedMapper.map(payloadInBase64, User.class)).thenReturn(user);

        Map<String, Object> mappedUser = new HashMap<>();
        mappedUser.put("name", "mustehssun");
        mappedUser.put("password", "password");
        Mockito.when(mockedMapper.map(user)).thenReturn(mappedUser);

        return mockedMapper;
    }

    private User createUser(String name, String password) {
        User user = new User();
        user.name = name;
        user.password = password;
        return user;
    }
}
