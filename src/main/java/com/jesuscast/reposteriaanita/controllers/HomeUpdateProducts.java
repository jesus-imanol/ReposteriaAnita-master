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

public class HomeUpdateProducts {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView carlotaUpdateImage;

    @FXML
    private ImageView cupcakeUpdateImage;

    @FXML
    private Button exitBtn;

    @FXML
    private ImageView flanUpdateImage;

    @FXML
    private ImageView gelatinaUpdateImage;

    @FXML
    private ImageView pastelUpdateImage;

    @FXML
    private ImageView postreFrutasUpdateImage;

    @FXML
    void onClickExit(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void onClickUpdateCarlota(MouseEvent event) {
        AppReposteria.newStage("edit-carlota-view","Editar carlota");
    }

    @FXML
    void onClickUpdateCupcake(MouseEvent event) {
        AppReposteria.newStage("edit-cupcake-view","Editar cupcake");
    }

    @FXML
    void onClickUpdateFlan(MouseEvent event) {
        AppReposteria.newStage("edit-flan-view","Editar flan");
    }

    @FXML
    void onClickUpdateGelatina(MouseEvent event) {
        AppReposteria.newStage("edit-gelatina-view","Editar gelatina");
    }

    @FXML
    void onClickUpdatePastel(MouseEvent event) {
        AppReposteria.newStage("edit-cake-view","Editar pastel");
    }

    @FXML
    void onClickUpdatePostreFrutas(MouseEvent event) {
        AppReposteria.newStage("edit-postreFrutas-view","Editar postre de frutas");
    }

    @FXML
    void initialize() {

    }

}
