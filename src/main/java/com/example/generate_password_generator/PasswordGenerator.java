package com.example.generate_password_generator;

import java.security.SecureRandom;

import javafx.scene.transform.Scale;


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
                                    boolean includeSpecialSymbols, String SecretWord, String valueChoiceBox){

        StringBuilder password = new StringBuilder();

        boolean isChoiceSelected = (valueChoiceBox.equals("")) ? false : true;

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

        if(isChoiceSelected==true){
            if(valueChoiceBox.equals("Beginning")){
                //
                return password.substring(0,0) + SecretWord + password.substring(0); // append at the beginning of the string
            } else if (valueChoiceBox.equals("Middle")){
                //
                int findMiddleIndex = length/2;
                return password.substring(0,findMiddleIndex) + SecretWord + password.substring(findMiddleIndex); // append at the middle of the string
            } else {
                //
                password.append(SecretWord); // append it to the end
            }
        }

        return password.toString();
    }




}//end PasswordGenerator