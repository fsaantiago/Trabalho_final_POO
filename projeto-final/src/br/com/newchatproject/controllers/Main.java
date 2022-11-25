package br.com.newchatproject.controllers;


import java.util.ArrayList;

//import br.com.newchatproject.model.Usuario;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    //public static Usuario usuarioLogado = null;    

    
    private static Stage stage; 
    
    private static Scene indexScene;//index
    private static Scene acessarContaScene; //acessar-conta
    private static Scene cadastroScene;//cadastro
    private static Scene menuScene;//menu
    // private static Scene addAmigoScene;//seguir-perfil
    // private static Scene listSeguindoScene;//listar-seguindo
    // private static Scene excluirSeguindoScene;//excluir-perfil
   
    
    public static void main(String[] args) {
        launch(args);
    }//fim do main
    
    
    @Override
    public void start(Stage primaryStage) throws Exception{

        stage = primaryStage;
        
        
        Parent fxmlIndex = FXMLLoader.load(getClass().getResource("../views/index.fxml"));
        indexScene = new Scene(fxmlIndex);

        Parent fxmlAcessarConta = FXMLLoader.load(getClass().getResource("../views/acessar-conta.fxml"));
        acessarContaScene = new Scene(fxmlAcessarConta);
        
        Parent fxmlCadastro = FXMLLoader.load(getClass().getResource("../views/cadastro.fxml"));
        cadastroScene = new Scene(fxmlCadastro);

        Parent fxmlMenu = FXMLLoader.load(getClass().getResource("../views/index.fxml"));
        menuScene = new Scene(fxmlMenu);
        


        primaryStage.setTitle("Trabalho Final - NewChat");
        primaryStage.setScene(indexScene);
        primaryStage.show();
    } //fim do metodo Sart
    
    //Metodo para trocar de tela 

    public static void changeScreen(String scr, Object userData){
        switch (scr) {
            case "index":
                stage.setScene(indexScene);
                notifyAllListeners("index", userData);
                break;
            case "cadastro":
                stage.setScene(cadastroScene);
                notifyAllListeners("cadastro", userData);
                break;
            case "acessarConta":
                stage.setScene(acessarContaScene);
                notifyAllListeners("acessarConta", userData);
                break;
            case "menu":
                stage.setScene(menuScene);
                notifyAllListeners("menu", userData);
                break;
        }
    }

    public static void changeScreen(String scr){
        changeScreen(scr,null);
    }



    /*---------------------------------------------------------------------------*/

    private static ArrayList<OnChangeScreen> listeners = new ArrayList<>();

    public static interface OnChangeScreen {
        void onScreenChanged(String newScreen, Object userData);
    }

    public static void addOnChangeScreen(OnChangeScreen newListener){
        listeners.add(newListener);
    }

    private static void notifyAllListeners(String newScreen, Object userData){
        for(OnChangeScreen l:listeners)
            l.onScreenChanged(newScreen, userData);
    }


}//fim da minha classe Main
