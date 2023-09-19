module com.example.generate_password_generator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.generate_password_generator to javafx.fxml;
    exports com.example.generate_password_generator;
}