/**
 * Ahorcado
 * @author Hugo López
 * @version 1.0.0
 */
import java.util.*;
public class Ahorcado {
    public static Scanner sc = new Scanner(System.in);
    /// Variable publica con la palabra correcta
    public static String palabra = meta().toLowerCase();

    /**
     * Metodo principal
     * @param args Argumentos de consola
     */
    public static void main(String[] args) {
        menu();
    }

    /**
     * Metodo cual retorna una palabra aleatoria correcta
     * @return String palabra aleatoria
     */
    static String meta() {
        String[] lista = {
            "Afganistan", "Albania", "Alemania", "Andorra", "Angola", "Argelia", "Argentina", "Armenia", "Australia", "Austria", "Azerbaiyan", "Bahamas", "Banglades", "Barbados", "Barein", "Belgica", "Belice", "Benin", "Bielorrusia", "Birmania", "Bolivia", "Botsuana", "Brasil", "Brunei", "Bulgaria", "Burundi", "Butan", "Camboya", "Camerun", "Canada", "Catar", "Chad", "Chile", "China", "Chipre", "Colombia", "Comoras", "Croacia", "Cuba", "Dinamarca", "Dominica", "Ecuador", "Egipto", "Eritrea", "Eslovaquia", "Eslovenia", "Espana", "Estonia", "Etiopia", "Filipinas", "Finlandia", "Fiyi", "Francia", "Gabon", "Gambia", "Georgia", "Ghana", "Granada", "Grecia", "Guatemala", "Guyana", "Guinea", "Haiti", "Honduras", "Hungria", "India", "Indonesia", "Irak", "Iran", "Irlanda", "Islandia", "Israel", "Italia", "Jamaica", "Japon", "Jordania", "Kazajistan", "Kenia", "Kirguistan", "Kiribati", "Kuwait", "Laos", "Lesoto", "Letonia", "Libano", "Liberia", "Libia", "Liechtenstein", "Lituania", "Luxemburgo", "Madagascar", "Malasia", "Malaui", "Maldivas", "Mali", "Malta", "Marruecos", "Mauricio", "Mauritania", "Mexico", "Micronesia", "Moldavia", "Monaco", "Mongolia", "Montenegro", "Mozambique", "Namibia", "Nauru", "Nepal", "Nicaragua", "Niger", "Nigeria", "Noruega", "Oman", "Pakistan", "Palaos", "Panama", "Paraguay", "Peru", "Polonia", "Portugal", "Ruanda", "Rumania", "Rusia", "Samoa", "Senegal", "Serbia", "Seychelles", "Singapur", "Siria", "Somalia", "Suazilandia", "Sudafrica", "Sudan", "Suecia", "Suiza", "Surinam", "Tailandia", "Tanzania", "Tayikistan", "Togo", "Tonga", "Tunez", "Turkmenistan", "Turquia", "Tuvalu", "Ucrania", "Uganda", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Yemen", "Yibuti", "Zambia", "Zimbabue"
        };
        return lista[(int) (Math.random()* lista.length)];
    }

    /**
     * Metodo cual devuelve el dibujo del ahorcado
     * @param intento nº de intento del juego
     * @return String el dibujo del tablero
     */
    static String estados(int intento){
        String[] estados = {
          "     -----\n     |   |\n         |\n         |\n         |\n         |\n    =========", "     -----\n     |   |\n     O   |\n         |\n         |\n         |\n    =========","     -----\n     |   |\n     O   |\n     |   |\n         |\n         |\n    =========","     -----\n     |   |\n     O   |\n    /|   |\n         |\n         |\n    =========","     -----\n     |   |\n     O   |\n    /|\\  |\n         |\n         |\n    =========","     -----\n     |   |\n     O   |\n    /|\\  |\n    /    |\n         |\n    =========","     -----\n     |   |\n     O   |\n    /|\\  |\n    / \\  |\n         |\n    ========="
        };
        return estados[intento];
    }

    /**
     * Funcion cual maneja el menu del juego
     */
    static void menu(){
        int opcion;
        System.out.println("Bienvenido/a al ahorcado de paises: ");
        System.out.println("1.Jugar");
        System.out.println("2.Salir");
        opcion = sc.nextInt();
        switch (opcion){
            case 1:
                juego();
                break;
            case 2:
                break;
            default:
                System.out.println("Introduzca un valor valido");
                break;
        }
    }

    /**
     * Metodo cual establece la palabra oculta
     * @param meta Palabra cual queremos establecer
     * @return String de guiones de la misma longitud que la palabra meta
     */
    static String metaoculta(String meta){
        String guiones = "";
        for (int i = 0; i < meta.length(); i++) {
            guiones = guiones.concat("_");
        }

        return guiones;
    }

    /**
     * Funcion cual inicializa el juego
     */
    static void juego(){
        int intentos=0;
        String user;
        String letras_adi = metaoculta(palabra);
        Set<Character> falladas = new HashSet<>();
        System.out.println("Empieza el juego: ");
        do {
            System.out.println(estados(intentos));
            System.out.println(letras_adi);
            System.out.println("Letras falladas: "+falladas);
            user = sc.next().toLowerCase();
            if (user.length()>1){
                if (user.equals(palabra)){
                    letras_adi = palabra;
                }else {
                    intentos++;
                }
            }else {
                for (int i = 0; i < user.length(); i++) {
                    if (palabra.contains(user.charAt(i)+"")){
                        letras_adi = sustituirGuion(letras_adi, user.charAt(i));
                    }else {
                        if (!falladas.contains(user.charAt(i))){
                            falladas.add(user.charAt(i));
                            intentos++;
                        }
                    }
                }
            }
        }while (!(letras_adi.equalsIgnoreCase(palabra))&&intentos<6);
        if (letras_adi.equals(palabra)){
            System.out.println(estados(intentos));
            System.out.println("Enhorabuena has ganado, el país era: "+palabra+", tan solo has tenido "+intentos+" errores.");
        }else{
            System.out.println(estados(intentos));
            System.out.println("El país era: "+palabra);
        }

    }

    /**
     * Metodo para sustituir los guiones de las posiciones indicadas por la letra dada
     * @param letras_adi Letras originalmente arri
     * @param letra La letra cual estamos adivinando
     * @return La palabra con guiones y las letras cambiadas
     */
    static String sustituirGuion(String letras_adi, char letra){
        StringBuilder temp = new StringBuilder(letras_adi);
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i)==letra){
                temp.setCharAt(i,letra);
            }
        }
        return temp.toString();
    }
}