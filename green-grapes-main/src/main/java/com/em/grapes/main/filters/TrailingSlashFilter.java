package com.em.grapes.main.filters;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

//@Component
public class TrailingSlashFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Modify the request URL to remove trailing slashes
        String requestURI = request.getServerName() + ((HttpServletRequest) request).getRequestURI().replaceAll("/+$", "");
        
        // Create a new request wrapper with the modified URL
        ModifiedRequestWrapper modifiedRequest = new ModifiedRequestWrapper((HttpServletRequest) request, requestURI);
        
        // Continue the filter chain with the modified request
        chain.doFilter(modifiedRequest, response);
    }

    // Other methods of the Filter interface (init, destroy) can be left empty.

    // You may need to create a custom request wrapper to modify the request URI.
    private static class ModifiedRequestWrapper extends HttpServletRequestWrapper {

        private final String modifiedRequestURI;

        public ModifiedRequestWrapper(HttpServletRequest request, String modifiedRequestURI) {
            super(request);
            this.modifiedRequestURI = modifiedRequestURI;
        }

        @Override
        public String getRequestURI() {
            return modifiedRequestURI;
        }
    }
}
