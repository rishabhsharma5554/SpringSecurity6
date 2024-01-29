package com.rishabh.basicauthentication_01.configuration;

import jakarta.servlet.*;

import java.io.IOException;

public class MyCustomFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Before");
        chain.doFilter(request,response);
        System.out.println("After");

    }
}
