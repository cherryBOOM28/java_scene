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
    private PasswordField signupLastName;

    @FXML
    private TextField signupLogin;

    @FXML
    private TextField signupName;

    @FXML
    private PasswordField signupPassword;

    @FXML
    void initialize() {

    }

}

