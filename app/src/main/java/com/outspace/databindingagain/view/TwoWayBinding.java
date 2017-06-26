package com.outspace.databindingagain.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.outspace.databindingagain.R;
import com.outspace.databindingagain.databinding.ActivitySimpleBindingBinding;
import com.outspace.databindingagain.databinding.ActivityTwoWayBindingBinding;
import com.outspace.databindingagain.model.Person;

public class TwoWayBinding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_simple_binding);

        final Person person = new Person();
        person.firstName  = "Luis Jesús";
        person.lastName   = "Virueña Silva";
        person.birthDay   = "08/16/2017";
        person.coolPhrase = "Follow the white rabbit";

        ActivityTwoWayBindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_two_way_binding);
        binding.setPerson(person);

        binding.btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                person.firstName  = "";
                person.lastName   = "";
                person.birthDay   = "";
                person.coolPhrase = "";
            }
        });
    }
}
