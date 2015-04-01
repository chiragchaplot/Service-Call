package com.tseapp.paperbind.servicecall;

import android.content.Intent;
import android.media.MediaScannerConnection;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.gcacace.signaturepad.views.SignaturePad;

import java.io.File;


public class signature extends ActionBarActivity
{

    SignaturePad mSignaturePad;
    File imageFileFolder, imageFileName;
    MediaScannerConnection msConn;
    EditText name, phone;
    Button submit;
    session s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature);
        UIBuilder();
    }

    public void UIBuilder()
    {
        mSignaturePad = (SignaturePad) findViewById(R.id.signature_pad);
        mSignaturePad.setOnSignedListener(new SignaturePad.OnSignedListener() {
            @Override
            public void onSigned()
            {
               s.end_shift_sign  = mSignaturePad.getSignatureBitmap();
            }

            @Override
            public void onClear()
            {

            }
        });

        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);

        phone.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        submit.setEnabled(true);
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                }
        );

        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        s.end_person_in_charge = name.getText().toString();
                        s.end_person_phone = phone.getText().toString();
                        startActivity(new Intent(getApplicationContext(),knowledge_base.class));
                    }
                }
        );
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_signature, menu);
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
