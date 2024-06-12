package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UpdateSuppliesController {
    //Actualizar en la base de datos
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button editNameBtn;

    @FXML
    private Button editUnitBtn;

    @FXML
    private Button editUnitExtentBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private TextField nameInsumoInput;

    @FXML
    private TextField idSearchSupplies;

    @FXML
    private ComboBox<String> unitComboBox;

    @FXML
    private TextField unitExtentInput;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/reposteriaanita";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    private Connection connection;
    // Establecer conexión
    public UpdateSuppliesController() {
        try {

            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            if (connection != null) {
                System.out.println("Conexión exitosa a la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    @FXML
    void onClickEditName(MouseEvent event) {
        if (nameInsumoInput.getText().trim().isEmpty() || idSearchSupplies.getText().trim().isEmpty()) {
            showAlert("Error", "Por favor, rellene todos los campos");
        } else {
            String id = idSearchSupplies.getText();
            String nombre = nameInsumoInput.getText();
            try {
                System.out.println("Actualizando nombre del insumo con ID: " + id + " a " + nombre);
                //Aqui se actualiza el insumo mediante la funcion obviamente el nombre
                updateInsumoName(id, nombre);
                showAlert("Éxito", "El producto se ha editado exitosamente");
            } catch (SQLException e) {
                e.printStackTrace();  // Imprimir el stack trace de la excepción
                showAlert("Error", "Error al actualizar el nombre del insumo: " + e.getMessage());
            }
        }
    }

    @FXML
    void onClickEditUnit(MouseEvent event) {
        if (idSearchSupplies.getText().trim().isEmpty()) {
            showAlert("Error", "Por favor, no deje los campos en blanco");
        } else {
            if (unitComboBox.getValue() != null) {
                String id = idSearchSupplies.getText();
                String medida = unitComboBox.getValue();
                try {
                    System.out.println("Actualizando unidad de medida del insumo con ID: " + id + " a " + medida);
                    //Aqui se actualiza el insumo mediante la funcion obviamente la unidad
                    updateInsumoUnit(id, medida);
                    showAlert("Éxito", "La unidad de medida se ha editado con éxito");
                } catch (SQLException e) {
                    e.printStackTrace();  // Imprimir el stack trace de la excepción
                    showAlert("Error", "Error al actualizar la unidad de medida: " + e.getMessage());
                }
            } else {
                showAlert("Error", "Por favor ingrese algo en la medida");
            }
        }
    }

    @FXML
    void onClickEditUnitExtent(MouseEvent event) {
        if (unitExtentInput.getText().trim().isEmpty() || idSearchSupplies.getText().trim().isEmpty()) {
            showAlert("Error", "Por favor ingrese una cantidad");
        } else {
            String id = idSearchSupplies.getText();
            try {
                double cantidad = Double.parseDouble(unitExtentInput.getText());
                System.out.println("Actualizando cantidad del insumo con ID: " + id + " a " + cantidad);
                //Aqui se actualiza el insumo mediante la funcion obviamente la cantidad
                updateInsumoCantidad(id, cantidad);
                showAlert("Éxito", "El insumo se ha editado exitosamente");
            } catch (NumberFormatException e) {
                showAlert("Error", "Ingrese un valor numérico válido");
            } catch (SQLException e) {
                e.printStackTrace();  // Imprimir el stack trace de la excepción
                showAlert("Error", "Error al actualizar la cantidad del insumo: " + e.getMessage());
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
        unitComboBox.getItems().addAll("Kilo", "Unidad", "Litro");
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void updateInsumoName(String id, String nombre) throws SQLException {
        //y esto se utiliza y se ordena en funciones para editar lo que queremos donde esta el id correspondiente
        String sql = "UPDATE supplies SET name = ? WHERE idsupplies = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, id);
            int rowsAffected = statement.executeUpdate();
            System.out.println("Filas afectadas: " + rowsAffected);
        }
    }

    private void updateInsumoUnit(String id, String unidadMedida) throws SQLException {
        //y esto se utiliza y se ordena en funciones para editar lo que queremos donde esta el id correspondiente
        String sql = "UPDATE supplies SET unit = ? WHERE idsupplies = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, unidadMedida);
            statement.setString(2, id);
            int rowsAffected = statement.executeUpdate();
            System.out.println("Filas afectadas: " + rowsAffected);
        }
    }

    private void updateInsumoCantidad(String id, double cantidad) throws SQLException {
        //y esto se utiliza y se ordena en funciones para editar lo que queremos donde esta el id correspondiente
        String sql = "UPDATE supplies SET amount = ? WHERE idsupplies = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, cantidad);
            statement.setString(2, id);
            int rowsAffected = statement.executeUpdate();
            System.out.println("Filas afectadas: " + rowsAffected);
        }
    }
}
