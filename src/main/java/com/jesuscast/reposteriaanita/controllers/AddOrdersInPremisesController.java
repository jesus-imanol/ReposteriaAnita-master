package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import com.jesuscast.reposteriaanita.AppReposteria;
import com.jesuscast.reposteriaanita.models.Pedido;
import com.jesuscast.reposteriaanita.models.PedidoEnLocal;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddOrdersInPremisesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addOrdersBtn;

    @FXML
    private TextField clienteOrderinput;
    @FXML
    private DatePicker dateOrderDatePicker;

    @FXML
    private TextField designProduct;

    @FXML
    private Button exitBtn;

    @FXML
    private TextField nameProductPeopleInput;
    @FXML
    private ComboBox<String> statusOrderComboBox;
    @FXML
    private TextField timeOrderInput;

    @FXML
    void onClickAddOrders(MouseEvent event) {
     if (clienteOrderinput.getText().trim().isEmpty() ||dateOrderDatePicker.getValue()==null ||designProduct.getText().trim().isEmpty() ||nameProductPeopleInput.getText().trim().isEmpty() ||statusOrderComboBox.getValue().trim().isEmpty() ||timeOrderInput.getText().trim().isEmpty()){
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Se requieren datos");
         alert.setContentText("Por favor complete los campos");
         alert.showAndWait();
     }else {
         String nombreCliente=clienteOrderinput.getText();
         String desingProducto=designProduct.getText();
         String nombreProducto=nameProductPeopleInput.getText();
         String estatus=statusOrderComboBox.getValue();
         String localRecogido = "";
         LocalDate fechaDeRecogido = null;
         LocalTime horaDeRecogido = null;
         LocalTime horaDeEntrega=null;
         LocalDate fechaDeEntrega=null;
         boolean error = false;
         try {
             fechaDeEntrega = dateOrderDatePicker.getValue();
         }catch (Exception e){
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Error");
             alert.setContentText("Ingrese la fecha correctamente: dd/mm/aaaa"+e.getMessage());
             alert.showAndWait();
             error = true;
         }
         try {
             horaDeEntrega = LocalTime.parse(timeOrderInput.getText());
         }catch (Exception e){
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Error");
             alert.setContentText("Ingrese la hpra correctamente: hh:mm:ss(segundos opcionales)"+e.getMessage());
             alert.showAndWait();
             error = true;
         }
         if (!error){
             Pedido pedido = new PedidoEnLocal(nombreCliente,fechaDeEntrega,horaDeEntrega,desingProducto,estatus,nombreProducto,fechaDeRecogido,horaDeRecogido,localRecogido);
             if (AppReposteria.getReposteria().addPedido(pedido)){
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setTitle("Exito");
                 alert.setContentText("Guardado exitosamente");
                 alert.showAndWait();
             }else {
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setTitle("Error");
                 alert.setContentText("Ha habido un error al guardar, intente de nuevo, por favor");
                 alert.showAndWait();
             }
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
