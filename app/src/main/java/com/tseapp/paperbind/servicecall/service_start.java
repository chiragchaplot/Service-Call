package com.tseapp.paperbind.servicecall;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class service_start extends ActionBarActivity
{

    Button scan, submit, reset;
    EditText barcode;
    session s;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_start);

        buildUI();
    }

    public void buildUI()
    {
        scan = (Button) findViewById(R.id.scan_barcode);
        submit = (Button) findViewById(R.id.submit);
        submit.setEnabled(false);
        reset = (Button) findViewById(R.id.reset);
        reset.setEnabled(false);

        barcode = (EditText) findViewById(R.id.barcode);

        barcode.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        button_enabler();
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                }
        );

        scan.setOnClickListener
                (

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        IntentIntegrator integrator = new IntentIntegrator(service_start.this);
                        integrator.initiateScan();
                    }
                }
        );

        submit.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        startActivity(new Intent(getApplicationContext(),fill_details.class));
                    }
                }
        );

        reset.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        //Reset or Move Back
                        startActivity(new Intent(getApplicationContext(),Today_List_Work.class));
                        finish();
                    }
                }
        );

        button_enabler();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_service_start, menu);
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

    public void button_enabler()
    {
        if(barcode.getText().length()>0)
        {
            submit.setEnabled(true);
            reset.setEnabled(true);
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null)
        {
            String re = scanResult.getContents();
            Log.d("code", re);

            s.machine_code = re;
            barcode.setText(re);
        }
        // else continue with any other code you need in the method

        button_enabler();
    }
}
