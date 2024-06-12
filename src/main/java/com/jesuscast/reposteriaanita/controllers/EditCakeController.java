package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jesuscast.reposteriaanita.AppReposteria;
import com.jesuscast.reposteriaanita.models.Pastel;
import com.jesuscast.reposteriaanita.models.Pedido;
import com.jesuscast.reposteriaanita.models.PedidoADomicilio;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EditCakeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField amountInput;

    @FXML
    private Button amountPersonEditBtn;

    @FXML
    private TextField amountPersonInput;

    @FXML
    private Button decreaseEditBtn;

    @FXML
    private Button designEditBtn;

    @FXML
    private TextField designInput;

    @FXML
    private ImageView exitImage;

    @FXML
    private ImageView imgCentral;

    @FXML
    private Button increaseEditBtn;

    @FXML
    private TextField idSearchInput;
    @FXML
    private Button nameEditBtn;

    @FXML
    private TextField nameInput;

    @FXML
    private Button priceEditBtn;

    @FXML
    private TextField priceInput;

    @FXML
    private Button stuffedEditBtn;

    @FXML
    private TextField stuffedInput;

    @FXML
    void onClickDecrease(MouseEvent event) {
    if (amountInput.getText().trim().isEmpty() ||idSearchInput.getText().trim().isEmpty()){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Se requieren datos");
        alert.setContentText("Por favor complete los campos");
        alert.showAndWait();
    }else {
        String id=idSearchInput.getText();
        boolean encontrado = false;
        int index = 0;
        boolean bandera = false;
        ArrayList<Pastel> pasteles = AppReposteria.getReposteria().getListaProductosPastel();
        while (!bandera && index < pasteles.size()) {
            if (pasteles.get(index).getId().indexOf(id) >= 0 && pasteles.get(index).isStatus()) {
                bandera = true;
                encontrado=true;
                int cantidad;
                try {
                    cantidad=Integer.parseInt(amountInput.getText());
                    if (cantidad>=0) {
                        if (AppReposteria.getReposteria().getListaProductosPastel().get(index).restarCantidad(cantidad)) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Éxito");
                            alert.setContentText("El pastel se ha editado exitosamente");
                            alert.showAndWait();
                        } else {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Error");
                            alert.setContentText("No puede restar esta cantidad, debido a que es más grande que la cantidad existente");
                            alert.showAndWait();
                        }
                    }else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Error");
                        alert.setContentText("Ingrese solo números positivos");
                        alert.showAndWait();
                    }
                }catch (Exception e){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setContentText("Error al guardar datos, ingrese solo valores númericos"+e.getMessage());
                    alert.showAndWait();
                }
            }
            index++;
        }
        if (!encontrado){
            Alert alert= new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("Esta  ID no está dentro de la lista de pasteles, ingrese uno existente");
            alert.showAndWait();
        }
    }
    }

    @FXML
    void onClickEditAmountPerson(MouseEvent event) {
   if (amountPersonInput.getText().trim().isEmpty() || idSearchInput.getText().trim().isEmpty()){
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
       alert.setTitle("Se requieren datos");
       alert.setContentText("Por favor complete los campos");
       alert.showAndWait();
   }else {
       String id = idSearchInput.getText();
       boolean encontrado = false;
       int index=0;
       boolean bandera = false;
       ArrayList<Pastel> pasteles = AppReposteria.getReposteria().getListaProductosPastel();
       while (!bandera && index < pasteles.size()) {
           if (pasteles.get(index).getId().indexOf(id) >= 0 && pasteles.get(index).isStatus()) {
               bandera = true;
               encontrado=true;
               int cantidadPersonas;
               try {
                   cantidadPersonas=Integer.parseInt(amountPersonInput.getText());
                   if (cantidadPersonas>=0) {
                       AppReposteria.getReposteria().getListaProductosPastel().get(index).setCantidadPersonas(cantidadPersonas);
                   }else {
                       Alert alert = new Alert(Alert.AlertType.INFORMATION);
                       alert.setTitle("Error");
                       alert.setContentText("Ingrese solo números positivos");
                       alert.showAndWait();
                   }
                   } catch (Exception e){
                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
                   alert.setTitle("Error");
                   alert.setContentText("Error al guardar datos, ingrese solo valores númericos"+e.getMessage());
                   alert.showAndWait();
               }
           }
           index++;
       }
       if (encontrado){
           Alert alert= new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Éxito");
           alert.setContentText("El pastel se ha editado exitosamente");
           alert.showAndWait();
       }
       else{
           Alert alert= new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Error");
           alert.setContentText("Esta ID no está dentro de la lista de pasteles, ingrese uno existente");
           alert.showAndWait();
       }
   }
    }

    @FXML
    void onClickEditDesign(MouseEvent event) {
        if (designInput.getText().trim().isEmpty() || idSearchInput.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Se requieren datos");
            alert.setContentText("Por favor complete los campos");
            alert.showAndWait();
        }else {
            String id=idSearchInput.getText();
            boolean encontrado = false;
            int index=0;
            boolean bandera = false;
            ArrayList<Pastel> pasteles = AppReposteria.getReposteria().getListaProductosPastel();
            while (!bandera && index < pasteles.size()) {
                if (pasteles.get(index).getId().indexOf(id) >= 0 && pasteles.get(index).isStatus()) {
                    bandera = true;
                    encontrado=true;
                  String desing = designInput.getText();
                    AppReposteria.getReposteria().getListaProductosPastel().get(index).setDesing(desing);
                }
                index++;
            }
            if (encontrado){
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Éxito");
                alert.setContentText("El pastel se ha editado exitosamente");
                alert.showAndWait();
            }
            else{
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Esta ID no está dentro de la lista de pasteles, ingrese uno existente");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void onClickEditName(MouseEvent event) {
        if (nameInput.getText().trim().isEmpty() || idSearchInput.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Se requieren datos");
            alert.setContentText("Por favor complete los campos");
            alert.showAndWait();
        }else {
            String id=idSearchInput.getText();
            boolean encontrado = false;
            int index=0;
            boolean bandera = false;
            ArrayList<Pastel> pasteles = AppReposteria.getReposteria().getListaProductosPastel();
            while (!bandera && index < pasteles.size()) {
                if (pasteles.get(index).getId().indexOf(id) >= 0 && pasteles.get(index).isStatus()) {
                    bandera = true;
                    encontrado=true;
                    String name = nameInput.getText();
                    AppReposteria.getReposteria().getListaProductosPastel().get(index).setNombreProducto(name);
                }
                index++;
            }
            if (encontrado){
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Éxito");
                alert.setContentText("El pastel se ha editado exitosamente");
                alert.showAndWait();
            }
            else{
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Esta ID no está dentro de la lista de cupcakes, ingrese uno existente");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void onClickEditPrice(MouseEvent event) {
        if (priceInput.getText().trim().isEmpty() || idSearchInput.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Se requieren datos");
            alert.setContentText("Por favor complete los campos");
            alert.showAndWait();
        }else {
            String id=idSearchInput.getText();
            boolean encontrado = false;
            int index=0;
            boolean bandera = false;
            ArrayList<Pastel> pasteles = AppReposteria.getReposteria().getListaProductosPastel();
            while (!bandera && index < pasteles.size()) {
                if (pasteles.get(index).getId().indexOf(id) >= 0 && pasteles.get(index).isStatus()) {
                    bandera = true;
                    encontrado=true;
                    double precio;
                    try {
                        precio= Double.parseDouble(priceInput.getText());
                        if (precio>=0) {
                            AppReposteria.getReposteria().getListaProductosPastel().get(index).setPrecio(precio);
                        }else {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Error");
                            alert.setContentText("No puede ingresar cantidades negativas");
                            alert.showAndWait();
                        }
                    }catch (Exception e){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Error");
                        alert.setContentText("Error al guardar datos, ingrese solo valores númericos"+e.getMessage());
                        alert.showAndWait();
                    }
                }
                index++;
            }
            if (encontrado){
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Éxito");
                alert.setContentText("El pastel se ha editado exitosamente");
                alert.showAndWait();
            }
            else{
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Esta ID no está dentro de la lista de pasteles, ingrese uno existente");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void onClickEditStuffed(MouseEvent event) {
        if (stuffedInput.getText().trim().isEmpty() || idSearchInput.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Se requieren datos");
            alert.setContentText("Por favor complete los campos");
            alert.showAndWait();
        }else {
            String id=idSearchInput.getText();
            boolean encontrado = false;
            int index=0;
            boolean bandera = false;
            ArrayList<Pastel> pasteles = AppReposteria.getReposteria().getListaProductosPastel();
            while (!bandera && index < pasteles.size()) {
                if (pasteles.get(index).getId().indexOf(id) >= 0 && pasteles.get(index).isStatus()) {
                    bandera = true;
                    encontrado=true;
                    String relleno = stuffedInput.getText();
                    AppReposteria.getReposteria().getListaProductosPastel().get(index).setRelleno(relleno);
                }
                index++;
            }
            if (encontrado){
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Éxito");
                alert.setContentText("El pastel se ha editado exitosamente");
                alert.showAndWait();
            }
            else{
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Esta ID no está dentro de la lista de pasteles, ingrese uno existente");
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
    void onClickIncrease(MouseEvent event) {
        if (amountInput.getText().trim().isEmpty() ||idSearchInput.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Se requieren datos");
            alert.setContentText("Por favor complete los campos");
            alert.showAndWait();
        }else {
            String id=idSearchInput.getText();
            boolean encontrado = false;
            int index = 0;
            boolean bandera = false;
            ArrayList<Pastel> pasteles = AppReposteria.getReposteria().getListaProductosPastel();
            while (!bandera && index < pasteles.size()) {
                if (pasteles.get(index).getId().indexOf(id) >= 0 && pasteles.get(index).isStatus()) {
                    bandera = true;
                    encontrado=true;
                    int cantidad;
                    try {
                        cantidad=Integer.parseInt(amountInput.getText());
                        if (cantidad>=0) {
                            AppReposteria.getReposteria().getListaProductosPastel().get(index).sumarCantidad(cantidad);
                        }else {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Error");
                            alert.setContentText("No puede ingresar cantidades negativas");
                            alert.showAndWait();
                        }
                    }catch (Exception e){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Error");
                        alert.setContentText("Error al guardar datos, ingrese solo valores númericos"+e.getMessage());
                        alert.showAndWait();
                    }
                }
                index++;
            }
            if (encontrado){
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Éxito");
                alert.setContentText("El pastel se ha editado exitosamente");
                alert.showAndWait();
            }
            else{
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Esta ID no está dentro de la lista de pasteles, ingrese uno existente");
                alert.showAndWait();
            }
        }
    }


    @FXML
    void initialize() {

    }

}
