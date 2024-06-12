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

public class TypesOrdersController {

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
        AppReposteria.newStage("pedidos-domicilio-view","Pedidos a domicilio");
    }

    @FXML
    void onClickOrdersInPremises(MouseEvent event) {
        AppReposteria.newStage("pedidos-local-view","Pedidos en local");
    }

    @FXML
    void initialize() {

    }

}
