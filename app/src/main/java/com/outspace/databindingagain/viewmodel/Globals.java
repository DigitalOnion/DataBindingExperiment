package com.outspace.databindingagain.viewmodel;

import com.outspace.databindingagain.view.MainActivity;

/**
 * Created by user on 6/25/17.
 */

class Globals {
    private static final Globals ourInstance = new Globals();

    static Globals getInstance() {
        return ourInstance;
    }

    private Globals() {
    }

    public String getViewPackage() {
        String pack = MainActivity.class.getPackage().getName();
        return pack;
    }

}
