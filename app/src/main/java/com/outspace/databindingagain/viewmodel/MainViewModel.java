package com.outspace.databindingagain.viewmodel;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

import com.outspace.databindingagain.databinding.ActivityMainBinding;

/**
 * Created by user on 6/18/17.
 */

public class MainViewModel {
    private Activity activity;
    private ActivityMainBinding binding;

    public MainViewModel(Activity activity, ActivityMainBinding binding) {
        this.activity = activity;
        this.binding  = binding;
    }

    public void OnClickBtnGo(View view) {
        Toast.makeText(activity.getApplicationContext(), "I am at OnClickBtnGo", Toast.LENGTH_SHORT).show();
    }


}
