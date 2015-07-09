package com.example.theepicflyer.sunshine;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.apache.http.client.methods.HttpGet;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] data = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        List<String> forecast = new ArrayList<String>(Arrays.asList(data));

        ArrayAdapter<String> forecastAdaptor = new ArrayAdapter<String>(this, R.layout.list_item_forecast, R.id.list_item_forecast_textview, forecast);
        ListView listView = (ListView) findViewById(R.id.listview_forecast);
        listView.setAdapter(forecastAdaptor);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void bus() {
        String urlText = "http://datamall2.mytransport.sg/ltaodataservice/BusArrival?BusStopID=28469&ServiceNo=198";

        URL url = new URL();
        try {
            url = new URL(urlText);
        }
        catch (MalformedURLException e) {
            // do nothing
        }

        //HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        ConnectivityManager connMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){

        } else {
            //Display error
        }
    }
}
