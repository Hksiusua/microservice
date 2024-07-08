package com.example.user.service.impl;

import com.example.user.dto.request.AuthenticationRequest;
import com.example.user.dto.request.IntrospectRequest;
import com.example.user.dto.response.AuthenticationResponse;
import com.example.user.dto.response.IntrospectResponse;
import com.example.user.entity.UsersE;
import com.example.user.mapper.UsersMapper;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.StringJoiner;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationService {
    @Autowired
    private UsersMapper usersMapper;
//    protected static final String SIGNER_KEY = "IAssKX4DKjNIvHfKU9ZbV7ZAFVkCFcLU35BP3qtOcWzwqrVl/JZ8p/Q48+caVJKT";


    @Value("${signer.key}")
    private String SIGNER_KEY;
    public IntrospectResponse introspect(IntrospectRequest introspectRequest) throws JOSEException, ParseException {
        var token = introspectRequest.getToken();
        JWSVerifier jwsVerifier = new MACVerifier(SIGNER_KEY.getBytes());
        SignedJWT signature = SignedJWT.parse(token);
        Date expiryTime = signature.getJWTClaimsSet().getExpirationTime();
        var verified = signature.verify(jwsVerifier);
        return IntrospectResponse.builder()
                .valid(verified && expiryTime.after(new Date()))
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) throws JOSEException {
        var user = usersMapper.getUserLogin(authenticationRequest.getUsername());
        log.debug("User roles from database: {}", user.getRoles()); // Thêm dòng log này
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        boolean authenticated = passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword());
        if (!authenticated) {
            throw new RuntimeException("Sai tên đăng nhập hoặc mật khẩu");
        }
        var token = generateToken(user);
        return AuthenticationResponse.builder()
                .token(token)
                .authenticated(true)
                .build();
    }


    public String generateToken(UsersE user) throws JOSEException, KeyLengthException {
        // Create the header
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        // Create the claims
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(user.getUsername())
                .issuer("khoihai.com")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
                ))
                .claim("userId", user.getUserId())
                .claim("roles",user.getRoles())
                .claim("roleName", user.getRole_name())
                .build();
        Payload payload = new Payload(claimsSet.toJSONObject());
        JWSObject jwsObject = new JWSObject(header, payload);

        // ki token
        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (Exception e) {
            log.error("Cannot craete token");
            throw new RuntimeException(e);
        }
    }
//    private String buildScope(UsersE usersE){
//        StringJoiner stringJoiner =new StringJoiner(" ");
//        if(CollectionUtils.isEmpty(usersE.getRoles())){
//            usersE.getRoles()
//        }
//    }
}
