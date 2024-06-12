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



public class MenuProductsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView carlotaImage;

    @FXML
    private ImageView cupcakeImage;
    @FXML
    private Button exitBtn;
    @FXML
    private ImageView exitImage;

    @FXML
    private ImageView flanImage;

    @FXML
    private ImageView gelatinaImage;

    @FXML
    private ImageView pastelImage;

    @FXML
    private ImageView postreFrutasImage;

    @FXML
    void onClickCarlota(MouseEvent event) {
        AppReposteria.newStage("add-carlota-view","Agregar carlota");
    }

    @FXML
    void onClickCupcake(MouseEvent event) {
        AppReposteria.newStage("add-cupcake-view","Agregar cupcake");
    }

    @FXML
    void onClickExit(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void onClickFlan(MouseEvent event) {
        AppReposteria.newStage("add-flan-view","Agregar flan");
    }

    @FXML
    void onClickGelatina(MouseEvent event) {
        AppReposteria.newStage("add-gelatina-view","Agregar gelatina");
    }

    @FXML
    void onClickPastel(MouseEvent event) {
        AppReposteria.newStage("add-cake-view","Agregar pastel");
    }

    @FXML
    void onClickPostreFrutas(MouseEvent event) {
        AppReposteria.newStage("add-postreFrutas-view","Agregar postre de frutas");
    }

    @FXML
    void initialize() {

    }

}
