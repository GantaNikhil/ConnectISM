package com.example.myapplication.admins.requests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.ui.requests.ReqAdapter;
import com.example.myapplication.ui.requests.RequestsViewModel;

import java.util.ArrayList;

public class ADMIN_REQUESTS extends Fragment {
    RecyclerView recyclerView;
    ArrayList<ADMIN_REQUESTSViewModel> arrayList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout._admins_fragment_requests, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerrequest_admins);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        arrayList = new ArrayList<>();

        ADMIN_REQUESTSViewModel requestsViewModel = new ADMIN_REQUESTSViewModel("Dean", "Open College");
        arrayList.add(requestsViewModel);
        ADMIN_REQUESTSViewModel requestsViewModel1 = new ADMIN_REQUESTSViewModel("Director", "Reopen College");
        arrayList.add(requestsViewModel1);
        ADMIN_REQUESTSViewModel requestsViewModel2 = new ADMIN_REQUESTSViewModel("ADean", "Cancel exams");
        arrayList.add(requestsViewModel2);

        recyclerView.setAdapter(new ADMIN_REQUESTSAdapter(arrayList));
        return v;
    }
}