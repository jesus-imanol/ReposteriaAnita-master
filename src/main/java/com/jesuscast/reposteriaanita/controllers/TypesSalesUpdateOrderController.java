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

public class TypesSalesUpdateOrderController {

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
        AppReposteria.newStage("update-sales-pedidos-domicilio-view","Actualizar pedidos a domicilio");
    }

    @FXML
    void onClickOrdersInPremises(MouseEvent event) {
        AppReposteria.newStage("update-sales-pedidos-local-view","Actualizar pedidos locales");
    }

    @FXML
    void initialize() {

    }

}
