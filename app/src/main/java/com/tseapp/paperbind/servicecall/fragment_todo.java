package com.tseapp.paperbind.servicecall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chiragchaplot on 3/20/15.
 */
public class fragment_todo extends Fragment
{
    public View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootview = inflater.inflate(R.layout.fragment_todolist, container, false);


        return rootview;
    }
}
