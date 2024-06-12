package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SeeOrdersHomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> clientColumn;

    @FXML
    private TableColumn<?, ?> costSentColumn;

    @FXML
    private TableColumn<?, ?> dateOrderColumn;

    @FXML
    private TableColumn<?, ?> designProductColumn;

    @FXML
    private Button exitButton;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> nameHomeColumn;

    @FXML
    private TableColumn<?, ?> orderPeopleColumn;

    @FXML
    private TableColumn<?, ?> referenceColumn;

    @FXML
    private TableColumn<?, ?> statusColumn;

    @FXML
    private TableView<?> tableOrders;

    @FXML
    private TableColumn<?, ?> timeOrderColumn;

    @FXML
    void onClickExit(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {

    }

}
