package com.outspace.databindingagain.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.outspace.databindingagain.R;
import com.outspace.databindingagain.databinding.ActivityTwoWayBindingBinding;
import com.outspace.databindingagain.model.PersonObservable;
import com.outspace.databindingagain.viewmodel.ViewModelForVMBinding;

public class ViewModelBinding extends AppCompatActivity {

    private PersonObservable person = new PersonObservable();
    private ViewModelForVMBinding vmBinding = new ViewModelForVMBinding();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityTwoWayBindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_viewmodel_binding);
        binding.setPerson(person);
    }


}
