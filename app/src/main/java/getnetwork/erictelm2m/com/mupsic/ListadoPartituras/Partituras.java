package getnetwork.erictelm2m.com.mupsic.ListadoPartituras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import getnetwork.erictelm2m.com.mupsic.R;
import getnetwork.erictelm2m.com.mupsic.Utils.Adaptador;

public class Partituras extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_partituras);

        ArrayList<ListaPartituras> datos = new ArrayList<ListaPartituras>();

        datos.add(new ListaPartituras("Partitura1","Sebastian Bach"));

        lista = (ListView) findViewById(R.id.ListView_listado);

        lista.setAdapter(new Adaptador(this, R.layout.entrada, datos) {
            @Override
            public void onEntrada(Object entrada, View view) {

                TextView texto_titulo = (TextView) view.findViewById(R.id.titulo);
                texto_titulo.setText(((ListaPartituras)entrada).getTitulo());

                TextView texto_autor = (TextView) view.findViewById(R.id.autor);
                texto_autor.setText(((ListaPartituras)entrada).getDescripcion());
            }
        });
    }
}
