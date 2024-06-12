package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jesuscast.reposteriaanita.AppReposteria;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ProductoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView addProductImage;

    @FXML
    private ImageView deleteProductImage;

    @FXML
    private ImageView returnImage;

    @FXML
    private ImageView seeProductImage;

    @FXML
    private ImageView updateProductImage;

    @FXML
    void onClickAddProduct(MouseEvent event) {
        AppReposteria.newStage("menu-products-view","Agregar productos");
    }

    @FXML
    void onClickDeleteProduct(MouseEvent event) {
        AppReposteria.newStage("delete-product-view","Eliminar producto");
    }

    @FXML
    void onClickReturnHome(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void onClickSeeProduct(MouseEvent event) {
        AppReposteria.newStage("menu-see-products","Ver");
    }

    @FXML
    void onClickUpdateProduct(MouseEvent event) {
        AppReposteria.newStage("update-products-view","Actualizar productos");
    }

    @FXML
    void initialize() {

    }

}
