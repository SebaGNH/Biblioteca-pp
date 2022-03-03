public class Libro {    
    private String titulo;
    private float precioReposicion;
    private int estado; //(1: disponible, 2: prestado, 3: extraviado)
    private Prestamo prestamo;

    public void settitulo (String titulo) {
        this.titulo = titulo;
    }
    public String gettitulo () {
        return titulo;
    }

    public void setprecioReposicion (float precioReposicion) {
        this.precioReposicion = precioReposicion;
    }
    public float getprecioReposicion () {
        return precioReposicion;
    }

    public void setestado (int estado) {
        this.estado = estado;
    }
    public int getestado () {
        return estado;
    }

    public void setprestamo (Prestamo prestamo) {
        this.prestamo = prestamo;
    }
    public Prestamo getprestamo () {
        return prestamo;
    }

    public String getElEstado(){
        if (getestado() == 1) {
            return "disponible";
        }else if(getestado() == 2){
            return "prestado";
        }else if(getestado() == 3){
            return "extraviado";
        }
        return "no esta cargada esta informacion";
    }

    public Libro(String titulo, float precioReposicion, int estado, Prestamo prestamo){
        this.titulo = titulo;
        this.precioReposicion = precioReposicion;
        this.estado = estado;
        this.prestamo = prestamo;
    }

    public float getPrecioReposicion(){
        float acumuladorPrecio = 0;
        if (estado == 3) {
            acumuladorPrecio += precioReposicion; 
        }
        return acumuladorPrecio;
    }

    @Override
    public String toString(){
        return "Libro Titulo: "+ this.titulo+", precio de reposicion: "+ this.precioReposicion+ ", estado: "+ getElEstado() + prestamo.toString();
    }
}
