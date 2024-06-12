package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jesuscast.reposteriaanita.AppReposteria;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button loginBtn;

    @FXML
    private TextField passwordInput;

    @FXML
    private TextField userInput;

    @FXML
    void onClickLoginBtn(MouseEvent event) {
        AppReposteria.newStage("home-view-admin","Home-Super Administrador");
    }

    @FXML
    void initialize() {

    }

}
