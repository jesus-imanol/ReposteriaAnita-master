package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jesuscast.reposteriaanita.AppReposteria;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TypesOrdersSeeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exitBtn;

    @FXML
    private ImageView orderInPremisesImage;

    @FXML
    private ImageView ordersHomeImage;

    @FXML
    void onClickExit(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void onClickOrdersHome(MouseEvent event) {
        AppReposteria.newStage("ver-pedidos-domicilio-view","Ver pedidos a domicilio");
    }

    @FXML
    void onClickOrdersInPremises(MouseEvent event) {
        AppReposteria.newStage("ver-pedidos-local-view","Ver pedidos en local");
    }

    @FXML
    void initialize() {

    }

}
