public class Funcionalidades {
    public static void main(String[] args) {
        System.out.println(invertirPalabra("Hola mundo"));
        int [] numeros = new int[] {2, 4, 9, 8298321, 5, 2};
        System.out.println(sumarPares(numeros));
    }

    public static String invertirPalabra(String palabra) {
        String palabraInvertida = "";

        for(int i = (palabra.length() - 1); i >= 0; i--) {
            palabraInvertida += String.valueOf(palabra.charAt(i));
        }

        return palabraInvertida;
    }

    public static int sumarPares(int [] numeros) {
        int suma = 0;

        for(int i = 0; i < numeros.length; i++) {
            if(numeros[i] % 2 == 0) {
                suma += numeros[i];
            }
        }

        return suma;
    }
}
