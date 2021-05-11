package com.mediscreen.ui.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class RequestInterceptor implements Filter {

    Logger LOGGER = LogManager.getLogger(RequestInterceptor.class);

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        try {
            LOGGER.info("Request -> path: " + req.getRequestURI() + ", method: " + req.getMethod() + ", body " + req.getQueryString());
            chain.doFilter(request, response);
        } finally {
            LOGGER.info("Response -> path: " + req.getRequestURI() + ", method: " + req.getMethod() + ", body " + req.getQueryString());
        }
    }
}
