package calculadora;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.time.LocalDate;

/**
 * Integrantes:
 * Juan Esteban Soto Pérez
 * Diane Ortega Soto
 * Natalia Tejada Cardona
 */
public class App extends Application {

    @Override
    // Crea la ventana con sus acciones
    public void start(Stage primaryStage) {
        // Crear DatePicker
        DatePicker datePicker = new DatePicker();

        // Crear etiqueta para mostrar la edad
        Label edadLabel = new Label("Tu edad aparecerá aquí.");

        // Crear botón para calcular la edad
        Button calcularButton = new Button("Calcular Edad");
        calcularButton.setOnAction(e -> {
            LocalDate fechaNacimiento = datePicker.getValue();
            if (fechaNacimiento != null) {
                int edad = calcularEdad(fechaNacimiento);
                edadLabel.setText("Tienes " + edad + " años.");
            } else {
                edadLabel.setText("Por favor selecciona tu fecha de nacimiento.");
            }
        });

        // Crear contenedor VBox para organizar los elementos
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(datePicker, calcularButton, edadLabel);

        // Configurar la escena y mostrar la ventana
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculadora de Edad");
        primaryStage.show();
    }

    // Método para calcular la edad a partir de la fecha de nacimiento
    private int calcularEdad(LocalDate fechaNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        int edad = fechaActual.getYear() - fechaNacimiento.getYear();
        // Ajustar la edad si aún no ha pasado el cumpleaños este año
        if (fechaNacimiento.plusYears(edad).isAfter(fechaActual)) {
            edad--;
        }

        return edad;
    }

    public static void main(String[] args) {
        launch(args);
    }
}