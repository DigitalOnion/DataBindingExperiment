package com.outspace.databindingagain.viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.outspace.databindingagain.R;
import com.outspace.databindingagain.databinding.ActivityMainBinding;
import com.outspace.databindingagain.view.MainActivity;

import java.util.ArrayList;

/**
 * Created by user on 6/18/17.
 */

public class MainViewModel {
    private AppCompatActivity activity;
    private ActivityMainBinding binding;
    private WebView web;
    private String selectedClassName;
    private Example[] examples = null;

    public MainViewModel(AppCompatActivity activity, ActivityMainBinding binding) {
        this.activity = activity;
        this.binding  = binding;

        Spinner spinner = binding.spinner;
        InitSpinner(spinner);
        InitSpinnerListener(spinner);
    }

//    public void OnClickBtnGo(View view) {
//        Toast.makeText(activity.getApplicationContext(), "I am at OnClickBtnGo", Toast.LENGTH_SHORT).show();
//    }

    public void OnClickBtnGo(View view) {
        if(selectedClassName != null) {
            try {
                Class clazz = Class.forName(selectedClassName);
                Intent intent = new Intent(activity, clazz);
                activity.startActivity(intent);
            } catch (ClassNotFoundException e) {
                String notYet = activity.getResources().getString(R.string.not_yet);
                Toast.makeText(activity, notYet, Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void InitSpinner(Spinner spinner) {

        ArrayList<String> array = new ArrayList<>();

        String[] strExamples = activity.getResources().getStringArray(R.array.examples);
        examples = new Example[strExamples.length];
        for(int i = 0; i < strExamples.length; i++) {
            Example example = new Example();
            String[] split = strExamples[i].split("\\|");
            example.classname = split[0];
            example.message   = split[1];
            example.url       = split[2];
            examples[i] = example;
            array.add(example.message);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity.getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item, array);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void InitSpinnerListener(Spinner spinner) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String url = MainViewModel.this.examples[position].url;
                MainViewModel.this.web.loadUrl(url);
                MainViewModel.this.selectedClassName = null;
                if(position != 0)
                    MainViewModel.this.selectedClassName = MainViewModel.this.examples[position].classname;
            }

            @Override public void onNothingSelected(AdapterView<?> parent) { }
        });

    }

    private class Example {
        public String classname;
        public String message;
        public String url;
    }
}
