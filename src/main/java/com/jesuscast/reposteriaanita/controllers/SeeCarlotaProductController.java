package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jesuscast.reposteriaanita.AppReposteria;
import com.jesuscast.reposteriaanita.models.Carlota;
import javafx.beans.Observable;
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

public class SeeCarlotaProductController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn amountProductColumn;

    @FXML
    private AnchorPane container;

    @FXML
    private Button exitBtn;

    @FXML
    private TableColumn idProductColumn;

    @FXML
    private TableColumn nameProductColumn;

    @FXML
    private TableColumn priceProductColumn;

    @FXML
    private TableColumn sizeProductColumn;

    @FXML
    private TableView<Carlota> tableProduct;

    @FXML
    private Label titleLabel;

    @FXML
    private TableColumn<?, ?> typeProductColumn;
    private ObservableList<Carlota> carlotas;

    @FXML
    void onClickExitBtn(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
     carlotas= FXCollections.observableArrayList();
        ArrayList<Carlota> listaCarlotas;
        listaCarlotas= AppReposteria.getReposteria().getListaProductosCarlota();
        this.nameProductColumn.setCellValueFactory(new PropertyValueFactory("nombreProducto"));
        this.amountProductColumn.setCellValueFactory(new PropertyValueFactory("cantidad"));
        this.priceProductColumn.setCellValueFactory(new PropertyValueFactory("precio"));
        this.sizeProductColumn.setCellValueFactory(new PropertyValueFactory("size"));
        this.typeProductColumn.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        this.idProductColumn.setCellValueFactory(new PropertyValueFactory("id"));
        for(short i=0; i<listaCarlotas.size(); i++){
            if(listaCarlotas.get(i).isStatus()){
             carlotas.add(listaCarlotas.get(i));
            }
        }
        tableProduct.setItems(carlotas);
    }

}
