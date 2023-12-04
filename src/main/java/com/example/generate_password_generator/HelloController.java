package com.example.generate_password_generator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;



public class HelloController {
    
    private PasswordGenerator passwordGenerator = new PasswordGenerator();
    final Font DOGICA_PIXEL_BOLD_LOAD_FLIE = Font.loadFont(getClass().getResourceAsStream("fonts/dogicapixelbold.ttf"), 8);
    final Font PIXELLAND_LOAD_FLIE = Font.loadFont(getClass().getResourceAsStream("fonts/Pixeland.ttf"),56);



    @FXML
    private AnchorPane titleText;

    // TextAreas
    @FXML
    private TextArea passwordOutput;
    @FXML
    private TextArea lengthInput;
    @FXML
    private TextArea secretWord;

    // Labels
    @FXML
    private Label choiceLabel;
    @FXML 
    private Label labelForUserInputLength;
    @FXML
    private Label HeaderFont;

    // Buttons
    @FXML
    private Button generateButton;
    @FXML
    private Button resetButton;

    // ChoiceBox
    @FXML
    private ChoiceBox<String> wordChoicePlacement;

    // CheckBox
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

        uppercaseToggle.setFont(DOGICA_PIXEL_BOLD_LOAD_FLIE);
        lowercaseToggle.setFont(DOGICA_PIXEL_BOLD_LOAD_FLIE);
        symbolsToggle.setFont(DOGICA_PIXEL_BOLD_LOAD_FLIE);
        numbersToggle.setFont(DOGICA_PIXEL_BOLD_LOAD_FLIE);
        generateButton.setFont(DOGICA_PIXEL_BOLD_LOAD_FLIE);
        resetButton.setFont(DOGICA_PIXEL_BOLD_LOAD_FLIE);

        choiceLabel.setFont(DOGICA_PIXEL_BOLD_LOAD_FLIE);
        labelForUserInputLength.setFont(DOGICA_PIXEL_BOLD_LOAD_FLIE);
        HeaderFont.setFont(PIXELLAND_LOAD_FLIE);

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

    @FXML
    public void resetButtonClick(ActionEvent actionEvent){
        lengthInput.setText("");
        passwordOutput.setText("");
        secretWord.setText("");
        wordChoicePlacement.setValue("");
        uppercaseToggle.setSelected(false);
        lowercaseToggle.setSelected(false);
        numbersToggle.setSelected(false);
        symbolsToggle.setSelected(false);
        symbolsToggle.setSelected(false);
    }
}