package br.com.newchatproject.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class cadastroCt {

    @FXML
    private TextField mailInput;

    @FXML
    private TextField nameInput;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signinButton;

    @FXML
    private Button signupButton;

    @FXML
    private Label subtitleLabel;

    @FXML
    private Label titleLabel;

    @FXML
    protected void initialize(){
        Main.addOnChangeScreen(new Main.OnChangeScreen() {

            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                System.out.println("nova tela: "+newScreen+","+userData);
            }
            
        });
    } 

    @FXML
    protected void btnovo(ActionEvent event) {
        System.out.println("você clicou");

        Main.changeScreen("index");

    }

}
