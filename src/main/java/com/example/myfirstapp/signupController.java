package com.example.myfirstapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class signupController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button signupButton;

    @FXML
    private CheckBox signupCheckBoxFemale;

    @FXML
    private CheckBox signupCheckBoxMale;

    @FXML
    private TextField signupCountry;

    @FXML
    private TextField signupLastName;

    @FXML
    private TextField signupLogin;

    @FXML
    private TextField signupName;

    @FXML
    private PasswordField signupPassword;

    @FXML
    void initialize() {

        signupButton.setOnAction(event ->{
            
            signupNewUser();


        });

    }

    private void signupNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String firstname = signupName.getText();
        String lastname = signupLastName.getText();
        String login = signupLogin.getText();
        String password = signupPassword.getText();
        String country = signupCountry.getText();
        String gender = "";
        if(signupCheckBoxFemale.isSelected())
            gender = "Женский";
        else
            gender = "Мужской";

        User user = new User(firstname, lastname, login, password, country, gender);

        dbHandler.signUpUser(user);
    }

}

