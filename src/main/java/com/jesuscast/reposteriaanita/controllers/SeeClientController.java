package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jesuscast.reposteriaanita.AppReposteria;
import com.jesuscast.reposteriaanita.models.Cliente;
import com.jesuscast.reposteriaanita.models.Flan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SeeClientController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn addressColumn;

    @FXML
    private Button exitBtn;

    @FXML
    private TableColumn  genderColumn;

    @FXML
    private TableColumn idColumn;

    @FXML
    private TableColumn nameColumn;

    @FXML
    private TableView<Cliente> tableClient;


    @FXML
    private TableColumn timeOfClientColumn;
    private ObservableList<Cliente> listaCliente;

    @FXML
    void onClickExit(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        ArrayList<Cliente> clientes;
        listaCliente= FXCollections.observableArrayList();
        clientes = AppReposteria.getReposteria().getListaClientes();
        this.nameColumn.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.genderColumn.setCellValueFactory(new PropertyValueFactory("sexo"));
        this.idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        this.addressColumn.setCellValueFactory(new PropertyValueFactory("direccion"));
        this.timeOfClientColumn.setCellValueFactory(new PropertyValueFactory("tiempoCliente"));
        for(short i=0; i<clientes.size(); i++){
            if(clientes.get(i).isStatus()){
                clientes.add(clientes.get(i));
            }
        }
        tableClient.setItems(listaCliente);


    }

}
