package com.example.myapplication.ui.admins;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AdminsViewModel {
    String Phoneno;
    String  Email;

    public AdminsViewModel(String Phoneno, String Email) {
        this.Phoneno = Phoneno;
        this.Email = Email;
    }

    public String getPhoneno() {
        return Phoneno;
    }

    public void setPhoneno(String Phoneno) {
        this.Phoneno = Phoneno;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String  Email) {
        this.Email = Email;
    }
}
