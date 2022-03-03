public class Libro {

    private String titulo;
    private float precioReposicion;
    private int estado; //(1: disponible, 2: prestado, 3: extraviado)
    private Prestamo [] prestamo;

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

    public void setprestamo (Prestamo[] prestamo) {
        this.prestamo = prestamo;
    }
    public Prestamo[] getprestamo () {
        return prestamo;
    }
    
    public Libro(String titulo, float precioReposicion, int estado, int cantPrestamos){
        this.titulo = titulo;
        this.precioReposicion = precioReposicion;
        this.estado = estado;
        this.prestamo = new Prestamo[cantPrestamos];
    }
    
    
    @Override
    public String toString(){
        return "Libro Titulo: "+ this.titulo+", precio de reposicion: "+ this.precioReposicion+ ", estado: "+ getElEstado() + prestamo.toString();
    }

    public String getElEstado(){
        if (this.estado == 1) {
            return "disponible";
        }else if(this.estado == 2){
            return "prestado";
        }else if(this.estado == 3){
            return "extraviado";
        }
        return "no esta cargada esta informacion";
    }

    public float getPrecioReposicion(){
        float acumuladorPrecio = 0;
        if (estado == 3) {
            acumuladorPrecio += precioReposicion; 
        }
        return acumuladorPrecio;
    }

    public void agregarPrestamo(Prestamo p){
        for (int i = 0; i < prestamo.length; i++) {
            if (prestamo[i] == null) {
                prestamo[i] = p;
                break;
            }
        }
    }

    public String getListadoPersonas(){
        String mensaje = "";
        for (Prestamo presta : prestamo) {
            if(presta != null){
                mensaje = presta.getnombreSolicitante() + "\n";
            }
        }
        return mensaje;
    }

    public int getCantPrestamos(){
        int contador = 0;
        for (Prestamo presta : prestamo) {
            if(presta!= null){
                contador ++;
            }
        }
        return contador;
    }

}
