package com.tseapp.paperbind.servicecall;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
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
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class knowledge_base extends ActionBarActivity
{

    EditText ans_1, ans_2,ans_3;
    TextView q2,q3;
    Button submit;
    public session s;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge_base);
        UIBuilder();
    }

    public void UIBuilder()
    {
        ans_1 = (EditText) findViewById(R.id.ans_1);
        ans_2 = (EditText) findViewById(R.id.ans_2);
        ans_3 = (EditText) findViewById(R.id.ans_3);
        q2 = (TextView) findViewById(R.id.textView2);
        q3 = (TextView) findViewById(R.id.textView3);
        submit = (Button) findViewById(R.id.submit);

        ans_1.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        ans_2.setEnabled(false);
                        ans_3.setEnabled(false);
                        q2.setEnabled(false);
                        q3.setEnabled(false);
                        submit.setEnabled(false);
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        ans_2.setEnabled(true);
                        q2.setEnabled(true);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        ans_2.setEnabled(true);

                    }
                }
        );

        ans_2.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        q3.setEnabled(true);
                        ans_3.setEnabled(true);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                }
        );

        ans_3.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        submit.setEnabled(true);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                }
        );

        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        s.ans1 = ans_1.getText().toString();
                        s.ans2 = ans_2.getText().toString();
                        s.ans3 = ans_3.getText().toString();

                        finish();
                        startActivity(new Intent(getApplicationContext(),todolist.class));
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

    public class send_details extends AsyncTask<Void, Void,String>
    {
        public boolean check = false;
        public ProgressDialog p;


        @Override
        public void onPreExecute()
        {
            p.setIcon(R.drawable.ic_launcher);
            p.setTitle("Uploading");
            p.setMessage("Sending Information to the server");
            p.show();
        }

        @Override
        protected String doInBackground(Void... params)
        {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            String addresslist = null;
            try {
                final String BASE_URL = "http://rishvatkhori.com/app/submit_report.php?";


                Uri builtUri = Uri.parse(BASE_URL).buildUpon()
                        .appendQueryParameter("barcode",s.barcode)
                        .appendQueryParameter("person_incharge",s.person_in_charge)
                        .appendQueryParameter("phone_incharge",s.phone_in_charge)
                        .appendQueryParameter("end_time",s.end_time)
                        .appendQueryParameter("end_person_incharge_name",s.end_person_in_charge)
                        .appendQueryParameter("end_person_incarhe_phone",s.end_person_phone)
                        .appendQueryParameter("status",s.status)
                        .appendQueryParameter("answer_1",s.ans1)
                        .appendQueryParameter("answer_2",s.ans2)
                        .appendQueryParameter("answer_3",s.ans3)
                        .appendQueryParameter("ticket",s.job.ticket)
                        .appendQueryParameter("emp_id",s.emp_id)
                        .build();

                URL url = new URL(builtUri.toString());

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();

                if (inputStream == null) {
                    // Nothing to do.
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;

                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    return null;
                }

                addresslist = buffer.toString();

            } catch (IOException e) {
                Log.e("ERRORLOG", "Error ", e);
                return null;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }

                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        Log.e("ERRORLOG", "Error closing stream ", e);
                    }
                }
            }

            try {
                Log.v("CHIRAGCHAPLOT", addresslist.toString());
                return getresult(addresslist);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public String getresult(String result) throws JSONException {
            JSONObject operation_result = new JSONObject(result);
            String message = operation_result.getString("message");
            if (message.equals("1"))
            {
                check = true;
            }
            else
            {
                check = false;
            }
            return message;
        }

        @Override
        protected void onPostExecute(String done)
        {
            if(p.isShowing())
            {
                p.dismiss();
                if(check==true)
                {
                    Toast.makeText(getApplicationContext(),"Data Sent",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Couldn't be sent",Toast.LENGTH_SHORT).show();
                }

            }
        }
    }


}
