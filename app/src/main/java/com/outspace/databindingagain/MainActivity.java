package com.outspace.databindingagain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Example[] examples = null;
    private String selectedClassName = null;

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
            example.url       = split[2];
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

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String url = MainActivity.this.examples[position].url;
                WebView web = (WebView) findViewById(R.id.web);
                web.loadUrl(url);
                MainActivity.this.selectedClassName = null;
                if(position != 0)
                    MainActivity.this.selectedClassName = MainActivity.this.examples[position].classname;
            }

            @Override public void onNothingSelected(AdapterView<?> parent) { }
        });
    }

    public void OnClickBtnGo(View view) {
        if(selectedClassName != null) {
            try {
                Class clazz = Class.forName(selectedClassName);
                Intent intent = new Intent(this, clazz);
                startActivity(intent);
            } catch (ClassNotFoundException e) {
                String notYet = getResources().getString(R.string.not_yet);
                Toast.makeText(this, notYet, Toast.LENGTH_SHORT).show();
            }
        }
    }

    private class Example {
        public String classname;
        public String message;
        public String url;
    }
}
