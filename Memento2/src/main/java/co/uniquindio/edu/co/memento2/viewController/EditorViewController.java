package co.uniquindio.edu.co.memento2.viewController;

import co.uniquindio.edu.co.memento2.App;
import co.uniquindio.edu.co.memento2.controller.EditorController;
import co.uniquindio.edu.co.memento2.model.Caretaker;
import co.uniquindio.edu.co.memento2.model.Memento;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.collections.FXCollections;

public class EditorViewController {
    private final EditorController editorController = new EditorController();
    private final Caretaker caretaker = new Caretaker();
App app;
    @FXML private ColorPicker skinColorPicker;
    @FXML private ComboBox<Integer> powerComboBox;
    @FXML private ComboBox<Integer> healthComboBox;
    @FXML private Rectangle characterBody;
    @FXML private ListView<Memento> characterHistory;

    public void setApp(App app) {
        this.app = app;
    }
    public void initialize() {
        // Inicializar color por defecto
        skinColorPicker.setValue(Color.WHITE);
        characterBody.setFill(Color.WHITE);
        
        // Configurar ComboBox de poder (niveles del 1 al 10)
        powerComboBox.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        powerComboBox.setValue(1);
        
        // Configurar ComboBox de vida (100, 200, 300, ..., 1000)
        healthComboBox.setItems(FXCollections.observableArrayList(
            100, 200, 300, 400, 500, 600, 700, 800, 900, 1000
        ));
        healthComboBox.setValue(100);
        
        // Configurar color picker para actualizar la vista
        skinColorPicker.setOnAction(e -> updateCharacterView());
        
        setupCharacterHistoryListView();
    }

    private void updateCharacterView() {
        characterBody.setFill(skinColorPicker.getValue());
    }

    private void setupCharacterHistoryListView() {
        characterHistory.setCellFactory(param -> new ListCell<>() {
            private final Rectangle miniCharacter = new Rectangle(30, 45);
            private final Label statsLabel = new Label();
            private final HBox content = new HBox(10);

            {
                content.setAlignment(Pos.CENTER_LEFT);
                content.getChildren().addAll(miniCharacter, statsLabel);
            }

            @Override
            protected void updateItem(Memento item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    miniCharacter.setFill(item.getSkinColor());
                    statsLabel.setText(String.format(
                        "Poder: %d | Vida: %d",
                        item.getPowerLevel(),
                        item.getHealthPoints()
                    ));
                    setGraphic(content);
                }
            }
        });
    }

    private void updateCharacterHistory() {
        characterHistory.getItems().clear();
        characterHistory.getItems().addAll(caretaker.getHistory());
    }

    @FXML
    public void saveCharacter() {
        editorController.setSkinColor(skinColorPicker.getValue());
        editorController.setPowerLevel(powerComboBox.getValue());
        editorController.setHealthPoints(healthComboBox.getValue());
        
        Memento memento = editorController.createMemento();
        caretaker.save(memento);
        updateCharacterHistory();
    }

    @FXML
    public void undo() {
        Memento memento = caretaker.undo();
        if (memento != null) {
            editorController.restoreFromMemento(memento);
            
            skinColorPicker.setValue(memento.getSkinColor());
            powerComboBox.setValue(memento.getPowerLevel());
            healthComboBox.setValue(memento.getHealthPoints());
            
            updateCharacterView();
            updateCharacterHistory();
        }
    }


}
