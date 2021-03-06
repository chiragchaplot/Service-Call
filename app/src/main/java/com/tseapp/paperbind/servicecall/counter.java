package com.tseapp.paperbind.servicecall;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class counter extends ActionBarActivity {

    private final static String TAG = "StopWatchClass";
    private static boolean running = false;
    private static long startTime = 0;
    private Runnable timer = new Runnable() {
        @Override
        public void run() {
            TimeConverter timeConverter = new TimeConverter(System.currentTimeMillis() - startTime);
            hour.setText(TimeConverter.twoDigits(timeConverter.getHours()));
            minutes.setText(TimeConverter.twoDigits(timeConverter.getMinutes()));
            seconds.setText(TimeConverter.twoDigits(timeConverter.getSeconds()));
            milliseconds.setText(TimeConverter.threeDigits(timeConverter.getMilliseconds()));
            handler.postDelayed(this, 100);
        }

    };
    private static Handler handler = new Handler();
    public AlertDialog end_options;
    public session s;
    public String[] items = {"Call Completed", "Call in Progress", "Escalation to Another Engineer", "Cancel"};
    TextView name, location, machinename;
    private TextView hour;
    private TextView minutes;
    private TextView seconds;
    private TextView milliseconds;
    private int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        hour = (TextView) findViewById(R.id.hours);
        minutes = (TextView) findViewById(R.id.minutes);
        seconds = (TextView) findViewById(R.id.seconds);
        milliseconds = (TextView) findViewById(R.id.milliseconds);

        startTime = System.currentTimeMillis();
        timer.run();
        running = true;

        final AlertDialog.Builder builder = new AlertDialog.Builder(counter.this);
        builder.setTitle("End of Day Options");
        builder.setSingleChoiceItems
                (items, -1, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int item) {
                                switch (item) {

                                    case 0:
                                        //When Call is completed
                                        handler.removeCallbacks(timer);
                                        running = false;
                                        recordtimer();
                                        result = 0;
                                        startActivity(new Intent(getApplicationContext(), signature.class));
                                        break;

                                    case 1:
                                        //When call is incomplete
                                        running = false;
                                        recordtimer();
                                        result = 1;
                                        break;

                                    case 2:
                                        //When call is escalated to another engineer
                                        handler.removeCallbacks(timer);
                                        running = false;
                                        recordtimer();
                                        result = 2;
                                        startActivity(new Intent(getApplicationContext(), signature.class));
                                        break;

                                    case 3:
                                        break;
                                }
                                end_options.dismiss();
                            }
                        }
                );
        end_options = builder.create();

        Button button = (Button) findViewById(R.id.startButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creating and Building the Dialog
                end_options.show();
            }

        });

        BuilderUI();
    }

    public void recordtimer() {
        s.end_time = hour.getText().toString() + ":" + minutes.getText().toString() + ":" + seconds.getText().toString();
    }

    public void BuilderUI() {
        name = (TextView) findViewById(R.id.company_name);
        location = (TextView) findViewById(R.id.location);
        machinename = (TextView) findViewById(R.id.machine);

        name.setText(s.job.getName());
        location.setText(s.job.getArea() + ", " + s.job.getCity() + ", " + s.job.getState());
        machinename.setText(s.machine_code);
    }

}

