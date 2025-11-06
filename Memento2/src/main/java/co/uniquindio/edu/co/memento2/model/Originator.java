package co.uniquindio.edu.co.memento2.model;

import javafx.scene.paint.Color;

public class Originator {
    private Color skinColor;
    private int powerLevel;
    private int healthPoints;

    public void setSkinColor(Color color) {
        this.skinColor = color;
    }

    public void setPowerLevel(int power) {
        this.powerLevel = power;
    }

    public void setHealthPoints(int health) {
        this.healthPoints = health;
    }

    public Color getSkinColor() {
        return skinColor;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public Memento createConcreteMemento() {
        return new Memento(skinColor, powerLevel, healthPoints);
    }

    public void undoConcreteMemento(Memento memento) {
        this.skinColor = memento.getSkinColor();
        this.powerLevel = memento.getPowerLevel();
        this.healthPoints = memento.getHealthPoints();
    }
}
