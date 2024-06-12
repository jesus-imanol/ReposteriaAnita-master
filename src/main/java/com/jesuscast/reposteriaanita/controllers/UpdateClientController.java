package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UpdateClientController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField addressClientInput;

    @FXML
    private Button addressEditBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private Button genderEditBtn;

    @FXML
    private TextField id;

    @FXML
    private TextField nameClientInput;

    @FXML
    private Button nameEditBtn;

    @FXML
    private ComboBox<?> sexoClientComboBox;

    @FXML
    private Button timeClientEditBtn;

    @FXML
    private TextField timeClientInput;

    @FXML
    void onClickEditAmountPerson(MouseEvent event) {

    }

    @FXML
    void onClickEditName(MouseEvent event) {

    }

    @FXML
    void onClickEditPrice(MouseEvent event) {

    }

    @FXML
    void onClickEditStuffed(MouseEvent event) {

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
