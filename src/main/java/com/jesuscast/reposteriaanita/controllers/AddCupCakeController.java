package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jesuscast.reposteriaanita.AppReposteria;
import com.jesuscast.reposteriaanita.models.Cupcake;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddCupCakeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView addProductImage;

    @FXML
    private TextField amountInput;

    @FXML
    private TextField designInput;

    @FXML
    private ImageView exitImage;

    @FXML
    private TextField nameInput;

    @FXML
    private TextField priceInput;

    @FXML
    private TextField stuffedInput;


    @FXML
    void onClickAddProduct(MouseEvent event) {
        AppReposteria.animateImage(addProductImage);
        if (amountInput.getText().trim().isEmpty() ||
                nameInput.getText().trim().isEmpty() ||
                priceInput.getText().trim().isEmpty() ||
               designInput.getText().isEmpty() || stuffedInput.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Se requieren datos");
            alert.setContentText("Por favor complete los campos");
            alert.showAndWait();
        } else {
        String nombre = nameInput.getText();
        String relleno = stuffedInput.getText();
        String desing = designInput.getText();
        int cantidad;
        double precio;
        try {
            cantidad = Integer.parseInt(amountInput.getText());
            precio=Double.parseDouble(priceInput.getText());
            if (cantidad>=0 && precio>=0) {
                Cupcake cupcake = new Cupcake(nombre, cantidad, precio,relleno, desing);
                if (AppReposteria.getReposteria().addCupcake(cupcake)) {
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
        AppReposteria.addValidator(amountInput);
        AppReposteria.addValidator(priceInput);
        AppReposteria.addValidator(nameInput);
        AppReposteria.addValidator(designInput);
        AppReposteria.addValidator(stuffedInput);
    }

}
