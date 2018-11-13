package getnetwork.erictelm2m.com.mupsic.ListadoPartituras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import getnetwork.erictelm2m.com.mupsic.R;
import getnetwork.erictelm2m.com.mupsic.Utils.Adaptador;

public class Partituras extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_partituras);

        ListView lista;

        ArrayList<ListaPartituras> datos = new ArrayList<>();

        datos.add(new ListaPartituras("Partitura1","Sebastian Bach"));

        lista = findViewById(R.id.ListView_listado);

        lista.setAdapter(new Adaptador(this, R.layout.entrada, datos) {
            @Override
            public void onEntrada(Object entrada, View view) {

                TextView texto_titulo = view.findViewById(R.id.titulo);
                texto_titulo.setText(((ListaPartituras)entrada).getTitulo());

                TextView texto_autor = view.findViewById(R.id.autor);
                texto_autor.setText(((ListaPartituras)entrada).getDescripcion());
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    ListaPartituras elegido = (ListaPartituras) adapterView.getItemAtPosition(i);
                    Toast toast = Toast.makeText(Partituras.this, "Abriendo PDF", Toast.LENGTH_LONG);
                    toast.show();

                    //Falta sacar url de elegido y hacer un intent para abrir PDFs;

                }
        });

    }
}
