package com.example.myapplication.ui.admins;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class AdminsFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<AdminsViewModel> arrayList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_admins, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycleradmins);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        arrayList = new ArrayList<>();

        AdminsViewModel requestsViewModel = new AdminsViewModel("+91-326-223-5213", "dean_acad@iitism.ac.in","Prof. G. UdayaBhanu");
        arrayList.add(requestsViewModel);
        AdminsViewModel requestsViewModel1 = new AdminsViewModel("+91-326-223-", "dean_admin@iitism.ac.in","Prof. D D Pathak");
        arrayList.add(requestsViewModel1);
        AdminsViewModel requestsViewModel2 = new AdminsViewModel("+91-326-223-5204", "dean_fac@iitism.ac.in","Prof. Jairam Manam");
        arrayList.add(requestsViewModel2);
        AdminsViewModel requestsViewModel3 = new AdminsViewModel("+91-326-223-5286", "dean_ic@iitism.ac.in","Prof. Chiranjeev Kumar");
        arrayList.add(requestsViewModel3);
        AdminsViewModel requestsViewModel4 = new AdminsViewModel("+91-326-223-5437", "dean_infra@iitism.ac.in","Prof. J.K. Pattanayak");
        arrayList.add(requestsViewModel4);
        AdminsViewModel requestsViewModel5 = new AdminsViewModel("+91-326-223-5445", "dean_iraa@iitism.ac.in","Prof. Dheeraj Kumar");
        arrayList.add(requestsViewModel5);
        AdminsViewModel requestsViewModel6 = new AdminsViewModel("+91-326-223-5203", "dean_rnd@iitism.ac.in","Prof. Shalivahan");
        arrayList.add(requestsViewModel6);
        AdminsViewModel requestsViewModel7 = new AdminsViewModel("+91-326-223-5205", "dean_sw@iitism.ac.in","Prof. M.K.Singh");
        arrayList.add(requestsViewModel7);

        recyclerView.setAdapter(new AdminsAdapter(arrayList));
        return v;
    }
}