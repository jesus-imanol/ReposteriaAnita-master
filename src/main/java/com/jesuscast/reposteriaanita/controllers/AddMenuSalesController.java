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

public class AddMenuSalesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView decorationImg;

    @FXML
    private ImageView existVentaImage;

    @FXML
    private Button exitBtn;

    @FXML
    private ImageView newVentaImage;

    @FXML
    private Label titulo1;

    @FXML
    private Label titulo2;

    @FXML
    void OnClickNewVenta(MouseEvent event) {
        AppReposteria.newStage("nuevo-venta-view","Agregar nueva venta");
    }

    @FXML
    void onClickExistVenta(MouseEvent event) {
        AppReposteria.newStage("tipo-existe-pedido-view","Agregar pedido ya existente");
    }

    @FXML
    void onClickExit(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {

    }

}
