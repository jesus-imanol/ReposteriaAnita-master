package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import com.jesuscast.reposteriaanita.AppReposteria;
import com.jesuscast.reposteriaanita.models.Pedido;
import com.jesuscast.reposteriaanita.models.PedidoADomicilio;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddOrdersHomeController {

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
    private TextField nameHome;

    @FXML
    private TextField nameProductPeopleInput;

    @FXML
    private TextField referenceInput;

    @FXML
    private TextField shippingCostInput;

    @FXML
    private ComboBox<String> statusOrderComboBox;

    @FXML
    private TextField timeOrderInput;

    @FXML
    void onClickAddOrders(MouseEvent event) {
       if(clienteOrderinput.getText().trim().isEmpty() || dateOrderDatePicker.getValue()==null || designProduct.getText().trim().isEmpty() || nameHome.getText().trim().isEmpty() || nameProductPeopleInput.getText().trim().isEmpty() || referenceInput.getText().trim().isEmpty() || shippingCostInput.getText().trim().isEmpty() ||statusOrderComboBox.getValue()==null || timeOrderInput.getText().trim().isEmpty()){
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Se requieren datos");
           alert.setContentText("Por favor complete los campos");
           alert.showAndWait();
       }
       else {
           String nombreProducto = nameProductPeopleInput.getText();
           String nombreCliente = clienteOrderinput.getText();
           String desingProducto=designProduct.getText();
           String nombreDomicilio=nameHome.getText();
           String referencia= referenceInput.getText();
           String estatus = statusOrderComboBox.getValue();
           LocalDate fechaDeEntrega=null;
           LocalTime horaDeEntrega=null;
           double costoEnvio=0;
           boolean error=false;
           try {
               fechaDeEntrega=dateOrderDatePicker.getValue();
           }catch (Exception e){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Error");
               alert.setContentText("Ingrese la fecha correctamente: dd/mm/aaaa"+e.getMessage());
               alert.showAndWait();
               error = true;
           }
           try {
               horaDeEntrega=LocalTime.parse(timeOrderInput.getText());
           }catch (Exception e){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Error");
               alert.setContentText("Ingrese la hora correctamente: hh:mm:ss(los segundos son opcionales)"+e.getMessage());
               alert.showAndWait();
               error = true;
           }
           try {
               costoEnvio= Double.parseDouble(shippingCostInput.getText());
           }catch (Exception e){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Error");
               alert.setContentText("Ingrese solo valores numericos"+e.getMessage());
               alert.showAndWait();
               error = true;
           }
           if (!error){
               if (costoEnvio>=0) {
                   Pedido pedido = new PedidoADomicilio(nombreCliente, fechaDeEntrega, horaDeEntrega, desingProducto, estatus, nombreProducto, nombreDomicilio, costoEnvio, referencia);
                   if (AppReposteria.getReposteria().addPedido(pedido)) {
                       Alert alert = new Alert(Alert.AlertType.INFORMATION);
                       alert.setTitle("Exito");
                       alert.setContentText("Guardado exitosamente");
                       alert.showAndWait();
                   } else {
                       Alert alert = new Alert(Alert.AlertType.INFORMATION);
                       alert.setTitle("Error");
                       alert.setContentText("Ha habido un error al guardar, intente de nuevo, por favor");
                       alert.showAndWait();
                   }
               }else {
                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
                   alert.setTitle("Error");
                   alert.setContentText("No puede ingresar cantidades negativas");
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
        statusOrderComboBox.getItems().addAll("Por entregar","Sin corfirmar");
    }

}
