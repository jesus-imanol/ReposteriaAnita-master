package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jesuscast.reposteriaanita.AppReposteria;
import com.jesuscast.reposteriaanita.models.Carlota;
import com.jesuscast.reposteriaanita.models.Cupcake;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SeeCupcakeProduct {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn amountProductColumn;

    @FXML
    private AnchorPane container;

    @FXML
    private TableColumn designProductColumn;

    @FXML
    private Button exitBtn;

    @FXML
    private TableColumn idProductColumn;

    @FXML
    private TableColumn nameProductColumn;

    @FXML
    private TableColumn priceProductColumn;

    @FXML
    private TableColumn stuffedProductColumn;

    @FXML
    private TableView<Cupcake> tableProduct;

    @FXML
    private Label titleLabel;
    private ObservableList<Cupcake> cupcakes;
    @FXML
    void onClickExitBtn(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        cupcakes= FXCollections.observableArrayList();
        ArrayList<Cupcake> listaCupcakes;
        listaCupcakes= AppReposteria.getReposteria().getListaProductosCupcake();
        this.nameProductColumn.setCellValueFactory(new PropertyValueFactory("nombreProducto"));
        this.amountProductColumn.setCellValueFactory(new PropertyValueFactory("cantidad"));
        this.priceProductColumn.setCellValueFactory(new PropertyValueFactory("precio"));
        this.stuffedProductColumn.setCellValueFactory(new PropertyValueFactory("relleno"));
        this.designProductColumn.setCellValueFactory(new PropertyValueFactory("desing"));
        this.idProductColumn.setCellValueFactory(new PropertyValueFactory("id"));
        for(short i=0; i<listaCupcakes.size(); i++){
            if(listaCupcakes.get(i).isStatus()){
                cupcakes.add(listaCupcakes.get(i));
            }
        }
        tableProduct.setItems(cupcakes);
    }

}
