package br.com.newchatproject.controllers;

import java.util.ArrayList;
import java.util.Optional;

import br.com.newchatproject.model.AdicionaAmigo;
import br.com.newchatproject.model.PerfilUsuario;
import br.com.newchatproject.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;

public class SeguirPerfilCt {
    private Usuario usuarioLogado;

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnVoltar;

    @FXML
    private ListView<PerfilUsuario> viewUsuarios;

    @FXML
    private void initialize() {
        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {

            @Override
            public void onScreenChanged(String newScreen, Usuario userData) {
                if (newScreen.equals("add")) {
                    usuarioLogado = userData;
                    carregarLista();
                }
            }
        });
    }

    @FXML
    void adicionarAmigo(ActionEvent event) {
        PerfilUsuario perfilUsuario = viewUsuarios.getSelectionModel().getSelectedItem();
        if (perfilUsuario != null) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmação de amizade");
            alert.setHeaderText("Adicionar " + perfilUsuario.getNome() + " como amigo?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                AdicionaAmigo novoAmigo = new AdicionaAmigo();
                novoAmigo.adicionarAmigo(usuarioLogado.getId(), perfilUsuario.getId());
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Confirmação de amizade");
                alert.setHeaderText("Vocês e o usuário " + perfilUsuario.getNome() + " agora são amigos!");
                alert.show();
                carregarLista();
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Confirmação de amizade");
            alert.setHeaderText("É necessário selecionar um usuário para adicionar como amigo!");
            alert.show();
        }

    }

    @FXML
    void voltar(ActionEvent event) {
        Main.changeScreen("menu", usuarioLogado);
    }

    private void carregarLista() {
        viewUsuarios.getItems().clear();
        AdicionaAmigo addAmigos = new AdicionaAmigo();
        ArrayList<PerfilUsuario> contas = addAmigos.buscaPerfilUsuarioParaAdicionar(usuarioLogado.getId());
        for (PerfilUsuario contaUsuario : contas) {
            viewUsuarios.getItems().add(contaUsuario);
        }
    }

}
