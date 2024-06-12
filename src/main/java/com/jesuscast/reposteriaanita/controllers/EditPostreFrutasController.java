package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EditPostreFrutasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField amountInput;

    @FXML
    private Button decreaseBtn;

    @FXML
    private Button editNameBtn;

    @FXML
    private ImageView exitImage;

    @FXML
    private TextField idSearchInput;

    @FXML
    private Button increaseBtn;

    @FXML
    private TextField nameInput;

    @FXML
    private Button priceEditBtn;

    @FXML
    private TextField priceInput;

    @FXML
    private ComboBox<?> sizeComboBox;

    @FXML
    private Button sizeEditBtn;

    @FXML
    void onClickDecrease(MouseEvent event) {

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
    void onClickIncrease(MouseEvent event) {

    }

    @FXML
    void initialize() {

    }

}
