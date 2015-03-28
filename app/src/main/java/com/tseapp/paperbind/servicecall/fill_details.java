package com.tseapp.paperbind.servicecall;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class fill_details extends ActionBarActivity {

    component listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_details);
        // preparing list data
        prepareListData();
        listAdapter = new component(this, listDataHeader, listDataChild);
        // setting list adapter
        expListView.setAdapter(listAdapter);
    }


    public void UIbuilder()
    {
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        startActivity(new Intent(getApplicationContext(),counter.class));
                    }
                }
        );
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fill_details, menu);
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

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("PUR Binders");
        listDataHeader.add("Paper Cutting Machine");
        listDataHeader.add("Digital Creasers");
        listDataHeader.add("Digital Silt Cut and Crease");

        // Adding child data
        List<String> pur = new ArrayList<String>();
        pur.add("PUR Binder 380");
        pur.add("PUR Binder 440");
        pur.add("PUR Binder 440+");

        List<String> paper_cutting = new ArrayList<String>();
        paper_cutting.add("Pressure Cut Series");
        paper_cutting.add("Pro Titan Cut Series");

        List<String> creaser = new ArrayList<String>();
        creaser.add("DIGITAL PRESSURE CREASE 330/520 M");
        creaser.add("DIGITAL PRESSURE CREASE 335 MULTI");
        creaser.add("DPC 335 AUTO");
        creaser.add("DPC 335 AUTO SP");

        List<String> silt_cut = new ArrayList<String>();
        silt_cut.add("DIGITAL PRESSURE CREASE 375 SC");
        silt_cut.add("DIGITAL PRESSURE CREASE 375 SCC");
        silt_cut.add("DIGITAL PRESSURE CREASE 375 SCF");

        listDataChild.put(listDataHeader.get(0), pur); // Header, Child data
        listDataChild.put(listDataHeader.get(1), paper_cutting);
        listDataChild.put(listDataHeader.get(2), creaser);
    }
}
