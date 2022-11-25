package br.com.newchatproject.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class indexCt {


    @FXML
    private void btCadastrar(ActionEvent event) {
        Main.changeScreen("cadastro");
    }

    @FXML
    private void btAcessar(ActionEvent event) {      
        Main.changeScreen("acessarConta");
    }

}
