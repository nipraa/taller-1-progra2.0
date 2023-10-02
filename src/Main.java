import edu.princeton.cs.stdlib.StdDraw;

import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        /*
         variable para finalizar el programa
         */
        boolean salir = false;
        Color colorSeleccionado = Color.BLUE;


        /*
         definir los ajustes del lienzo
         */
        StdDraw.setCanvasSize(600, 600);
        double max = 1000;
        double min = -1000;
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);
        StdDraw.setTitle("taller_1");
        StdDraw.enableDoubleBuffering();

        while (!salir) {
            System.out.println("Menú de la computación");
            System.out.println("1. Agregar una línea ");
            System.out.println("2. Crear una circunferencia");
            System.out.println("3. Cambiar color");
            System.out.println("4. Anillos en capa");
            System.out.println("5. Borrar todo");
            System.out.println("6. Insertar texto");
            System.out.println("7. Crear una circunferencia pintada");
            System.out.println("8. Crear un ACPIA");
            System.out.println("9. Circunferencia con una línea");
            System.out.println("10. Salir");
            System.out.println("Escriba la opcion que desea: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ClassLineas.lineas(colorSeleccionado);
                    break;

                case 2:
                    ClassLineas.crearCircunferencia(colorSeleccionado);
                    break;

                case 3:
                    colorSeleccionado = ClassLineas.cambiarColor();
                    break;

                case 4:
                    ClassLineas.crearCircunferenciaConCirculosInternos(colorSeleccionado);
                    break;

                case 5:
                    ClassLineas.borrarLienzo();
                    break;

                case 6:
                    ClassLineas.mostrarTexto(colorSeleccionado);
                    break;

                case 7:
                    ClassLineas.crearCircunferenciaRellena(colorSeleccionado);
                    break;

                case 8:
                    ClassLineas.anillosEnCapaPintadoAleatorio();
                    break;

                case 9:
                    ClassLineas classLineas = new ClassLineas();
                    classLineas.circunferenciaConLineaAnimada(colorSeleccionado);
                    break;

                case 10:

                    /*
                     Salida del programa y mensaje de despedida
                     */
                    System.out.println("Programa cerrado.");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida, intente de nuevo por favor .");

            }

        }




    }
}

class ClassLineas {
    public static void lineas(Color colorlinea){
        Scanner scanner =new Scanner(System.in);

        /*
         Ingresar las cordenadas iniciales y finales
         */
        System.out.println("Ingrese las cordenadas de X0 (Inicial): ");
        int pix = scanner.nextInt();
        System.out.println("Ingrese las cordenadas en Y0 (Inicial): ");
        int piy = scanner.nextInt();
        System.out.println("Ingrese las cordenadas de XF (Final): ");
        int pfx = scanner.nextInt();
        System.out.println("Ingrese las cordenadas de XF (Final): ");
        int pfy = scanner.nextInt();


        /*
         Establecer el color de la línea
         */
        StdDraw.setPenColor(colorlinea);
        /*
         Crear la línea
         */
        StdDraw.line(pix, piy, pfx, pfy);

        StdDraw.show();
    }

    public static void crearCircunferencia(Color colorCircuferencia){
        Scanner scanner = new Scanner(System.in);

        /*
         Ingresar cordenadas de posicion y radio
         */
        System.out.println("Ingrese las cordenadas del centro en X: ");
        double centroX = scanner.nextDouble();

        System.out.println("Ingrese las coordenada del centro en Y: ");
        double centroY = scanner.nextDouble();

        System.out.println("Ingrese el radio de la circunferencia (Real Positivo): ");
        double radio = scanner.nextDouble();


        if (radio <= 0) {
            System.out.println("El radio debe ser un número positivo.");
            /*
             Ventana emergente que indica un error
             */
        }

        else {
            /*
             Dibujar el circulo en las cordenadas escogidas
             */
            double x = centroX;
            /*
             Coordenada en X del centro de la circunferencia
             */

            double y = centroY;
            /*
             Coordenada en Y del centro de la circunferencia
             */

            /*
             Establecer el color de la circunferencia
             */
            StdDraw.setPenColor(colorCircuferencia);

            /*
             Dibujar la circunferencia
             */
            StdDraw.circle(x, y, radio);

            StdDraw.show();
        }
    }

