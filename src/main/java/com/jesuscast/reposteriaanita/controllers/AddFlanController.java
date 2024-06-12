package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jesuscast.reposteriaanita.AppReposteria;
import com.jesuscast.reposteriaanita.models.Flan;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddFlanController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView addProductImage;

    @FXML
    private TextField amountInput;

    @FXML
    private TextField amountPersonInput;

    @FXML
    private TextField designInput;

    @FXML
    private ImageView exitImage;
    //Este es para el tamaño del flan
    @FXML
    private ComboBox<String> sizeComboBox;

    @FXML
    private TextField nameInput;

    @FXML
    private TextField priceInput;

    @FXML
    void onClickAddProduct(MouseEvent event) {
        AppReposteria.animateImage(addProductImage);
        if (amountInput.getText().trim().isEmpty() ||
                nameInput.getText().trim().isEmpty() ||
                priceInput.getText().trim().isEmpty() || designInput.getText().isEmpty() ||
                amountPersonInput.getText().isEmpty() || sizeComboBox.getValue().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Se requieren datos");
            alert.setContentText("Por favor complete los campos");
            alert.showAndWait();
        }
        //Somer aqui agregaras el producto
        else {
          String nombre=nameInput.getText();
          String desing = designInput.getText();
          String size= sizeComboBox.getValue();
          int cantidad;
          double precio;
          try {
              cantidad=Integer.parseInt(amountInput.getText());
              precio=Double.parseDouble(priceInput.getText());
              if (cantidad >=0 && precio >=0) {
                  Flan flan = new Flan(nombre, cantidad, precio,desing, size);
                  if (AppReposteria.getReposteria().addFlan(flan)) {
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
        AppReposteria.addValidator(amountInput);
        AppReposteria.addValidator(designInput);
        AppReposteria.addValidator(nameInput);
        AppReposteria.addValidator(priceInput);
    }

}
