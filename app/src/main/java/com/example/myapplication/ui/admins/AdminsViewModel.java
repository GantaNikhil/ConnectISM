package com.example.myapplication.ui.admins;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AdminsViewModel {
    String Phoneno;
    String  Email;
    String name;

    public AdminsViewModel(String Phoneno, String Email,String name) {
        this.Phoneno = Phoneno;
        this.Email = Email;
        this.name=name;
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

    public String getName() {
        return name;
    }

    public void setName(String  name) {
        this.name = name;
    }
}
