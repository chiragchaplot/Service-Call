package com.tseapp.paperbind.servicecall;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
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


public class Today_List_Work extends ActionBarActivity
{

    private List<job_list> jobs = new ArrayList<job_list>();
    private ListView mListView;
    private Context mContext = this;
    public session s;
    public AlertDialog call_office;
    Button office;
    public job_view_adapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today__list__work);
        addjobs();
        UIbuilder();
    }

    public void UIbuilder()
    {
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
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                    {
                        job_list chosen = adapter.getItem(position);
                        Toast t = Toast.makeText(getApplicationContext(), chosen.getName(), Toast.LENGTH_SHORT);
                        t.show();
                        s.job = chosen;

                        startActivity(new Intent(getApplicationContext(),chose_location.class));

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
        builder.setPositiveButton("Call", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                //All of the fun happens inside the CustomListener now.
                //I had to move it to enable data validation.
                String posted_by = "+919555688688";

                String uri = "tel:" + posted_by.trim() ;
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


    public void addjobs()
    {
        jobs.add(new job_list("PaperBind","Suite 326, Spazedge Park","Sector 47","Gurgaon","HR","122001","9999999999","Nisha Joseph"));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_today__list__work, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
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
