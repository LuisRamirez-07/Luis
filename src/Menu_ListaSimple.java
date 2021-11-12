import java.util.Scanner;

public class Menu_ListaSimple {
    private static final Scanner scanner = new Scanner(System.in);
    private static final OperListaSimple ops = new OperListaSimple();

    public static void main(String args[]) {
        while (true) {
            printMenu();
            int option = scanner.nextInt();
            scanner.nextLine();
            if (option == 8) {
                break;
            }
            execOption(option);
        }

        scanner.close();
    }

    public static void printMenu() {
        clearScreen();
        System.out.println("MENU");
        System.out.println();
        System.out.println("1.- Insertar elemento al inicio");
        System.out.println("2.- Eliminar elemento al inicio");
        System.out.println("3.- Insertar elemento al final");
        System.out.println("4.- Eliminar elemento al final");
        System.out.println("5.- Insertar elemento enseguida de otro elemento");
        System.out.println("6.- Eliminar elemento dado");
        System.out.println("7.- Mostrar elementos");
        System.out.println("8.- Salir");
        System.out.println();
        System.out.print("Opción a realizar: ");
    }

    public static void execOption(int option) {
        int elemento;
        switch (option) {
            case 1:
                elemento = getElement();
                ops.insertarInicio(elemento);
                System.out.println("Se agregó el " + elemento + " a inicio de la lista.");
                break;
            case 2:
                ops.eliminarInicio();
                System.out.println("Se elimino el primer elemento");
                break;
            case 3:
                elemento = getElement();
                ops.insertarFinal(elemento);
                System.out.println("Se agregó el " + elemento + " al final de la lista.");
                break;
            case 4:
                ops.eliminarUltimo();
                System.out.println("Se elimino el último elemento");
                break;
            case 5:
                elemento = getElement();
                System.out.print("Enseguida de que elemento: ");
                int enseguidaDe = scanner.nextInt();
                scanner.nextLine();
                if (ops.insertarEnseguida(elemento, enseguidaDe)) {
                    System.out.println("Se agregó el " + elemento + " después del primer " + enseguidaDe + " encontrado en la lista");
                } else {
                    System.out.println("No se encontró el " + enseguidaDe + " en la lista");
                }
                break;
            case 6:
                elemento = getElement(false);
                if (ops.eliminarElemento(elemento)) {
                    System.out.println("Se eliminó el primer elemento " + elemento + " encontrado de la lista");
                } else {
                    System.out.println("No se encontró el " + elemento + " en la lista");
                }
                break;
            case 7:
                ops.mostrar();
                break;
            default:
                System.out.println("Opción no valida, intente con otra");
        }
        pressEnter();
    }

    public static void pressEnter() {
        System.out.println("Presione Enter para continuar");
        scanner.nextLine();
    }

    public static int getElement() {
        return getElement(true);
    }

    public static int getElement(boolean isIngresar) {
        String action;
        if (isIngresar)
            action = "ingresar";
        else
            action = "eliminar";
        System.out.print("Ingrese el número que desea " + action + ": ");
        int elemento = scanner.nextInt();
        scanner.nextLine();
        return elemento;
    }

    public static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            System.out.println("No se pudo limpiar la pantalla");
        }
    }
}
