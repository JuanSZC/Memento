package co.uniquindio.edu.co.editorTexto.controller;

import co.uniquindio.edu.co.editorTexto.model.Memento;
import co.uniquindio.edu.co.editorTexto.model.Originator;

/**
 * La clase EditorController actúa como puente entre la vista y el modelo.
 * Delega las operaciones de edición de texto al Originator y gestiona
 * la creación y restauración de objetos Memento.
 * 
 * @author JuanSZC
 * @version 1.0
 */
public class EditorController {
    Originator originator = new Originator();


    public void setTexto(String Texto) {
        this.originator.setTexto(Texto);
    }
    public void mostrarTexto() {
        this.originator.mostrarTexto();
    }
    public void createMemento(Memento memento) {
        this.originator.createConcreteMemento();
    }
    public void undoMemento(Memento memento) {
        this.originator.undoConcreteMemento(memento);
    }
}
