package com.outspace.databindingagain.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.outspace.databindingagain.BR;

// BaseObservable, allows that changes to the properties (Through setter) will
// be notified to the user interface. - Changes to the POJO are reflected on the UI.
// though, changes to the UI do not reflect on the POJO. For that we need...

public class PersonObservable extends BaseObservable {
    private String firstName;
    private String lastName;
    private String birthDay;
    private String coolPhrase;

    private TextWatcher firstNameWatcher;
    private TextWatcher lastNameWatcher;
    private TextWatcher birthdayWatcher;
    private TextWatcher coolPhraseWatcher;

    public PersonObservable() {
        firstNameWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                PersonObservable.this.firstName = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        };
        lastNameWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                PersonObservable.this.lastName = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        };
        birthdayWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                PersonObservable.this.birthDay = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        };
        coolPhraseWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                PersonObservable.this.coolPhrase = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        };
    }

    @Bindable
    public TextWatcher getFirstNameWatcher() {
        return firstNameWatcher;
    }

    @Bindable
    public TextWatcher getLastNameWatcher() {
        return lastNameWatcher;
    }

    @Bindable
    public TextWatcher getBirthdayWatcher() {
        return birthdayWatcher;
    }

    @Bindable
    public TextWatcher getCoolPhraseWatcher() {
        return coolPhraseWatcher;
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    @Bindable
    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
        notifyPropertyChanged(BR.birthDay);
    }

    @Bindable
    public String getCoolPhrase() {
        return coolPhrase;
    }

    public void setCoolPhrase(String coolPhrase) {
        this.coolPhrase = coolPhrase;
        notifyPropertyChanged(BR.coolPhrase);
    }

}
