package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jesuscast.reposteriaanita.AppReposteria;
import com.jesuscast.reposteriaanita.models.Pedido;
import com.jesuscast.reposteriaanita.models.PedidoEnLocal;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ExistOrderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addPedidoBtn;

    @FXML
    private DatePicker dateCollectedDatePicker;

    @FXML
    private ImageView decorationImg;

    @FXML
    private Button exitBtn;

    @FXML
    private TextField idSearchInput;

    @FXML
    private TextField timeCollectedInput;
    @FXML
    private TextField premisesCollectedInput;

    @FXML
    private Label titulo1;

    @FXML
    private Label titulo2;

    @FXML
    void onClickAddPedido(MouseEvent event) {
        if (idSearchInput.getText().trim().isEmpty() || timeCollectedInput.getText().isEmpty()||premisesCollectedInput.getText().isEmpty() || dateCollectedDatePicker.getValue()==null){
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
            while (!bandera && index < listaPedidos.size()) {
                if (listaPedidos.get(index).getId().indexOf(id) >= 0&& !listaPedidos.get(index).getStatus().equals("Cancelado") && !listaPedidos.get(index).getStatus().equals("Entregado")) {
                    String localRecogido = premisesCollectedInput.getText();
                    boolean error = false;
                    LocalDate fechaDeRecogido=null;
                    LocalTime horaDeRecogido=null;
                    try {
                        fechaDeRecogido=dateCollectedDatePicker.getValue();
                    }catch (Exception e){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Error");
                        alert.setContentText("Ingrese la fecha correctamente: dd/mm/aaaa"+e.getMessage());
                        alert.showAndWait();
                        error = true;
                    }
                    try {
                        horaDeRecogido =LocalTime.parse(timeCollectedInput.getText());
                    }catch (Exception e){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Error");
                        alert.setContentText("Ingrese la hora correctamente: hh:mm:ss(segundos opcionales)"+e.getMessage());
                        alert.showAndWait();
                        error = true;
                    }
                    if (!error){
                        Pedido pedido = AppReposteria.getReposteria().getListaPedidos().get(index);
                        if (pedido instanceof PedidoEnLocal){
                            String estatus="Entregado";
                            ((PedidoEnLocal) pedido).setFechaRecogido(fechaDeRecogido);
                            ((PedidoEnLocal) pedido).setHoraRecogido(horaDeRecogido);
                            ((PedidoEnLocal) pedido).setLocalRecogido(localRecogido);
                            pedido.setStatus(estatus);
                            AppReposteria.getReposteria().getListaPedidos().set(index,pedido);
                            AppReposteria.getReporteVenta().addReporteVenta(pedido);
                        }else {
                            Alert alert= new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Error");
                            alert.setContentText("Este no es un pedido desde el local, ingrese un pedido que sí sea a domicilio");
                            alert.showAndWait();
                        }
                    }
                    bandera = true;
                }
                index++;
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
