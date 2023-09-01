package com.company.hr.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Date;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;

public final class JWTAuthService {

  private static final String ISSUER = "COM-HR";
  private static final String SUBJECT = "JWT token for accessing COM HR API.";
  private static final String APP_NAME_CLAIM = "appName";
  private static final String ORG_NAME_CLAIM = "orgName";

  private final Algorithm algorithm;
  private final JWTVerifier jwtVerifier;

  public JWTAuthService(String secret) {

    this.algorithm = Algorithm.HMAC256(secret);
    this.jwtVerifier = JWT.require(this.algorithm)
        .withIssuer(ISSUER)
        .withClaimPresence(ORG_NAME_CLAIM)
        .withClaimPresence(APP_NAME_CLAIM)
        .build();
  }

  public String createToken(String orgName, String appName) {

    if (StringUtils.isBlank(orgName))
      throw new IllegalArgumentException("Parameter 'orgName' must not be null, empty, or blank.");
    if (StringUtils.isBlank(appName))
      throw new IllegalArgumentException("Parameter 'appName' must not be null, empty, or blank.");

    return JWT.create()
        .withIssuer(ISSUER)
        .withSubject(SUBJECT)
        .withClaim(ORG_NAME_CLAIM, orgName)
        .withClaim(APP_NAME_CLAIM, appName)
        .withIssuedAt(new Date())
        .withJWTId(UUID.randomUUID().toString())
        .sign(this.algorithm);
  }

  public void validate(String jwtToken, String orgName, String appName) {

    DecodedJWT decodedJWT = this.jwtVerifier.verify(jwtToken);

    Claim orgNameClaim = decodedJWT.getClaim(ORG_NAME_CLAIM);
    if (!StringUtils.equals(orgNameClaim.asString(), orgName)) {
      throw new JWTVerificationException("The parameter '" + orgName + "' is not a valid organization name.");
    }

    Claim appNameClaim = decodedJWT.getClaim(APP_NAME_CLAIM);
    if (!StringUtils.equals(appNameClaim.asString(), appName)) {
      throw new JWTVerificationException("The parameter '" + appName + "' is not a valid application name.");
    }
  }
}