    public static Color cambiarColor() {
        Scanner scanner = new Scanner(System.in);

        /*
         Menu de opciones de colores
         */
        System.out.println("1. Rojo");
        System.out.println("2. Amarillo");
        System.out.println("3. Azul");
        System.out.println("4. Rosado");
        System.out.println("5. verde");
        System.out.println("6. Naranja");
        System.out.println("7. Negro");
        System.out.println("8. Gris");
        System.out.println("9. Blanco");

        System.out.println("elige un color: ");
        int opcion = scanner.nextInt();

        Color colorSelect;

        /*
         Switch de los colores
         */
        switch (opcion) {
            case 1:
                colorSelect = Color.RED;
                break;
            case 2:
                colorSelect = Color.YELLOW;
                break;
            case 3:
                colorSelect = Color.BLUE;
                break;
            case 4:
                colorSelect = Color.PINK;
                break;
            case 5:
                colorSelect = Color.GREEN;
                break;
            case 6:
                colorSelect = Color.ORANGE;
                break;
            case 7:
                colorSelect = Color.BLACK;
                break;
            case 8:
                colorSelect = Color.GRAY;
                break;
            case 9:
                colorSelect = Color.WHITE;
                break;

            /*
             al usar una opcion invalida arrojara un mensaje
             */
            default:
                System.out.println("Color no válido, se usará el color predeterminado Azul.");
                colorSelect = Color.BLUE;
                break;
        }
        /*
         Return de color elegido o predeterminado.
         */
        return colorSelect;
    }
    public static void anillosEnCapaPintadoAleatorio() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la coordenada del centro en X: ");
        double centroX = scanner.nextDouble();

        System.out.println("Ingrese la coordenada del centro en Y: ");
        double centroY = scanner.nextDouble();

        System.out.println("Ingrese el radio inicial de la circunferencia : ");
        double radioInicial = scanner.nextDouble();

        if (radioInicial <= 0) {
            System.out.println("debe ser un número positivo.");
            return;
        }
        /*
        Ventana emergente que indica un error
         */
        System.out.println("Ingrese el valor de reducción del radio para los anillos : ");
        double reduccionRadio = scanner.nextDouble();

        if (reduccionRadio <= 0) {
            System.out.println("debe ser un número positivo.");
            return;
        }

        Color[] colores = {Color.RED, Color.YELLOW, Color.BLUE, Color.PINK, Color.GREEN, Color.ORANGE, Color.BLACK, Color.GRAY, Color.WHITE};


        double radio = radioInicial;
        int indiceColor = 0;

        while (radio > 0) {
            // color aleatorio
            Color colorSeleccionado = colores[indiceColor % colores.length];
            indiceColor++;

            /*
             Dibujar la circunferencia rellenada
             */
            StdDraw.setPenColor(colorSeleccionado);
            StdDraw.filledCircle(centroX, centroY, radio);

            /*
            Reducir el radio para el siguiente anillo
             */
            radio -= reduccionRadio;

            /*
             Tiempo de espera para visualizar cada anillo
             */
            StdDraw.pause(700);
        }

