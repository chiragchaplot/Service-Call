package com.tseapp.paperbind.servicecall;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class chose_information extends ActionBarActivity {

    Button location,open,closed,report;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_information);
        buildUI();
    }

    public void buildUI()
    {
        location = (Button) findViewById(R.id.location);
        open = (Button) findViewById(R.id.open);
        closed = (Button) findViewById(R.id.closed);
        report = (Button) findViewById(R.id.report);

        UIoperations();
    }

    public void UIoperations()
    {
        location.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        startActivity(new Intent(getApplicationContext(),eng_location.class));
                    }
                }
        );

        open.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {

                        startActivity(new Intent(getApplicationContext(),open_cases.class));

                    }
                }
        );

        closed.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    startActivity(new Intent(getApplicationContext(),eng_location.class));

                }
            }
        );

        report.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    startActivity(new Intent(getApplicationContext(),eng_location.class));

                }
            }
        );
    }


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
