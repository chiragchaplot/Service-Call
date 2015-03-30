package com.tseapp.paperbind.servicecall;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class chose_location extends ActionBarActivity
{
    Button home, current;
    session s;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_location);
        UIbuilder();
        //sendlocation();
    }


    public void UIbuilder()
    {
        home = (Button) findViewById(R.id.home);
        current = (Button) findViewById(R.id.current);

        if (s.started_home!=true)
        {
            home.setEnabled(true);
            current.setEnabled(false);
        }
        else
        {
            home.setEnabled(false);
            current.setEnabled(true);
        }


        home.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),Today_List_Work.class));
                        home.setEnabled(false);
                        current.setEnabled(true);
                    }
                }
        );

        current.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),Today_List_Work.class));
                    }
                }
        );
    }

    /*
    public void sendlocation()
    {

    }
    */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chose_location, menu);
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
}
