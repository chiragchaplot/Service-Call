package com.tseapp.paperbind.servicecall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class chose_location extends ActionBarActivity {
    public GPSTracker gpsTracker;
    Button home, current;
    session s;
    GPSTracker gpsTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_location);
        // check if GPS enabled
        gpsTracker = new GPSTracker(this);
        UIbuilder();
    }


<<<<<<< HEAD

    public void UIbuilder()
    {
=======
    public void send_location() {
        if (gpsTracker.canGetLocation()) {
            String stringLatitude = String.valueOf(gpsTracker.latitude);


            String stringLongitude = String.valueOf(gpsTracker.longitude);

            String country = gpsTracker.getCountryName(this);

            String city = gpsTracker.getLocality(this);

            String postalCode = gpsTracker.getPostalCode(this);

            String addressLine = gpsTracker.getAddressLine(this);
            Toast.makeText(getApplicationContext(), stringLatitude + '\n' + stringLatitude + '\n' + country + '\n' + city + '\n' + postalCode + '\n' + addressLine, Toast.LENGTH_SHORT).show();
        } else {
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            Toast.makeText(getApplicationContext(), "Coordinates Not Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void UIbuilder() {
>>>>>>> 41a668f5b63b191977a24f0e6903f563ee82a839
        home = (Button) findViewById(R.id.home);
        current = (Button) findViewById(R.id.current);

        if (s.started_home != true) {
            home.setEnabled(true);
            current.setEnabled(false);
        } else {
            home.setEnabled(false);
            current.setEnabled(true);
        }


        home.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
<<<<<<< HEAD
                        startActivity(new Intent(getApplicationContext(),Today_List_Work.class));
                        s.started_home = true;
=======
                        startActivity(new Intent(getApplicationContext(), Today_List_Work.class));
>>>>>>> 41a668f5b63b191977a24f0e6903f563ee82a839
                        home.setEnabled(false);
                        current.setEnabled(true);

                    }
                }
        );

        current.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), Today_List_Work.class));
                    }
                }
        );

        /*

         */
    }

    /*
    public void sendlocation()
    {

    }
    */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
