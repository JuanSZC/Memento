package co.uniquindio.edu.co.editorTexto.model;

/**
 * La clase Memento representa una instantánea del estado del editor.
 * Almacena el contenido del texto en un punto específico en el tiempo,
 * permitiendo al sistema restaurar ese estado posteriormente.
 * 
 * @author JuanSZC
 * @version 1.0
 */
public class Memento {

    private final String Texto;

    public Memento(String texto) {
        Texto = texto;
    }

    public String getTexto() {
        return Texto;
    }
}
