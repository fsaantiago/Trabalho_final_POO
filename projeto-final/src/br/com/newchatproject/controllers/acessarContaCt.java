package br.com.newchatproject.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class acessarContaCt {
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
    protected void btEntrar(ActionEvent event) {
        System.out.println("você clicou");

        Main.changeScreen("index");

    }
}
