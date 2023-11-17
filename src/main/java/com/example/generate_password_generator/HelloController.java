package com.example.generate_password_generator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
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
    private TextArea secretWord;

    // Buttons
    @FXML
    private Button generateButton;
    @FXML
    private Button resetButton;

    // Slider
    @FXML
    private ChoiceBox<String> wordChoicePlacement;

    // ToggleButtons
    @FXML
    private CheckBox uppercaseToggle;
    @FXML
    private CheckBox lowercaseToggle;
    @FXML
    private CheckBox symbolsToggle;
    @FXML
    private CheckBox numbersToggle;


    // not allowing user to edit the output textArea
    public void initialize(){
        passwordOutput.setEditable(false);
        secretWord.setText("");
        wordChoicePlacement.getItems().addAll("Beginning", "Middle", "End");
        wordChoicePlacement.setValue("");
    }

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
                    symbolsToggle.isSelected(),
                    SecretWordInput,
                    wordChoicePlacement.getValue());

            // output generated password
            passwordOutput.setText(generatedPassword);
        }

    }

    @FXML
    public void resetButtonClick(ActionEvent actionEvent){
        lengthInput.setText("");
        passwordOutput.setText("");
        secretWord.setText("");
        uppercaseToggle.setSelected(false);
        lowercaseToggle.setSelected(false);
        numbersToggle.setSelected(false);
        symbolsToggle.setSelected(false);
        symbolsToggle.setSelected(false);
    }
}