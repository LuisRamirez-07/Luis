public class NodoSimple {
    private int dato;
    NodoSimple sig;

    public NodoSimple(int d) {
        dato = d;
        sig = null;
    }

    public int getDato() {
        return dato;
    }

    public void set(int d) {
        dato = d;
    }

}