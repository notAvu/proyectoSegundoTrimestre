package clases;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Buscador buscador = new Buscador();

    /*    String[] palabras = {"p", "b"};
        String[] palabras1 = {"p", "d"};
        String[] palabras2 = {"p", "c"};
        String[] palabras3 = {"p", "b"};


        String[] palabras4 = {"p", "t"};



        String[] palabrasParaFiltar = {"p", "t"};

        buscador.agregarPagina(new Pagina("a", "c", 1, palabras));
        buscador.agregarPagina(new Pagina("b", "c", 2, palabras1));
        buscador.agregarPagina(new Pagina("c", "c", 3, palabras2));
        buscador.agregarPagina(new Pagina("d", "c", 2, palabras3));
        buscador.agregarPagina(new Pagina("e", "c", 1, palabras4));
        buscador.agregarPagina(new Pagina("t", "c", 2, palabras4));



        Pagina[] filtrado = buscador.ordenarBusqueda(palabrasParaFiltar);

        for(int i = 0; i < filtrado.length; i++) {

            System.out.println(filtrado[i]);

        }  */

        String[] palabras = {"p", "b"};
        Pagina pagina = new Pagina("primera", "a", 1, palabras);
        buscador.agregarPagina(pagina);

        int opcion = 1;

        System.out.println("1.Ingresar sin hipervinculo");
        System.out.println("2.Ingresar con hipervinculo");

        Scanner teclado = new Scanner(System.in);

        opcion = teclado.nextInt();
        String hiper = " ";

        switch (opcion) {

            case 1:

                //Introducir pag sin hip

                break;

            case 2:

                System.out.println("Introduce hipervinculo");
                teclado.nextLine();
                hiper = teclado.nextLine();
                if(buscador.comprobarPagina(hiper)) {

                    Pagina paginaDevuelta = buscador.obtenerPagina(hiper);
                    buscador.agregarPagina(new Pagina("segunda", "t", 1, paginaDevuelta, palabras));
                    System.out.println(pagina.getPageRank());


                } else {

                    System.out.println("no hay pagina asi");

                }

                break;

        }


    }


}
