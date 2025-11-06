package co.uniquindio.edu.co.editorPersonaje.model;

import javafx.scene.paint.Color;

/**
 * La clase Memento representa una instantánea del estado del personaje.
 * Almacena el color de piel, nivel de poder y puntos de salud en un
 * momento específico, permitiendo restaurar estos estados posteriormente.
 * 
 * @author JuanSZC
 * @version 1.0
 */
public class Memento {
    private final Color skinColor;
    private final int powerLevel;
    private final int healthPoints;

    public Memento(Color skinColor, int powerLevel, int healthPoints) {
        this.skinColor = skinColor;
        this.powerLevel = powerLevel;
        this.healthPoints = healthPoints;
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
}
