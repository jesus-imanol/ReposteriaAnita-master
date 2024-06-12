package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jesuscast.reposteriaanita.AppReposteria;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TypesSaleOrderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView decorationImg;

    @FXML
    private Button exitBtn;

    @FXML
    private ImageView orderInPremisesImage;

    @FXML
    private ImageView ordersHomeImage;

    @FXML
    private Label titulo1;

    @FXML
    private Label titulo2;

    @FXML
    void onClickExit(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void onClickOrdersHome(MouseEvent event) {
        AppReposteria.newStage("add-ventas-pedido-domicilio-view","Agregar nuevo pedido");
    }

    @FXML
    void onClickOrdersInPremises(MouseEvent event) {
        AppReposteria.newStage("add-ventas-pedidos-local-view","Agregar nuevo pedido");
    }

    @FXML
    void initialize() {

    }

}
