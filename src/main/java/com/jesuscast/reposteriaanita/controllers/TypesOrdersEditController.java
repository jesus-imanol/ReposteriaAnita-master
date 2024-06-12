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

public class TypesOrdersEditController {

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
        AppReposteria.newStage("editar-pedidos-domicilio-view","Editar pedidos a domicilio");
    }

    @FXML
    void onClickOrdersInPremises(MouseEvent event) {
        AppReposteria.newStage("editar-pedidos-local-view","Editar pedidos en el local");
    }

    @FXML
    void initialize() {

    }

}
