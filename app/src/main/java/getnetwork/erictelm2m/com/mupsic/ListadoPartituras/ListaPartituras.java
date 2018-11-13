package getnetwork.erictelm2m.com.mupsic.ListadoPartituras;

public class ListaPartituras {

    private String titulo;
    private String descripcion;
    private String direccion;

    public ListaPartituras (String titulo, String descripcion) {

        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String getTitulo (){
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String dir){
        this.direccion = dir;
    }
}
