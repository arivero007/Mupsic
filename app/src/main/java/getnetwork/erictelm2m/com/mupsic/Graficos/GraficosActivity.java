package getnetwork.erictelm2m.com.mupsic.Graficos;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.HashMap;

import getnetwork.erictelm2m.com.mupsic.R;

public class GraficosActivity extends AppCompatActivity {

    public static ArrayList myArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficos);

        GraphView graph1 = findViewById(R.id.graph1);

        createBarGraph(graph1);
    }

    public void createLineGraph(GraphView graph,HashMap<String, Object> hm){

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0,446),
                new DataPoint(10,133),
                new DataPoint(20,174),
                new DataPoint(30,243),
                new DataPoint(40,176),
                new DataPoint(50,92)
        });
        graph.setTitle("Tiempo-Kilometros");
        graph.addSeries(series);
        graph.getViewport().setScalable(true);
        graph.getViewport().setScrollable(true);
    }

    public void createBarGraph(GraphView graph){
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0,446),
                new DataPoint(10,133),
                new DataPoint(20,174),
                new DataPoint(30,243),
                new DataPoint(40,176),
                new DataPoint(50,92)
        });

        graph.addSeries(series);

        // set Axis Titles
        graph.setTitle("Tiempo-Kilometros");
        graph.getGridLabelRenderer().setHorizontalAxisTitle("Kilometros");
        graph.getGridLabelRenderer().setVerticalAxisTitleColor(getResources().getColor(R.color.colorAccent));
        graph.getGridLabelRenderer().setVerticalAxisTitle("Tiempo");
        graph.getGridLabelRenderer().setHorizontalAxisTitleColor(getResources().getColor(R.color.colorAccent));

        // set manual X bounds
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(100);
        graph.getViewport().setScalable(false);
        graph.getViewport().setScrollable(true);
        series.setColor(getResources().getColor(R.color.colorGreen));
        series.setSpacing(50);

    }
}
