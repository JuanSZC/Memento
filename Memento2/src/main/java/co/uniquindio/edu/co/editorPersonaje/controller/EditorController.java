package co.uniquindio.edu.co.editorPersonaje.controller;

import co.uniquindio.edu.co.editorPersonaje.model.Memento;
import co.uniquindio.edu.co.editorPersonaje.model.Originator;
import javafx.scene.paint.Color;

/**
 * La clase EditorController actúa como intermediario entre la vista y el modelo.
 * Gestiona las operaciones de modificación del personaje, delegando las acciones
 * al Originator y coordinando la creación y restauración de estados mediante Mementos.
 * 
 * @author JuanSZC
 * @version 1.0
 */
public class EditorController {
    private final Originator originator = new Originator();

    public void setSkinColor(Color color) {
        this.originator.setSkinColor(color);
    }

    public void setPowerLevel(int power) {
        this.originator.setPowerLevel(power);
    }

    public void setHealthPoints(int health) {
        this.originator.setHealthPoints(health);
    }

    public Color getSkinColor() {
        return this.originator.getSkinColor();
    }

    public int getPowerLevel() {
        return this.originator.getPowerLevel();
    }

    public int getHealthPoints() {
        return this.originator.getHealthPoints();
    }

    public Memento createMemento() {
        return this.originator.createConcreteMemento();
    }

    public void restoreFromMemento(Memento memento) {
        this.originator.undoConcreteMemento(memento);
    }
}
