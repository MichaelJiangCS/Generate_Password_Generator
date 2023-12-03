package com.example.generate_password_generator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.InputStream;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /**
         * file:resources/fonts/Pixeland.ttf
         */
        // if(Font.loadFont(getClass().getResourceAsStream("file:resources/fonts/dogicapixelbold.ttf"), 11) == null) {
        //     System.out.println("Failed");
        // } else {
        //     System.out.println("Should work");
        // }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Secret Password");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);

    }

    public static void main(String[] args) {
        launch();
    }
}