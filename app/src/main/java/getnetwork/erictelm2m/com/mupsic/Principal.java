package getnetwork.erictelm2m.com.mupsic;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity implements View.OnClickListener{

    private Button btnWeb;
    private Button btnBlog;
    private TextView txtWeb;
    private ListView listView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        listView = (ListView)findViewById(R.id.list_view);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        txtWeb  = (TextView)findViewById(R.id.text_web);
        btnWeb = (Button)findViewById(R.id.btn_web);
        btnWeb.setOnClickListener(this);
        btnBlog = (Button)findViewById(R.id.btn_blog);
        btnBlog.setOnClickListener(this);

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final String[] opciones = {"Partituras","Localización y Contacto"};

        listView.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,opciones));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(Principal.this, "Item: " + opciones[i], Toast.LENGTH_SHORT).show();
                Intent intent;

                switch (i){
                    case (1):
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

    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menulateral, menu);
        return true;
}

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

            case R.id.settings:
                txtWeb.setText("Entrando ajustes");
                return true;

            case R.id.lang:
                txtWeb.setText("Cambiando idioma");
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
