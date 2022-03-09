import java.util.Scanner;


public class Juego {
    static Scanner entrada;
    static float SumaDeDatos = 0;
    static boolean error = false;
    static int menu = 0;
    static int filaG = 0;
    static int Oro;
    static int columnaG = 0;
    static int columnaB = 0;
    static int filaB = 0;
    static int conteoG = 0;
    static int conteobye = 0;
    static int submenu = 0;
    static int FilaJ;
    static int aleator3;
    static int ColumnaJ;
    static int[] Filas = new int[900];
    static int[] Columnas = new int[900];
    static int Conteo = 0;
    static int Conteoconteo = 0;
    static int ConteodeOroT = 0;
    static int conteoS = 0;
    static int ConteoB = 0;
    static int conteoT = 0;
    static int modo = 0;
    static int conteoOro;
    static int movBot;
    static int conteoMapa0;
    static int conteoMapa1;
    static int conteoMapa2;
    static int columnaBot;
    static int filaBot;
    static int conteobas = 0;
    static int conteoMapa0mod1;
    static int conteoMapa1mod1;
    static int conteoMapa2mod1;
    static int conteoMapa0mod2;
    static int conteoMapa1mod2;
    static int conteoMapa2mod2;
    static float conteomov = 0;
    static float conteomov2 = 0;
    static float conteoJugar = 0;
    static int contadorLaberinto;
    static int contadorCambio;
    static int matriz = 0;
    static int tipo = 0;
    static int visionBot;
    static int conteoDeOpciones;
    static String letra;
    static int activacion = 2;
    static String[][][] Laberinto = LaberintoInicial();
    static int numLab = 0;
    /* Clase Pincipal*/
    public static void main(String[] args) {
        menuP();
    }

    /* Menú inicial*/

    public static void menuP(){
        try{entrada = new Scanner(System.in);
            do {

                //Espacios(LaberintoInicial());
                

                System.out.println("                 Menu                    ");
                System.out.println("*****************************************");
                System.out.println("1) Jugar.");
                System.out.println("2) Crear mapa.");
                System.out.println("3) Reportes.");
                System.out.println("4) visualizar el mapa.");
                System.out.println("5) Salir.");
                System.out.println("Selecione entre 1-5");
                menu = entrada.nextInt();
                entrada.nextLine();


                switch (menu) {
                    case 1:
                        System.out.println("\n***********Jugar***********");
                        if (contadorLaberinto > 0){
                            menuMapas();
                        }
                        else{
                            maprev();
                        }
                        break;
                    case 2:
                    if (numLab < 3) {
                        System.out.println("\n***********Crear mapa***********");
                        creacion();
                    }
                    else{
                        System.out.println("No se puede Crear mas de 2 mapas");
                        menuP();
                    }
                        break;
                    case 3:
                        System.out.println("****************Reportes****************");
                        Reportes();
                        report();
                        break;
                    case 4:
                        System.out.println("\n***********Visualizar el mapa***********");
                        if (contadorLaberinto > 0){
                            masmaps();
                        }
                        else{
                            previs();
                        }
                        break;
                    case 5:
                        System.out.println("\n***********Adios***********");
                        error = false;
                        System.exit(0);

                        break;

                    default:
                        System.out.println("\n***********Adios***********");
                        error = false;
                        System.exit(0);
                        break;
                }



            } while (error);
        }catch(Exception e){
			System.out.println("\n*************Ingrese valores numericos correctos*********\n");
            menuP();
		}
    }

    /*Menu de previsualización para Jugar*/

    public static void maprev(){
        try {entrada = new Scanner(System.in);
            Espacios(Laberinto);
            jugador();
            Espacios(Laberinto);
            Bot();
            GenerarOro();
            GeneradorLab(LaberintoInicial());
            System.out.println("1.Jugar");
            System.out.println("2.volver al menu");
            System.out.println("3.salir");

            submenu = entrada.nextInt();
            entrada.nextLine();

            switch (submenu) {
                case 1:
                    Jugar();
                    break;
                case 2:
                    menuP();
                    break;
                case 3:
                    error = false;
                    System.exit(0);
                    System.out.println("\n***********Adios***********");
                    break;

                default:
                    error = false;
                    System.exit(0);
                    System.out.println("\n***********Adios***********");
                    break;
            }
        }catch(Exception e){
			System.out.println("\n*************Ingrese valores numericos correctos*********\n");
            maprev();
		}

    }

    /**Menu de previsualización para ver los mapas**/

    public static void previs(){
        try  {entrada = new Scanner(System.in);
            int submenudos = 0;

            GeneradorLab(LaberintoInicial());
            System.out.println("1.volver al menu");
            System.out.println("2.salir");
            submenudos = entrada.nextInt();
            entrada.nextLine();

            switch (submenudos) {
                case 1:
                    menuP();
                    break;

                default:
                error = false;
                System.exit(0);
                System.out.println("\n***********Adios***********");
                    break;
            }
        }catch(Exception e){
			System.out.println("\n*************Ingrese valores numericos correctos*********\n");
            previs();
		}
    }

    public static void report(){
        try  {entrada = new Scanner(System.in);
            int submenucuatro = 0;

            System.out.println("1.volver al menu");
            System.out.println("2.salir");
            submenucuatro = entrada.nextInt();
            entrada.nextLine();

            switch (submenucuatro) {
                case 1:
                    menuP();
                    break;

                default:
                error = false;
                System.out.println("\n***********Adios***********");
                System.exit(0);
                    break;
            }
        }catch(Exception e){
			System.out.println("\n*************Ingrese valores numericos correctos*********\n");
            report();
		}
    }

    public static void menuMapas() {
        try {entrada = new Scanner(System.in);
            int mapas = 0;
            tipo = 0;
            GeneradorLab(Laberinto);
            System.out.println("1.Jugar");
            System.out.println("2.Cambiar de mapa");
            System.out.println("3.volver al menu");
            System.out.println("4.salir");

            mapas = entrada.nextInt();
            entrada.nextLine();

            switch (mapas) {
                case 1:
                    Jugar();
                    break;
                case 2:
                    contadorCambio = contadorCambio + 1;
                    CambiarMas();
                    menuMapas();
                    break;
                case 3:
                    menuP();
                    break;
                case 4:
                    error = false;
                    System.exit(0);
                    break;

                default:
                    error = false;
                    System.exit(0);
                    break;
            }
        }catch(Exception e){
			System.out.println("Ingrese valores numericos correctos");
            menuMapas();
		}
    }

    public static void masmaps(){
        try  {entrada = new Scanner(System.in);
            int submenutres = 0;
            tipo = 0;
            GeneradorLab(Laberinto);
            System.out.println("1.Cambiar de mapa");
            System.out.println("2.volver al menu");
            System.out.println("3.salir");
            submenutres = entrada.nextInt();
            entrada.nextLine();

            switch (submenutres) {
                case 1:
                    contadorCambio = contadorCambio + 1;
                    CambiarMas();
                    masmaps();
                    break;
                case 2:
                    menuP();
                    break;

                default:
                error = false;
                System.exit(0);
                System.out.println("\n***********Adios***********");
                    break;
            }
        }catch(Exception e){
			System.out.println("\n*************Ingrese valores numericos correctos*********\n");
            previs();
		}
    }

    /**Laberinto Incial
     * @return **/

