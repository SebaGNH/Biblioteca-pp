
import java.util.Scanner;

public class AppBiblioteca {
    
    public static void main(String[] args) throws Exception{
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Bienvenido, por favor ingrese la cantidad de libros que va a agregar");
        int cantLibros = sc.nextInt();
        Biblioteca biblioteca = new Biblioteca(cantLibros);

        for (int i = 0; i < cantLibros; i++) {
            System.out.println("Ingrese el titulo del libro "+ (i+1));
            String titulo = sc.next();

            System.out.println("Ingrese el precio de reposicion del libro "+ titulo);
            float precioReposicion = sc.nextFloat();

            System.out.println("Ingrese 1 si esta Disponible, 2 si esta Prestado o 3 si se encuentra extraviado");
            int estado = sc.nextInt();

            System.out.println("Ingrese cantidad de prestamos");
            int cantPrest = sc.nextInt();

            Libro libro = new Libro(titulo, precioReposicion, estado, cantPrest);

            for (int j = 0; j < cantPrest; j++) {
                System.out.println("Ingrese el nombre del solicitante");
                String nombreSolicitante = sc.next();
    
                System.out.println("Ingrese la cantidad de dias que sera prestado");
                int cantDiasPrestamo = sc.nextInt();

                System.out.println("Ingrese 1 si es que fue devuelto o 2 si es que todavia no fue devuelto");
                int devuelto = sc.nextInt();
                boolean fueDevuelto = false;
                    if (devuelto == 1) {
                        fueDevuelto = true;
                    }
                
                Prestamo prestamo = new Prestamo(nombreSolicitante, cantDiasPrestamo, fueDevuelto);

                libro.agregarPrestamo(prestamo);
            }             
            biblioteca.agregarLibro(libro); 
        }
        

        /* Inicio <-- SALIDAS ----- ----- ----- ----- ----- ----- ----- */
        
        System.out.println("Cantidad de libros por estado \n" + biblioteca.getCantLibrosPorEstado());

        System.out.println("La suma del precio para los libros extraviados es de $"+ biblioteca.getPrecioReposicionExtraviados());

        System.out.println("El promedio de veces que el libro fue prestado es de "+ biblioteca.getPromedioLibroPrestado());

        System.out.println("Ingrese el nombre de un libro para saber quienes lo solicitaron");
        String tituloLibros = sc.next();
        System.out.println(biblioteca.getNombreSolicitantes(tituloLibros));
        
        
        /* Fin <<<<-- SALIDAS ----- ----- ----- ----- ----- ----- ----- */
        sc.close();
    }    
}
