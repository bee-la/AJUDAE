package com.app.armetech.ajudae;

/**
 * Created by user on 10/12/2017.
 */

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public final class Criptografia{
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static String encryptPassword(String password){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes(StandardCharsets.UTF_8));
            byte[] encryptPassword = md.digest();
            System.out.print(encryptPassword[0]);
            System.out.println(" " + encryptPassword[1]);
            StringBuilder sb = new StringBuilder();
            for (byte caractere : encryptPassword) {
                sb.append(String.format("%02X", caractere));
            }

            return sb.toString();

        }catch(NoSuchAlgorithmException e){
            return null;
        }
    }

    public static boolean validatePassword(String password1, String password2){
        return password1.equals(password2);
    }




}

