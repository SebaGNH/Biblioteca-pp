public class Biblioteca {   
    Libro[] libros;

    public Biblioteca(int cantLibros){
        libros = new Libro[cantLibros];
    }

    public void agregarLibro(Libro libro){
        for (int i = 0; i < libros.length; i++) {
            if (libros[i]== null) {
                libros[i] = libro;
                break;
            }
        }
    }

    //Cantidad de libros en cada estado (tres totales)
    public String getCantLibrosPorEstado(){
        int disponible = 0;
        int prestado = 0;
        int extraviado = 0;
        for (Libro libro : libros) {
            if (libro != null){
                if (libro.getestado() == 1) {
                    disponible ++;
                }else if(libro.getestado() == 2){
                    prestado ++;
                }else if(libro.getestado() == 3){
                    extraviado ++;
                }
            }
        }    
        return "disponibles: "+ disponible + ", prestado: "+ prestado+ ", extraviado: "+ extraviado;
    }

    //Sumatoria del precio de reposición de todos los libros extraviados
    public float getPrecioReposicionExtraviados(){
        float sumaPrecioExtraviados = 0f;
        for (Libro libro : libros) {
            if (libro !=null && libro.getestado() == 3) {
                sumaPrecioExtraviados += libro.getPrecioReposicion();
            }
        }
        return sumaPrecioExtraviados;
    }

    //Nombre de todos los solicitantes de un libro en particular identificadopor su título
    public String getNombreSolicitantes(String titulo){
        String nombreSolicitantes = "";
        for (Libro libro : libros) {
            if (libro !=null && libro.gettitulo().equals(titulo)) {
                nombreSolicitantes += libro.getListadoPersonas();
            }
        }
        return nombreSolicitantes;
    }

    //Promedio de veces que fueron prestados los libros de la biblioteca. 
    //Es decir, se debe responder a la consulta de cuántas veces es prestado en promedio cada libro
    public float getPromedioLibroPrestado(){
        float acumulador = 0f;
        float contador = 0f;
        for (Libro libro : libros) {
            if (libro!=null) {
                contador ++;
                acumulador += libro.getCantPrestamos(); 
                
            }
        }
        return acumulador / contador;
    } 
}
