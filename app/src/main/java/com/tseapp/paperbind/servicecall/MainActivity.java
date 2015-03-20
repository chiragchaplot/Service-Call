package com.tseapp.paperbind.servicecall;

import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends ActionBarActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment
    {
        public Button submit, reset;
        public EditText emp_id, password;
        public String id,pwd,name;
        public String result;
        public boolean done=false;



        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            submit = (Button) rootView.findViewById(R.id.submit);
            reset = (Button) rootView.findViewById(R.id.reset);

            emp_id = (EditText) rootView.findViewById(R.id.emp_id);
            password = (EditText) rootView.findViewById(R.id.password);

            submit.setOnClickListener(
                    new View.OnClickListener()
                    {

                        @Override
                        public void onClick(View arg0) {
                            ProgressDialog progress;
                            progress = new ProgressDialog(getActivity());
                            progress.setTitle("Loading");
                            progress.setMessage("Wait while logging in...");

                            //String username = txtUsername.getText().toString();
                            id = emp_id.getText().toString();
                            pwd = password.getText().toString();


                            if (id.length() > 0 && pwd.length() > 0) {
                                login();
                            }

                        }
                    }
            );
            return rootView;
        }

        public void login()
        {
            Fragment objFragment = null;
            objFragment = new fragment_todo();
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main,objFragment)
                    .commit();

        }

        public class dologin extends AsyncTask<String, String, String> {
            @Override
            protected String doInBackground(String... params) {
                Log.v("CHIRAGCHAPLOT", "ENTERED DOLOGIN");

                HttpURLConnection urlConnection = null;
                BufferedReader reader = null;

                String loginresult = null;

                try {
                    Log.v("CHIRAGCHAPLOT", "Entered DoLogin connection");

                    final String BASE_URL = "http://www.pressmgr.com/chiragchaplot/final/loginsignup/login.php?";
                    //URL url = new URL("http://pressmgr.com/chiragchaplot/test/login.php?");
                    final String PARAM_EMAIL = "email";
                    final String PARAM_PASSWORD = "password";

                    Uri builtUri = Uri.parse(BASE_URL).buildUpon()
                            .appendQueryParameter(PARAM_EMAIL, id)
                            .appendQueryParameter(PARAM_PASSWORD, pwd).build();

                    Log.v("CHIRAGCHAPLOT", builtUri.toString());

                    URL url = new URL(builtUri.toString());
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.connect();

                    Log.v("CHIRAGCHAPLOT", "CONNECTION SET");

                    InputStream inputStream = urlConnection.getInputStream();
                    StringBuffer buffer = new StringBuffer();

                    if (inputStream == null) {
                        loginresult = null;
                    }

                    reader = new BufferedReader(new InputStreamReader(inputStream));

                    String line;

                    while ((line = reader.readLine()) != null) {
                        buffer.append(line + "\n");
                    }
                    if (buffer.length() == 0) {
                        return null;
                    }

                    loginresult = buffer.toString();
                } catch (IOException e) {
                    Log.e("ERRORLOG", "Error: ", e);
                    return null;
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }

                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (final IOException e) {
                            Log.e("ERRORLOG", "Error closing stream", e);
                        }
                    }
                }

                try
                {
                    Log.v("CHIRAGCHAPLOT", loginresult);
                    return getloginresult(loginresult);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                return null;

            }


            public String getloginresult(String result) throws JSONException {

                result = result.substring(3,result.length());
                JSONObject user = new JSONObject(result);
                String message = user.getString("message");
                if (message.equals("1"))
                {
                    name = user.getString("name");
                    id = user.getString("uid");

                }
                Log.v("CHIRAGCHAPLOT", "MESSAGE CODE: " + message);

                return (message);

            }

            @Override
            public void onPostExecute(String message)
            {
                if (message.equals("1")) {
                /*
                    1. Get user details
                    2. Create New Session with email and password
                */
                    message = "You have logged in successfully";
                    //Open the fragment with the next fragment
                    //startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    result = message;
                    done = true;

                }
                else if (message.equals("2"))
                {
                    message = "Email/Password is wrong";

                }
                else if (message.equals("3")) {
                    message = "Couldn't connect to server";

                }
                else {
                    message = "Enter all fields";

                }


            }

        }
    }


}
