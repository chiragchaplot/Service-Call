package com.tseapp.paperbind.servicecall;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class knowledge_base extends ActionBarActivity
{

    EditText ans_1, ans_2,ans_3;
    TextView q2,q3;
    Button submit;
    session s;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge_base);
        UIBuilder();
    }

    public void UIBuilder()
    {
        ans_1 = (EditText) findViewById(R.id.ans_1);
        ans_2 = (EditText) findViewById(R.id.ans_2);
        ans_3 = (EditText) findViewById(R.id.ans_3);
        q2 = (TextView) findViewById(R.id.textView2);
        q3 = (TextView) findViewById(R.id.textView3);
        submit = (Button) findViewById(R.id.submit);

        ans_1.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        ans_2.setEnabled(false);
                        ans_3.setEnabled(false);
                        q2.setEnabled(false);
                        q3.setEnabled(false);
                        submit.setEnabled(false);
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        ans_2.setEnabled(true);
                        q2.setEnabled(true);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        ans_2.setEnabled(true);

                    }
                }
        );

        ans_2.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        q3.setEnabled(true);
                        ans_3.setEnabled(true);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                }
        );

        ans_3.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        submit.setEnabled(true);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                }
        );

        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        s.ans1 = ans_1.getText().toString();
                        s.ans2 = ans_2.getText().toString();
                        s.ans3 = ans_3.getText().toString();

                        finish();
                        startActivity(new Intent(getApplicationContext(),todolist.class));
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_knowledge_base, menu);
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
}
