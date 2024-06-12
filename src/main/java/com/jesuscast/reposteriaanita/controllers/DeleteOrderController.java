package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jesuscast.reposteriaanita.AppReposteria;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DeleteOrderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button deleteOrders;

    @FXML
    private Button exitBtn;

    @FXML
    private TextField idSearchOrder;

    @FXML
    void onClickDeleteOrders(MouseEvent event) {
        if(idSearchOrder.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("EL CAMPO NO PUEDE ESTAR VACÍO");
            alert.showAndWait();
        }
        else {
        String id = idSearchOrder.getText();
        if (AppReposteria.getReposteria().cancelarPedido(id)){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Éxito");
            alert.setContentText("Pedido eliminado con éxito");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("No existe ningún pedido con esta ID");
            alert.showAndWait();
        }
        }
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
