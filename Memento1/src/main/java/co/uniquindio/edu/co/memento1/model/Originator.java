package co.uniquindio.edu.co.memento1.model;

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
