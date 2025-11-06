package co.uniquindio.edu.co.editorTexto.viewController;

import co.uniquindio.edu.co.editorTexto.App;
import co.uniquindio.edu.co.editorTexto.controller.EditorController;
import co.uniquindio.edu.co.editorTexto.model.Caretaker;
import co.uniquindio.edu.co.editorTexto.model.Memento;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * La clase EditorViewController maneja las interacciones de la interfaz de usuario
 * para el editor de texto. Gestiona el componente de área de texto y coordina
 * con el EditorController para implementar la funcionalidad de deshacer usando el
 * patrón Memento.
 * 
 * @author JuanSZC
 * @version 1.0
 */
public class EditorViewController {
    private EditorController editorController = new EditorController();
    private App app;
    private Caretaker caretaker= new Caretaker();

    @FXML
    private TextArea text;

    public void setApp(App app) {
        this.app = app;
    }

    public void setEditorController(EditorController editorController) {
        this.editorController = editorController;
    }

    public void setCaretaker(Caretaker caretaker) {
        this.caretaker = caretaker;
    }

    @FXML
    public void guardar() {
        String textoActual = text.getText();
        editorController.setTexto(textoActual);
        Memento memento = new Memento(textoActual);
        caretaker.save(memento);
    }

    @FXML
    public void deshacer() {
        Memento memento = caretaker.undo();
        if (memento != null) {
            String texto = memento.getTexto();
            editorController.setTexto(texto);
            text.setText(texto);
        }
        else  {
            text.setText("");
            guardar();
        }
    }
    public void initialize(){
        guardar();
    }

}
