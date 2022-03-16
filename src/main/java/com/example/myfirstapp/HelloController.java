package com.example.myfirstapp;

import com.example.myfirstapp.animations.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button authSignInButton;

    @FXML
    private Button loginSignUpButton;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    public HelloController() {
    }

    @FXML
    void initialize() {

        authSignInButton.setOnAction(event -> {
            String loginText = login_field.getText().trim();
            String loginPassword = password_field.getText().trim();

            if(!loginText.equals("") && !loginPassword.equals("")) {
                loginUser(loginText, loginPassword);
            } else
                System.out.println("Login and Password is empty!");


        });


        loginSignUpButton.setOnAction(event ->  {
            openNewWindow("signUp.fxml");

//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource());
        });
    }

    private void loginUser(String loginText, String loginPassword) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setFirstname(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;

        while(true) {
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;
        }
        if(counter >= 1) {
            openNewWindow("secondWindow.fxml");

        }
        else {
            Shake userLoginAnim = new Shake(login_field);
            Shake userUserPassAnim = new Shake(password_field);
            userLoginAnim.playAnim();
            userUserPassAnim.playAnim();
        }
    }
    public void openNewWindow(String window) {
        loginSignUpButton.getScene().getWindow().hide();

//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource());
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();

    }

}
