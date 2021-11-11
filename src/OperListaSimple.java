public class OperListaSimple {

    NodoSimple prim = null, ult = null;

    public void insertarInicio(int x) {
        NodoSimple nuevo = new NodoSimple(x);

        if(prim == null) {
            prim = nuevo;
            ult = nuevo;
        }else {
            nuevo.sig = prim;
            prim = nuevo;
        }
    }

    public void eliminarInicio() {
        if(prim==ult) {
            prim = null;
            ult = null;
        }else {
            NodoSimple aux = prim;
            prim = prim.sig;
            aux.sig = null;
        }
    }

    public void mostrar() {
        NodoSimple aux = prim;
        for(;aux!= null;aux = aux.sig)
            System.out.println(aux.getDato());
    }

    public void insertarFinal(int x) {
        NodoSimple nuevo = new NodoSimple(x);
        if(prim == null) {
            prim = nuevo;
            ult = nuevo;
        }else {
            ult.sig = nuevo;
            ult = nuevo;
        }
    }

    public void eliminarUltimo() {
        if(prim==ult) {
            prim = null;
            ult = null;
        }else {
            NodoSimple aux = prim;
            for(;aux.sig!=ult;aux=aux.sig);
            ult = aux;
            ult.sig = null;
        }
    }

    public boolean insertarEnseguida(int x,int y) {

    }

    public boolean eliminarElemento(int x,int y) {

    }

}
