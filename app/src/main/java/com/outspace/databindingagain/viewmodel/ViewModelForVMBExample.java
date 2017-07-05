package com.outspace.databindingagain.viewmodel;

import android.view.View;
import android.widget.Toast;

import com.outspace.databindingagain.databinding.ActivityViewmodelBindingBinding;
import com.outspace.databindingagain.model.PersonObservable;

/**
 * Created by Luis Jesús Virueña Silva on 7/4/17.
 */

public class ViewModelForVMBExample {
    PersonObservable person = new PersonObservable();
    ActivityViewmodelBindingBinding binding = null;

    public PersonObservable getPerson() {
        return person;
    }

    public void setBinding(final ActivityViewmodelBindingBinding binding) {
        this.binding = binding;

        this.binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(binding.getRoot().getContext(), "Hellllloooooo!", Toast.LENGTH_SHORT).show();
            }
        });

        this.binding.btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                person.setFirstName("");
                person.setLastName("");
                person.setBirthDay("");
                person.setCoolPhrase("");
            }
        });
    }

    public boolean canSave() {
        return person.getFirstName().length() > 0;
    }

    public void init() {
        person.setFirstName("Luis Jesús");
        person.setLastName("Virueña Silva");
        person.setBirthDay("08/16/2017");
        person.setCoolPhrase("Always follow the white rabbit");
    }
}
