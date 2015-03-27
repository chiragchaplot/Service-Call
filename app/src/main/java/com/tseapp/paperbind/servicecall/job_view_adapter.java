package com.tseapp.paperbind.servicecall;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chiragchaplot on 3/27/15.
 */
public class job_view_adapter extends ArrayAdapter<job_list>
{

    private final Activity context;
    private static List<job_list> jobs = new ArrayList<job_list>();

    public job_view_adapter(Activity context, List<job_list> jobs)
    {
        super(context, R.layout.jobview,jobs);
        this.context = context;
        job_view_adapter.jobs = jobs;
    }

    public View getView(int position, View view, ViewGroup parent)
    {
        View itemView = view;

        if(itemView == null)
        {
            itemView = context.getLayoutInflater().inflate(R.layout.jobview,parent,false);


        }

        //Get the job
        job_list current_job = jobs.get(position);

        //Connect to UI
        TextView companyname  = (TextView) itemView.findViewById(R.id.companyname);
        TextView line1  = (TextView) itemView.findViewById(R.id.line1);
        TextView area  = (TextView) itemView.findViewById(R.id.area);
        TextView city  = (TextView) itemView.findViewById(R.id.city);
        TextView state  = (TextView) itemView.findViewById(R.id.state);
        TextView pincode  = (TextView) itemView.findViewById(R.id.pincode);
        TextView poc  = (TextView) itemView.findViewById(R.id.poc);
        TextView phone  = (TextView) itemView.findViewById(R.id.contact_phone);

        //Set Elements to update
        companyname.setText(current_job.getName());
        line1.setText(current_job.getLine1());
        area.setText(current_job.getArea());
        city.setText(current_job.getCity());
        state.setText(current_job.getState());
        pincode.setText(current_job.getPincode());
        poc.setText(current_job.getPoc());
        phone.setText(current_job.getPhone());

        return itemView;
    }


}
