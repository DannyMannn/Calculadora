public class Nodo {
    //Character token //no puede ser char porque los números pueden ser más de un char
    String dato;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(String dato)
    {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }

    public Nodo()
    {
        this.dato = null;
        this.izquierdo = null;
        this.derecho = null;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }

    public void setIzquierdo(Nodo izquierdo)
    {
        this.izquierdo = izquierdo;
    }
}
