package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jesuscast.reposteriaanita.AppReposteria;
import com.jesuscast.reposteriaanita.models.Carlota;
import com.jesuscast.reposteriaanita.models.Cupcake;
import com.jesuscast.reposteriaanita.models.Pastel;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EditCupCakeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView addProductImage;

    @FXML
    private TextField amountInput;

    @FXML
    private Button decreaseBtn;

    @FXML
    private Button designEditBtn;

    @FXML
    private TextField designInput;

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
            ArrayList<Cupcake> cupcakes = AppReposteria.getReposteria().getListaProductosCupcake();
            while (!bandera && index < cupcakes.size()) {
                if (cupcakes.get(index).getId().indexOf(id) >= 0 && cupcakes.get(index).isStatus()) {
                    bandera = true;
                    encontrado=true;
                    int cantidad;
                    try {
                        cantidad=Integer.parseInt(amountInput.getText());
                        if (cantidad>=0) {
                            if (AppReposteria.getReposteria().getListaProductosCupcake().get(index).restarCantidad(cantidad)) {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Éxito");
                                alert.setContentText("El cupcake se ha editado exitosamente");
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
                alert.setContentText("Esta ID no está dentro de la lista de cupcakes, ingrese uno existente");
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
            ArrayList<Cupcake> cupcakes = AppReposteria.getReposteria().getListaProductosCupcake();
            while (!bandera && index < cupcakes.size()) {
                if (cupcakes.get(index).getId().indexOf(id) >= 0 && cupcakes.get(index).isStatus()) {
                    bandera = true;
                    encontrado=true;
                    String desing = designInput.getText();
                    AppReposteria.getReposteria().getListaProductosCupcake().get(index).setDesing(desing);
                }
                index++;
            }
            if (encontrado){
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Éxito");
                alert.setContentText("El cupcake se ha editado exitosamente");
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
            ArrayList<Cupcake> cupcakes = AppReposteria.getReposteria().getListaProductosCupcake();
            while (!bandera && index < cupcakes.size()) {
                if (cupcakes.get(index).getId().indexOf(id) >= 0 && cupcakes.get(index).isStatus()) {
                    bandera = true;
                    encontrado=true;
                    String name = nameInput.getText();
                    AppReposteria.getReposteria().getListaProductosCupcake().get(index).setNombreProducto(name);
                }
                index++;
            }
            if (encontrado){
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Éxito");
                alert.setContentText("El cupcake se ha editado exitosamente");
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
            ArrayList<Cupcake> cupcakes = AppReposteria.getReposteria().getListaProductosCupcake();
            while (!bandera && index < cupcakes.size()) {
                if (cupcakes.get(index).getId().indexOf(id) >= 0 && cupcakes.get(index).isStatus()) {
                    bandera = true;
                    encontrado=true;
                    double precio;
                    try {
                        precio= Double.parseDouble(priceInput.getText());
                        if (precio>=0) {
                            AppReposteria.getReposteria().getListaProductosCupcake().get(index).setPrecio(precio);
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
                alert.setContentText("El cupcake se ha editado exitosamente");
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
    void onClickEditSuffed(MouseEvent event) {
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
            ArrayList<Cupcake> cupcakes = AppReposteria.getReposteria().getListaProductosCupcake();
            while (!bandera && index < cupcakes.size()) {
                if (cupcakes.get(index).getId().indexOf(id) >= 0 && cupcakes.get(index).isStatus()) {
                    bandera = true;
                    encontrado=true;
                    String relleno = stuffedInput.getText();
                    AppReposteria.getReposteria().getListaProductosCupcake().get(index).setRelleno(relleno);
                }
                index++;
            }
            if (encontrado){
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Éxito");
                alert.setContentText("El cupcake se ha editado exitosamente");
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
            ArrayList<Cupcake> cupcakes = AppReposteria.getReposteria().getListaProductosCupcake();
            while (!bandera && index < cupcakes.size()) {
                if (cupcakes.get(index).getId().indexOf(id) >= 0 && cupcakes.get(index).isStatus()) {
                    bandera = true;
                    encontrado=true;
                    int cantidad;
                    try {
                        cantidad=Integer.parseInt(amountInput.getText());
                        if (cantidad>=0) {
                            AppReposteria.getReposteria().getListaProductosCupcake().get(index).sumarCantidad(cantidad);
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
                alert.setContentText("El cupcake se ha editado exitosamente");
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
    void initialize() {

    }

}
