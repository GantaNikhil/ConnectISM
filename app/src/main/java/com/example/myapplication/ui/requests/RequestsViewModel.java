package com.example.myapplication.ui.requests;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RequestsViewModel {
    String rollno;
    String  arrayList;

    public RequestsViewModel(String rollno, String arrayList) {
        this.rollno = rollno;
        this.arrayList = arrayList;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getArrayList() {
        return arrayList;
    }

    public void setArrayList(String  arrayList) {
        this.arrayList = arrayList;
    }
}
