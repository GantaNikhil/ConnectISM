package com.example.myapplication.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfileViewModel {
    String myrequests;

    public ProfileViewModel(String myrequests) {
        this.myrequests = myrequests;
    }

    public String getMyrequests() {
        return myrequests;
    }

    public void setMyrequests(String myrequests) {
        this.myrequests = myrequests;
    }
}
