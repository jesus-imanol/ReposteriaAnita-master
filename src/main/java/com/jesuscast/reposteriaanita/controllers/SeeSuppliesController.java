package com.jesuscast.reposteriaanita.controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jesuscast.reposteriaanita.models.Insumo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SeeSuppliesController {
    //Ver insumos aplicando lo de base datos
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Insumo, String> amountSuppliesColumn;

    @FXML
    private AnchorPane container;

    @FXML
    private Button exitBtn;

    @FXML
    private TableColumn<Insumo, String> nameSuppliesColumn;

    @FXML
    private TableView<Insumo> tableSupplies;

    @FXML
    private Label titleLabel;

    @FXML
    private Label titleLabel1;

    @FXML
    private TableColumn<Insumo, String> unitSuppliesColumn;

    private ObservableList<Insumo> insumos;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/reposteriaanita";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    private Connection connection;
    // Establecer conexión a la base de datos
    public SeeSuppliesController() {
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
    void onClickExitBtn(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        insumos = FXCollections.observableArrayList();

        // Obtener datos de la base de datos y agregarlos a la lista de insumos
        loadDataFromDatabase();

        this.nameSuppliesColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.unitSuppliesColumn.setCellValueFactory(new PropertyValueFactory<>("unidadMedida"));

        tableSupplies.setItems(insumos);
    }
    //Esto es para cargar lo que hay en la base de datos, y mostrarla en la tabla
    private void loadDataFromDatabase() {
        //con esto se puede ver lo que hay en la base de datos
        String sql = "SELECT idsupplies, name, unit, amount FROM supplies";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String nombre = resultSet.getString("name");
                String unidadMedida = resultSet.getString("unit");
                Insumo insumo = new Insumo(nombre, unidadMedida);
                insumos.add(insumo);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de la base de datos: " + e.getMessage());
        }
    }
}
