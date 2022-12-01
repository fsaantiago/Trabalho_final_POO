package br.com.newchatproject.controllers;

import br.com.newchatproject.model.Signin;
import br.com.newchatproject.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class acessarContaCt {

    @FXML
    private TextField mailInput;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signinButton;

    @FXML
    private Button btnCadastrar;

    @FXML
    protected void initialize(){

        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {

            @Override
            public void onScreenChanged(String newScreen, Usuario userData) {
                if (newScreen.equals("login")) {
                    mailInput.setText("");
                    passwordField.setText("");
                }
            }
            
        });
    } 
    
    @FXML
    void btnCadastro(ActionEvent event) {
        Main.changeScreen("cadastrar", null);
    }
    
    @FXML
    protected void login(ActionEvent event) {
        if (this.mailInput.getText().isEmpty() || this.passwordField.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Error!");
            alert.setHeaderText("Informe o usuário e senha para fazer login!");
            alert.showAndWait();
        } else {
            Signin novoLogin = new Signin(this.mailInput.getText(), this.passwordField.getText());
            if (novoLogin.statusLog() == true) {
            Main.changeScreen("menu", novoLogin);
            } else {
            this.passwordField.setText(null);
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Error!");
            alert.setHeaderText("Erro ao fazer Login! \nUsuário ou senha incorretos.");
            alert.showAndWait();
            }
        }
    }

}
