package com.tseapp.paperbind.servicecall;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.tseapp.paperbind.servicecall.GPS.LogMessage;
import com.tseapp.paperbind.servicecall.GPS.TrackerService;

import java.util.ArrayList;

public class todolist extends ActionBarActivity
{

    Button start,todo,end;

    //Tracker Service
    Messenger mService = null;
    boolean mIsBound;
    final Messenger mMessenger = new Messenger(new IncomingHandler());


    session s;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);

        connect_to_ui();
    }

    public void connect_to_ui()
    {
        start = (Button) findViewById(R.id.start_day);
        todo = (Button) findViewById(R.id.to_do_list);
        end = (Button) findViewById(R.id.end_day);


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
                        s.start_pressed = true;
                        start.setEnabled(false);
                        todo.setEnabled(true);
                        end.setEnabled(true);
                        /*
                        Intent i = new Intent(todolist.this, MyService.class);
                        startService(i);
                        */
                        
                        startActivity(new Intent(getApplicationContext(), chose_location.class));

                    }
                }
        );

        todo.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View arg0)
                    {
                        startActivity(new Intent(getApplicationContext(), chose_location.class));
                        s.continue_pressed = true;
                    }
                }
        );

        end.setOnClickListener(
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

    void doBindService() {
        bindService(new Intent(this, TrackerService.class), mConnection,Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService() {
        if (!mIsBound)
            return;

        if (mService != null) {
            try {
                Message msg = Message.obtain(null,TrackerService.MSG_UNREGISTER_CLIENT);
                msg.replyTo = mMessenger;
                mService.send(msg);
            }
            catch (RemoteException e) {
            }
        }

        unbindService(mConnection);
        mIsBound = false;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        if (id == R.id.action_logout)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class IncomingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case TrackerService.MSG_LOG:
                    break;

                case TrackerService.MSG_LOG_RING:
                    ArrayList<LogMessage> logs = (ArrayList) msg.obj;

                    for (int i = 0; i < logs.size(); i++) {
                        LogMessage l = logs.get(i);
                    }

                    break;

                default:
                    super.handleMessage(msg);
            }
        }
    }





    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            mService = new Messenger(service);
            try {
                Message msg = Message.obtain(null,
                        TrackerService.MSG_REGISTER_CLIENT);
                msg.replyTo = mMessenger;
                mService.send(msg);
            }
            catch (RemoteException e) {
            }
        }

        public void onServiceDisconnected(ComponentName className) {
            mService = null;
        }
    };
}
