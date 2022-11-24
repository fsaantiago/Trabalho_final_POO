package br.com.newchatproject.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class signupController {

    @FXML
    private TextField mailInput;

    @FXML
    private TextField nameInput;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signupButton;

    @FXML 
    public void btnovo(ActionEvent e){
        System.out.println("bt novo");
    }

    @FXML
    private Label subtitleLabel;

    @FXML
    private Label titleLabel;


}
