package co.uniquindio.edu.co.editorTexto.model;

import java.util.Stack;

/**
 * La clase Caretaker gestiona el historial de estados del editor.
 * Mantiene una pila de objetos Memento, permitiendo operaciones de deshacer
 * mediante el almacenamiento y recuperación de estados previos del editor.
 * 
 * @author JuanSZC
 * @version 1.0
 */
public class Caretaker {

    private final Stack<Memento> listMementos = new Stack<>();

    public void save(Memento memento) {
        listMementos.push(memento);
    }

    public Memento undo() {
        if (!listMementos.isEmpty()) {
            return listMementos.pop();
        }
        else {
            listMementos.push(new Memento(""));
        }

        return null;
    }
}
