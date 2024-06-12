package com.jesuscast.reposteriaanita;

import com.jesuscast.reposteriaanita.models.ReporteVenta;
import com.jesuscast.reposteriaanita.models.Reposteria;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
public class AppReposteria extends javafx.application.Application {
    private static Reposteria reposteria = new Reposteria();
    private static ReporteVenta reporteVenta = new ReporteVenta();
    public static Reposteria getReposteria() {
        return reposteria;
    }
    public static ReporteVenta getReporteVenta(){
        return reporteVenta;
    }
    private static Stage stageView;
    private static Stage stageRoot;

    @Override
    public void start(Stage stage) throws IOException {
        stageRoot = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(AppReposteria.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setTitle("Login - Reposteria");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public static void newStage(String fxml, String title) {
        stageView = new Stage();
        Scene scene = null;
        try {
            scene = new Scene(loadFXML(fxml));
            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
            stageView.setTitle(title);
            stageView.setScene(scene);
            stageView.centerOnScreen();
            stageView.initOwner(stageRoot);
            stageView.initModality(Modality.APPLICATION_MODAL);
            stageView.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Stage getStageView(){
        return stageView;
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppReposteria.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
        System.exit(1);
    }
    public static void addValidator(TextField field) {
        field.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.trim().isEmpty()) {
                    field.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                } else {
                    field.setStyle("");
                }
            }
        });
    }
    public static void animateImage(ImageView image) {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.25), image);
        transition.setToY(-50);
        transition.setCycleCount(2);
        transition.setAutoReverse(true);
        transition.play();
    }
    public static void animateButton(Button button) {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.25), button);
        transition.setToY(-50);
        transition.setCycleCount(2);
        transition.setAutoReverse(true);
        transition.play();
    }
}