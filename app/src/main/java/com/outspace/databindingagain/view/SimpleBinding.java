package com.outspace.databindingagain.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.outspace.databindingagain.R;
import com.outspace.databindingagain.databinding.ActivitySimpleBindingBinding;
import com.outspace.databindingagain.model.Person;

public class SimpleBinding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_simple_binding);

        Person person = new Person();
        person.setFirstName("Luis Jesús");
        person.setLastName("Virueña Silva");
        person.setBirthDay("08/16/2017");
        person.setCoolPhrase("Follow the white rabbit");

        ActivitySimpleBindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_simple_binding);
        binding.setPerson(person);
    }
}
