package br.com.newchatproject.controllers;


//import br.com.newchatproject.model.Usuario;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    


    //public static Usuario usuarioLogado = null;

    
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("../views/indexScreen.fxml"));
        primaryStage.setTitle("NewChat - Criar");
        primaryStage.setScene(new Scene(root, 860, 720));
        primaryStage.show();



    }
    
}
