package com.smart.parking.client.secuirity;

import com.smart.parking.client.entity.Auth;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTUtil {
    @Value("${jwt.secret.token}")
    private String secretKeyToken;

    public String generateToken(Auth userDetails , String type) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("username", userDetails.getUsername());
        claims.put("avatar", userDetails.getAvatar());
        claims.put("nickname", userDetails.getNickname());
        claims.put("firstname", userDetails.getFirstName());
        claims.put("lastname", userDetails.getLastName());
        return generateToken(claims, userDetails , type);
    }
    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails,
            String type
    ) {
        return buildToken(extraClaims, userDetails , type);
    }
    private String buildToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails,
            String type
    ) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(
                        Date.from(
                               type.equals("ACCESS-TOKEN") ? Instant.now().plus(5, ChronoUnit.DAYS) : Instant.now().plus(10, ChronoUnit.DAYS)
                        )
                )
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKeyToken);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    public  String extractUsername(String token){
        return extractClaims(token ,Claims::getSubject);
    }
    public <T> T extractClaims(String token , Function<Claims,T>claimsTFunction){
        final Claims claims =extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }


}
