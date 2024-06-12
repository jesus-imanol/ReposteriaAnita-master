package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jesuscast.reposteriaanita.AppReposteria;
import com.jesuscast.reposteriaanita.models.Cupcake;
import com.jesuscast.reposteriaanita.models.Flan;
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

public class SeeFlanProductController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> amountPersonProductColumn;

    @FXML
    private TableColumn<?, ?> amountProductColumn;

    @FXML
    private AnchorPane container;

    @FXML
    private TableColumn<?, ?> designProductColumn;

    @FXML
    private Button exitBtn;

    @FXML
    private TableColumn<?, ?> idProductColumn;

    @FXML
    private TableColumn<?, ?> nameProductColumn;

    @FXML
    private TableColumn<?, ?> priceProductColumn;

    @FXML
    private TableView<Flan> tableProduct;

    @FXML
    private Label titleLabel;
    private ObservableList<Flan> flans;
    @FXML
    void onClickExitBtn(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        flans= FXCollections.observableArrayList();
        ArrayList<Flan> listaFlans;
        listaFlans= AppReposteria.getReposteria().getListaProductosFlan();
        this.nameProductColumn.setCellValueFactory(new PropertyValueFactory("nombreProducto"));
        this.amountProductColumn.setCellValueFactory(new PropertyValueFactory("cantidad"));
        this.priceProductColumn.setCellValueFactory(new PropertyValueFactory("precio"));
        this.amountPersonProductColumn.setCellValueFactory(new PropertyValueFactory("cantidadPersonas"));
        this.designProductColumn.setCellValueFactory(new PropertyValueFactory("desing"));
        this.idProductColumn.setCellValueFactory(new PropertyValueFactory("id"));
        for(short i=0; i<listaFlans.size(); i++){
            if(listaFlans.get(i).isStatus()){
                flans.add(listaFlans.get(i));
            }
        }
        tableProduct.setItems(flans);
    }

}
