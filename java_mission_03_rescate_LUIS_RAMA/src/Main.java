import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Mision de rescate preparada");

        char[][] matriz = new char[10][10];
        char robot = 'R';
        char metafinal = 'F';
        int vidas = 9;

        //MATRIZ 10X10 FULL DE ASTERISCOS

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                matriz[fila][columna] = '*';
            }
        }

        //PONEMOS ROBOT Y META FINAL EN SUS POSICIONES

        matriz[0][0] = robot;
        matriz [9][9] = metafinal;



        //COLOCAMOS 5 X Y UNA B EN POSICIONES ALEATORIAS X-OBSTACULO Y B-BATERIA

        Random aleatorios = new Random();

        int filaRandom = aleatorios.nextInt(10);
        int columnaRandom = aleatorios.nextInt(10);

        for (int i1 = 0; i1 < 1; i1++) {
            do {
                filaRandom = aleatorios.nextInt(10);
                columnaRandom =aleatorios.nextInt(10);
            }while (matriz[filaRandom][columnaRandom] != '*');
            matriz[filaRandom][columnaRandom] = 'B';
        }

        int filarandom2 = aleatorios.nextInt(10);
        int columnarandom2 = aleatorios.nextInt(10);

        for (int i = 0; i < 5; i++) {
            do {
                filarandom2 = aleatorios.nextInt(10);
                columnarandom2 = aleatorios.nextInt(10);
            } while (matriz[filarandom2][columnarandom2] != '*');
            matriz[filarandom2][columnarandom2] = 'P';

        }












        System.out.println(" ");

        //contar elementos de matriz
        int cantidadR = 0;
        int cantidadP = 0;
        int cantidadB = 0;
        int cantidadF = 0;
        int cantidadLibres = 0;

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz.length; columna++) {

                if (matriz[fila][columna] == 'R') {
                    cantidadR++;
                } else if (matriz[fila][columna] == 'P') {
                    cantidadP++;
                } else if (matriz[fila][columna] == 'B') {
                    cantidadB++;
                } else if (matriz[fila][columna] == 'F') {
                    cantidadF++;
                } else if (matriz[fila][columna] == '*') {
                    cantidadLibres++;
                }


            }

        }


            //NIVEL 2

        System.out.println("El robot se encuentra en la casilla 0,0");
        System.out.println("Y te puedes desplazar con las letras W A S D");

        Scanner sc = new Scanner(System.in);

        int filarobot = 0;
        int columnarobot = 0;

        matriz[filarobot][columnarobot] = robot;

        do {
            System.out.println("Dime una letra: ");
            char desplazamiento = sc.next().charAt(0);

            System.out.println("La letra elegida es " + desplazamiento);

            if (desplazamiento == 'D') {
                if (columnarobot < 9) {

                    matriz[filarobot][columnarobot] = '*';
                    columnarobot++;


                    if (matriz[filarobot][columnarobot] == 'B') {
                        vidas = vidas + 2;
                        System.out.println("Bien hecho, has conseguido una bateria extra");
                    }

                    if (matriz[filarobot][columnarobot] == 'X') {
                        vidas++;
                        System.out.println("No puedes moverte a traves de la X");
                        columnarobot--;
                    }

                    matriz[filarobot][columnarobot] = robot;
                } else {
                    System.out.println("No puedes moverte más a la derecha");
                }
            }

            if (desplazamiento == 'A') {
                if (columnarobot > 0) {

                    matriz[filarobot][columnarobot] = '*';
                    columnarobot--;


                    if (matriz[filarobot][columnarobot] == 'B') {
                        vidas = vidas + 2;
                        System.out.println("Bien hecho, has conseguido una bateria extra");
                    }

                    if (matriz[filarobot][columnarobot] == 'X') {
                        vidas++;
                        System.out.println("No puedes moverte a traves de la X");
                        columnarobot++;
                    }

                    matriz[filarobot][columnarobot] = robot;
                } else {
                    System.out.println("No puedes moverte más a la izquierda");
                }
            }


            if (desplazamiento == 'W') {
                if (filarobot > 0) {

                    matriz[filarobot][columnarobot] = '*';
                    filarobot--;


                    if (matriz[filarobot][columnarobot] == 'B') {
                        vidas = vidas + 2;
                        System.out.println("Bien hecho, has conseguido una bateria extra");
                    }

                    if (matriz[filarobot][columnarobot] == 'X') {
                        vidas++;
                        System.out.println("No puedes moverte a traves de la X");
                        filarobot--;
                    }

                    matriz[filarobot][columnarobot] = robot;
                } else {
                    System.out.println("No puedes moverte más hacia arriba");
                }
            }

            if (desplazamiento == 'S') {
                if (filarobot < 9) {

                    matriz[filarobot][columnarobot] = '*';
                    filarobot++;


                    if (matriz[filarobot][columnarobot] == 'B') {
                        vidas = vidas + 2;
                        System.out.println("Bien hecho, has conseguido una bateria extra");
                    }

                    if (matriz[filarobot][columnarobot] == 'X') {
                        vidas++;
                        System.out.println("No puedes moverte a traves de la X");
                        filarobot++;
                    }

                    matriz[filarobot][columnarobot] = robot;
                } else {
                    System.out.println("No puedes moverte más hacia arriba");
                }
            }


            //MOSTRAR MATRIZ EN CONSOLA

            for (int fila = 0; fila < matriz.length; fila++) {
                for (int columna = 0; columna < matriz.length; columna++) {
                    System.out.print(matriz[fila][columna] + " ");
                }
                System.out.println(" ");
            }
            System.out.println();
            System.out.println("Te quedan " + vidas + " baterias ");
            vidas--;



        }while (vidas>=0);

        //MOSTRAMOS RECUENTO

        System.out.println("--- RESUMEN DE LA MISION ---");
        System.out.println("Robots (R): " + cantidadR);
        System.out.println("Obstaculos (P): " + cantidadP);
        System.out.println("Baterias (B): " + cantidadB);
        System.out.println("Metas finales (F): " + cantidadF);
        System.out.println("Casillas libres (*): " + cantidadLibres);


    }
}