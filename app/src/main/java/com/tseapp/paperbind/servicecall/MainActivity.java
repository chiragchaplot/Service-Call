package com.tseapp.paperbind.servicecall;

<<<<<<< HEAD
import android.app.AlertDialog;
=======
>>>>>>> 41a668f5b63b191977a24f0e6903f563ee82a839
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
<<<<<<< HEAD
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
=======
>>>>>>> 41a668f5b63b191977a24f0e6903f563ee82a839
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
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

        //noinspection SimplifiabeIfStatement
        if (id == R.id.action_logout) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
<<<<<<< HEAD
    public static class PlaceholderFragment extends Fragment
    {
        /*
        public Button submit, reset;
        public EditText emp_id, password;
        public String id,pwd,name,phone,email;
        public String result;
        public boolean done=false;
        */
=======
    public static class PlaceholderFragment extends Fragment {
        public Button submit, reset;
        public EditText emp_id, password;
        public String id, pwd, name;
        public String result;
        public boolean done = false;
        public session s;
>>>>>>> 41a668f5b63b191977a24f0e6903f563ee82a839

        public Button start,todo,end;
        //Components
        EditText emp_id,password;

<<<<<<< HEAD
        public session s;
        View rootView;
        public ViewGroup temp;


=======
>>>>>>> 41a668f5b63b191977a24f0e6903f563ee82a839
        public PlaceholderFragment() {
        }

        @Override
<<<<<<< HEAD
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            rootView = inflater.inflate(R.layout.fragment_main, container, false);
            temp = container;
            connect_to_ui();
            s = new session();
=======
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
>>>>>>> 41a668f5b63b191977a24f0e6903f563ee82a839

            return rootView;
        }

        public void connect_to_ui()
        {
            start = (Button) rootView.findViewById(R.id.start_day);
            todo = (Button) rootView.findViewById(R.id.to_do_list);
            end = (Button) rootView.findViewById(R.id.end_day);

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
                            if(s.loggedin == true)
                            {
                                Log.v("CHIRAGCHAPLOT","Start Pressed & User is logged in");
                                s.start_pressed = true;
                                start.setEnabled(false);
                                todo.setEnabled(true);
                                end.setEnabled(true);
                            }
                            else
                            {
                                Log.v("CHIRAGCHAPLOT","Start Pressed & User is not logged in");
                                show_login_dialogue();
                            }
                        }
                    }
            );

            todo.setOnClickListener(
                    new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View arg0)
                        {
                            startActivity(new Intent(getActivity(), chose_location.class));
                            s.continue_pressed = true;
                        }
                    }
            );

            end.setOnClickListener
                    (
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v)
                        {
                            start.setEnabled(true);
                            todo.setEnabled(false);
                            end.setEnabled(false);
                        /*
                        //Stop Service
                        stopService(new Intent(todolist.this,MyService.class));
                        // export all current rows
                        DbExportTask task = new DbExportTask(getApplicationContext());
                        task.execute();
                        // delete all current rows
                        String[] match = {"0"};
                        getContentResolver().delete(LocContentProvider.CONTENT_URI, LocTable.COLUMN_ID + " > ?", match);
                        */
                            s.start_pressed = false;
                            s.started_home = false;
                        }
                    }
            );
        }

<<<<<<< HEAD
        public void show_login_dialogue()
        {
            Log.v("CHIRAGCHAPLOT","Entered show_login_dialogue");
            final AlertDialog.Builder login_dialogue = new AlertDialog.Builder(getActivity());
            LayoutInflater inflater = getActivity().getLayoutInflater();
            login_dialogue.setTitle("Log In");
            View convertView = (View) inflater.inflate(R.layout.login_form,temp, false);
            login_dialogue.setView(convertView);
=======
            submit.setOnClickListener(
                    new View.OnClickListener() {
>>>>>>> 41a668f5b63b191977a24f0e6903f563ee82a839



            //Setting up
            emp_id = (EditText) convertView.findViewById(R.id.emp_id);
            password = (EditText) convertView.findViewById(R.id.password);

<<<<<<< HEAD
            login_dialogue.setPositiveButton("Submit",new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    dologin d = new dologin();
                    d.execute();
                }
            });
=======
                            if (id.length() > 0 && pwd.length() > 0) {
                                if (id.equals("admin") && pwd.equals("anujmehta")) {
                                    startActivity(new Intent(getActivity(), master_view.class));
                                } else {
                                    login();
                                }
                            }
>>>>>>> 41a668f5b63b191977a24f0e6903f563ee82a839

            login_dialogue.setNegativeButton("Reset", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id)
                {
                    emp_id.setText("");
                    password.setText("");
                }
            });

            //Final Step of creation
            login_dialogue.setIcon(R.drawable.ic_launcher);
            AlertDialog logger = login_dialogue.create();
            logger.show();
        }

