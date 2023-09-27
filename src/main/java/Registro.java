import java.util.InputMismatchException;
import java.util.Scanner;

public class Registro {
    public static void main(String[] args) {
        String [][] registro = new String[50][3];
        int opcionUsuario = -1;

        do {
            mostrarMenu();
            opcionUsuario = pedirEntero(1, 6);

            switch (opcionUsuario) {
                case 1 -> menuAgregarPersona(registro);
                case 2 -> System.out.println("Hay " + obtenerPersonasSegunEdad(registro, 18, 120) + " mayores de edad.");
                case 3 -> System.out.println("Hay " + obtenerPersonasSegunEdad(registro, 15, 17)+ " menores de edad.");
                case 4 -> System.out.println("Hay " + obtenerPersonasSegunEdad(registro, 60, 120)+ " personas de la tercera edad.");
                case 5 -> mostrarPersonasSegunEstadoCivil(registro);
                case 6 -> System.out.println("Programa finalizado.");
                default -> System.err.println("Opción inválida");
            }
        }while (opcionUsuario != 6);
    }

    private static void menuAgregarPersona(String [][] registro) {
        if(hayCupo(registro)) {
            System.out.println("Por favor ingrese el nombre.");
            String nombre = pedirInput();

            System.out.println("Por favor ingrese el estado civil.");
            String estadoCivil = pedirEstadoCivil();

            System.out.println("Por favor ingrese la edad.");
            int edad = pedirEntero(15, 120);

            agregarPersona(registro, nombre, estadoCivil, edad);
            System.out.println("Persona agregada.");
        } else {
            System.out.println("No hay cupo.");
        }
    }

    private static String pedirEstadoCivil() {
        System.out.println("1) Casado/a.\n2) Soltero/a");
        return pedirEntero(1, 2) == 1 ? "casado" : "soltero";
    }

    private static void agregarPersona(String[][] registro, String nombre, String estadoCivil, int edad) {
        int indiceDisponible = registro.length - obtenerEspaciosDisponibles(registro);

        registro[indiceDisponible][0] = nombre;
        registro[indiceDisponible][1] = estadoCivil;
        registro[indiceDisponible][2] = String.valueOf(edad);
    }


    public static int obtenerUltimoEspacio(String [][] registro) {
        return registro.length - obtenerEspaciosDisponibles(registro);
    }

    public static boolean hayCupo(String [][] registro) {
        return obtenerEspaciosDisponibles(registro) != 0;
    }

    public static int obtenerEspaciosDisponibles(String [][] registro) {
        for(int i = 0; i < registro.length; i++) {
            if(registro[i][0] == null){
                return registro.length - i;
            }
        }
        return 0;
    }

    public static void mostrarMenu() {
        System.out.println("""
                Menú
                1) Agregar persona.
                2) Mostrar la cantidad de personas mayores de edad.
                3) Mostrar la cantidad de personas menores de edad.
                4) Mostrar la cantidad de personas de tercera edad.
                5) Mostrar la cantidad de personas según estado civil (Soltero/a - Casado/a).
                6)Salir.
                """);
    }

    public static int pedirEntero(int min, int max) {
        int entero = 0;

        do {
            System.out.println("Ingrese un número entre " + min + " y " + max + ".");
            try {
                entero = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Opción inválida");
                return pedirEntero(min, max);
            }
        }while (entero < min || entero > max);

        return entero;
    }


    public static String pedirInput() {
        Scanner leer = new Scanner(System.in);
        String inputUsuario = "";

        while(inputUsuario.isEmpty()) {
            inputUsuario = leer.nextLine();
        }

        return inputUsuario;
    }

    public static int obtenerPersonasSegunEdad(String [][] registro, int edadMin, int edadMax) {
        int personas = 0;
        int ultimaPersona = obtenerUltimoEspacio(registro);

        for(int i = 0; i < ultimaPersona; i++) {
            if(Integer.parseInt(registro[i][2]) >= edadMin && Integer.parseInt(registro[i][2]) <= edadMax) {
                personas++;
            }
        }
        return personas;
    }

    public static void mostrarPersonasSegunEstadoCivil(String [][] registro) {
        int casados = 0;
        int solteros = 0;

        int ultimaPersona = obtenerUltimoEspacio(registro);

        for(int i = 0; i < ultimaPersona; i++) {
            if(registro[i][1].equalsIgnoreCase("casado")) {
                casados++;
            } else {
                solteros++;
            }
        }

        System.out.println("Hay " + casados + " casados/as.");
        System.out.println("Hay " + solteros + " solteros/as.");
    }
}
