package getnetwork.erictelm2m.com.mupsic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import getnetwork.erictelm2m.com.mupsic.ListadoPartituras.Partituras;
import getnetwork.erictelm2m.com.mupsic.Localizacion.LocalizacionContacto;

public class Principal extends AppCompatActivity implements View.OnClickListener{

    private Button btnWeb;
    private Button btnBlog;
    private ListView listView;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        listView = (ListView)findViewById(R.id.list_view);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        btnWeb = (Button)findViewById(R.id.btn_web);
        btnWeb.setOnClickListener(this);
        btnBlog = (Button)findViewById(R.id.btn_blog);
        btnBlog.setOnClickListener(this);
        SharedPreferences pref = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

        if(!pref.getBoolean("appInstalled",false)) {
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("appInstalled",true);
            editor.commit();
            Intent intent = new Intent(Principal.this, MainActivity.class);
            startActivity(intent);
        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);

        final String[] opciones = {"Partituras","Videos","Localización y Contacto"};

        listView.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,opciones));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(Principal.this, "Item: " + opciones[i], Toast.LENGTH_SHORT).show();
                Intent intent;

                switch (i){

                    case (0):
                        intent = new Intent(Principal.this, Partituras.class);
                        startActivity(intent);
                        break;
                    case (2):
                        intent = new Intent(Principal.this, LocalizacionContacto.class);
                        startActivity(intent);
                        break;

                    default:
                        break;
                }

                drawerLayout.closeDrawers();
            }
        });
    }

/*No es necesario un menu izquierdo

    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menulateral, menu);
        return true;
}
*/
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        switch (id){

            case android.R.id.home:
                if (drawerLayout.isDrawerOpen(listView)) {
                    drawerLayout.closeDrawers();
                } else {
                    drawerLayout.openDrawer(listView);
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClick(View view){

        Uri uriWeb = Uri.parse("http://mupsic.com/");
        Uri uriBlog = Uri.parse("http://mupsic.com/blog-2/");
        Intent intent;

        switch (view.getId()) {

            case R.id.btn_web:
                intent = new Intent(Intent.ACTION_VIEW, uriWeb);
                startActivity(intent);
                break;

            case R.id.btn_blog:
                intent = new Intent(Intent.ACTION_VIEW, uriBlog);
                startActivity(intent);
                break;

                default:

                    break;
        }
    }
}
