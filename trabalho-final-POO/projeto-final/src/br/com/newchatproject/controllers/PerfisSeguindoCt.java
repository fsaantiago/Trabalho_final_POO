package br.com.newchatproject.controllers;

import java.util.ArrayList;

import br.com.newchatproject.model.PerfilUsuario;

import br.com.newchatproject.model.ListarAmigos;
import br.com.newchatproject.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class PerfisSeguindoCt {

    private Usuario usuarioLogado;

    @FXML
    private Button btnVoltar;

    @FXML
    private ListView<PerfilUsuario> viewAmizades;

    @FXML
    private void initialize() {
        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {

            @Override
            public void onScreenChanged(String newScreen, Usuario userData) {
                if (newScreen.equals("list")) {
                    usuarioLogado = userData;
                    carregaLista();
                }
            }
        });
    }

    @FXML
    void voltar(ActionEvent event) {
        Main.changeScreen("menu", usuarioLogado);
    }

    private void carregaLista() {
        viewAmizades.getItems().clear();
        ListarAmigos seguindo = new ListarAmigos();
        ArrayList<PerfilUsuario> contas = seguindo.buscaAmizades(usuarioLogado.getId());
        for (PerfilUsuario contaUsuario : contas) {
            viewAmizades.getItems().add(contaUsuario);
        }
    }

}
