package org.orgw.simples.core.util;


import java.util.Random;

public final class CryptUtil {


    public static String generateNumericToken(int digits) {
        final String R = "0123456789";
        String np = "";
        Random random = new Random();

        for (int i = 0; i < digits; i++) {
            int x = Math.abs(random.nextInt(R.length() - 1));
            np = np + R.substring(x, x + 1);
        }
        return np;
    }
}
