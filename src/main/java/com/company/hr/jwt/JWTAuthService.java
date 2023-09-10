package com.company.hr.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;
import java.util.UUID;

public final class JWTAuthService {

  public static final String ISSUER = "COM-HR-SERVICE";
  public static final String SUBJECT = "JWT token for accessing COM HR API.";
  public static final String APP_NAME_CLAIM = "appName";
  public static final String PERMISSION_LEVEL_CLAIM = "permissionLevel";

  private Algorithm algorithm;
  private JWTVerifier jwtVerifier;

  public JWTAuthService(byte[] secret) {

    initializeJWT(secret);
  }

  public JWTAuthService(String file) throws IOException {

    byte[] secret;
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      secret = reader.readLine().getBytes();
    }

    initializeJWT(secret);
  }

  private void initializeJWT(byte[] secret) {

    this.algorithm = Algorithm.HMAC512(secret);
    this.jwtVerifier = JWT.require(this.algorithm)
        .withIssuer(ISSUER)
        .withClaimPresence(APP_NAME_CLAIM)
        .withClaimPresence(PERMISSION_LEVEL_CLAIM)
        .build();
    Arrays.fill(secret, (byte) 0);
  }

  public String createToken(String appName, int permissionLevel) {

    return JWT.create()
        .withIssuer(ISSUER)
        .withSubject(SUBJECT)
        .withClaim(APP_NAME_CLAIM, appName)
        .withClaim(PERMISSION_LEVEL_CLAIM, permissionLevel)
        .withIssuedAt(Instant.now())
        .withJWTId(UUID.randomUUID().toString())
        .sign(this.algorithm);
  }

  public DecodedJWT validate(String jwtToken) {

    return this.jwtVerifier.verify(jwtToken);
  }
}