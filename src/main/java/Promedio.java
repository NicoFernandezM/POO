import java.text.DecimalFormat;

public class Promedio {

    public static void main(String[] args) {
        double promedio = calcularPromedio();
        mostrarResultados(promedio);
    }

    public static double generarNota() {
        return (Math.random() * 6) + 1;
    }

    public static double calcularPromedio() {
        double promedio = 0;

        for(int i = 0; i < 3; i++) {
            promedio += (generarNota() / 3);
        }

        return promedio;
    }

    public static void mostrarResultados(double promedio) {
        if(promedio >= 4) {
            System.out.print("El estudiante aprobó con un promedio de: ");
        } else if(promedio < 4 && promedio >= 3.6) {
            System.out.print("El estudiante rinde examen con un promedio de: ");
        } else {
            System.out.print("El estudiante reprobó con un promedio de: ");
        }

        System.out.println(formatearPromedio(promedio));
    }

    public static String formatearPromedio(double promedio) {
        DecimalFormat formateador = new DecimalFormat("#.00");
        return formateador.format(promedio);
    }
}