package com.proyecto.tienda.security;

import com.proyecto.tienda.exception.Security.UnauthorizedException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Filtro que valida si la peticion tiene la cabezera de Autorizacion
 */
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    /**
     * Lista blanca de URIS o EndPoints
     */
    private List<String> urlsToSkip = List.of("/auth", "/swagger-ui.html", "/swagger-ui", "/api-docs","/api/productos/uploads/img/","/images/");

    /**
     * Verifica si a la URI no se le debe aplicar el filtro
     * @param request current HTTP request Petición a validar
     * @return True si la URI existe en la lista blanca,de lo contrario retorna false
     * @throws ServletException
     */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return urlsToSkip.stream().anyMatch(url -> request.getRequestURI().contains(url));
    }

    /**
     * Valida si la petición contiene la cabezera de authorization con el bearer token
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     * @throws UnauthorizedException - Si no tiene la cabezera HttpHeaders.AUTHORIZATION
     *                               - Si tiene más de dos elementos en al cabezera o no tiene 'Bearer'
     *                               - Si el token no es valido
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (header==null){
            throw new UnauthorizedException();
        }
        String[] authElements = header.split(" ");
        /**
         * Busca el Bearer y el token
         */
        if (authElements.length != 2 || !"Bearer".equals(authElements[0])) {
            throw new UnauthorizedException();
        }
        try {
            Authentication auth = jwtAuthenticationProvider.validateToken(authElements[1]);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }catch (RuntimeException e){
            SecurityContextHolder.clearContext();
            throw new RemoteException();
        }
        filterChain.doFilter(request,response);
    }
}
