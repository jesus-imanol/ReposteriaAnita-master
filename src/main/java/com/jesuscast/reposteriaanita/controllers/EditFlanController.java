package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jesuscast.reposteriaanita.AppReposteria;
import com.jesuscast.reposteriaanita.models.Carlota;
import com.jesuscast.reposteriaanita.models.Cupcake;
import com.jesuscast.reposteriaanita.models.Flan;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EditFlanController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField amountInput;
    @FXML
    private Button decreaseBtn;

    @FXML
    private Button design;

    @FXML
    private TextField designInput;

    @FXML
    private Button editNameBtn;

    @FXML
    private Button editSize;

    @FXML
    private ImageView exitImage;

    @FXML
    private TextField idSearchInput;

    @FXML
    private Button increaseBtn;

    @FXML
    private TextField nameInput;

    @FXML
    private Button priceEditBtn;

    @FXML
    private TextField priceInput;

    @FXML
    private ComboBox<String> sizeComboBox;
    @FXML
    void onClickEditAmountPeople(MouseEvent event) {

    }
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
            ArrayList<Flan> flans = AppReposteria.getReposteria().getListaProductosFlan();
            while (!bandera && index < flans.size()) {
                if (flans.get(index).getId().indexOf(id) >= 0 && flans.get(index).isStatus()) {
                    bandera = true;
                    encontrado=true;
                    int cantidad;
                    try {
                        cantidad=Integer.parseInt(amountInput.getText());
                        if (cantidad>=0) {
                            if (AppReposteria.getReposteria().getListaProductosFlan().get(index).restarCantidad(cantidad)) {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Éxito");
                                alert.setContentText("El flan se ha editado exitosamente");
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
                alert.setContentText("Esta ID no está dentro de la lista de flans, ingrese uno existente");
                alert.showAndWait();
            }
        }
    }
    @FXML
    void onClickEditDesign(MouseEvent event) {
        if (design.getText().trim().isEmpty() ||idSearchInput.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Se requieren datos");
            alert.setContentText("Por favor complete los campos");
            alert.showAndWait();
        }else {
            String id=idSearchInput.getText();
            boolean encontrado = false;
            int index = 0;
            boolean bandera = false;
            ArrayList<Flan> flans = AppReposteria.getReposteria().getListaProductosFlan();
            while (!bandera && index < flans.size()) {
                if (flans.get(index).getId().indexOf(id) >= 0 && flans.get(index).isStatus()) {
                    bandera = true;
                    encontrado=true;
                   String desing = designInput.getText();
                   AppReposteria.getReposteria().getListaProductosFlan().get(index).setDesing(desing);
                }
                index++;
            }
            if (!encontrado){
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Esta ID no está dentro de la lista de flans, ingrese uno existente");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void onClickEditName(MouseEvent event) {
        if (nameInput.getText().trim().isEmpty() ||idSearchInput.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Se requieren datos");
            alert.setContentText("Por favor complete los campos");
            alert.showAndWait();
        }else {
            String id=idSearchInput.getText();
            boolean encontrado = false;
            int index = 0;
            boolean bandera = false;
            ArrayList<Flan> flans = AppReposteria.getReposteria().getListaProductosFlan();
            while (!bandera && index < flans.size()) {
                if (flans.get(index).getId().indexOf(id) >= 0 && flans.get(index).isStatus()) {
                    bandera = true;
                    encontrado=true;
                    String name = nameInput.getText();
                    AppReposteria.getReposteria().getListaProductosFlan().get(index).setNombreProducto(name);
                }
                index++;
            }
            if (!encontrado){
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Esta ID no está dentro de la lista de flans, ingrese uno existente");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void onClickEditPrice(MouseEvent event) {
        if (nameInput.getText().trim().isEmpty() ||idSearchInput.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Se requieren datos");
            alert.setContentText("Por favor complete los campos");
            alert.showAndWait();
        }else {
            String id=idSearchInput.getText();
            boolean encontrado = false;
            int index = 0;
            boolean bandera = false;
            ArrayList<Flan> flans = AppReposteria.getReposteria().getListaProductosFlan();
            while (!bandera && index < flans.size()) {
                if (flans.get(index).getId().indexOf(id) >= 0 && flans.get(index).isStatus()) {
                    bandera = true;
                    encontrado=true;
                    double precio;
                    try {
                        precio=Double.parseDouble(priceInput.getText());
                        if (precio>=0){
                            AppReposteria.getReposteria().getListaProductosFlan().get(index).setPrecio(precio);
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
            if (!encontrado){
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Esta ID no está dentro de la lista de flans, ingrese uno existente");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void onClickEditSize(MouseEvent event) {
        if (sizeComboBox.getValue().trim().isEmpty() ||idSearchInput.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Se requieren datos");
            alert.setContentText("Por favor complete los campos");
            alert.showAndWait();
        }else {
            String id=idSearchInput.getText();
            boolean encontrado = false;
            int index = 0;
            boolean bandera = false;
            ArrayList<Flan> flans = AppReposteria.getReposteria().getListaProductosFlan();
            while (!bandera && index < flans.size()) {
                if (flans.get(index).getId().indexOf(id) >= 0 && flans.get(index).isStatus()) {
                    bandera = true;
                    encontrado=true;
                    String size =sizeComboBox.getValue();
                    AppReposteria.getReposteria().getListaProductosFlan().get(index).setSize(size);
                    Alert alert= new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Éxito");
                    alert.setContentText("El flan se ha editado exitosamente");
                    alert.showAndWait();
                }
                index++;
            }
            if (!encontrado){
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Esta ID no está dentro de la lista de flans, ingrese uno existente");
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
            ArrayList<Flan> flans = AppReposteria.getReposteria().getListaProductosFlan();
            while (!bandera && index < flans.size()) {
                if (flans.get(index).getId().indexOf(id) >= 0 && flans.get(index).isStatus()) {
                    bandera = true;
                    encontrado=true;
                    int cantidad;
                    try {
                        cantidad=Integer.parseInt(amountInput.getText());
                        if (cantidad>=0) {
                            AppReposteria.getReposteria().getListaProductosFlan().get(index).sumarCantidad(cantidad);
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
                alert.setContentText("El flan se ha editado exitosamente");
                alert.showAndWait();
            }
            else{
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Esta ID no está dentro de la lista de flans, ingrese uno existente");
                alert.showAndWait();
            }
        }
    }


    @FXML
    void initialize() {
           sizeComboBox.getItems().addAll("Mediano", "Grande");
    }

}
