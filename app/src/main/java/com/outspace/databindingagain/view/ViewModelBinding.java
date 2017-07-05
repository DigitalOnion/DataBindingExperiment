package com.outspace.databindingagain.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.outspace.databindingagain.R;
import com.outspace.databindingagain.databinding.ActivityViewmodelBindingBinding;
import com.outspace.databindingagain.viewmodel.ViewModelForVMBExample;

public class ViewModelBinding extends AppCompatActivity {

    private ViewModelForVMBExample viewmodel = new ViewModelForVMBExample();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityViewmodelBindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_viewmodel_binding);
        binding.setPerson(viewmodel.getPerson());
        binding.setViewmodel(viewmodel);

        viewmodel.setBinding(binding);
        viewmodel.init();
    }
}
