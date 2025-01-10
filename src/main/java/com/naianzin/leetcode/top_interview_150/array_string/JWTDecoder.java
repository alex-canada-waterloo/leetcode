package com.naianzin.leetcode.top_interview_150.array_string;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTDecoder {

    public static void main(String[] args) {




        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJIWFEyT2xiZ3FUZ2s5YWJ4T2dXZ1ZnPT0iLCJleHAiOjE3MjM1ODkyMjB9.7V5q346ifIS6nAvo8UVUEIxTsuPXkus5FxsCw3f_Tto";

        // Decode the token
        DecodedJWT decodedJWT = JWT.decode(token);

        // Print out the header, payload, and signature
        System.out.println("Header: " + decodedJWT.getHeader());
        System.out.println("Payload: " + decodedJWT.getPayload());
        System.out.println("Signature: " + decodedJWT.getSignature());

        // Access specific claims from the payload
        String issuer = decodedJWT.getIssuer();
        String subject = decodedJWT.getSubject();
        System.out.println("Issuer: " + issuer);
        System.out.println("Subject: " + subject);
    }

}
