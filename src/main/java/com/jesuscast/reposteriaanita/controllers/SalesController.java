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

public class SalesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView addVentaImage;

    @FXML
    private ImageView decorationImg;

    @FXML
    private ImageView deleteVentaImage;

    @FXML
    private Button exitBtn;

    @FXML
    private ImageView seeVentaImage;

    @FXML
    private ImageView updateVentaImage;

    @FXML
    void OnClickSeeVenta(MouseEvent event) {
        AppReposteria.newStage("ventas-ver-pedidos-view","Ver ventas de los pedidos");
    }

    @FXML
    void onClickAddVenta(MouseEvent event) {
        AppReposteria.newStage("add-menu-ventas-view","Agregar ventas");
    }

    @FXML
    void onClickDeleteVenta(MouseEvent event) {
        AppReposteria.newStage("delete-sale-view","Eliminar venta ");
    }

    @FXML
    void onClickExit(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void onClickUpdateVenta(MouseEvent event) {
        AppReposteria.newStage("type-sales-update-pedidos-view","Actualizando un nuevo pedido");
    }

    @FXML
    void initialize() {

    }

}
