public class OperListaSimple {

    NodoSimple prim = null, ult = null;

    public void insertarInicio(int x) {
        NodoSimple nuevo = new NodoSimple(x);

        if (prim == null) {
            prim = nuevo;
            ult = nuevo;
        } else {
            nuevo.sig = prim;
            prim = nuevo;
        }
    }

    public void eliminarInicio() {
        if (prim == ult) {
            prim = null;
            ult = null;
        } else {
            NodoSimple aux = prim;
            prim = prim.sig;
            aux.sig = null;
        }
    }

    public void mostrar() {
        NodoSimple aux = prim;
        if (aux == null) {
            System.out.println("No hay elementos en la lista");
            return;
        }

        for (; aux != null; aux = aux.sig)
            System.out.println(aux.getDato());
    }

    public void insertarFinal(int x) {
        NodoSimple nuevo = new NodoSimple(x);
        if (prim == null) prim = nuevo;
        else ult.sig = nuevo;

        ult = nuevo;
    }

    public void eliminarUltimo() {
        if (prim == ult) {
            prim = null;
            ult = null;
        } else {
            NodoSimple aux = prim;
            for (; aux.sig != ult; aux = aux.sig) ;
            ult = aux;
            ult.sig = null;
        }
    }

    public boolean insertarEnseguida(int x, int y) {
        NodoSimple aux = prim;
        for (; aux != null && aux.getDato() != y; aux = aux.sig) ;

        if (aux == null) {
            return false;
        }

        NodoSimple nuevo = new NodoSimple(x);
        nuevo.sig = aux.sig;
        aux.sig = nuevo;
        return true;
    }

    public boolean eliminarElemento(int y) {
        NodoSimple aux = prim;
        NodoSimple previous = null;
        while (true) {
            if (aux != null && aux.getDato() != y) {
                previous = aux;
                aux = aux.sig;
                continue;
            }
            if (aux == null) return false;

            if (aux == prim) {
                prim = null;
                return true;
            }

            if (previous != null)
                previous.sig = aux.sig;
            return true;
        }
    }

}
