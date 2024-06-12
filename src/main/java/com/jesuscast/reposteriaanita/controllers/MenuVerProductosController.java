package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jesuscast.reposteriaanita.AppReposteria;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuVerProductosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Button exitBtn;


    @FXML
    private ImageView verCarlotaImage;

    @FXML
    private ImageView verCupcakeImage;

    @FXML
    private ImageView verFlanImage;

    @FXML
    private ImageView verGelatinaImage;

    @FXML
    private ImageView verPastelImage;

    @FXML
    private ImageView verPostreImage;

    @FXML
    void onClickSeeCarlota(MouseEvent event) {
        AppReposteria.newStage("see-carlota-view","Ver carlota");
    }

    @FXML
    void onClickSeeCupcake(MouseEvent event) {
        AppReposteria.newStage("see-cupcake-view","Ver cupcake");
    }

    @FXML
    void onClickSeeFlan(MouseEvent event) {
        AppReposteria.newStage("see-flan-view","Ver flan");
    }

    @FXML
    void onClickSeeGelatina(MouseEvent event) {
        AppReposteria.newStage("see-gelatina-view","Ver gelatina");
    }

    @FXML
    void onClickSeePastel(MouseEvent event) {
        AppReposteria.newStage("see-pasteles-view","Ver pasteles");
    }

    @FXML
    void onClickSeePostreFrutas(MouseEvent event) {
        AppReposteria.newStage("see-postreFrutas-view","Ver postre de frutas");
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

