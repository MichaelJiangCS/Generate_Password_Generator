package com.example.generate_password_generator;

import java.security.SecureRandom;


public class PasswordGenerator {
    // character pools: upper & lower characters, nums and special symbols
    public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "012345679";
    public static final String SPECIAL_SYMBOLS = "!@#$%^&*()-_=+[]{};:,.<>/?";

    // Creates a new random number generator
    private final SecureRandom random;

    // Ctor
    public PasswordGenerator(){
        random = new SecureRandom();
    }


    public String generatePassword (int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers,
                                    boolean includeSpecialSymbols){

        StringBuilder password = new StringBuilder();

        // Store valid characters based on user's toggle
        String validCharacters = "";
        if(includeUppercase) validCharacters += UPPERCASE_CHARACTERS;
        if(includeLowercase) validCharacters += LOWERCASE_CHARACTERS;
        if(includeNumbers) validCharacters += NUMBERS;
        if(includeSpecialSymbols) validCharacters += SPECIAL_SYMBOLS;

        // build password
        for(int i = 0; i < length; i++) {
            // get a random index
            int randomIndex = random.nextInt(validCharacters.length());

            // get char at that index
            char randomChar = validCharacters.charAt(randomIndex);

            // append char to build password
            password.append(randomChar);
        }

        return password.toString();
    }




}//end PasswordGenerator
