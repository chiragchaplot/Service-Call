package com.tseapp.paperbind.servicecall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class chose_information extends ActionBarActivity {

    Button location,open,closed,report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD:app/src/main/java/com/tseapp/paperbind/servicecall/chose_information.java
        setContentView(R.layout.activity_chose_information);
        buildUI();
=======
        setContentView(R.layout.activity_master_view);

        buildUI();

>>>>>>> 41a668f5b63b191977a24f0e6903f563ee82a839:app/src/main/java/com/tseapp/paperbind/servicecall/master_view.java
    }

    public void buildUI() {
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
<<<<<<< HEAD:app/src/main/java/com/tseapp/paperbind/servicecall/chose_information.java
                    public void onClick(View v)
                    {
                        startActivity(new Intent(getApplicationContext(),eng_location.class));
=======
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), chose_engineer.class));
>>>>>>> 41a668f5b63b191977a24f0e6903f563ee82a839:app/src/main/java/com/tseapp/paperbind/servicecall/master_view.java
                    }
                }
        );

        open.setOnClickListener(
                new View.OnClickListener() {
                    @Override
<<<<<<< HEAD:app/src/main/java/com/tseapp/paperbind/servicecall/chose_information.java
                    public void onClick(View v)
                    {

                        startActivity(new Intent(getApplicationContext(),open_cases.class));

=======
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Open Clicked", Toast.LENGTH_SHORT).show();
>>>>>>> 41a668f5b63b191977a24f0e6903f563ee82a839:app/src/main/java/com/tseapp/paperbind/servicecall/master_view.java
                    }
                }
        );

        closed.setOnClickListener(
<<<<<<< HEAD:app/src/main/java/com/tseapp/paperbind/servicecall/chose_information.java
            new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    startActivity(new Intent(getApplicationContext(),eng_location.class));

=======
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Closed Clicked", Toast.LENGTH_SHORT).show();
                    }
>>>>>>> 41a668f5b63b191977a24f0e6903f563ee82a839:app/src/main/java/com/tseapp/paperbind/servicecall/master_view.java
                }
            }
        );

        report.setOnClickListener(
<<<<<<< HEAD:app/src/main/java/com/tseapp/paperbind/servicecall/chose_information.java
            new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    startActivity(new Intent(getApplicationContext(),eng_location.class));

=======
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Reports Clicked", Toast.LENGTH_SHORT).show();
                    }
>>>>>>> 41a668f5b63b191977a24f0e6903f563ee82a839:app/src/main/java/com/tseapp/paperbind/servicecall/master_view.java
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