    public static String[][][] LaberintoInicial() {
       String[][][] Laberinto ={ {
        {"#","#","#","#","#","#","#","#","S","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
        {"S","O","O","O","O","O","O","#","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","O","#","O","O","S"},
        {"#","#","#","#","#","#","O","O","#","#","#","O","#","#","#","O","#","O","O","#","#","#","#","#","#","O","O","#","O","#"},
        {"#","O","O","O","O","#","O","#","O","O","#","O","#","O","#","O","#","O","#","O","#","O","O","O","#","#","O","O","O","#"},
        {"#","O","#","#","O","#","O","O","O","O","#","O","#","O","#","O","#","#","O","O","#","O","#","O","O","#","O","#","O","#"},
        {"#","O","#","O","O","#","O","#","#","#","#","#","#","O","#","O","O","O","#","O","#","O","#","#","#","#","O","#","O","#"},
        {"#","O","#","#","O","O","O","O","O","O","#","O","#","O","O","O","O","O","O","O","O","O","#","O","O","O","O","#","#","#"},
        {"#","#","O","O","O","#","O","#","O","#","O","O","#","#","O","#","#","O","#","#","#","#","#","O","#","O","#","#","O","#"},
        {"#","O","O","#","O","#","O","O","O","#","O","#","O","#","O","O","#","O","#","O","O","O","O","O","#","O","O","#","O","#"},
        {"#","O","#","#","O","#","#","#","O","#","O","#","#","O","#","O","#","#","#","O","#","#","#","#","#","#","O","#","O","#"},
        {"#","O","O","O","O","#","O","#","O","#","O","#","O","#","O","O","#","O","O","O","#","O","O","#","O","#","O","#","O","#"},
        {"#","#","#","O","#","O","O","O","O","#","O","#","O","#","#","O","#","#","#","#","#","O","#","O","#","#","O","#","O","#"},
        {"#","O","O","#","O","O","#","#","#","O","O","#","O","#","O","O","O","O","O","O","O","O","O","O","O","#","O","#","O","#"},
        {"#","#","O","#","#","O","#","O","O","#","O","#","O","#","O","O","O","#","O","#","#","O","#","O","O","#","O","#","O","#"},
        {"#","O","O","#","O","O","#","O","#","#","O","#","O","#","O","#","#","O","O","#","O","O","#","O","O","#","O","#","O","#"},
        {"#","#","O","#","#","O","O","O","O","#","O","#","#","#","O","#","O","O","O","O","O","#","O","O","#","#","O","#","O","#"},
        {"#","O","O","#","O","O","#","O","#","#","O","O","#","O","O","#","O","#","#","#","#","#","O","#","O","#","O","#","O","#"},
        {"#","#","O","O","O","#","#","#","O","#","O","#","O","#","O","O","O","#","O","O","O","O","O","O","O","O","#","#","O","#"},
        {"#","O","#","O","#","O","O","O","O","#","O","O","#","#","#","#","#","#","#","#","#","#","#","#","#","O","O","O","O","#"},
        {"#","O","#","O","O","O","#","#","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","#","#","O","#","O","#"},
        {"#","O","#","#","#","#","#","O","O","#","#","#","#","#","#","#","#","#","#","#","#","#","#","O","O","#","O","#","#","#"},
        {"#","O","#","O","O","O","#","O","#","O","O","O","O","O","O","O","O","O","O","O","O","O","O","#","O","#","O","O","O","S"},
        {"#","O","O","O","#","O","#","O","O","#","O","#","#","#","#","#","#","O","#","#","#","O","O","O","O","#","O","#","#","#"},
        {"#","#","#","#","#","O","#","O","#","O","O","#","O","O","O","O","#","O","O","O","#","O","#","#","#","#","O","#","O","#"},
        {"#","O","#","O","O","O","#","O","O","#","O","#","#","#","#","O","#","#","#","O","#","O","O","O","O","#","O","O","O","#"},
        {"#","O","#","#","#","O","#","#","#","#","O","#","O","O","O","O","#","O","#","O","#","#","#","O","#","O","#","#","O","#"},
        {"#","O","#","O","O","O","O","O","O","O","O","O","O","#","O","O","#","O","#","O","O","O","O","O","#","O","#","O","O","#"},
        {"#","O","#","#","#","#","#","#","#","#","#","O","#","O","#","#","#","O","#","O","#","#","#","#","#","O","O","O","#","#"},
        {"#","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","O","O","O","O","O","O","O","O","O","#","O","O","#"},
        {"#","#","#","#","#","#","#","#","#","#","#","#","#","S","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"}},

        {{"2","#","#","#","#","#","#","#","S","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
        {"S","O","#","O","#","O","O","O","O","O","#","O","O","O","#","O","#","O","O","O","O","O","O","O","O","O","O","O","O","S"},
        {"#","O","#","O","#","#","#","O","#","O","#","O","#","O","#","O","#","O","#","#","#","O","#","#","#","#","#","#","#","#"},
        {"#","O","#","O","O","O","O","O","#","O","#","O","#","O","#","O","#","O","#","O","O","O","#","#","O","O","O","#","O","#"},
        {"#","O","O","O","#","O","O","O","#","O","#","O","#","O","#","O","#","O","#","O","#","O","#","O","O","#","O","#","O","#"},
        {"#","O","#","O","#","#","#","#","#","O","#","O","#","O","#","O","#","O","#","O","#","O","#","O","#","#","O","#","O","#"},
        {"#","O","#","O","#","O","O","O","O","O","#","O","#","O","#","O","O","O","O","#","O","O","#","O","#","O","O","O","O","#"},
        {"#","O","#","O","#","O","#","#","#","#","#","O","#","O","#","O","#","#","O","#","O","#","#","O","#","O","#","#","#","#"},
        {"#","O","#","O","#","O","#","O","#","O","O","O","#","O","O","O","O","#","O","#","O","O","#","O","#","O","#","O","O","S"},
        {"#","O","#","O","#","O","#","O","#","#","#","#","#","#","#","#","O","#","O","#","#","O","#","O","#","O","#","#","O","#"},
        {"#","O","#","O","#","O","O","O","O","O","O","O","O","O","O","#","O","#","O","#","O","O","#","O","#","O","#","O","O","#"},
        {"#","O","#","#","#","#","#","#","#","#","#","#","#","#","O","#","O","#","O","#","O","#","#","O","#","O","#","O","#","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","S"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","#","#","#","#","#","#","#","#","#","#","#","#","S","#","#","#","#","S","#","#","#","#","#","#","#","#","#","#","#"}},

        {{"1","#","#","#","#","#","#","#","S","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
        {"S","O","#","O","#","O","O","O","O","O","#","O","O","O","#","O","#","O","O","O","O","O","O","O","O","O","O","O","O","S"},
        {"#","O","#","O","#","#","#","O","#","O","#","O","#","O","#","O","#","O","#","#","#","O","#","#","#","#","#","#","#","#"},
        {"#","O","#","O","O","O","O","O","#","O","#","O","#","O","#","O","#","O","#","O","O","O","#","#","O","O","O","#","O","#"},
        {"#","O","O","O","#","O","O","O","#","O","#","O","#","O","#","O","#","O","#","O","#","O","#","O","O","#","O","#","O","#"},
        {"#","O","#","O","#","#","#","#","#","O","#","O","#","O","#","O","#","O","#","O","#","O","#","O","#","#","O","#","O","#"},
        {"#","O","#","O","#","O","O","O","O","O","#","O","#","O","#","O","O","O","O","#","O","O","#","O","#","O","O","O","O","#"},
        {"#","O","#","O","#","O","#","#","#","#","#","O","#","O","#","O","#","#","O","#","O","#","#","O","#","O","#","#","#","#"},
        {"#","O","#","O","#","O","#","O","#","O","O","O","#","O","O","O","O","#","O","#","O","O","#","O","#","O","#","O","O","S"},
        {"#","O","#","O","#","O","#","O","#","#","#","#","#","#","#","#","O","#","O","#","#","O","#","O","#","O","#","#","O","#"},
        {"#","O","#","O","#","O","O","O","O","O","O","O","O","O","O","#","O","#","O","#","O","O","#","O","#","O","#","O","O","#"},
        {"#","O","#","#","#","#","#","#","#","#","#","#","#","#","O","#","O","#","O","#","O","#","#","O","#","O","#","O","#","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","S"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","O","O","O","O","O","O","O","O","O","O","#","O","O","O","O","O","O","O","#","O","O","O","O","#","O","O","O","O","#"},
        {"#","#","#","#","#","#","#","#","#","#","#","#","#","S","#","#","#","#","S","#","#","#","#","#","#","#","#","#","#","#"}},};
        return Laberinto;
    }

    /* Genreardor de Laberinto */
    public static void GeneradorLab(String[][][] Laber ) {
        
        if (tipo == 0) {
            skynet();

            activacion = 2;
        for (int i = 0; i < 30 ; i++) {
            for (int k = 0; k < 30; k++) {
                System.out.print(" "+Laber[matriz][i][k]);
                if (k == 29) {
                    System.out.println("");
                }
                if (Laber[matriz][i][k].equals("J") ) {
                    FilaJ = i;
                    ColumnaJ = k;
                }
                if (Laber[matriz][i][k].equals("B") ) {
                    filaB = i;
                    columnaB = k;
                }
                if (Laber[matriz][i][k].equals("G") ) {
                    conteoG = conteoG + 1;
                }
                if (Laber[matriz][filaG][columnaG].equals("O") && activacion == 2) {
                    Laber[matriz][filaG][columnaG] = "G";
                }
                if (FilaJ == filaB && ColumnaJ == columnaB && FilaJ != 0 && ColumnaJ != 0) {
                    Laberinto[matriz][filaB][columnaB] = "B";
                    visionBot = visionBot +1;
                    modo = 1;
                    Contadores();
                    ConteodeOroT = 0;
                    ConteodeOroT = ConteodeOroT +conteoOro;
                    ConteoB = ConteoB + 1;
                    ReportealF();
                    Reinicio();
                }
            }
        }
        
        }

        if (tipo == 1) {
            skynet();
            activacion = 2;
        for (int i = 0; i < 30 ; i++) {
            for (int k = 0; k < 30; k++) {
                if (Laber[matriz][i][k].equals("J") ) {
                    FilaJ = i;
                    ColumnaJ = k;
                }
                if (Laber[matriz][i][k].equals("B") ) {
                    
                    filaB = i;
                    columnaB = k;
                }
                if (Laber[matriz][i][k].equals("G") ) {
                    conteoG = conteoG + 1;
                }
                if (Laber[matriz][filaG][columnaG].equals("O") && activacion == 2) {
                    Laber[matriz][filaG][columnaG] = "G";
                }
                if (FilaJ == filaB && ColumnaJ == columnaB && FilaJ != 0 && ColumnaJ != 0) {
                    Laberinto[matriz][filaB][columnaB] = "B";
                    visionBot = visionBot +1;
                    modo = 1;
                    Contadores();
                    ConteodeOroT = 0;
                    ConteodeOroT = ConteodeOroT +conteoOro;
                    ConteoB = ConteoB + 1;
                    ReportealF();
                    Reinicio();
                }
            }
        }


            
                for (int i = -1; i < 2 ; i++) {
                    System.out.print("              ");
                    for (int k = -1; k < 2; k++) {
                        System.out.print(" "+Laber[matriz][(FilaJ+i)][(ColumnaJ+k)]);
                        if (k == 1) {
                            System.out.println("");
                        }
                    }
                }
                
        }

    }

    /* Jugar */
    //Se encarga de ejecutar todas las piezas del juego
    public static void Jugar() {
        try {
            Conteoconteo = Conteoconteo + 1;
            if (Conteoconteo == 1) {
                modo = 0;
                Contadores();
                conteoJugar = conteoJugar + 1;
            }

            tipo = 1;
            if (conteoT == 0) {
                System.out.println("**************Laberinto "+ matriz +"******************");
                GeneradorLab(Laberinto);


            }


            conteoT = 0;
            System.out.println("*********Hacia donde desea mover el jugador******");
            System.out.println("Norte = N" + "               Cantidad de Oro = " + conteoOro );
            System.out.println("Sur = S  " + "               Levantar oro = L");
            System.out.println("Este = E " + "               Mirar = M");
            System.out.println("Oeste = O" + "               Oro para salir = " + Oro);
            System.out.print("N,S,E,O :");
            letra = entrada.next();
            entrada.nextLine();
            mover(letra);
        } catch (Exception e) {
            System.out.println("\n*************Ingrese letras no numeros*********\n");
            Jugar();
        }

    }

    /* Espacios */
    //Busca la cantidad de O que hay en en el Laberinto;

    public static void Espacios(String[][][] Laber2) {
        Conteo = 0;

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                if (Laber2[matriz][i][j].equals("O")) {
                    Conteo = Conteo + 1;
                    Filas[Conteo] = i;
                    Columnas[Conteo] = j;
                }
            }
        }
    }

    /* Generador de Casilla aleatoria del jugador*/
    public static void jugador() {
        int aleator = 0;

        aleator = (int) (Math.random()*(Conteo)+1);

        Laberinto[matriz][Filas[aleator]][Columnas[aleator]] = "J";
    }

    /* Generador de Casilla aleatoria del Bot*/

    public static void Bot() {
        int aleator = 0;

        aleator = (int) (Math.random()*(Conteo)+1);

        Laberinto[matriz][Filas[aleator]][Columnas[aleator]] = "B";
    }

    /* Generador de Oro aleatorio entre 15 y 20 monedas */

    public static void GenerarOro() {
        int aleator = 0;
        Oro = 0;
        

        Oro = (int) (Math.random()*(20)+15);
        for (int index = 0; index < Oro; index++) {
            Espacios(Laberinto);
            aleator = (int) (Math.random()*(Conteo)+1);
            Laberinto[matriz][Filas[aleator]][Columnas[aleator]] = "G";
        }
    }

    public static void mover(String movimiento){
        conteomov = conteomov +1;
        conteomov2 = conteomov2 + 1;
        //Izquierda
        if (letra.equals("o") || letra.equals("O")){
            if (Laberinto[matriz][FilaJ][(ColumnaJ-1)].equals("O")) {
                Laberinto[matriz][FilaJ][(ColumnaJ-1)] = "J";
                Laberinto[matriz][FilaJ][ColumnaJ] = "O";
                System.out.println("\nSe ha movido al Oeste");
                Jugar();
            }
            if (Laberinto[matriz][FilaJ][(ColumnaJ-1)].equals("G")) {

                Laberinto[matriz][FilaJ][(ColumnaJ-1)] = "J";
                Laberinto[matriz][FilaJ][ColumnaJ] = "O";
                filaG = FilaJ;
                columnaG = (ColumnaJ-1);

                System.out.println("\nSe ha movido al Oeste");
                Jugar();

            }
            if (Laberinto[matriz][FilaJ][(ColumnaJ-1)].equals("S")) {
                Salir();
            }
            if (Laberinto[matriz][FilaJ][(ColumnaJ-1)].equals("B")) {
                filaB = FilaJ;
                columnaB = ColumnaJ;
                Jugar();
            }
        }
        //Arriba
        if (letra.equals("n") || letra.equals("N")){
            if (Laberinto[matriz][(FilaJ-1)][ColumnaJ].equals("O")) {
                Laberinto[matriz][(FilaJ-1)][ColumnaJ] = "J";
                Laberinto[matriz][FilaJ][ColumnaJ] = "O";
                System.out.println("\nSe ha movido al Norte");
                Jugar();
            }
            if (Laberinto[matriz][(FilaJ-1)][ColumnaJ].equals("G")) {
                Laberinto[matriz][(FilaJ-1)][ColumnaJ] = "J";
                Laberinto[matriz][FilaJ][ColumnaJ] = "O";
                filaG = (FilaJ-1);
                columnaG = ColumnaJ;

                System.out.println("\nSe ha movido al Norte");
                Jugar();
            }
            if (Laberinto[matriz][(FilaJ-1)][ColumnaJ].equals("S")) {
                Salir();
            }
            if (Laberinto[matriz][(FilaJ-1)][ColumnaJ].equals("B")) {
                filaB = FilaJ;
                columnaB = ColumnaJ;
                Jugar();
            }
        }
        //Derecha
        if (letra.equals("e") || letra.equals("E")){
            if (Laberinto[matriz][(FilaJ)][(ColumnaJ+1)].equals("O")) {
                Laberinto[matriz][FilaJ][(ColumnaJ+1)] = "J";
                Laberinto[matriz][FilaJ][ColumnaJ] = "O";
                System.out.println("\nSe ha movido al Este");
                Jugar();
            }
            if (Laberinto[matriz][FilaJ][(ColumnaJ+1)].equals("G")) {

                Laberinto[matriz][FilaJ][(ColumnaJ+1)] = "J";
                Laberinto[matriz][FilaJ][ColumnaJ] = "O";
                filaG = FilaJ;
                columnaG = (ColumnaJ+1);
                System.out.println("\nSe ha movido al Este");
                Jugar();
            }
            if (Laberinto[matriz][FilaJ][(ColumnaJ+1)].equals("S")) {
                Salir();
            }
            if (Laberinto[matriz][FilaJ][(ColumnaJ+1)].equals("B")) {
                filaB = FilaJ;
                columnaB = ColumnaJ;
                Jugar();
            }
        }
        //Abajo
        if (letra.equals("s") || letra.equals("S")){
            if (Laberinto[matriz][(FilaJ+1)][ColumnaJ].equals("O")) {
                Laberinto[matriz][(FilaJ+1)][ColumnaJ] = "J";
                Laberinto[matriz][FilaJ][ColumnaJ] = "O";
                System.out.println("\nSe ha movido al Sur");
                Jugar();
            }
            if (Laberinto[matriz][(FilaJ+1)][ColumnaJ].equals("G")) {
                Laberinto[matriz][(FilaJ+1)][ColumnaJ] = "J";
                Laberinto[matriz][FilaJ][ColumnaJ] = "O";
                filaG = (FilaJ+1);
                columnaG = ColumnaJ;
                conteoG = conteoG + 1;
                System.out.println("\nSe ha movido al Sur");
                Jugar();
            }
            if (Laberinto[matriz][(FilaJ + 1)][ColumnaJ].equals("S")) {
                Salir();
            }
            if (Laberinto[matriz][(FilaJ+1)][ColumnaJ].equals("B")) {
                filaB = FilaJ;
                columnaB = ColumnaJ;
                Jugar();
            }
        }
        //Levantar Oro
        if (letra.equals("l") || letra.equals("L")){
            Levantar();
            Jugar();
        }
        // Mirar
        if (letra.equals("m") || letra.equals("M")){
            conteoT = 0;
            conteoT = conteoT +1;
            System.out.println("\nSe ha Ejecutado mirar");
            System.out.println("**************Laberinto******************");
            Mirar(FilaJ,ColumnaJ);
        }
        else{
            Jugar();
        }

    }

    /* Levantar */
    //Se encarga de contar el oro que recoge el jugador

    public static void Levantar() {
       


        activacion = activacion - 1;
        if (ColumnaJ == columnaG && FilaJ == filaG) {
            System.out.println("\nSe ha levntado oro");
            conteoOro = conteoOro + 1;
        }
        
        filaG = 0;
        columnaG = 0;
    }

    /*Salir*/
    //El usurio saldra si tiene suficiente oro
    public static void Salir() {
        try (Scanner entrada = new Scanner(System.in)) {
            String salidaTotal;

            System.out.println("Presione S para salir si tiene suficiente oro");
            salidaTotal = entrada.next();
            entrada.nextLine();

            if (Oro == conteoOro) {
                if(salidaTotal.equals("S") || salidaTotal.equals("s")){
                    conteobye = 0;
                    conteobye = conteobye +1;
                    modo = 2;
                    conteoS = conteoS +1;
                    Contadores();
                    ConteodeOroT = 0;
                    ConteodeOroT = ConteodeOroT +conteoOro;
                    ReportealF();
                    Reinicio();

                }
                else{
                    if (Oro < conteoOro) {
                        System.out.println("Error ");
                        Reinicio();

                }
                else{
                    System.out.println("Por favor ingrese la letra S para salir");
                        Salir();
                    }
                }
            }
            else {
                System.out.println("Falta oro para salir siga jugando");
                Jugar();

            }

        }
        catch(Exception e){
            System.out.println("Ingrese las letras correctas");
        }
}

/* Reinicio */
public static void Reinicio() {
                    Laberinto = LaberintoInicial();
                    ColumnaJ = 0;
                    FilaJ = 0;
                    conteoG = 0;
                    conteomov2 = 0;
                    columnaG = 0;
                    Oro = 0;
                    filaG = 0;
                    columnaB = 0;
                    filaB = 0;
                    letra = "";
                    filaBot = 0;
                    columnaBot = 0;
                    visionBot = 0;
                    movBot = 0;
                    menuP();
}

/* Creador de mapas */

public static void creacion() {
    try (Scanner entrada = new Scanner(System.in)) {
        int numeroF = 0;
        String intermedio = "";
        int conteoAste = 0;
        numLab = numLab + 1;


        System.out.println("");
        System.out.println("**************Creacion de mapa**************");
        System.out.println("\nSolo puede crea un maximo de dos mapas");
        System.out.println("El oro, el bot y el jugador se gneran de manera aleatoria no es necesario crearlos en el mapa\n");
        System.out.println("Paredes = #   " + "Camino = O   " + "Salida = S   " + "Para guardar presione X" + "     Volver al menu presione V");

        for (int j = 0; j < 30 ; j++) {
                numeroF = numeroF + 1;
                if (j <= 8) {
                    System.out.print(numeroF + "  ");
                }
                else {
                    System.out.print(numeroF + " ");
                }
            for (int l = 0; l < 30; l++) {
                System.out.print(" "+(Laberinto[numLab][j][(l)]="*"));
                if (l == 29) {
                    System.out.println("");
                }
            }
        }

            for (int i = 0; i < 30 ; i++) {

                for (int k = 0; k < 30; k++) {
                    System.out.print("Ingrese el valor para el mapa :");
                    intermedio = entrada.next();


                    if (intermedio.equals("#") || intermedio.equals("O") || intermedio.equals("S") ) {
                        System.out.println("**************Creacion de mapa**************");
                        System.out.println("\nSolo puede crea un maximo de dos mapas");
                        System.out.println("El oro, el bot y el jugador se gneran de manera aleatoria no es necesario crearlos en el mapa\n");
                        System.out.println("Paredes = #   " + "Camino = O   " + "Salida = S   "+ "Para guardar presione X" + "     Volver al menu presione V");

                        Laberinto[numLab][i][(k)] = intermedio;

                        for (int j = 0; j < 30 ; j++) {
                            if (j <= 8) {
                                System.out.print((j+1) + "  ");
                            }
                            else {
                                System.out.print((j+1) + " ");
                            }

                            for (int l = 0; l < 30; l++) {
                                System.out.print(" "+Laberinto[numLab][j][(l)]);
                                if (l == 29) {
                                    System.out.println("");
                                }
                            }
                        }
                    }
                    else{
                        if (intermedio.equals("X") || intermedio.equals("x") ) {
                            conteoAste = 0;
                            for (int j = 0; j < 30 ; j++) {
                                for (int l = 0; l < 30; l++) {
                                    if (Laberinto[numLab][j][(l)].equals("*")){
                                        conteoAste = conteoAste +1;
                                        
                                    }
                                }
                            }

                            

                            if (conteoAste == 0) {
                                contadorLaberinto = contadorLaberinto + 1;
                                System.out.println("Laberinto guardado");
                                menuP();
                            } 
                            else{
                                if (conteoAste >0) {
                                    System.out.println("Termine de generar su laberinto");
                                        if (k == 0) {
                                            k = -1;
                                        }
                                        else{
                                            k = k-1;
                                        }
                                }
                            }
                            
                        }
                        else{
                            if (intermedio.equals("v") || intermedio.equals("V") ) {
                                contadorLaberinto = 0;
                                numLab = 0;
                                menuP();
                            }
                            else{
                                System.out.println("Ingrese las letras indicadas");
                                if (k == 0) {
                                    k = -1;
                                }
                                else{
                                    k = k-1;
                                }
                            }
                        }

                        
                    }
                }
            }
            String guardado = "";
            System.out.println("\n\n\n");
            System.out.println("Si quiere guadar su mapa presiones X");
            guardado =  entrada.next();
            entrada.nextInt();
            if (guardado.equals("X")||guardado.equals("x")) {
                System.out.println("Laberinto guardado");
                menuP();
            }
            else{
                System.out.println("Lo siento no guardo su mapa");
                contadorLaberinto = 0;
                numLab = 0;
                menuP();
            }
    }catch(Exception e){
        System.out.println("Error");
    }

}

    /* Cambiar de mapa */

    public static void CambiarMas() {
        if (contadorLaberinto == 1) {
            if(contadorCambio == 1){
                matriz = contadorCambio;
            }
            else{
                contadorCambio = 0;
                matriz = contadorCambio;
            }
        }
        else{
            if (contadorLaberinto == 2) {
                if(contadorCambio == 1){
                    matriz = contadorCambio;
                }
                if(contadorCambio == 2){
                    matriz = contadorCambio;
                }
                else{
                    contadorCambio = 0;
                    matriz = contadorCambio;
                }
            }
        }
    }

    /* Estadisticas y reportes */
    // Se encarga de recolectar todos los datos necesarios

    public static void Reportes() {
        int AtrapB = 0;
        int PartG = 0;
        float PromOro = 0;
        
        float PromMov = 0;
        int MapaMJ = 0;
        int MapaMPerd = 0;
        int MapaMGanad = 0;
        int MapasCread = 0;

        AtrapB = AtrapB + ConteoB;
        PartG = PartG + conteoS;
        SumaDeDatos = SumaDeDatos + ConteodeOroT;
        PromOro = SumaDeDatos/conteoJugar;
        PromMov = conteomov/conteoJugar;

        if (conteoMapa0 > conteoMapa1) {
            MapaMJ = 0;
        }
        if (conteoMapa1 > conteoMapa0){
            MapaMJ = 1;
        }
        if (conteoMapa2 > MapaMJ){
            MapaMJ = 2;
        }

        if (conteoMapa0mod1 > conteoMapa1mod1) {
            MapaMPerd = 0;
        }
        if (conteoMapa1mod1 > conteoMapa0mod1){
            MapaMPerd = 1;
        }
        if (conteoMapa2mod1 > MapaMJ){
            MapaMPerd = 2;
        }

        if (conteoMapa0mod2 > conteoMapa1mod2) {
            MapaMGanad = 0;
        }
        if (conteoMapa1mod2 > conteoMapa0mod2){
            MapaMGanad = 1;
        }
        if (conteoMapa2mod2 > MapaMJ){
            MapaMGanad = 2;
        }

        MapasCread = contadorLaberinto + 1;

        
        System.out.println("El Juagador fue atrapado por el bot " + AtrapB + " veces");
        System.out.println("El Juagador a ganado " + PartG + " veces");
        System.out.println("El promedio de oro por partida es " + PromOro );
        System.out.println("El promedio de movimientos por  partida es " + PromMov + " movimientos");
        System.out.println("El mapa mas jugado es el laberinto " + MapaMJ );
        System.out.println("El mapa en que mas se ha perdido es el laberinto " + MapaMPerd);
        System.out.println("El mapa en que mas se ha ganado es el laberinto " + MapaMGanad);
        System.out.println("Total de mapas " + MapasCread );
    }

    public static void Mirar(int fila, int columna) {

        if (conteoT  == 1) {
            if (fila >= 2 && columna >= 2 && fila <= 27 && columna <= 27) {
                for (int i = -2; i < 3; i++) {
                    System.out.print("              ");
                for (int j = -2; j < 3; j++) {
                    System.out.print(" " + Laberinto[matriz][(fila + i)][(columna + j)]);
                }
                System.out.println("");
                }
                Jugar();
            }
            else{
                if (fila >= 2 && columna == 1 && fila <= 27) {
                    for (int i = -2; i < 3; i++) {
                        System.out.print("              ");
                    for (int j = -1; j < 4; j++) {
                        System.out.print(" " + Laberinto[matriz][(fila + i)][(columna + j)]);
                    }
                    System.out.println("");
                    }
                    Jugar();
                }
                else{
                    if (fila >= 2 && columna == 28 && fila <= 27) {
                        for (int i = -2; i < 3; i++) {
                            System.out.print("              ");
                        for (int j = -3; j < 2; j++) {
                            System.out.print(" " + Laberinto[matriz][(fila + i)][(columna + j)]);
                        }
                        System.out.println("");
                        }
                        Jugar();
                    }
                    else{
                        if (fila == 1 && columna >= 2 && columna <=27) {
                            for (int i = -1; i < 4; i++) {
                                System.out.print("              ");
                            for (int j = -2; j < 3; j++) {
                                System.out.print(" " + Laberinto[matriz][(fila + i)][(columna + j)]);
                            }
                            System.out.println("");
                            }
                            Jugar();
                        }
                        else{
                            if (fila == 28 && columna >= 2 && columna <=27) {
                                for (int i = -3; i < 2; i++) {
                                    System.out.print("              ");
                                for (int j = -2; j < 3; j++) {
                                    System.out.print(" " + Laberinto[matriz][(fila + i)][(columna + j)]);
                                }
                                System.out.println("");
                                }
                                Jugar();
                            }
                            else{
                                if (fila == 1 && columna == 1) {
                                    
                                        for (int i = -1; i < 4; i++) {
                                            System.out.print("              ");
                                        for (int j = -1; j < 4; j++) {
                                            System.out.print(" " + Laberinto[matriz][(fila + i)][(columna + j)]);
                                        }
                                        System.out.println("");
                                        }
                                        Jugar();
                                }
                                else{
                                    if (fila == 28 && columna == 1) {
                                    
                                        for (int i = -3; i < 2; i++) {
                                            System.out.print("              ");
                                        for (int j = -3; j < 2; j++) {
                                            System.out.print(" " + Laberinto[matriz][(fila + i)][(columna + j)]);
                                        }
                                        System.out.println("");
                                        }
                                        Jugar();
                                    }
                                    else{
                                        if (fila == 1 && columna == 28) {
                                    
                                            for (int i = -1; i < 4; i++) {
                                                System.out.print("              ");
                                            for (int j = -3; j < 2; j++) {
                                                System.out.print(" " + Laberinto[matriz][(fila + i)][(columna + j)]);
                                            }
                                            System.out.println("");
                                            }
                                            Jugar();
                                        }
                                        else{
                                            if (fila == 28 && columna == 28) {
                                    
                                                for (int i = -3; i < 2; i++) {
                                                    System.out.print("              ");
                                                for (int j = -3; j < 2; j++) {
                                                    System.out.print(" " + Laberinto[matriz][(fila + i)][(columna + j)]);
                                                }
                                                System.out.println("");
                                                }
                                                Jugar();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* Contadores */
    // Este metdoo cuenta la cantida de veces que se ejecuta un mapa en especifica

    public static void Contadores() {
        if (modo == 0){
            if(matriz == 0){
                conteoMapa0 = conteoMapa0 + 1;
            }
            if(matriz == 1){
                conteoMapa1 = conteoMapa1 + 1;
            }
            if(matriz == 2){
                conteoMapa2 = conteoMapa2 + 1;
            }
        }
        if (modo == 1){
            if(matriz == 0){
                conteoMapa0mod1 = conteoMapa0mod1 + 1;
            }
            if(matriz == 1){
                conteoMapa1mod1 = conteoMapa1mod1 + 1;
            }
            if(matriz == 2){
                conteoMapa2mod1 = conteoMapa2mod1 + 1;
            }
        }
        if (modo == 2){
            if(matriz == 0){
                conteoMapa0mod2 = conteoMapa0mod2 + 1;
            }
            if(matriz == 1){
                conteoMapa1mod2 = conteoMapa1mod2 + 1;
            }
            if(matriz == 2){
                conteoMapa2mod2 = conteoMapa2mod2 + 1;
            }
        }
    }

    public static void skynet() {
        

        int rep = 0;
        int rep2 = 0;
        conteobas = 0;

        for (int i = 0; i < 30 ; i++) {
            for (int k = 0; k <30 ; k++) {
                if (Laberinto[matriz][i][k].equals("B")) {
                    conteobas= conteobas + 1;
                    if (conteobas == 1) {
                        
                        columnaBot = k;
                        filaBot = i;
                        rep = columnaB;
                        rep2 = filaBot;

                    }
                    else{
                        if (conteobas == 2){
                            Laberinto[matriz][rep2][rep] = "O";
                        }
                    }
                }
            }
        }
        
            


        if (columnaBot > 1 && columnaBot < 28 && filaBot >1 && filaBot < 28){

            if (Laberinto[matriz][(filaBot + 2)][(columnaBot)].equals("J") ||
                Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("J") ||
                Laberinto[matriz][(filaBot-2)][(columnaBot)].equals("J") ||
                Laberinto[matriz][(filaBot-1)][(columnaBot)].equals("J") ||
                Laberinto[matriz][(filaBot)][(columnaBot-2)].equals("J") ||
                Laberinto[matriz][(filaBot)][(columnaBot-1)].equals("J") ||
                Laberinto[matriz][(filaBot)][(columnaBot+1)].equals("J") |
                Laberinto[matriz][(filaBot)][(columnaBot + 2)].equals("J")) {

            visionBot = visionBot + 1;
            Laberinto[matriz][FilaJ][ColumnaJ] = "B";
            Laberinto[matriz][filaBot][columnaBot] = "O";
            columnaB = ColumnaJ;
            filaB = FilaJ;
            modo = 1;
            Contadores();
            Laberinto[matriz][filaBot][columnaBot] = "B";
            ReportealF();
            ConteodeOroT = 0;
            ConteodeOroT = ConteodeOroT +conteoOro;
            ConteoB = ConteoB + 1;
            Reinicio();

        }
        else{
            if (Laberinto[matriz][(filaBot + 2)][(columnaBot)].equals("G") ||
                Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("G") ||
                Laberinto[matriz][(filaBot-2)][(columnaBot)].equals("G") ||
                Laberinto[matriz][(filaBot-1)][(columnaBot)].equals("G") ||
                Laberinto[matriz][(filaBot)][(columnaBot-2)].equals("G") ||
                Laberinto[matriz][(filaBot)][(columnaBot-1)].equals("G") ||
                Laberinto[matriz][(filaBot)][(columnaBot+1)].equals("G") |
                Laberinto[matriz][(filaBot)][(columnaBot + 2)].equals("G")) {

                    aleator3 = (int) (Math.random() * (4)) + 1;
                    conteoDeOpciones = 0;
                    moverbot();

        }
         else {
            if (Laberinto[matriz][(filaBot + 2)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot - 2)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot - 2)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot - 1)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot + 2)].equals("O") 
                    ) {

                aleator3 = (int) (Math.random() * (4)) + 1;
                conteoDeOpciones = 0;
                moverbot();

            }
        else {
            if (Laberinto[matriz][(filaBot - 2)][(columnaBot)].equals("O") &&
                Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") &&
                Laberinto[matriz][(filaBot)][(columnaBot - 2)].equals("O") &&
                Laberinto[matriz][(filaBot)][(columnaBot - 1)].equals("O") &&
                Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O") &&
                Laberinto[matriz][(filaBot)][(columnaBot + 2)].equals("O") 
                ) {

                    aleator3 = (int) (Math.random() * (3)) + 1;
                    conteoDeOpciones = 1;
                    moverbot();

            }
            else {
                if (Laberinto[matriz][(filaBot + 2)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot - 2)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot - 1)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot + 2)].equals("O") 
                    ) {

                        aleator3 = (int) (Math.random() * (3)) + 1;
                        conteoDeOpciones = 2;
                        moverbot();

            }
            else {
                if (Laberinto[matriz][(filaBot + 2)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot - 2)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot + 2)].equals("O") 
                                ) {

                            aleator3 = (int) (Math.random() * (3)) + 1;
                            conteoDeOpciones = 3;
                            moverbot();

                }
            else {
                if (Laberinto[matriz][(filaBot + 2)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot - 2)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot - 2)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot - 1)].equals("O") 
                    ) {

                                aleator3 = (int) (Math.random() * (3)) + 1;
                                conteoDeOpciones = 4;
                                moverbot();

                }
            else {
                if (Laberinto[matriz][(filaBot + 2)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot + 2)].equals("O") 
                ) {

                                aleator3 = (int) (Math.random() * (2)) + 1;
                                conteoDeOpciones = 5;
                                moverbot();

            }
            else {
                if (Laberinto[matriz][(filaBot + 2)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot - 2)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot - 1)].equals("O") 
                    ) {

                                aleator3 = (int) (Math.random() * (2)) + 1;
                                conteoDeOpciones = 6;
                                moverbot();

                }
                else {
                if (Laberinto[matriz][(filaBot - 2)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot + 2)].equals("O") 
                    ) {

                        aleator3 = (int) (Math.random() * (2)) + 1;
                        conteoDeOpciones = 7;
                        moverbot();

                }
                else {
                        if (Laberinto[matriz][(filaBot - 2)][(columnaBot)].equals("O") &&
                            Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") &&
                            Laberinto[matriz][(filaBot)][(columnaBot - 2)].equals("O") &&
                            Laberinto[matriz][(filaBot)][(columnaBot - 1)].equals("O") 
                        ) {

                        aleator3 = (int) (Math.random() * (2)) + 1;
                        conteoDeOpciones = 8;
                        moverbot();

                }
                else {
                        if (Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                            Laberinto[matriz][(filaBot)][(columnaBot + 2)].equals("O") &&
                            Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O") ) {

                            aleator3 = (int) (Math.random() * (2)) + 1;
                            conteoDeOpciones = 15;
                            moverbot();

                        }
                else {
                        if (Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                            Laberinto[matriz][(filaBot)][(columnaBot - 2)].equals("O") &&
                            Laberinto[matriz][(filaBot)][(columnaBot - 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2)) + 1;
                            conteoDeOpciones = 16;
                            moverbot();

                        }
                else {
                        if (Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") &&
                            Laberinto[matriz][(filaBot)][(columnaBot + 2)].equals("O") &&
                            Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O") ) {

                            aleator3 = (int) (Math.random() * (2)) + 1;
                            conteoDeOpciones = 17;
                            moverbot();

                        }
                else {
                        if (Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") &&
                            Laberinto[matriz][(filaBot)][(columnaBot - 2)].equals("O")&&
                            Laberinto[matriz][(filaBot)][(columnaBot - 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2)) + 1;
                            conteoDeOpciones = 18;
                            moverbot();

                        } 
                else {
                        if (Laberinto[matriz][(filaBot+ 2)][(columnaBot)].equals("O") &&
                            Laberinto[matriz][(filaBot+ 1)][(columnaBot)].equals("O") &&
                            Laberinto[matriz][(filaBot- 2)][(columnaBot)].equals("O") &&
                            Laberinto[matriz][(filaBot- 1)][(columnaBot)].equals("O")) {

                            aleator3 = (int) (Math.random()* (2)) + 1;
                            conteoDeOpciones = 9;
                            moverbot();

                    }
                    else {
                        if (Laberinto[matriz][(filaBot)][(columnaBot- 2)].equals("O") &&
                            Laberinto[matriz][(filaBot)][(columnaBot- 1)].equals("O") &&
                            Laberinto[matriz][(filaBot)][(columnaBot+ 1)].equals("O") &&
                            Laberinto[matriz][(filaBot)][(columnaBot+ 2)].equals("O")) {

                            aleator3 = (int) (Math.random()* (2)) + 1;
                            conteoDeOpciones = 10;
                            moverbot();
                        }
                    else {
                        if (Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                            Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2)) + 1;
                            conteoDeOpciones = 19;
                            moverbot();

                        }
                        else {
                        if (Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                            Laberinto[matriz][(filaBot)][(columnaBot - 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2)) + 1;
                            conteoDeOpciones = 20;
                            moverbot();

                        }
                        else {
                        if (Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") &&
                            Laberinto[matriz][(filaBot)][(columnaBot+ 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2)) + 1;
                            conteoDeOpciones = 21;
                            moverbot();

                        }
                        else {
                        if (Laberinto[matriz][(filaBot- 1)][(columnaBot)].equals("O") &&
                            Laberinto[matriz][(filaBot)][(columnaBot- 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2))+ 1;
                            conteoDeOpciones = 22;
                            moverbot();

                        }
                        else {
                        if (Laberinto[matriz][(filaBot+ 1)][(columnaBot)].equals("O") ) {

                            aleator3 = 1;
                            conteoDeOpciones = 11;
                            moverbot();

                            } else {
                        if (Laberinto[matriz][(filaBot- 1)][(columnaBot)].equals("O")) {

                        aleator3 = 1;
                        conteoDeOpciones = 12;
                        moverbot();

                        }
                        else {
                        if (Laberinto[matriz][(filaBot)][(columnaBot+ 1)].equals("O")) {

                            aleator3 = 1;
                            conteoDeOpciones = 13;
                            moverbot();
                        }
                        else {
                        if (Laberinto[matriz][(filaBot)][(columnaBot- 1)].equals("O")) {

                        aleator3 = 1;
                        conteoDeOpciones = 14;
                        moverbot();
                        }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        //Fila 1 columnas del 1 al 28

        if (columnaBot > 1 && columnaBot < 28 && filaBot == 1){

            if (Laberinto[matriz][(filaBot + 2)][(columnaBot)].equals("G") ||
                Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("G") ||
                Laberinto[matriz][(filaBot-1)][(columnaBot)].equals("G") ||
                Laberinto[matriz][(filaBot)][(columnaBot-2)].equals("G") ||
                Laberinto[matriz][(filaBot)][(columnaBot-1)].equals("G") ||
                Laberinto[matriz][(filaBot)][(columnaBot+1)].equals("G") |
                Laberinto[matriz][(filaBot)][(columnaBot + 2)].equals("G")) {

                    aleator3 = (int) (Math.random() * (4)) + 1;
                    conteoDeOpciones = 0;
                    moverbot();

            }
            else{

            if (Laberinto[matriz][(filaBot + 2)][(columnaBot)].equals("J") ||
                Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("J") ||
                Laberinto[matriz][(filaBot-1)][(columnaBot)].equals("J") ||
                Laberinto[matriz][(filaBot)][(columnaBot-2)].equals("J") ||
                Laberinto[matriz][(filaBot)][(columnaBot-1)].equals("J") ||
                Laberinto[matriz][(filaBot)][(columnaBot+1)].equals("J") |
                Laberinto[matriz][(filaBot)][(columnaBot + 2)].equals("J")) {

                    visionBot = visionBot + 1;
                    Laberinto[matriz][FilaJ][ColumnaJ] = "B";
                    Laberinto[matriz][filaBot][columnaBot] = "O";
            }
            else{
                if (Laberinto[matriz][(filaBot + 2)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot - 2)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot - 1)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot + 2)].equals("O") 
                    ) {

                        aleator3 = (int) (Math.random() * (3)) + 1;
                        conteoDeOpciones = 2;
                        moverbot();

                }
            else{
                if (Laberinto[matriz][(filaBot+ 2)][(columnaBot)].equals("O") &&
                Laberinto[matriz][(filaBot+ 1)][(columnaBot)].equals("O") &&
                Laberinto[matriz][(filaBot- 1)][(columnaBot)].equals("O")) {

                aleator3 = (int) (Math.random()* (2)) + 1;
                conteoDeOpciones = 9;
                moverbot();

        }
        else {
            if (Laberinto[matriz][(filaBot)][(columnaBot- 1)].equals("O") &&
                Laberinto[matriz][(filaBot)][(columnaBot+ 1)].equals("O") &&
                Laberinto[matriz][(filaBot)][(columnaBot+ 2)].equals("O")) {

                aleator3 = (int) (Math.random()* (2)) + 1;
                conteoDeOpciones = 10;
                moverbot();
            }
            else{
                if (Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2)) + 1;
                            conteoDeOpciones = 19;
                            moverbot();

                }
                else {
                if (Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                            Laberinto[matriz][(filaBot)][(columnaBot - 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2)) + 1;
                            conteoDeOpciones = 20;
                            moverbot();

                }
                else {
                if (Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot+ 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2)) + 1;
                            conteoDeOpciones = 21;
                            moverbot();

                }
                else {
                if (Laberinto[matriz][(filaBot- 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot- 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2))+ 1;
                            conteoDeOpciones = 22;
                            moverbot();

                }
                else{
                    if (Laberinto[matriz][(filaBot+ 1)][(columnaBot)].equals("O") ) {

                        aleator3 = 1;
                        conteoDeOpciones = 11;
                        moverbot();

                        } else {
                    if (Laberinto[matriz][(filaBot- 1)][(columnaBot)].equals("O")) {

                    aleator3 = 1;
                    conteoDeOpciones = 12;
                    moverbot();

                    }
                    else {
                    if (Laberinto[matriz][(filaBot)][(columnaBot+ 1)].equals("O")) {

                        aleator3 = 1;
                        conteoDeOpciones = 13;
                        moverbot();
                    }
                    else {
                    if (Laberinto[matriz][(filaBot)][(columnaBot- 1)].equals("O")) {

                    aleator3 = 1;
                    conteoDeOpciones = 14;
                    moverbot();
                    }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

//Fila 27 columnas del  1 al 27

        if (columnaBot > 1 && columnaBot < 28 && filaBot == 27){

            if (Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("G") ||
                Laberinto[matriz][(filaBot-1)][(columnaBot)].equals("G") ||
                Laberinto[matriz][(filaBot-2)][(columnaBot)].equals("G") ||
                Laberinto[matriz][(filaBot)][(columnaBot-2)].equals("G") ||
                Laberinto[matriz][(filaBot)][(columnaBot-1)].equals("G") ||
                Laberinto[matriz][(filaBot)][(columnaBot+1)].equals("G") |
                Laberinto[matriz][(filaBot)][(columnaBot + 2)].equals("G")) {

                    aleator3 = (int) (Math.random() * (4)) + 1;
                    conteoDeOpciones = 0;
                    moverbot();

            }
            else{

            if (Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("J") ||
                Laberinto[matriz][(filaBot-1)][(columnaBot)].equals("J") ||
                Laberinto[matriz][(filaBot-2)][(columnaBot)].equals("J") ||
                Laberinto[matriz][(filaBot)][(columnaBot-2)].equals("J") ||
                Laberinto[matriz][(filaBot)][(columnaBot-1)].equals("J") ||
                Laberinto[matriz][(filaBot)][(columnaBot+1)].equals("J") |
                Laberinto[matriz][(filaBot)][(columnaBot + 2)].equals("J")) {

                    visionBot = visionBot + 1;
                    Laberinto[matriz][FilaJ][ColumnaJ] = "B";
                    Laberinto[matriz][filaBot][columnaBot] = "O";
            }
            else{
            if (Laberinto[matriz][(filaBot - 2)][(columnaBot)].equals("O") &&
                Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") &&
                Laberinto[matriz][(filaBot)][(columnaBot - 2)].equals("O") &&
                Laberinto[matriz][(filaBot)][(columnaBot - 1)].equals("O") &&
                Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O") &&
                Laberinto[matriz][(filaBot)][(columnaBot + 2)].equals("O") 
                ) {

                    aleator3 = (int) (Math.random() * (3)) + 1;
                    conteoDeOpciones = 1;
                    moverbot();

            }
            else{
                if (Laberinto[matriz][(filaBot+ 1)][(columnaBot)].equals("O") &&
                Laberinto[matriz][(filaBot- 1)][(columnaBot)].equals("O")) {

                aleator3 = (int) (Math.random()* (2)) + 1;
                conteoDeOpciones = 9;
                moverbot();

        }
        else {
            if (Laberinto[matriz][(filaBot)][(columnaBot- 1)].equals("O") &&
                Laberinto[matriz][(filaBot)][(columnaBot+ 1)].equals("O") &&
                Laberinto[matriz][(filaBot)][(columnaBot+ 2)].equals("O")) {

                aleator3 = (int) (Math.random()* (2)) + 1;
                conteoDeOpciones = 10;
                moverbot();
            }
            else{
                if (Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2)) + 1;
                            conteoDeOpciones = 19;
                            moverbot();

                }
                else {
                if (Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                            Laberinto[matriz][(filaBot)][(columnaBot - 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2)) + 1;
                            conteoDeOpciones = 20;
                            moverbot();

                }
                else {
                if (Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot+ 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2)) + 1;
                            conteoDeOpciones = 21;
                            moverbot();

                }
                else {
                if (Laberinto[matriz][(filaBot- 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot- 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2))+ 1;
                            conteoDeOpciones = 22;
                            moverbot();

                }
                else{
                    if (Laberinto[matriz][(filaBot+ 1)][(columnaBot)].equals("O") ) {

                        aleator3 = 1;
                        conteoDeOpciones = 11;
                        moverbot();

                        } else {
                    if (Laberinto[matriz][(filaBot- 1)][(columnaBot)].equals("O")) {

                    aleator3 = 1;
                    conteoDeOpciones = 12;
                    moverbot();

                    }
                    else {
                    if (Laberinto[matriz][(filaBot)][(columnaBot+ 1)].equals("O")) {

                        aleator3 = 1;
                        conteoDeOpciones = 13;
                        moverbot();
                    }
                    else {
                    if (Laberinto[matriz][(filaBot)][(columnaBot- 1)].equals("O")) {

                    aleator3 = 1;
                    conteoDeOpciones = 14;
                    moverbot();
                    }
                                                            
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // coolumna 1 filas del 1 a 28

        if (columnaBot == 1 && filaBot < 28 && filaBot > 1){
            if (Laberinto[matriz][(filaBot + 2)][(columnaBot)].equals("G") ||
                Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("G") ||
                Laberinto[matriz][(filaBot-1)][(columnaBot)].equals("G") ||
                Laberinto[matriz][(filaBot-2)][(columnaBot)].equals("G") ||
                Laberinto[matriz][(filaBot)][(columnaBot-1)].equals("G") ||
                Laberinto[matriz][(filaBot)][(columnaBot+1)].equals("G") |
                Laberinto[matriz][(filaBot)][(columnaBot + 2)].equals("G")) {

                    aleator3 = (int) (Math.random() * (4)) + 1;
                    conteoDeOpciones = 0;
                    moverbot();

            }
            else{

            if (Laberinto[matriz][(filaBot + 2)][(columnaBot)].equals("J") ||
                Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("J") ||
                Laberinto[matriz][(filaBot-1)][(columnaBot)].equals("J") ||
                Laberinto[matriz][(filaBot-2)][(columnaBot)].equals("J") ||
                Laberinto[matriz][(filaBot)][(columnaBot-1)].equals("J") ||
                Laberinto[matriz][(filaBot)][(columnaBot+1)].equals("J") |
                Laberinto[matriz][(filaBot)][(columnaBot + 2)].equals("J")) {

                    visionBot = visionBot + 1;
                    Laberinto[matriz][FilaJ][ColumnaJ] = "B";
                    Laberinto[matriz][filaBot][columnaBot] = "O";
            }
            else{
            if (Laberinto[matriz][(filaBot + 2)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot - 2)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot + 2)].equals("O") 
                                ) {

                            aleator3 = (int) (Math.random() * (3)) + 1;
                            conteoDeOpciones = 3;
                            moverbot();
                }
                else{
                    if (Laberinto[matriz][(filaBot+ 2)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot+ 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot- 1)][(columnaBot)].equals("O")) {
    
                    aleator3 = (int) (Math.random()* (2)) + 1;
                    conteoDeOpciones = 9;
                    moverbot();
    
            }
            else {
                if (Laberinto[matriz][(filaBot)][(columnaBot- 1)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot+ 1)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot+ 2)].equals("O")) {
    
                    aleator3 = (int) (Math.random()* (2)) + 1;
                    conteoDeOpciones = 10;
                    moverbot();
                }
                else{
                    if (Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                        Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O")) {
    
                                aleator3 = (int) (Math.random() * (2)) + 1;
                                conteoDeOpciones = 19;
                                moverbot();
    
                    }
                    else {
                    if (Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                                Laberinto[matriz][(filaBot)][(columnaBot - 1)].equals("O")) {
    
                                aleator3 = (int) (Math.random() * (2)) + 1;
                                conteoDeOpciones = 20;
                                moverbot();
    
                    }
                    else {
                    if (Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") &&
                        Laberinto[matriz][(filaBot)][(columnaBot+ 1)].equals("O")) {
    
                                aleator3 = (int) (Math.random() * (2)) + 1;
                                conteoDeOpciones = 21;
                                moverbot();
    
                    }
                    else {
                    if (Laberinto[matriz][(filaBot- 1)][(columnaBot)].equals("O") &&
                        Laberinto[matriz][(filaBot)][(columnaBot- 1)].equals("O")) {
    
                                aleator3 = (int) (Math.random() * (2))+ 1;
                                conteoDeOpciones = 22;
                                moverbot();
    
                    }
                    else{
                        if (Laberinto[matriz][(filaBot+ 1)][(columnaBot)].equals("O") ) {
    
                            aleator3 = 1;
                            conteoDeOpciones = 11;
                            moverbot();
    
                            } else {
                        if (Laberinto[matriz][(filaBot- 1)][(columnaBot)].equals("O")) {
    
                        aleator3 = 1;
                        conteoDeOpciones = 12;
                        moverbot();
    
                        }
                        else {
                        if (Laberinto[matriz][(filaBot)][(columnaBot+ 1)].equals("O")) {
    
                            aleator3 = 1;
                            conteoDeOpciones = 13;
                            moverbot();
                        }
                        else {
                        if (Laberinto[matriz][(filaBot)][(columnaBot- 1)].equals("O")) {
    
                        aleator3 = 1;
                        conteoDeOpciones = 14;
                        moverbot();
                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

//Columnas 28 filas del 1 a 27

        if (columnaBot == 28 && filaBot < 28 && filaBot > 1){
            if (Laberinto[matriz][(filaBot + 2)][(columnaBot)].equals("G") ||
                Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("G") ||
                Laberinto[matriz][(filaBot-1)][(columnaBot)].equals("G") ||
                Laberinto[matriz][(filaBot-2)][(columnaBot)].equals("J") ||
                Laberinto[matriz][(filaBot)][(columnaBot-2)].equals("G") ||
                Laberinto[matriz][(filaBot)][(columnaBot-1)].equals("G") ||
                Laberinto[matriz][(filaBot)][(columnaBot+1)].equals("G") ) {

                    aleator3 = (int) (Math.random() * (4)) + 1;
                    conteoDeOpciones = 0;
                    moverbot();

            }
            else{

            if (Laberinto[matriz][(filaBot + 2)][(columnaBot)].equals("J") ||
                Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("J") ||
                Laberinto[matriz][(filaBot-1)][(columnaBot)].equals("J") ||
                Laberinto[matriz][(filaBot-2)][(columnaBot)].equals("J") ||
                Laberinto[matriz][(filaBot)][(columnaBot-2)].equals("J") ||
                Laberinto[matriz][(filaBot)][(columnaBot-1)].equals("J") ||
                Laberinto[matriz][(filaBot)][(columnaBot+1)].equals("J") ) {

                    visionBot = visionBot + 1;
                    Laberinto[matriz][FilaJ][ColumnaJ] = "B";
                    Laberinto[matriz][filaBot][columnaBot] = "O";
            }
            else{
                if (Laberinto[matriz][(filaBot + 2)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot - 2)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O") 
                                ) {

                            aleator3 = (int) (Math.random() * (3)) + 1;
                            conteoDeOpciones = 3;
                            moverbot();

                    }

                    else{
                        if (Laberinto[matriz][(filaBot + 2)][(columnaBot)].equals("O") &&
                            Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                            Laberinto[matriz][(filaBot - 2)][(columnaBot)].equals("O") &&
                            Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") &&
                            Laberinto[matriz][(filaBot)][(columnaBot - 2)].equals("O") &&
                            Laberinto[matriz][(filaBot)][(columnaBot - 1)].equals("O") 
                            ) {

                                        aleator3 = (int) (Math.random() * (3)) + 1;
                                        conteoDeOpciones = 4;
                                        moverbot();

                        }
                        else{
                            if (Laberinto[matriz][(filaBot+ 2)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot+ 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot- 1)][(columnaBot)].equals("O")) {
    
                    aleator3 = (int) (Math.random()* (2)) + 1;
                    conteoDeOpciones = 9;
                    moverbot();
    
            }
            else {
                if (Laberinto[matriz][(filaBot)][(columnaBot- 1)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot+ 1)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot+ 2)].equals("O")) {
    
                    aleator3 = (int) (Math.random()* (2)) + 1;
                    conteoDeOpciones = 10;
                    moverbot();
                }
                else{
                    if (Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                        Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O")) {
    
                                aleator3 = (int) (Math.random() * (2)) + 1;
                                conteoDeOpciones = 19;
                                moverbot();
    
                    }
                    else {
                    if (Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                                Laberinto[matriz][(filaBot)][(columnaBot - 1)].equals("O")) {
    
                                aleator3 = (int) (Math.random() * (2)) + 1;
                                conteoDeOpciones = 20;
                                moverbot();
    
                    }
                    else {
                    if (Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") &&
                        Laberinto[matriz][(filaBot)][(columnaBot+ 1)].equals("O")) {
    
                                aleator3 = (int) (Math.random() * (2)) + 1;
                                conteoDeOpciones = 21;
                                moverbot();
    
                    }
                    else {
                    if (Laberinto[matriz][(filaBot- 1)][(columnaBot)].equals("O") &&
                        Laberinto[matriz][(filaBot)][(columnaBot- 1)].equals("O")) {
    
                                aleator3 = (int) (Math.random() * (2))+ 1;
                                conteoDeOpciones = 22;
                                moverbot();
    
                    }
                    else{
                        if (Laberinto[matriz][(filaBot+ 1)][(columnaBot)].equals("O") ) {
    
                            aleator3 = 1;
                            conteoDeOpciones = 11;
                            moverbot();
    
                            } else {
                        if (Laberinto[matriz][(filaBot- 1)][(columnaBot)].equals("O")) {
    
                        aleator3 = 1;
                        conteoDeOpciones = 12;
                        moverbot();
    
                        }
                        else {
                        if (Laberinto[matriz][(filaBot)][(columnaBot+ 1)].equals("O")) {
    
                            aleator3 = 1;
                            conteoDeOpciones = 13;
                            moverbot();
                        }
                        else {
                        if (Laberinto[matriz][(filaBot)][(columnaBot- 1)].equals("O")) {
    
                        aleator3 = 1;
                        conteoDeOpciones = 14;
                        moverbot();
                        }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }


/* ezquinaz*/
        if (columnaBot == 1 && filaBot == 1){
    if (Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
            Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O")) {

                    aleator3 = (int) (Math.random() * (2)) + 1;
                    conteoDeOpciones = 19;
                    moverbot();

        }
        else {
        if (Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot - 1)].equals("O")) {

                    aleator3 = (int) (Math.random() * (2)) + 1;
                    conteoDeOpciones = 20;
                    moverbot();

        }
        else {
        if (Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") &&
            Laberinto[matriz][(filaBot)][(columnaBot+ 1)].equals("O")) {

                    aleator3 = (int) (Math.random() * (2)) + 1;
                    conteoDeOpciones = 21;
                    moverbot();

        }
        else {
        if (Laberinto[matriz][(filaBot- 1)][(columnaBot)].equals("O") &&
            Laberinto[matriz][(filaBot)][(columnaBot- 1)].equals("O")) {

                    aleator3 = (int) (Math.random() * (2))+ 1;
                    conteoDeOpciones = 22;
                    moverbot();

        }
        else{
            if (Laberinto[matriz][(filaBot+ 1)][(columnaBot)].equals("O") ) {

                aleator3 = 1;
                conteoDeOpciones = 11;
                moverbot();

                } else {
            if (Laberinto[matriz][(filaBot- 1)][(columnaBot)].equals("O")) {

            aleator3 = 1;
            conteoDeOpciones = 12;
            moverbot();

            }
            else {
            if (Laberinto[matriz][(filaBot)][(columnaBot+ 1)].equals("O")) {

                aleator3 = 1;
                conteoDeOpciones = 13;
                moverbot();
            }
            else {
            if (Laberinto[matriz][(filaBot)][(columnaBot- 1)].equals("O")) {

            aleator3 = 1;
            conteoDeOpciones = 14;
            moverbot();
            }

                            }
                        }
                    }
                }
            }
        }
    }
}
        if (columnaBot == 28 && filaBot == 1){
            if (Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2)) + 1;
                            conteoDeOpciones = 19;
                            moverbot();

                }
                else {
                if (Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                            Laberinto[matriz][(filaBot)][(columnaBot - 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2)) + 1;
                            conteoDeOpciones = 20;
                            moverbot();

                }
                else {
                if (Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot+ 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2)) + 1;
                            conteoDeOpciones = 21;
                            moverbot();

                }
                else {
                if (Laberinto[matriz][(filaBot- 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot- 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2))+ 1;
                            conteoDeOpciones = 22;
                            moverbot();

                }
                else{
                    if (Laberinto[matriz][(filaBot+ 1)][(columnaBot)].equals("O") ) {

                        aleator3 = 1;
                        conteoDeOpciones = 11;
                        moverbot();

                        } else {
                    if (Laberinto[matriz][(filaBot- 1)][(columnaBot)].equals("O")) {

                    aleator3 = 1;
                    conteoDeOpciones = 12;
                    moverbot();

                    }
                    else {
                    if (Laberinto[matriz][(filaBot)][(columnaBot+ 1)].equals("O")) {

                        aleator3 = 1;
                        conteoDeOpciones = 13;
                        moverbot();
                    }
                    else {
                    if (Laberinto[matriz][(filaBot)][(columnaBot- 1)].equals("O")) {

                    aleator3 = 1;
                    conteoDeOpciones = 14;
                    moverbot();
                    }

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (columnaBot == 1 && filaBot == 28){
            if (Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2)) + 1;
                            conteoDeOpciones = 19;
                            moverbot();

                }
                else {
                if (Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                            Laberinto[matriz][(filaBot)][(columnaBot - 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2)) + 1;
                            conteoDeOpciones = 20;
                            moverbot();

                }
                else {
                if (Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot+ 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2)) + 1;
                            conteoDeOpciones = 21;
                            moverbot();

                }
                else {
                if (Laberinto[matriz][(filaBot- 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot- 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2))+ 1;
                            conteoDeOpciones = 22;
                            moverbot();

                }
                else{
                    if (Laberinto[matriz][(filaBot+ 1)][(columnaBot)].equals("O") ) {

                        aleator3 = 1;
                        conteoDeOpciones = 11;
                        moverbot();

                        } else {
                    if (Laberinto[matriz][(filaBot- 1)][(columnaBot)].equals("O")) {

                    aleator3 = 1;
                    conteoDeOpciones = 12;
                    moverbot();

                    }
                    else {
                    if (Laberinto[matriz][(filaBot)][(columnaBot+ 1)].equals("O")) {

                        aleator3 = 1;
                        conteoDeOpciones = 13;
                        moverbot();
                    }
                    else {
                    if (Laberinto[matriz][(filaBot)][(columnaBot- 1)].equals("O")) {

                    aleator3 = 1;
                    conteoDeOpciones = 14;
                    moverbot();
                    }

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (columnaBot == 28 && filaBot == 28){
            if (Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2)) + 1;
                            conteoDeOpciones = 19;
                            moverbot();

                }
                else {
                if (Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") &&
                            Laberinto[matriz][(filaBot)][(columnaBot - 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2)) + 1;
                            conteoDeOpciones = 20;
                            moverbot();

                }
                else {
                if (Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot+ 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2)) + 1;
                            conteoDeOpciones = 21;
                            moverbot();

                }
                else {
                if (Laberinto[matriz][(filaBot- 1)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot)][(columnaBot- 1)].equals("O")) {

                            aleator3 = (int) (Math.random() * (2))+ 1;
                            conteoDeOpciones = 22;
                            moverbot();

                }
                else{
                    if (Laberinto[matriz][(filaBot+ 1)][(columnaBot)].equals("O") ) {

                        aleator3 = 1;
                        conteoDeOpciones = 11;
                        moverbot();

                        } else {
                    if (Laberinto[matriz][(filaBot- 1)][(columnaBot)].equals("O")) {

                    aleator3 = 1;
                    conteoDeOpciones = 12;
                    moverbot();

                    }
                    else {
                    if (Laberinto[matriz][(filaBot)][(columnaBot+ 1)].equals("O")) {

                        aleator3 = 1;
                        conteoDeOpciones = 13;
                        moverbot();
                    }
                    else {
                    if (Laberinto[matriz][(filaBot)][(columnaBot- 1)].equals("O")) {

                    aleator3 = 1;
                    conteoDeOpciones = 14;
                    moverbot();
                    }

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    public static void moverbot() {

       


        if (aleator3 == 1 && conteoDeOpciones == 0 ||
                aleator3 == 1 && conteoDeOpciones == 1 ||
                aleator3 == 1 && conteoDeOpciones == 3 ||
                aleator3 == 1 && conteoDeOpciones == 4 ||
                aleator3 == 1 && conteoDeOpciones == 7 ||
                aleator3 == 1 && conteoDeOpciones == 8 ||
                aleator3 == 1 && conteoDeOpciones == 12 ||
                aleator3 == 1 && conteoDeOpciones == 9 ||
                aleator3 == 1 && conteoDeOpciones == 21 ||
                aleator3 == 1 && conteoDeOpciones == 17 ||
                aleator3 == 1 && conteoDeOpciones == 18 ||
                aleator3 == 1 && conteoDeOpciones == 22 ) {

            if (Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") && aleator3 == 1 && conteoDeOpciones == 17 ||
                    Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") && aleator3 == 1 && conteoDeOpciones == 18 ||
                    Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") && aleator3 == 1 && conteoDeOpciones == 12 ||
                    Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") && aleator3 == 1 && conteoDeOpciones == 20 ||
                    Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O") && aleator3 == 1 && conteoDeOpciones == 19) {

                        movBot = movBot +1;
                Laberinto[matriz][(filaBot)][(columnaBot)] = "O";
                Laberinto[matriz][(filaBot - 1)][(columnaBot)] = "B";

            } else {
                if (Laberinto[matriz][(filaBot - 2)][(columnaBot)].equals("O") &&
                    Laberinto[matriz][(filaBot - 1)][(columnaBot)].equals("O")) {

                        movBot = movBot +1;
                    Laberinto[matriz][(filaBot)][(columnaBot)] = "O";
                    Laberinto[matriz][(filaBot - 2)][(columnaBot)] = "B";
                }
            }

        }

        if (aleator3 == 2 && conteoDeOpciones == 0 ||
                aleator3 == 1 && conteoDeOpciones == 2 ||
                aleator3 == 2 && conteoDeOpciones == 3 ||
                aleator3 == 2 && conteoDeOpciones == 4 ||
                aleator3 == 1 && conteoDeOpciones == 5 ||
                aleator3 == 1 && conteoDeOpciones == 6 ||
                aleator3 == 1 && conteoDeOpciones == 11 ||
                aleator3 == 2 && conteoDeOpciones == 9 ||
                aleator3 == 1 && conteoDeOpciones == 15 ||
                aleator3 == 1 && conteoDeOpciones == 16 ||
                aleator3 == 1 && conteoDeOpciones == 19 ||
                aleator3 == 1 && conteoDeOpciones == 20 ) {
            if (Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") && aleator3 == 1 && conteoDeOpciones == 15 ||
            Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") && aleator3 == 1 && conteoDeOpciones == 11 ||
                    Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") && aleator3 == 1 && conteoDeOpciones == 16 ||
                    Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") && aleator3 == 1 && conteoDeOpciones == 21 ||
                    Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O") && aleator3 == 1 && conteoDeOpciones == 22) {
                        movBot = movBot +1;
                Laberinto[matriz][(filaBot)][(columnaBot)] = "O";
                Laberinto[matriz][(filaBot + 1)][(columnaBot)] = "B";
            } else {
                if (Laberinto[matriz][(filaBot + 2)][(columnaBot)].equals("O") &&
                        Laberinto[matriz][(filaBot + 1)][(columnaBot)].equals("O")) {
                            movBot = movBot +1;
                    Laberinto[matriz][(filaBot)][(columnaBot)] = "O";
                    Laberinto[matriz][(filaBot + 2)][(columnaBot)] = "B";
                }
            }
        }

        if (aleator3 == 3 && conteoDeOpciones == 0 ||
                aleator3 == 2 && conteoDeOpciones == 1 ||
                aleator3 == 2 && conteoDeOpciones == 2 ||
                aleator3 == 3 && conteoDeOpciones == 3 ||
                aleator3 == 2 && conteoDeOpciones == 5 ||
                aleator3 == 2 && conteoDeOpciones == 7 ||
                aleator3 == 1 && conteoDeOpciones == 13 ||
                aleator3 == 1 && conteoDeOpciones == 10 ||
                aleator3 == 2 && conteoDeOpciones == 15 ||
                aleator3 == 2 && conteoDeOpciones == 17 ||
                aleator3 == 2 && conteoDeOpciones == 19 ||
                aleator3 == 2 && conteoDeOpciones == 21) {

            if (Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O") && conteoDeOpciones == 15 ||
            Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O") && conteoDeOpciones == 13 ||
                    Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O") && conteoDeOpciones == 17 ||
                    Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O") && conteoDeOpciones == 19 ||
                    Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O") && conteoDeOpciones == 21) {
                        movBot = movBot +1;
                Laberinto[matriz][(filaBot)][(columnaBot)] = "O";
                Laberinto[matriz][(filaBot)][(columnaBot + 1)] = "B";
            } else {
                if (Laberinto[matriz][(filaBot)][(columnaBot + 2)].equals("O") &&
                        Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O")) {
                            movBot = movBot +1;
                    Laberinto[matriz][(filaBot)][(columnaBot)] = "O";
                    Laberinto[matriz][(filaBot)][(columnaBot + 2)] = "B";
                }
            }
        }

        if (aleator3 == 4 && conteoDeOpciones == 0 ||
                aleator3 == 3 && conteoDeOpciones == 1 ||
                aleator3 == 3 && conteoDeOpciones == 2 ||
                aleator3 == 3 && conteoDeOpciones == 4 ||
                aleator3 == 2 && conteoDeOpciones == 6 ||
                aleator3 == 2 && conteoDeOpciones == 8 ||
                aleator3 == 1 && conteoDeOpciones == 14 ||
                aleator3 == 2 && conteoDeOpciones == 10 ||
                aleator3 == 2 && conteoDeOpciones == 16 ||
                aleator3 == 2 && conteoDeOpciones == 18 ||
                aleator3 == 2 && conteoDeOpciones == 20 ||
                aleator3 == 2 && conteoDeOpciones == 22) {
            if (Laberinto[matriz][(filaBot)][(columnaBot - 1)].equals("O") && conteoDeOpciones == 16 ||
            Laberinto[matriz][(filaBot)][(columnaBot + 1)].equals("O") && conteoDeOpciones == 14 ||
                    Laberinto[matriz][(filaBot)][(columnaBot - 1)].equals("O") && conteoDeOpciones == 18 ||
                    Laberinto[matriz][(filaBot)][(columnaBot - 1)].equals("O") && conteoDeOpciones == 20 ||
                    Laberinto[matriz][(filaBot)][(columnaBot - 1)].equals("O") && conteoDeOpciones == 22) {
                Laberinto[matriz][(filaBot)][(columnaBot)] = "O";
                Laberinto[matriz][(filaBot)][(columnaBot - 1)] = "B";
            } else {movBot = movBot +1;
                if (Laberinto[matriz][(filaBot)][(columnaBot - 1)].equals("O") &&
                        Laberinto[matriz][(filaBot)][(columnaBot - 2)].equals("O")) {
                            movBot = movBot +1;
                    Laberinto[matriz][(filaBot)][(columnaBot)] = "O";
                    Laberinto[matriz][(filaBot)][(columnaBot - 2)] = "B";
                }
            }
        }
    }

    public static void ReportealF() {


        if (filaB == FilaJ  && columnaB == ColumnaJ && FilaJ != 0 && ColumnaJ != 0) {
            System.out.println("\n**********************El juego a terminado*******************");
        System.out.println("**********************El bot te a eliminado*******************");
        System.out.println("La cantidad de oro recolectado fue " + conteoOro);
        System.out.println("La cantidad de pasos fue de " + conteomov2);
        System.out.println("Cantidad de movimientos del bot " + movBot);
        System.out.println("Cantidad de veces que el jugador estuvo en la vision del bot fue " + visionBot);
        }

        if (conteobye == 1) {
            System.out.println("\n**********************El juego a terminado*******************");
            System.out.println("**********************Has ganado*******************");
            System.out.println("La cantidad de oro recolectado fue " + conteoOro);
            System.out.println("La cantidad de pasos fue de "+ conteomov2);
            System.out.println("Cantidad de movimientos del bot "+ movBot);
            System.out.println("Cantidad de veces que el jugador estuvo en la vision del bot fue " + visionBot);
        }

        }

}

