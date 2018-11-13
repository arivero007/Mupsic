package getnetwork.erictelm2m.com.mupsic.Graficos;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;


public class GraphicsData extends AppCompatActivity{

        public static ArrayList<Long> time;
        public static ArrayList<String> speed;

        public ArrayList<Long> getTime() {
            return time;
        }

        public ArrayList<String> getSpeed() {
            return speed;
        }

}
