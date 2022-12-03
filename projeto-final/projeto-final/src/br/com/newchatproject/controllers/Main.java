package br.com.newchatproject.controllers;

import java.util.ArrayList;

import br.com.newchatproject.model.Usuario;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage stage;

    private static Scene indexScene;// index
    private static Scene acessarContaScene; // acessar-conta
    private static Scene cadastroScene;// cadastro
    private static Scene menuScene;// menu
    private static Scene addAmigoScene;// seguir-perfil
    private static Scene listarSeguindoScene;// listar-seguindo
    private static Scene excluirSeguindoScene;// excluir-perfil

    public static Usuario usuarioLogado = null;

    public static void main(String[] args) {
        launch(args);
    }// fim do main

    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;

        Parent fxmlIndex = FXMLLoader.load(getClass().getResource("../views/index.fxml"));
        indexScene = new Scene(fxmlIndex);

        Parent fxmlAcessarConta = FXMLLoader.load(getClass().getResource("../views/acessar-conta.fxml"));
        acessarContaScene = new Scene(fxmlAcessarConta);

        Parent fxmlCadastro = FXMLLoader.load(getClass().getResource("../views/cadastro.fxml"));
        cadastroScene = new Scene(fxmlCadastro);

        Parent fxmlMenu = FXMLLoader.load(getClass().getResource("../views/menu.fxml"));
        menuScene = new Scene(fxmlMenu);

        Parent fxmlAddAmigo = FXMLLoader.load(getClass().getResource("../views/adicionar-amigo.fxml"));
        addAmigoScene = new Scene(fxmlAddAmigo);

        Parent fxmlListarSeguindo = FXMLLoader.load(getClass().getResource("../views/listar-amigos.fxml"));
        listarSeguindoScene = new Scene(fxmlListarSeguindo);

        Parent fxmlExcluir = FXMLLoader.load(getClass().getResource("../views/excluir-perfil.fxml"));
        excluirSeguindoScene = new Scene(fxmlExcluir);

        primaryStage.setTitle("Trabalho Final - NewChat");
        primaryStage.setScene(indexScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    } // fim do metodo Sart

    // Metodo para trocar de tela

    public static void changeScreen(String scr, Usuario userData) {
        switch (scr) {
            case "index":
                stage.setTitle("Pagina inicial - NewChat");
                stage.setScene(indexScene);
                notifyAllListeners("index", userData);
                break;
            case "cadastro":
                stage.setTitle("Criar Conta - NewChat");
                stage.setScene(cadastroScene);
                notifyAllListeners("cadastro", userData);
                break;
            case "acessarConta":
                stage.setTitle("Acessar Conta - NewChat");
                stage.setScene(acessarContaScene);
                notifyAllListeners("acessarConta", userData);
                break;
            case "menu":
                stage.setTitle("Menu Principal - NewChat");
                stage.setScene(menuScene);
                notifyAllListeners("menu", userData);
                break;
            case "add":
                stage.setTitle("Adicionar amigo - NewChat");
                stage.setScene(addAmigoScene);
                notifyAllListeners("add", userData);
                break;
            case "list":
                stage.setTitle("Usuários que você segue - NewChat");
                stage.setScene(listarSeguindoScene);
                notifyAllListeners("list", userData);
                break;
            case "excluir":
                stage.setTitle("Excluir usuário - NewChat");
                stage.setScene(excluirSeguindoScene);
                notifyAllListeners("excluir", userData);
                break;
        }
    }

    /*---------------------------------------------------------------------------*/

    private static ArrayList<OnChangeScreen> listeners = new ArrayList<>();

    public static interface OnChangeScreen {
        void onScreenChanged(String newScreen, Usuario userData);
    }

    public static void addOnChangeScreenListener(OnChangeScreen newListener) {
        listeners.add(newListener);
    }

    private static void notifyAllListeners(String newScreen, Usuario userData) {
        for (OnChangeScreen onChangeScreen : listeners) {
            onChangeScreen.onScreenChanged(newScreen, userData);
        }
    }

}// fim da minha classe Main
