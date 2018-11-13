package getnetwork.erictelm2m.com.mupsic.Graficos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
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
    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficos_btn);

        //lineChart = findViewById(R.id.linechart);
        barChart = findViewById(R.id.barchart);
        pieChart = findViewById(R.id.piechart);

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
        createPieChart();

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

        final String[] speeds = new String[]{"0km","10km","20km","30km","40km","50km"};

        IAxisValueFormatter formatter = new IAxisValueFormatter() {

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return speeds[(int) value];
            }

            // we don't draw numbers, so no decimal digits needed
            public int getDecimalDigits() {  return 0; }
        };

        XAxis xAxis = barChart.getXAxis();
        xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(formatter);
    }

    public void createPieChart(){
        List<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(18.5f, "Green"));
        entries.add(new PieEntry(26.7f, "Yellow"));
        entries.add(new PieEntry(24.0f, "Red"));
        entries.add(new PieEntry(30.8f, "Blue"));

        PieDataSet set = new PieDataSet(entries, "Election Results");
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(getResources().getColor(R.color.colorGreen));
        colors.add(getResources().getColor(R.color.colorYellow));
        colors.add(getResources().getColor(R.color.colorAccent));
        colors.add(getResources().getColor(R.color.colorLightBlue));

        set.setColors(colors);
        PieData data = new PieData(set);
        pieChart.setData(data);
        pieChart.invalidate(); // refresh
    }
}
