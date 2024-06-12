package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jesuscast.reposteriaanita.AppReposteria;
import com.jesuscast.reposteriaanita.models.Pedido;
import com.jesuscast.reposteriaanita.models.PedidoADomicilio;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ExistHomeOrderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addPedidoBtn;

    @FXML
    private ImageView decorationImg;

    @FXML
    private Button exitBtn;

    @FXML
    private TextField idSearchInput;

    @FXML
    private Label titulo1;

    @FXML
    private Label titulo2;

    @FXML
    void onClickAddPedido(MouseEvent event) {
if (idSearchInput.getText().trim().isEmpty()){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Se requieren datos");
    alert.setContentText("Por favor complete los campos");
    alert.showAndWait();
}else {
    boolean encontrado = false;
    String status;
    int index = 0;
    boolean bandera = false;
    String id=idSearchInput.getText();
    ArrayList<Pedido> listaPedidos = AppReposteria.getReposteria().getListaPedidos();
    Pedido pedido;
    boolean hecho=false;
    while (!bandera && index < listaPedidos.size()) {
        if (listaPedidos.get(index).getId().indexOf(id) >= 0&& !listaPedidos.get(index).getStatus().equals("Cancelado") && !listaPedidos.get(index).getStatus().equals("Entregado")) {
            bandera = true;
            encontrado = true;
            pedido=AppReposteria.getReposteria().getListaPedidos().get(index);
            if (pedido instanceof PedidoADomicilio) {
                status = "Entregado";
                listaPedidos.get(index).setStatus(status);
                AppReposteria.getReporteVenta().addReporteVenta(pedido);
                hecho=true;
            }else {
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Este no es un pedido a domicilio, ingrese un pedido que sí sea a domicilio");
                alert.showAndWait();
            }
        }
        index++;
    }
    if (encontrado && hecho){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Éxito");
        alert.setContentText("Reporte de venta realizado con éxito");
        alert.showAndWait();
    }else if (!encontrado){
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setContentText("Esta ID no le pertenece a ninún pedido, ingrese uno existente");
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
