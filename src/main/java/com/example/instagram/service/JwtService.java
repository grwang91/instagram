package com.example.instagram.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public <T> String create(T data) {
        String jws = Jwts.builder()
                .claim("userName", data)
                .setExpiration(new Date(System.currentTimeMillis() + 1 *(1000 * 60 * 60* 24)))
                .signWith(key)
                .compact();
        return jws;
    }

    //token이 조작 됐는지 확인하는 과정
    public boolean valid(String jws) {
        try{
            Date expiration = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jws)
                    .getBody()
                    .getExpiration();
            Date now = new Date();
            if(now.after(expiration)) {
                return false;
            }
            return true;
        } catch(Exception e) {
            return false;
        }
    }

}
