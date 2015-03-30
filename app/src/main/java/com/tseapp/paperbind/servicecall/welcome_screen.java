package com.tseapp.paperbind.servicecall;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

public class welcome_screen extends ActionBarActivity
    {

        private Thread mSplashThread;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_welcome_screen);
            final welcome_screen sPlashScreen = this;

            mSplashThread =  new Thread(){
                @Override
                public void run(){
                    try {
                        synchronized(this){

                            wait(2000);
                        }
                    }
                    catch(InterruptedException ex){
                    }

                    finish();

                    Intent intent = new Intent();
                    intent.setClass(sPlashScreen, MainActivity.class);
                    startActivity(intent);

                }
            };

            mSplashThread.start();
        }


        @Override

        public boolean onTouchEvent(MotionEvent evt)
        {
            if(evt.getAction() == MotionEvent.ACTION_DOWN)
            {
                synchronized(mSplashThread){
                    mSplashThread.notifyAll();
                }
            }
            return true;
        }
    }

