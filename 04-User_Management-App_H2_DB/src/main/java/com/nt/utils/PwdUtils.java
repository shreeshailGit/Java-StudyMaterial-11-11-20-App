package com.nt.utils;

import java.security.SecureRandom;

import org.springframework.stereotype.Component;
@Component
public class PwdUtils {

	public static String generateRandomPassword(int len)  {
        // ASCII range - alphanumeric (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
 
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
         // each iteration of loop choose a character randomly from the given ASCII range
        // and append it to StringBuilder instance
         for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
         return sb.toString();
    }
}//class
