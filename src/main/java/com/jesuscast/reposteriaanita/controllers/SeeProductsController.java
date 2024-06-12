package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jesuscast.reposteriaanita.AppReposteria;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SeeProductsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> amountProductColumn;

    @FXML
    private TableColumn<?, ?> idProductColumn;

    @FXML
    private TableColumn<?, ?> nameProductColumn;

    @FXML
    private TableColumn<?, ?> priceProductColumn;

    @FXML
    private TableView<?> tableProductColumn;

    @FXML
    private TableColumn<?, ?> typeProductColumn;

    @FXML
    void onClickExitSee(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {

    }

}
