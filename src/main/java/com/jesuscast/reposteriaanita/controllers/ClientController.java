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

public class ClientController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView addClientImage;

    @FXML
    private ImageView deleteClientImage;

    @FXML
    private Button exitBtn;

    @FXML
    private ImageView seeClientImage;

    @FXML
    private ImageView updateClientImage;

    @FXML
    void OnClickSeeClient(MouseEvent event) {
        AppReposteria.newStage("see-client-view","Ver cliente");
    }

    @FXML
    void onClickAddClient(MouseEvent event) {
        AppReposteria.newStage("add-client-view","Agregar cliente");
    }

    @FXML
    void onClickDeleteClient(MouseEvent event) {
        AppReposteria.newStage("delete-client-view","Eliminar cliente");

    }

    @FXML
    void onClickExit(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void onClickUpdateClient(MouseEvent event) {
        AppReposteria.newStage("update-client-view","Actualizar el cliente");
    }

    @FXML
    void initialize() {

    }

}
