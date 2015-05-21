package com.tseapp.paperbind.servicecall;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Today_List_Work extends ActionBarActivity {

    public session s;
    public AlertDialog call_office;
    public job_view_adapter adapter;
    Button office;
    private List<job_list> jobs = new ArrayList<job_list>();
    private ListView mListView;
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today__list__work);
        addjobs();
        alert_dialog_builder();
        UIbuilder();
    }

    public void alert_dialog_builder() {

    }

    public void UIbuilder() {
        TextView DisplayDate = (TextView) findViewById(R.id.tvDate);


        final Calendar c = Calendar.getInstance();
        int yy = c.get(Calendar.YEAR);
        int mm = c.get(Calendar.MONTH);
        int dd = c.get(Calendar.DAY_OF_MONTH);

        // set current date into textview
        DisplayDate.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(dd).append(" ").append("-").append(mm + 1).append("-")
                .append(yy));

        //Attach list to adapter and display
        adapter = new job_view_adapter(this, jobs);
        mListView = (ListView) findViewById(R.id.job_list);
        mListView.setAdapter(adapter);

        //Clicks
        mListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        job_list chosen = adapter.getItem(position);
                        Toast t = Toast.makeText(getApplicationContext(), chosen.getName(), Toast.LENGTH_SHORT);
                        t.show();
                        s.job = chosen;

<<<<<<< HEAD
                        startActivity(new Intent(getApplicationContext(),reached_customer.class));
=======
                        startActivity(new Intent(getApplicationContext(), service_start.class));
>>>>>>> 41a668f5b63b191977a24f0e6903f563ee82a839

                    }
                });

        //Alert Dialog Builder
        final AlertDialog.Builder builder = new AlertDialog.Builder(Today_List_Work.this);
        builder.setTitle("Office Details");
        builder.setMessage("Suite 326, Tower B, Spazedge, \n" +
                "Sohna Road, Sector 47,\n" +
                "Gurgaon - 122001 (Haryana) INDIA\n" +
                "Tel : +91 9555 688 688\n" +
                "Email : info@paperbind.in");
        builder.setIcon(R.drawable.ic_launcher);
        builder.setPositiveButton("Call", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //All of the fun happens inside the CustomListener now.
                //I had to move it to enable data validation.
                String posted_by = "+919555688688";

                String uri = "tel:" + posted_by.trim();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(uri));
                startActivity(intent);
            }
        });

        call_office = builder.create();


        //Button
        office = (Button) findViewById(R.id.office);
        office.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        call_office.show();
                    }
                }
        );
    }


<<<<<<< HEAD
    public void addjobs()
    {
        jobs.add(new job_list("PaperBind","Suite 326, Spazedge Park","Sector 47","Gurgaon","HR","122001","9999999999","Nisha Joseph","1"));
        jobs.add(new job_list("Solar Printers","D 10/7","Okhla Industrial Area","New Delhi","ND","110020","+91-11-6650 1000-04","Solar","2"));
        jobs.add(new job_list("Lunar Printers","MG Road","Sector 39","Gurgaon","HR","110020","+919876543210","Prajapati Shrikant Singham","3"));
=======
    public void addjobs() {
        jobs.add(new job_list("PaperBind", "Suite 326, Spazedge Park", "Sector 47", "Gurgaon", "HR", "122001", "9999999999", "Nisha Joseph"));
        jobs.add(new job_list("Solar Printers", "D 10/7", "Okhla Industrial Area", "New Delhi", "ND", "110020", "+91-11-6650 1000-04", "Solar"));
        jobs.add(new job_list("Lunar Printers", "MG Road", "Sector 39", "Gurgaon", "HR", "110020", "+919876543210", "Prajapati Shrikant Singham"));
>>>>>>> 41a668f5b63b191977a24f0e6903f563ee82a839

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
