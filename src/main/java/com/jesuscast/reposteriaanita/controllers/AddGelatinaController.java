package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jesuscast.reposteriaanita.AppReposteria;
import com.jesuscast.reposteriaanita.models.Gelatina;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddGelatinaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView addProductImage;

    @FXML
    private TextField amountInput;

    @FXML
    private ImageView exitImage;

    @FXML
    private TextField nameInput;

    @FXML
    private TextField priceInput;
    //nuevos combos box
    @FXML
    private ComboBox<String> sizeComboBox;

    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    void onClickAddProduct(MouseEvent event) {
        AppReposteria.animateImage(addProductImage);
        if (amountInput.getText().trim().isEmpty() ||
                nameInput.getText().trim().isEmpty() ||
                priceInput.getText().trim().isEmpty() ||
                sizeComboBox.getValue().trim().isEmpty() ||
                typeComboBox.getValue().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Se requieren datos");
            alert.setContentText("Por favor complete los campos");
            alert.showAndWait();
        }
        //Somer aqui agregaras el producto
        else {
            String nombre = nameInput.getText();
            String size = sizeComboBox.getValue();
            String tipo = typeComboBox.getValue();
            int cantidad;
            double precio;
            try{
                cantidad= Integer.parseInt(amountInput.getText());
                precio = Double.parseDouble(priceInput.getText());
                if (cantidad>=0 && precio>=0) {
                    Gelatina gelatina = new Gelatina(nombre, cantidad, precio, size, tipo);
                    if (AppReposteria.getReposteria().addGelatina(gelatina)) {
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
            catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Error al guardar datos, ingrese solo valores númericos"+e.getMessage());
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
        sizeComboBox.getItems().addAll("Mediano", "Grande");
        typeComboBox.getItems().addAll("De vaso", "Completa(tipo pastel)");
        AppReposteria.addValidator(amountInput);
        AppReposteria.addValidator(nameInput);
        AppReposteria.addValidator(priceInput);
    }

}
