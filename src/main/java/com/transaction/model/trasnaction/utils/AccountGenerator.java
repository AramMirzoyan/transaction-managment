package com.transaction.model.trasnaction.utils;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AccountGenerator {
    private static final String NUMBER = "0123456789";
    private static final String ACCOUNT_ALLOW_BASE_SHUFFLE = shuffleString(NUMBER);
    private static final String ACCOUNT_ALLOW = ACCOUNT_ALLOW_BASE_SHUFFLE;

    private static SecureRandom random = new SecureRandom();


    public static String generateRandomAccount(int length) {
        if (length < 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {

            int rndCharAt = random.nextInt(ACCOUNT_ALLOW.length());
            char rndChar = ACCOUNT_ALLOW.charAt(rndCharAt);

            sb.append(rndChar);
        }
        return sb.toString();
    }
    public static String shuffleString(String string) {
        List<String> letters = Arrays.asList(string.split(""));
        Collections.shuffle(letters);
        return letters.stream().collect(Collectors.joining());
    }
}
