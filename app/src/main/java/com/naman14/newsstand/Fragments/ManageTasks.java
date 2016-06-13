package com.naman14.newsstand.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.naman14.newsstand.R;

/**
 * Created by roshu on 26/4/16.
 */
public class ManageTasks extends Fragment{

    public ManageTasks(){

    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState){
        return layoutInflater.inflate(R.layout.fragment_manage_task,container,false);
    }
}
