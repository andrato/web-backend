//package com.shop.project.filter;
//
////import com.auth0.jwt.JWT;
////import com.auth0.jwt.JWTVerifier;
////import com.auth0.jwt.algorithms.Algorithm;
////import com.auth0.jwt.interfaces.DecodedJWT;
////import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
////import org.springframework.security.core.authority.SimpleGrantedAuthority;
////import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collection;
//
//import static java.util.Arrays.stream;
//import static org.springframework.http.HttpHeaders.AUTHORIZATION;
//
//public class CustomAuthorizationFilter extends OncePerRequestFilter
//{
//    @Override
//    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException
//    {
//        if(httpServletRequest.getServletPath().equals("/login"))
//        {
//            filterChain.doFilter(httpServletRequest, httpServletResponse);
//        }
//        else
//        {
//            String authorizationHandler = httpServletRequest.getHeader(AUTHORIZATION);
//
//            if(authorizationHandler != null && authorizationHandler.startsWith("Bearer "))
//            {
//                try
//                {
//                    String token = authorizationHandler.substring("Bearer ".length());
//                    Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
//                    JWTVerifier verifier = JWT.require(algorithm).build();
//                    DecodedJWT decodeJWT = verifier.verify(token);
//                    String username = decodeJWT.getSubject();
//                    String[] roles = decodeJWT.getClaim("roles").asArray(String.class);
//                    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//                    stream(roles).forEach(role -> {authorities.add(new SimpleGrantedAuthority(role));});
//
//                    UsernamePasswordAuthenticationToken authenticationToken =
//                            new UsernamePasswordAuthenticationToken(username, null, authorities);
//                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//                    filterChain.doFilter(httpServletRequest, httpServletResponse);
//
//                }
//                catch(Exception e)
//                {
//
//                }
//            }
//            else
//            {
//                filterChain.doFilter(httpServletRequest, httpServletResponse);
//            }
//        }
//
//    }
//}
