package co.uniquindio.edu.co.memento1.controller;

import co.uniquindio.edu.co.memento1.model.Memento;
import co.uniquindio.edu.co.memento1.model.Originator;

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
