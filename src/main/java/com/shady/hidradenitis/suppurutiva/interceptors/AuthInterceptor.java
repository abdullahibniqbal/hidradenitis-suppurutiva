package com.shady.hidradenitis.suppurutiva.interceptors;

import com.shady.hidradenitis.suppurutiva.auth.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    private Jwt jwt;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String jwtRequest = request.getParameter("jwt");
        if(jwt.verify(jwtRequest)) {
            request.setAttribute("user", jwt.decode(jwtRequest));

            return true;
        }
        else {
            System.out.println("Logout TODO...");   //TODO

            return false;
        }
    }
}
