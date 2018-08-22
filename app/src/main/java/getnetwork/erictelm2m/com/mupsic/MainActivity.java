package getnetwork.erictelm2m.com.mupsic;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        long splashDelay = 1000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initApp();
            }
        }, splashDelay);
    }

    private void initApp() {

        Intent register = new Intent(this, Principal.class);
        startActivity(register);

    }


}
