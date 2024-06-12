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

public class SuppliesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView addInsumoImage;

    @FXML
    private ImageView deleteInsumoImage;

    @FXML
    private Button exitBtn;

    @FXML
    private ImageView seeInsumoImage;

    @FXML
    private ImageView updateInsumoImage;

    @FXML
    void OnClickSeeInsumo(MouseEvent event) {
        AppReposteria.newStage("see-supplies-view","Ver insumos");
    }

    @FXML
    void onClickAddInsumo(MouseEvent event) {
        AppReposteria.newStage("add-supplies-view","Agregar insumos");
    }

    @FXML
    void onClickDeleteInsumo(MouseEvent event) {
        AppReposteria.newStage("delete-supplies-view","Eliminar insumos");
    }

    @FXML
    void onClickExit(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void onClickUpdateInsumo(MouseEvent event) {
        AppReposteria.newStage("update-supplies-view","Editar insumos");
    }

    @FXML
    void initialize() {

    }

}
