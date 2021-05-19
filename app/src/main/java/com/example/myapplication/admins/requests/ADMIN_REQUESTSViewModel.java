package com.example.myapplication.admins.requests;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ADMIN_REQUESTSViewModel {
    String rollno;
    String  arrayList;

    public ADMIN_REQUESTSViewModel(String rollno, String arrayList) {
        this.rollno = rollno;
        this.arrayList = arrayList;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String designation) {
        this.rollno = designation;
    }

    public String getArrayList() {
        return arrayList;
    }

    public void setArrayList(String  arrayList) {
        this.arrayList = arrayList;
    }
}
