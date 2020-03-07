package com.merchant.flow;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if ("GET".equals(request.getMethod())){
            Map<String,String> map = new HashMap<>();
            map.entrySet().forEach(x -> {
                x.getKey();
                x.getValue();
            });

            Map<String,String> mapll  = new HashMap<>();
            for (Map.Entry<String, String> entry : mapll.entrySet()) {
                entry.getKey();
                entry.getValue();
            }

            ArrayList<String> list = new ArrayList<>();
            list.stream().forEach(x -> {
                System.out.println(list.size());
                System.out.println(list.size());
            });
            String token = UUID.randomUUID().toString();
            request.setAttribute("x-token",token);
        } else if("POST".equals(request.getMethod())){
            String headerToken = request.getHeader("x-token");
            if (StringUtils.isNotBlank(headerToken)){
                Cookie[] cookies = request.getCookies();
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("x-token") && cookie.getValue().equals(headerToken)){
                        return;
                    }
                }
            }
        }

    }
}
