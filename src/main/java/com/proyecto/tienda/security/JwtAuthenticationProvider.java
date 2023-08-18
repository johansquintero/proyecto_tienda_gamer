package com.proyecto.tienda.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.proyecto.tienda.domain.pojo.cliente.ClientePojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Clase encargada de la creacion y validacion de jwt para el inicio de sesion de un Usuario
 * Se asigna como un componente de spring
 */
@Component
public class JwtAuthenticationProvider {
    /**
     * llave privada para cifrar el token
     */
    @Value("${jwt.secret.key}")
    private String secretKey;

    /**
     * Lista blanca de los tokens creados
     */
    private HashMap<String, ClientePojo> listToken = new HashMap<>();


    /**
     * Crea un nuevo jwt en base al cliente recibido por parametro y lo agrega a la lista blanca
     * @param clientePojo Cliente a utilizar en la creacion del jwt
     * @return Jwt creado
     */
    public String createToken(ClientePojo clientePojo){
        Date now = new Date();
        Date validity = new Date(now.getTime()+36000000);
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        String tokenCreated = JWT.create()
                .withClaim("id",clientePojo.getId())
                .withClaim("username",clientePojo.getUsername())
                .withClaim("email",clientePojo.getEmail())
                .withClaim("telephone",clientePojo.getTelephone())
                .withClaim("role",clientePojo.getRole())
                .withClaim("address",clientePojo.getAddress())
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .sign(algorithm);
        this.listToken.put(tokenCreated,clientePojo);
        return tokenCreated;
    }
    /**
     * Valida si el token es valido y retorna una sesión del usuario
     * @param token Token a validar
     * @return Sesion del usuario
     * @throws CredentialsExpiredException Si el token ya expiró
     * @throws BadCredentialsException Si el token no existe en la lista blanca
     */
    public Authentication validateToken(String token) throws AuthenticationException {
        JWT.require(Algorithm.HMAC256(this.secretKey)).build().verify(token);
        ClientePojo exists = this.listToken.get(token);
        if (exists==null){
            throw new BadCredentialsException("Usuario no registrado");
        }
        HashSet<SimpleGrantedAuthority> rolesAuthorities = new HashSet<>();
        rolesAuthorities.add(new SimpleGrantedAuthority("ROLE_"+exists.getRole()));
        return new UsernamePasswordAuthenticationToken(exists, token, rolesAuthorities);
    }

    public String deleteToken(String jwt){
        if (!listToken.containsKey(jwt)){
            return "El token no existe";
        }
        listToken.remove(jwt);
        return "token eliminado";
    }
}
