package com.chainsys.bug.controller;
import java.security.SecureRandom;
import java.util.Random;
 public class PasswordGenerator {
	    private static final Random RANDOM = new SecureRandom();
	    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	    public static void main(String[] args) {
	        int passwordLength = 10;
	        String password = generatePassword(passwordLength);
	        System.out.println("Secure password: " + password);
	    }
	    public static String generatePassword(int length) {
	        StringBuilder returnValue = new StringBuilder(length);
	        for (int i = 0; i < length; i++) {
	            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
	        }
	        return new String(returnValue);
	    }
	}

