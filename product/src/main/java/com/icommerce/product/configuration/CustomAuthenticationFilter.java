package com.icommerce.product.configuration;

import com.icommerce.product.core.shared.CommonUtils;
import com.icommerce.product.core.shared.LocalProfile;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class CustomAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        final String username = request.getHeader("userId");
        if (!CommonUtils.isNullOrEmpty(username)) {
            final SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_CUSTOMER");
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username,
                    "", Arrays.asList(authority));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            LocalProfile.setUserId(username);
        }
        filterChain.doFilter(request, response);
    }
}