        StdDraw.show();
    }
    public static void crearCircunferenciaConCirculosInternos(Color colorSeleccionado) {
        Scanner scanner = new Scanner(System.in);
        // Incripcion de coordenadas del circulo
        System.out.println("Ingrese la coordenada del centro en X: ");
        double centroX = scanner.nextDouble();

        System.out.println("Ingrese la coordenada del centro en Y: ");
        double centroY = scanner.nextDouble();

        System.out.println("Ingrese el radio inicial de la circunferencia : ");
        double radioInicial = scanner.nextDouble();



        if (radioInicial <= 0) {
            System.out.println("El radio inicial debe ser un número positivo.");
            return;
        }

        System.out.println("Ingrese el valor de reducción del radio para los círculos internos (positivo): ");
        double reduccionRadio = scanner.nextDouble();

        if (reduccionRadio <= 0) {
            System.out.println("debe ser un número positivo.");
            return;
        }
        /*Ventana emergente que indica un error

        * Dibujar una circunferencia en una ubicación específica

        */
        double x = centroX;
        /*
         Coordenada x del centro de la circunferencia
         */

        double y = centroY;
        /*
         Coordenada y del centro de la circunferencia
         */

        /*
         Dibujar la circunferencia exterior
         */
        StdDraw.setPenColor(colorSeleccionado);
        StdDraw.circle(x, y, radioInicial);

        /*
         Calcular radios de los círculos internos
         */
        double radioInterno1 = radioInicial - reduccionRadio;
        double radioInterno2 = radioInicial - 2 * reduccionRadio;

        /*
         Dibujar los círculos internos
         */
        StdDraw.circle(centroX, centroY, radioInterno1);
        StdDraw.circle(centroX, centroY, radioInterno2);

        StdDraw.show();
    }

    public static void borrarLienzo() {
        /*
         Borra lo dibujado en el lienzo
         */
        StdDraw.clear();
        StdDraw.show();
    }

    public static void mostrarTexto(Color colorSeleccionado) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escriba el texto que desea mostrar: ");
        String texto = scanner.nextLine();

        System.out.println("Escriba la coordenada X para el texto: ");
        double x = scanner.nextDouble();

        System.out.println("Escriba la coordenada Y para el texto: ");
        double y = scanner.nextDouble();


        /*
         * Establecer el color del texto
          */

        StdDraw.setPenColor(colorSeleccionado);

        /*
         *Dibujar el texto en la ubicación especificada
         */
        StdDraw.text(x, y, texto);
        StdDraw.show();
    }

    public static void crearCircunferenciaRellena(Color colorSeleccionado) {
        Scanner scanner = new Scanner(System.in);

        /*
         Inscribe las coordenadas del centro y el radio
         */
        System.out.println("Escriba la coordenada del centro en X: ");
        double centroX = scanner.nextDouble();

        System.out.println("Escriba la coordenada del centro en Y: ");
        double centroY = scanner.nextDouble();

        System.out.println("Escriba el radio de la circunferencia (positivo): ");
        double radio = scanner.nextDouble();

        if (radio <= 0) {
            System.out.println("El radio debe ser un número positivo.");

        } else {
            /*
            Dibujar una circunferencia rellena
             */
            double x = centroX;
            /*
             *Coordenada x del centro de la circunferencia
            */
            double y = centroY;
            /*
             Coordenada y del centro de la circunferencia
             */


            /*
             Establecer el color de la circunferencia y relleno de la circunferencia
             */
            StdDraw.setPenColor(colorSeleccionado);
            StdDraw.filledCircle(x, y, radio);

            StdDraw.show();
        }
    }



    public void circunferenciaConLineaAnimada(Color colorSeleccionado) {
        Scanner scanner = new Scanner(System.in);

        /*
         Borrar todo lo dibujado anterior mente
         */
        borrarLienzo();

        System.out.println("Ingrese la coordenada del centro en X: ");
        double centX = scanner.nextDouble();

        System.out.println("Ingrese la coordenada del centro en Y: ");
        double centY = scanner.nextDouble();

        System.out.println("Ingrese el radio de la circunferencia (positivo): ");
        double radio = scanner.nextDouble();

        if (radio <= 0) {
            System.out.println("El radio debe ser un número positivo.");
            return;
        }

        /*
         Solicitar al usuario las coordenadas de la línea dentro de la circunferencia
         */
        System.out.println("Ingrese la coordenada inicial de la línea en X: ");
        double X1 = scanner.nextDouble();

        System.out.println("Ingrese la coordenada inicial de la línea en Y: ");
        double Y1 = scanner.nextDouble();

        System.out.println("Ingrese la coordenada final de la línea en X: ");
        double X2 = scanner.nextDouble();

        System.out.println("Ingrese la coordenada final de la línea en Y: ");
        double Y2 = scanner.nextDouble();

        /*
         Calcular el ángulo de rotación
         */
        double angulo = 0;
        /*
         Ángulo inicial
         */
        double velocidadRotacion = 0.05;
        /*
         Puedes ajustar la velocidad de rotación según tu preferencia
         */

        while (true) {
            /*
             Dibuja la circunferencia
             */
            StdDraw.clear();
            StdDraw.circle(centX, centY, radio);

            /*
             Calcula las coordenadas rotadas de la línea
             */
            double X1Rot = centX + (X1 - centX) * Math.cos(angulo) - (Y1 - centY) * Math.sin(angulo);

            double Y1Rot = centY + (X1 - centX) * Math.sin(angulo) + (Y1 - centY) * Math.cos(angulo);

            double X2Rot = centX + (X2 - centX) * Math.cos(angulo) - (Y2 - centY) * Math.sin(angulo);

            double Y2Rot = centY + (X2 - centX) * Math.sin(angulo) + (Y2 - centY) * Math.cos(angulo);

            /*
             Dibuja la línea rotada
             */
            StdDraw.setPenColor(colorSeleccionado);
            StdDraw.line(X1Rot, Y1Rot, X2Rot, Y2Rot);
            StdDraw.show();

            /*
             Actualiza el ángulo de la rotación
             */
            angulo += velocidadRotacion;

            /*
             Solicitar si se desea borrar la animación
             */
            System.out.println("¿Desea borrar la animación? (1: Sí / 0: No): ");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                borrarLienzo();
                /*
                 Borra la animación
                 */
                break;
            }

            StdDraw.pause(1);
        }
    }
}