package co.uniquindio.edu.co.editorTexto.model;

/**
 * La clase Originator es responsable de crear y gestionar el estado del editor.
 * Puede crear instantáneas de su estado actual como objetos Memento y
 * restaurar su estado a partir de Mementos existentes.
 * 
 * @author JuanSZC
 * @version 1.0
 */
public class Originator {

    private String Texto;


    public void setTexto(String Texto) {
        this.Texto = Texto;
    }
    public void mostrarTexto() {
        System.out.println(Texto);
    }
    public Memento createConcreteMemento() {
        return new Memento(Texto);
    }
    public void undoConcreteMemento(Memento memento) {
        Texto = memento.getTexto();
    }
}
