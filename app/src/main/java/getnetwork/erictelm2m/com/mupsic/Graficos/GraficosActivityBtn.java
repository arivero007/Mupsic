package getnetwork.erictelm2m.com.mupsic.Graficos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import getnetwork.erictelm2m.com.mupsic.R;

public class GraficosActivityBtn extends AppCompatActivity {

    private LineChart lineChart;
    private BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficos_btn);

        //lineChart = findViewById(R.id.linechart);
        barChart = findViewById(R.id.barchart);

        JSONObject track = new JSONObject();
        JSONObject gps = new JSONObject();
        try {
            gps.put("t_00km",335);
            gps.put("t_10km",80);
            gps.put("t_20km",117);
            gps.put("t_30km",228);
            gps.put("t_40km",294);
            gps.put("t_50km",258);
            track.put("gps",gps);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        getSpeedTimeValues(track);
        createSpeedTimeBar();

    }

    private void getSpeedTimeValues(JSONObject track){

        JSONObject gps;
        GraphicsData.speed = new ArrayList<>();

        try {
            gps = track.getJSONObject("gps");

            for(int i = 0;i<=gps.length()-1;i++){
                GraphicsData.speed.add(gps.getString("t_"+i+"0km"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /*
    public void createSpeedLine(){

        List<Entry> entries = new ArrayList<>();

        for(GraphicsData i: data){
            entries.add(new Entry(i.getTime(),Float.parseFloat(i.getSpeed())));
        }

        LineDataSet dataSet = new LineDataSet(entries, "Speed Progress");
        LineData lineData = new LineData(dataSet);
        lineChart.setData(lineData);
    }
    */

    public void createSpeedTimeBar(){

        List<BarEntry> entries = new ArrayList<>();

        for(int i = 0;i<=GraphicsData.speed.size()-1;i++){
            entries.add(new BarEntry(i, Float.parseFloat(GraphicsData.speed.get(i))));
        }

        BarDataSet set = new BarDataSet(entries,"BarDataSet");

        BarData data = new BarData(set);
        data.setBarWidth(0.9f); // set custom bar width
        barChart.setData(data);
        barChart.setFitBars(true); // make the x-axis fit exactly all bars
        barChart.invalidate(); // refresh
    }
}
