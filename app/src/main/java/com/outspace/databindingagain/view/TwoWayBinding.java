package com.outspace.databindingagain.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.outspace.databindingagain.R;
import com.outspace.databindingagain.databinding.ActivitySimpleBindingBinding;
import com.outspace.databindingagain.databinding.ActivityTwoWayBindingBinding;
import com.outspace.databindingagain.model.Person;
import com.outspace.databindingagain.model.PersonObservable;

public class TwoWayBinding extends AppCompatActivity {

    private PersonObservable person = new PersonObservable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_simple_binding);

        person.setFirstName("Luis Jesús");
        person.setLastName("Virueña Silva");
        person.setBirthDay("08/16/2017");
        person.setCoolPhrase("Follow the white rabbit");

        ActivityTwoWayBindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_two_way_binding);
        binding.setPerson(person);

        binding.btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                person.setFirstName("");
                person.setLastName("");
                person.setBirthDay("");
                person.setCoolPhrase("");
            }
        });

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = person.getFirstName();
                Toast.makeText(TwoWayBinding.this, "Firstname:" + s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
