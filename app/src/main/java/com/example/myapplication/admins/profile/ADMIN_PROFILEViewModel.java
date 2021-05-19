package com.example.myapplication.admins.profile;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ADMIN_PROFILEViewModel {
    String myrequests;

    public ADMIN_PROFILEViewModel(String myrequests) {
        this.myrequests = myrequests;
    }

    public String getMyrequests() {
        return myrequests;
    }

    public void setMyrequests(String myrequests) {
        this.myrequests = myrequests;
    }
}

