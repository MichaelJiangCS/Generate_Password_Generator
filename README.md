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




- Credits: Rebecca Dady, Audre Jankowski, Michael Jiang, Zee Pearson, Kevin Wang.
