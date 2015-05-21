package com.tseapp.paperbind.servicecall;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by chiragchaplot on 5/12/15.
 */
public class send_location extends AsyncTask<Void, Void, Void>
{

    public GPSTracker gpsTracker;
    public String stringLatitude, stringLongitude, country, city,emp_id;

    protected send_location(String lat, String longi,String ctry, String cty, String id)
    {
        this.stringLatitude = lat;
        this.stringLongitude = longi;
        this.country = ctry;
        this.city = cty;
        this.emp_id = id;
    }

    @Override
    protected Void doInBackground(Void... params)
    {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        String loginresult = null;

        try {
            Log.v("CHIRAGCHAPLOT", "Entered DoLogin connection");

            final String BASE_URL = "http://www.rishvatkhori.com/app/service_call/send_location.php";
            final String PARAM_EMP_ID = "emp_id";
            final String PARAM_LONGITUDE = "longitude";
            final String PARAM_LATITUDE = "latitude";
            final String PARAM_COUNTRY = "country";
            final String PARAM_CITY = "city";

            Uri builtUri = Uri.parse(BASE_URL).buildUpon()
                    .appendQueryParameter(PARAM_EMP_ID, emp_id)
                    .appendQueryParameter(PARAM_LATITUDE, stringLatitude)
                    .appendQueryParameter(PARAM_LONGITUDE,stringLongitude)
                    .appendQueryParameter(PARAM_COUNTRY,country)
                    .appendQueryParameter(PARAM_CITY,city)
                    .build();

            Log.v("CHIRAGCHAPLOT", builtUri.toString());

            URL url = new URL(builtUri.toString());
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            Log.v("CHIRAGCHAPLOT", "CONNECTION SET");

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

            if (inputStream == null)
            {
                loginresult = null;
            }

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;

            while ((line = reader.readLine()) != null)
            {
                buffer.append(line + "\n");
            }
            if (buffer.length() == 0)
            {
                return null;
            }

            loginresult = buffer.toString();
        }
        catch (IOException e)
        {
            Log.e("ERRORLOG", "Error: ", e);
            return null;
        }
        finally
        {
            if (urlConnection != null)
            {
                urlConnection.disconnect();
            }

            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch (final IOException e)
                {
                    Log.e("ERRORLOG", "Error closing stream", e);
                }
            }
        }

        try
        {
            Log.v("CHIRAGCHAPLOT", loginresult);
            return getloginresult(loginresult);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    protected Void getloginresult(String result) throws JSONException
    {
        JSONObject a = new JSONObject(result);
        String message = a.getString("message");


        return null;
    }
}
