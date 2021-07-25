package com.shady.hidradenitis.suppurutiva.auth;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ComponentScan(basePackages = "com.shady")
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class AuthTest {
    public static final String USERNAME = "mustehssun";
    public static final String PASSWORD = "password";
    @Autowired
    private Jwt jwt;

    @Test
    public void testSign() {
        User user = new User();
        user.name = "mustehssun";
        user.password = "password";

        assert(jwt.sign(user) != null);
    }
    
    @Test
    public void testVerify() {
        User user = new User();
        user.name = "mustehssun";
        user.password = "password";

        String signedJwt = jwt.sign(user);

        assert(jwt.verify(signedJwt) == true);
        assert(jwt.verify("gibberish") == false);
    }

    @Test
    public void testDecode() {
        User user = new User();
        user.name = USERNAME;
        user.password = PASSWORD;

        String signedJwt = jwt.sign(user);

        System.out.println(jwt.decode(signedJwt));

        User decodedUser = (User) jwt.decode(signedJwt);
        assert(decodedUser.name.equals(USERNAME));
        assert(decodedUser.password.equals(PASSWORD));
    }
}
