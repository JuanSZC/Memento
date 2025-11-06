package co.uniquindio.edu.co.memento1;

import co.uniquindio.edu.co.memento1.viewController.EditorViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private Stage stage;

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception {

            this.stage = primaryStage;
            primaryStage.setTitle("Memento Ejemplo 1");
            openEditor();

    }

    public void openEditor() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/uniquindio/edu/co/memento1/editor.fxml"));
            AnchorPane rootLayout = loader.load();

            EditorViewController editor = loader.getController();
            editor.setApp(this);

            Scene scene = new Scene(rootLayout);

            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();

            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



}
