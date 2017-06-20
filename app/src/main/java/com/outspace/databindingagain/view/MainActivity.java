package com.outspace.databindingagain.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.outspace.databindingagain.R;
import com.outspace.databindingagain.databinding.ActivityMainBinding;
import com.outspace.databindingagain.viewmodel.MainViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String selectedClassName = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainViewModel mainVM = new MainViewModel(this, binding);
        binding.setMainVM(mainVM);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

}
