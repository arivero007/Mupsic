package getnetwork.erictelm2m.com.mupsic.ListadoPartituras;

public class ListaPartituras {

    private String titulo;
    private String descripcion;

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
}
