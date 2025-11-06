package co.uniquindio.edu.co.editorPersonaje.model;

import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

/**
 * La clase Caretaker gestiona el historial de estados del personaje.
 * Mantiene una pila de objetos Memento, permitiendo operaciones de deshacer
 * y mantiene un historial de cambios que pueden ser consultados.
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
        return null;
    }

    public List<Memento> getHistory() {
        List<Memento> history = new ArrayList<>(listMementos);
        // Invertimos la lista para mostrar el más reciente primero
        java.util.Collections.reverse(history);
        return history;
    }
}
