package com.animal.java.utils;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ValueUtils {

    public static String host = "http://localhost:8080";
    public static String authUrl = "/api/v1/auth/accountVerification/";
}
