package br.com.newchatproject.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class mainController {

    @FXML
    private HBox content;

    @FXML
    private TextArea dialogPane;

    @FXML
    private AnchorPane div01;

    @FXML
    private AnchorPane div02;

    @FXML
    private AnchorPane div03;

    @FXML
    private TextField explorador;

    @FXML
    private Button getContatos;

    @FXML
    private ImageView getFotoFriend;

    @FXML
    private Button getMessage;

    @FXML
    private ImageView getMyFoto;

    @FXML
    private Label getMyName;

    @FXML
    private Label getNameFriend;

    @FXML
    private SplitPane hSplitPane;

    @FXML
    private HBox header;

    @FXML
    private TextField inputMessage;

    @FXML
    private ImageView logo2;

    @FXML
    private MenuBar menu;

    @FXML
    private HBox readBox;

    @FXML
    private ToolBar toolBar;

    @FXML
    private ListView<?> userList;

    @FXML
    private SplitPane vSplitPane;

    @FXML
    private HBox writeBox;

}
