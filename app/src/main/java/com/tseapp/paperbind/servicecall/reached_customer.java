package com.tseapp.paperbind.servicecall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


<<<<<<< HEAD:app/src/main/java/com/tseapp/paperbind/servicecall/reached_customer.java
public class reached_customer extends ActionBarActivity
{
    Button reached;
=======
public class chose_engineer extends ActionBarActivity {
    Button engineer;

>>>>>>> 41a668f5b63b191977a24f0e6903f563ee82a839:app/src/main/java/com/tseapp/paperbind/servicecall/chose_engineer.java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reached_customer);

<<<<<<< HEAD:app/src/main/java/com/tseapp/paperbind/servicecall/reached_customer.java
        reached = (Button) findViewById(R.id.reached);
        reached.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),service_start.class));
=======
    public void UIbuilder() {
        engineer = (Button) findViewById(R.id.engineer);
        engineer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), MapsActivity.class));
>>>>>>> 41a668f5b63b191977a24f0e6903f563ee82a839:app/src/main/java/com/tseapp/paperbind/servicecall/chose_engineer.java
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
