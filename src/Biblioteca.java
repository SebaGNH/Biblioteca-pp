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

    public float getPrecioReposicionExtraviados(){
        float sumaPrecioExtraviados = 0f;
        for (Libro libro : libros) {
            if (libro !=null && libro.getestado() == 3) {
                sumaPrecioExtraviados += libro.getPrecioReposicion();
            }
        }
        return sumaPrecioExtraviados;
    }

    public String getNombreSolicitantesPorNombreLibro(String nombreLibro){
        String nombreSolicitantes = "";
        for (Libro libro : libros) {
            if(libro !=null && libro.gettitulo() == nombreLibro){
                nombreSolicitantes += libro.getprestamo().getnombreSolicitante()+ "\n";
            }
        }
        return nombreSolicitantes;
    }

    public String getNombreSolicitantes(String titulo){
        String nombreSolicitantes = "";
        for (Libro libro : libros) {
            if (libro !=null && libro.gettitulo() == titulo) {
                nombreSolicitantes += "\n" + libro.getprestamo().getnombreSolicitante();
            }
        }
        return nombreSolicitantes;
    }

    public float getPromedioLibroPrestado(){
        float cantLibrosPrestados = 0f;
        int cantTotalLibros =0;
        for (Libro libro : libros) {
            if (libro!=null) {
                if (libro.getElEstado() == "prestado") {
                    cantLibrosPrestados ++;
                } 
                cantTotalLibros ++;
            }
        }
        return (cantTotalLibros * cantLibrosPrestados) / 100; 
    } 
}
