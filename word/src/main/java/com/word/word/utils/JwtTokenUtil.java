package com.word.word.utils;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.word.word.entity.commons.TokenEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenUtil implements Serializable {
  public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

  @Value("${jwt.secret}")
  private String secret;

  public String getUsernameFromToken(String token) {
    return getClaimFromToken(token, Claims::getSubject);
  }

  public Date getExpirationDateFromToken(String token) {
    return getClaimFromToken(token, Claims::getExpiration);
  }

  public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = getAllClaimsFromToken(token);
    return claimsResolver.apply(claims);
  }

  @SuppressWarnings("deprecation")
  private Claims getAllClaimsFromToken(String token) {
    SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
    return Jwts.parser()
        .verifyWith(key)
        .build()
        .parseClaimsJws(token)
        .getBody();
  }

  public Boolean isTokenExpired(String token) {
    final Date expiration = getExpirationDateFromToken(token);
    return expiration.before(new Date());
  }

  public TokenEntity generateToken(UserDetails userDetails) {
    Map<String, Object> claims = new HashMap<>();
    claims.put("role", "admin");
    return doGenerateToken(claims, userDetails.getUsername());
  }

  private TokenEntity doGenerateToken(Map<String, Object> claims, String subject) {
    long timestamp = System.currentTimeMillis();
    Date currentDate = new Date(timestamp);
    Date expireDate = new Date(timestamp + JWT_TOKEN_VALIDITY * 1000);
    SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
    String token = Jwts.builder().claims(claims)
        .subject(subject)
        .issuedAt(currentDate)
        .expiration(expireDate)
        .signWith(key, Jwts.SIG.HS512)
        .compact();
    return new TokenEntity(token, expireDate);
  }

  public Boolean validateToken(String token, UserDetails userDetails) {
    final String username = getUsernameFromToken(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
  }
}
