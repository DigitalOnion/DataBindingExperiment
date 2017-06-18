package com.outspace.databindingagain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Example[] examples = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] strExamples = getResources().getStringArray(R.array.examples);
        examples = new Example[strExamples.length];
        for(int i = 0; i < strExamples.length; i++) {
            Example example = new Example();
            String[] split = strExamples[i].split("\\|");
            example.classname = split[0];
            example.message   = split[1];
            examples[i] = example;
        }

        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ArrayList<String> array = new ArrayList<>();
        for(Example ex: examples)
            array.add(ex.message);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item, array);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
    }

    private class Example {
        public String classname;
        public String message;
    }
}
