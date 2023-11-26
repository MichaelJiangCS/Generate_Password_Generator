# Secret Password - CIS-1512 Fall23

## Environment Setup
1. Visit the official [Oracle website](https://www.oracle.com/java/technologies/downloads/) and download the latest version of the JDK that matches your operating system.<br>
2. Download and install a preferred [JavaIDE](https://www.turing.com/blog/best-java-ides-and-editors/ "A list of javaIDE").<br>
3. Save this repository in a local directory, open it with JavaIDE and run the *HelloApplication.java* file.<br>

## Project Description
Our randomly generated password program will help users create strong passwords which protect users from unauthorized attempts to view private information. Users will be given options for the length and strength of their new password. As we continue to work and build on this project, in the future, we plan to add the ability to create an account and store passwords that have been created. Below are some key features of the random password generator: <br>
- random password generation
- password length customization
- password strength customization

## Code Explanation
```java
    public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";
    public static final String SPECIAL_SYMBOLS = "!@#$%^&*()-_=+[]{};:,.<>/?";
```
This block of code allows us to set up a character pool of the radom password generator. The pool contains lowercase character, uppercase character, numbers and special symbols.<br>

```java
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
```
The code above is the main logic of generating a password. The user is able to decide the strength of the passwrod, which is to checkbox if uppercase letter, lowercase letter, numbers or symbols should appear in the password. Then the program will generate the password accordingly based on the length input. There is also a secret word feature where it allows user to insert a word in the beginning/middle/end of the generated password.<br>

```java
    @FXML
    public void generateButtonClicked(ActionEvent actionEvent) {
        // call generatePassword() method when this button is clicked
        boolean anyToggleSelected = uppercaseToggle.isSelected() || lowercaseToggle.isSelected() || numbersToggle.isSelected()
                || symbolsToggle.isSelected();

        // convert user input into an int
        int passwordLength = Integer.parseInt(lengthInput.getText());

        // convert user word input to a String
        String SecretWordInput = (secretWord.getText().equals("")) ? "" : secretWord.getText();




        // length must be greater than 0
        if(passwordLength <= 0){
            return;
        }

        if (anyToggleSelected){
            // generate a password using length and toggles provided by user
            String generatedPassword = passwordGenerator.generatePassword(passwordLength,
                    uppercaseToggle.isSelected(),
                    lowercaseToggle.isSelected(),
                    numbersToggle.isSelected(),
                    symbolsToggle.isSelected(),
                    SecretWordInput,
                    wordChoicePlacement.getValue());

            // output generated password
            passwordOutput.setText(generatedPassword);
        }

    }
```
The code above is a method for the 'generate' button on click event. When the 'generate' button is clicked, the program will check if any of the options are toggled and if there's a secret word is input. It will also check if the length input is greater than 0. If it's less than 0, the program will not generate a password. If it's greater than 0, the program will generate a password based on the length and strength input.

```java
public void initialize(){
        passwordOutput.setEditable(false);
        secretWord.setText("");
        wordChoicePlacement.getItems().addAll("Beginning", "Middle", "End");
        wordChoicePlacement.setValue("");

        lengthInput.setWrapText(true);

        // Create a TextFormatter with a filter that allows only numeric input
        TextFormatter<Object> textFormatter = new TextFormatter<>(change -> {
            if (change.getText().matches("[0-9]*")) {
                return change; // Accept the change
            } else {
                return null; // Reject the change
            }
        });

        // Apply the TextFormatter to the TextArea
        lengthInput.setTextFormatter(textFormatter);
    }
```
This code sets the initiallization of the program. When the program runs, user is not supposed to input anyting in the output text area. The secret word text area should be empty at the beginning. In addition, user is only allowed to input integers in the length text area.<br>

## Contributors

- Rebecca Dady
- Audre Jankowski
- Michael Jiang
- Zee Pearson
- Kevin Wang
