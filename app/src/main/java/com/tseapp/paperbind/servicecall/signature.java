package com.tseapp.paperbind.servicecall;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
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

import com.github.gcacace.signaturepad.views.SignaturePad;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;


public class signature extends ActionBarActivity
{

    SignaturePad mSignaturePad;
    File imageFileFolder, imageFileName;
    MediaScannerConnection msConn;
    EditText name, phone;
    Button submit;


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
                //Event triggered when the pad is signed
                Bitmap bp = mSignaturePad.getSignatureBitmap();

                //Save it
                savePhoto(bp);

                //
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
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),knowledge_base.class));

                    }
                }
        );
    }

    public void savePhoto(Bitmap bmp)
    {
        imageFileFolder = new File(Environment.getExternalStorageDirectory(),"Rotate");
        imageFileFolder.mkdir();
        FileOutputStream out = null;
        Calendar c = Calendar.getInstance();
        String date = fromInt(c.get(Calendar.MONTH))
                + fromInt(c.get(Calendar.DAY_OF_MONTH))
                + fromInt(c.get(Calendar.YEAR))
                + fromInt(c.get(Calendar.HOUR_OF_DAY))
                + fromInt(c.get(Calendar.MINUTE))
                + fromInt(c.get(Calendar.SECOND));
        imageFileName = new File(imageFileFolder, date.toString() + ".jpg");
        try
        {
            out = new FileOutputStream(imageFileName);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
            scanPhoto(imageFileName.toString());
            out = null;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public String fromInt(int val)
    {
        return String.valueOf(val);
    }


    public void scanPhoto(final String imageFileName)
    {
        msConn = new MediaScannerConnection(signature.this,new MediaScannerConnection.MediaScannerConnectionClient()
        {
            public void onMediaScannerConnected()
            {
                msConn.scanFile(imageFileName, null);
                Log.i("msClient obj  in Photo Utility", "connection established");
            }
            public void onScanCompleted(String path, Uri uri)
            {
                msConn.disconnect();
                Log.i("msClient obj in Photo Utility","scan completed");
            }
        });
        msConn.connect();
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
