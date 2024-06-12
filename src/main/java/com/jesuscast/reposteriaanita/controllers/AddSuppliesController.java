package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddSuppliesController {
   //Agregar insumos a la base datos
    @FXML
    private Button addSuppliesBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private TextField nameInsumoInput;

    @FXML
    private ComboBox<String> unitComboBox;

    @FXML
    private TextField amountInput;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/reposteriaanita";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    private Connection connection;
    //Este es el apartado donde se hizo la conexion a la base datos
    public AddSuppliesController() {
        try {
            // Establecer conexión
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            if (connection != null) {
                System.out.println("Conexión exitosa a la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    @FXML
    void onClickAddSupplies(MouseEvent event) {
        if (nameInsumoInput.getText().trim().isEmpty() ||
                amountInput.getText().trim().isEmpty() ||
                unitComboBox.getValue() == null) {
            showAlert("Se requieren datos", "Por favor complete los campos");
        } else {
            String nombre = nameInsumoInput.getText();
            String unidadMedida = unitComboBox.getValue();
            try {
                switch (unidadMedida) {
                    case "Kilo":
                    case "Litro":
                        double cantidad = Double.parseDouble(amountInput.getText());
                        if (cantidad >= 0) {
                            //Aqui se hizo lo que es el agregar insumo a la base de datos pero por kilo y litro
                            insertInsumo(nombre, unidadMedida, cantidad);
                        } else {
                            showAlert("Error", "No puede ingresar cantidades negativas");
                        }
                        break;
                    case "Unidad":
                        String amountText = amountInput.getText();
                        if (!amountText.isEmpty()) {
                            try {
                                int amount = Integer.parseInt(amountText);
                                if (amount >= 0) {
                                    //Aqui se hizo lo de agregar por unidad
                                    insertInsumo(nombre, unidadMedida, amount);
                                } else {
                                    showAlert("Error", "No puede ingresar cantidades negativas");
                                }
                            } catch (NumberFormatException e) {
                                showAlert("Error", "Ingrese un valor numérico válido");
                            }
                        } else {
                            showAlert("Error", "El campo de cantidad está vacío");
                        }
                        break;
                }
            } catch (Exception e) {
                showAlert("Error", "Error al guardar datos, ingrese solo valores numéricos: " + e.getMessage());
            }
        }
    }
        //Esta es la funcion que se utilizo para agregar a la base de datos
    private void insertInsumo(String nombre, String unidadMedida, double cantidad) throws SQLException {
        String sql = "INSERT INTO supplies (name, unit, amount) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, unidadMedida);
            statement.setDouble(3, cantidad);
            // Ejecutar la consulta
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                showAlert("Éxito", "Guardado exitosamente");
            } else {
                System.out.println("Algo malo pasó");
            }
        }
    }

    @FXML
    void onClickExit(MouseEvent event) {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
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
}
