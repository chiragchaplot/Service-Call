package com.tseapp.paperbind.servicecall;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class todolist extends ActionBarActivity
{

    Button start,todo,end;

    session s;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);

        connect_to_ui();
    }

    public void connect_to_ui()
    {
        start = (Button) findViewById(R.id.start_day);
        todo = (Button) findViewById(R.id.to_do_list);
        end = (Button) findViewById(R.id.end_day);


        if (s.start_pressed == true)
        {
            start.setEnabled(false);
            todo.setEnabled(true);
            end.setEnabled(true);
        }
        else
        {
            start.setEnabled(true);
            todo.setEnabled(false);
            end.setEnabled(false);
        }

        //Start Activity leading to to do list for day
        start.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View arg0)
                    {
                        s.start_pressed = true;
                        start.setEnabled(false);
                        todo.setEnabled(true);
                        end.setEnabled(true);
                        startActivity(new Intent(getApplicationContext(), chose_location.class));

                    }
                }
        );

        todo.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View arg0)
                    {
                        startActivity(new Intent(getApplicationContext(), chose_location.class));
                        s.continue_pressed = true;
                    }
                }
        );

        end.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        start.setEnabled(true);
                        todo.setEnabled(false);
                        end.setEnabled(false);
                        s.start_pressed = false;
                        s.started_home = false;
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_todolist, menu);
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