<<<<<<< HEAD

        public class dologin extends AsyncTask<String, String, String>
        {
            ProgressDialog p = new ProgressDialog(getActivity());
=======
        public void login() {
            s.eid = emp_id.getText().toString();
            startActivity(new Intent(getActivity(), todolist.class));
>>>>>>> 41a668f5b63b191977a24f0e6903f563ee82a839

            @Override
            protected void onPreExecute()
            {
                p.setTitle("Login");
                p.setIcon(R.drawable.login_icon);
                p.setMessage("Logging you in");
                p.show();
            }

            @Override
            protected String doInBackground(String... params) {
                Log.v("CHIRAGCHAPLOT", "ENTERED DOLOGIN");

                HttpURLConnection urlConnection = null;
                BufferedReader reader = null;

                String loginresult = null;

                try {
                    Log.v("CHIRAGCHAPLOT", "Entered DoLogin connection");

                    final String BASE_URL = "http://www.rishvatkhori.com/app/service_call/login.php";
                    final String PARAM_EMAIL = "emp_id";
                    final String PARAM_PASSWORD = "password";

                    Uri builtUri = Uri.parse(BASE_URL).buildUpon()
                            .appendQueryParameter(PARAM_EMAIL, emp_id.getText().toString())
                            .appendQueryParameter(PARAM_PASSWORD, password.getText().toString())
                            .build();

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

                try {
                    Log.v("CHIRAGCHAPLOT", loginresult);
                    return getloginresult(loginresult);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return null;

            }


            public String getloginresult(String result) throws JSONException
            {

<<<<<<< HEAD
                //{"name":"Muthu","phone":"7766554433","email":"muthu@paperidea.in","message":"4"}
                JSONObject user = new JSONObject(result);
                String message = user.getString("message");
                if (message.equals("4"))
                {
                    s.emp_name = user.getString("name");
                    s.emp_phone= user.getString("phone");
                    s.emp_phone= user.getString("email");
=======
                result = result.substring(3, result.length());
                JSONObject user = new JSONObject(result);
                String message = user.getString("message");
                if (message.equals("1")) {
                    name = user.getString("name");
                    id = user.getString("uid");

>>>>>>> 41a668f5b63b191977a24f0e6903f563ee82a839
                }
                Log.v("CHIRAGCHAPLOT", "MESSAGE CODE: " + message);

                return (message);

            }

            @Override
<<<<<<< HEAD
            public void onPostExecute(String message)
            {
                p.dismiss();

                if (message.equals("4"))
                {
                    s.loggedin=true;
                    if(emp_id.getText().toString().equals("admin"))
                    {
                        startActivity(new Intent(getActivity(),chose_information.class));
                        getActivity().finish();
                    }
                    else
                    {
                        s.emp_id = emp_id.getText().toString();
                        startActivity(new Intent(getActivity(),todolist.class));
                        getActivity().finish();
                    }
                }
                else if (message.equals("3"))
                {
                    message = "Email/Password is wrong";
                    Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
                }
                else if (message.equals("2"))
                {
                    message = "Couldn't connect to server";
                    Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
                }
            }
        }
=======
            public void onPostExecute(String message) {
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

                } else if (message.equals("2")) {
                    message = "Email/Password is wrong";

                } else if (message.equals("3")) {
                    message = "Couldn't connect to server";

                } else {
                    message = "Enter all fields";
>>>>>>> 41a668f5b63b191977a24f0e6903f563ee82a839


        /*
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


                            if (id.length() > 0 && pwd.length() > 0)
                            {
                                dologin d = new dologin();
                                d.execute();
                            }

                        }
                    }
            );
            */
    }
}
