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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DeleteSuppliesController {
    //Eliminar en la base de datos
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exitBtn;

    @FXML
    private TextField idSearchSupplies;

    @FXML
    private Button deleteSuppliesBtn;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/reposteriaanita";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    private Connection connection;

    public DeleteSuppliesController() {
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
    void onClickExit(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void onClickDeleteSupplies(MouseEvent event) {
        if (idSearchSupplies.getText().trim().isEmpty()){
            showAlert("Error", "Por favor ingrese una ID");
        }
        else {
            String id = idSearchSupplies.getText();
            try {
                //En esta parte se elimina el insumo pasandole como parametro el id
                if (deleteInsumoById(id)) {
                    showAlert("Éxito", "Insumo eliminado con éxito");
                } else {
                    showAlert("Error", "No existe ningún producto con esta ID");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                showAlert("Error", "Error al eliminar el insumo: " + e.getMessage());
            }
        }
    }

    @FXML
    void initialize() {
        // Any necessary initialization here
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private boolean deleteInsumoById(String id) throws SQLException {
        //Esta parte esta muy clara solo le pasamos el id, de donde queremos eliminar
        String sql = "DELETE FROM supplies WHERE idsupplies = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
    }
}
