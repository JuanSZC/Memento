module co.uniquindio.edu.co.editorPersonaje {
    requires javafx.controls;
    requires javafx.fxml;

    // Abrir el paquete donde están tus controllers al FXMLLoader
    opens co.uniquindio.edu.co.editorPersonaje.viewController to javafx.fxml;

    exports co.uniquindio.edu.co.editorPersonaje;
}
