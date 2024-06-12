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

public class AddSaleOrdersHomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addOrdersBtn;

    @FXML
    private TextField clienteOrderinput;

    @FXML
    private DatePicker dateOrderDatePicker;

    @FXML
    private TextField designProduct;

    @FXML
    private Button exitBtn;

    @FXML
    private TextField nameHome;

    @FXML
    private TextField nameProductPeopleInput;

    @FXML
    private TextField referenceInput;

    @FXML
    private TextField shippingCostInput;

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
