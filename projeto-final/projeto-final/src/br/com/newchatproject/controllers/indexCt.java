package br.com.newchatproject.controllers;

import br.com.newchatproject.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class indexCt {

    @FXML
    protected void initialize() {
        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {

            @Override
            public void onScreenChanged(String newScreen, Usuario userData) {

            }

        });
    }

    @FXML
    private void btCadastrar(ActionEvent event) {
        Main.changeScreen("cadastro", null);
    }

    @FXML
    private void btAcessar(ActionEvent event) {
        Main.changeScreen("acessarConta", null);
    }

}
