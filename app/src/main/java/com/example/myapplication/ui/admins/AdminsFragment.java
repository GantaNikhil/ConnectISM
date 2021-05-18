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

        AdminsViewModel requestsViewModel = new AdminsViewModel("0000000000", "jj33jfjh@gmail.com");
        arrayList.add(requestsViewModel);
        AdminsViewModel requestsViewModel1 = new AdminsViewModel("1111111111", "jjj8h@gmail.com");
        arrayList.add(requestsViewModel1);
        AdminsViewModel requestsViewModel2 = new AdminsViewModel("222222222", "j7jjh@gmail.com");
        arrayList.add(requestsViewModel2);

        recyclerView.setAdapter(new AdminsAdapter(arrayList));
        return v;
    }
}