package co.uniquindio.edu.co.memento1.model;

import java.util.Stack;

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
