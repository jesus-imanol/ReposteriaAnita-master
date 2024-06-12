package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jesuscast.reposteriaanita.AppReposteria;
import com.jesuscast.reposteriaanita.models.Pastel;
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

public class SeePastelesProduct {

    @FXML
    private ResourceBundle resources;
    @FXML
    private AnchorPane container;
    @FXML
    private URL location;
    @FXML
    private Label titleLabel;
    @FXML
    private TableColumn amountPersonProductColumn;

    @FXML
    private TableColumn amountProductColumn;

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
    private TableView<Pastel> tableProduct;
    private ObservableList<Pastel> pasteles;
    @FXML
    void onClickExitBtn(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        container.getStylesheets().add("com/jesuscast/reposteriaanita/styles/style.css");
        pasteles= FXCollections.observableArrayList();
        ArrayList<Pastel> listaPasteles;
        listaPasteles= AppReposteria.getReposteria().getListaProductosPastel();
        this.nameProductColumn.setCellValueFactory(new PropertyValueFactory("nombreProducto"));
        this.amountProductColumn.setCellValueFactory(new PropertyValueFactory("cantidad"));
        this.priceProductColumn.setCellValueFactory(new PropertyValueFactory("precio"));
        this.amountPersonProductColumn.setCellValueFactory(new PropertyValueFactory("cantidadPersonas"));
        this.stuffedProductColumn.setCellValueFactory(new PropertyValueFactory("relleno"));
        this.designProductColumn.setCellValueFactory(new PropertyValueFactory("desing"));
        this.idProductColumn.setCellValueFactory(new PropertyValueFactory("id"));
        for(short i=0; i<listaPasteles.size(); i++){
            if(listaPasteles.get(i).isStatus()){
                pasteles.add(listaPasteles.get(i));
                System.out.println(listaPasteles.get(i));
            }
        }
        tableProduct.setItems(pasteles);
    }

}
