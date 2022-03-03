public class Prestamo {

    private String nombreSolicitante;
    private int cantDiasPrestamo;
    private boolean fueDevuelto;

    public void setnombreSolicitante (String nombreSolicitante) {
        this.nombreSolicitante = nombreSolicitante;
    }
    public String getnombreSolicitante () {
        return nombreSolicitante;
    }

    public void setcantDiasPrestamo (int cantDiasPrestamo) {
        this.cantDiasPrestamo = cantDiasPrestamo;
    }
    public int getcantDiasPrestamo () {
        return cantDiasPrestamo;
    }

    public void setfueDevuelto (boolean fueDevuelto) {
        this.fueDevuelto = fueDevuelto;
    }
    public boolean getfueDevuelto () {
        return fueDevuelto;
    }

    public Prestamo(String nombreSolicitante, int cantDiasPrestamo, boolean fueDevuelto){
        this.nombreSolicitante = nombreSolicitante;
        this.cantDiasPrestamo = cantDiasPrestamo;
        this.fueDevuelto = fueDevuelto;
    }

    public String getDevuelto(){
        if (this.fueDevuelto) {
            return ", fue devuelto.";
        }
        return ", no fue devuelto.";
    }

    @Override
    public String toString(){
        return "Prestamo Nombre del Solicitante: "+ this.nombreSolicitante+", Cantidad de dias prestado: "+this.cantDiasPrestamo+ getDevuelto();
    }

}
