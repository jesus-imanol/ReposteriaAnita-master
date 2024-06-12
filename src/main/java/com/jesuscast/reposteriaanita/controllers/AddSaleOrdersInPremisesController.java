package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddSaleOrdersInPremisesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addOrdersBtn;

    @FXML
    private TextField clienteOrderinput;

    @FXML
    private DatePicker dateCollected;

    @FXML
    private DatePicker dateOrderDatePicker;

    @FXML
    private TextField designProduct;

    @FXML
    private Button exitBtn;

    @FXML
    private TextField nameProductPeopleInput;

    @FXML
    private TextField premisesCollected;

    @FXML
    private TextField timeCollectedInput;

    @FXML
    private TextField timeOrderInput;

    @FXML
    void onClickAddOrders(MouseEvent event) {

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
