package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jesuscast.reposteriaanita.AppReposteria;
import com.jesuscast.reposteriaanita.models.Carlota;
import com.jesuscast.reposteriaanita.models.Flan;
import com.jesuscast.reposteriaanita.models.Gelatina;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EditGelatinaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField amountInput;

    @FXML
    private Button decreaseBtn;

    @FXML
    private Button editNameBtn;

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
    private Button sizeEditBtn;

    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    private Button typeEditBtn;

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
            ArrayList<Gelatina> gelatinas = AppReposteria.getReposteria().getListaProductosGelatina();
            while (!bandera && index < gelatinas.size()) {
                if (gelatinas.get(index).getId().indexOf(id) >= 0 && gelatinas.get(index).isStatus()) {
                    bandera = true;
                    encontrado=true;
                    int cantidad;
                    try {
                        cantidad=Integer.parseInt(amountInput.getText());
                        if (cantidad>=0) {
                            if (AppReposteria.getReposteria().getListaProductosGelatina().get(index).restarCantidad(cantidad)) {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Éxito");
                                alert.setContentText("La gelatina se ha editado exitosamente");
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
                alert.setContentText("Esta ID no está dentro de la lista de gelatinas, ingrese uno existente");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void onClickEditSize(MouseEvent event) {
        if (typeComboBox.getValue().trim().isEmpty() || idSearchInput.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Se requieren datos");
            alert.setContentText("Por favor complete los campos");
            alert.showAndWait();
        }else {
            String id=idSearchInput.getText();
            boolean encontrado = false;
            int index=0;
            boolean bandera = false;
            ArrayList<Gelatina> gelatinas = AppReposteria.getReposteria().getListaProductosGelatina();
            while (!bandera && index < gelatinas.size()) {
                if (gelatinas.get(index).getId().indexOf(id) >= 0 && gelatinas.get(index).isStatus()) {
                    bandera = true;
                    encontrado=true;
                    String tipo = typeComboBox.getValue();
                    AppReposteria.getReposteria().getListaProductosGelatina().get(index).setTipo(tipo);
                }
                index++;
            }
            if (encontrado){
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Éxito");
                alert.setContentText("La gelatina se ha editado exitosamente");
                alert.showAndWait();
            }
            else{
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Esta ID no está dentro de la lista de gelatinas, ingrese uno existente");
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
            ArrayList<Gelatina> gelatinas = AppReposteria.getReposteria().getListaProductosGelatina();
            while (!bandera && index < gelatinas.size()) {
                if (gelatinas.get(index).getId().indexOf(id) >= 0 && gelatinas.get(index).isStatus()) {
                    bandera = true;
                    encontrado=true;
                    String name = nameInput.getText();
                    AppReposteria.getReposteria().getListaProductosGelatina().get(index).setNombreProducto(name);
                    Alert alert= new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Éxito");
                    alert.setContentText("El cupcake se ha editado exitosamente");
                    alert.showAndWait();
                }
                index++;
            }
            if (!encontrado){
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Esta ID no está dentro de la lista de gelatinas, ingrese uno existente");
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
            ArrayList<Gelatina> gelatinas = AppReposteria.getReposteria().getListaProductosGelatina();
            while (!bandera && index < gelatinas.size()) {
                if (gelatinas.get(index).getId().indexOf(id) >= 0 && gelatinas.get(index).isStatus()) {
                    bandera = true;
                    encontrado=true;
                    double precio;
                    try {
                        precio=Double.parseDouble(priceInput.getText());
                        if (precio>=0){
                            AppReposteria.getReposteria().getListaProductosGelatina().get(index).setPrecio(precio);
                            Alert alert= new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Éxito");
                            alert.setContentText("El cupcake se ha editado exitosamente");
                            alert.showAndWait();
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
    void onClickEditType(MouseEvent event) {
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
            ArrayList<Gelatina> gelatinas = AppReposteria.getReposteria().getListaProductosGelatina();
            while (!bandera && index < gelatinas.size()) {
                if (gelatinas.get(index).getId().indexOf(id) >= 0 && gelatinas.get(index).isStatus()) {
                    bandera = true;
                    encontrado=true;
                    String size =sizeComboBox.getValue();
                    AppReposteria.getReposteria().getListaProductosGelatina().get(index).setSize(size);
                    Alert alert= new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Éxito");
                    alert.setContentText("La gelatina se ha editado exitosamente");
                    alert.showAndWait();
                }
                index++;
            }
            if (!encontrado){
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Esta ID no está dentro de la lista de gelatinas, ingrese uno existente");
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
            ArrayList<Gelatina> gelatinas = AppReposteria.getReposteria().getListaProductosGelatina();
            while (!bandera && index < gelatinas.size()) {
                if (gelatinas.get(index).getId().indexOf(id) >= 0 && gelatinas.get(index).isStatus()) {
                    bandera = true;
                    encontrado=true;
                    int cantidad;
                    try {
                        cantidad=Integer.parseInt(amountInput.getText());
                        if (cantidad>=0) {
                            AppReposteria.getReposteria().getListaProductosGelatina().get(index).sumarCantidad(cantidad);
                            Alert alert= new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Éxito");
                            alert.setContentText("El cupcake se ha editado exitosamente");
                            alert.showAndWait();
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
                alert.setContentText("La gelatina se ha editado exitosamente");
                alert.showAndWait();
            }
            else{
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Esta ID no está dentro de la lista de gelatinas, ingrese uno existente");
                alert.showAndWait();
            }
        }
    }


    @FXML
    void initialize() {
    sizeComboBox.getItems().addAll("Mediano", "Grande");
    typeComboBox.getItems().addAll("De vaso", "Entero (tipo pastel)");
    }

}

