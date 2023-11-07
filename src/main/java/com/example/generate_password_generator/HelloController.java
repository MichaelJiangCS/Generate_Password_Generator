package com.example.generate_password_generator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;

public class HelloController {
    private PasswordGenerator passwordGenerator = new PasswordGenerator();

    @FXML
    private AnchorPane titleText;

    @FXML
    private TextArea passwordOutput;
    @FXML
    private TextArea lengthInput;
    @FXML
    private Button generateButton;
    @FXML
    private ToggleButton uppercaseToggle;
    @FXML
    private ToggleButton lowercaseToggle;
    @FXML
    private ToggleButton symbolsToggle;
    @FXML
    private ToggleButton numbersToggle;


    // not allowing user to edit the output textArea
    public void initialize(){
        passwordOutput.setEditable(false);
    }

    @FXML
    public void generateButtonClicked(ActionEvent actionEvent) {
        // call generatePassword() method when this button is clicked
        boolean anyToggleSelected = uppercaseToggle.isSelected() || lowercaseToggle.isSelected() || numbersToggle.isSelected()
                || symbolsToggle.isSelected();

        // convert user input into an int
        int passwordLength = Integer.parseInt(lengthInput.getText());

        // length must be greater than 0
        if(passwordLength <= 0){
            // disable Generate button
            generateButton.setDisable(true);
            return;
        }

        if (anyToggleSelected){
            // generate a password using length and toggles provided by user
            String generatedPassword = passwordGenerator.generatePassword(passwordLength,
                    uppercaseToggle.isSelected(),
                    lowercaseToggle.isSelected(),
                    numbersToggle.isSelected(),
                    symbolsToggle.isSelected());

            // output generated password
            passwordOutput.setText(generatedPassword);
        }

    }
}