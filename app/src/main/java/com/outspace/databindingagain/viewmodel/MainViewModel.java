package com.outspace.databindingagain.viewmodel;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by user on 6/18/17.
 */

public class MainViewModel {

    private Activity activity;

    public MainViewModel() { }

    public MainViewModel(Activity activity) {
        this.activity = activity;
    }

    public void OnClickBtnGo(View view) {
        Toast.makeText(activity.getApplicationContext(), "I am at OnClickBtnGo", Toast.LENGTH_SHORT).show();
    }


}
