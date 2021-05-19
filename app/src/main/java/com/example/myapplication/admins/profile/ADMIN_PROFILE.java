package com.example.myapplication.admins.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.ui.profile.ProfileAdapter;
import com.example.myapplication.ui.profile.ProfileViewModel;

import java.util.ArrayList;

public class ADMIN_PROFILE extends Fragment {
    RecyclerView recyclerView;
    ArrayList<ADMIN_PROFILEViewModel> arrayList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout._admins_fragment_profile, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerprofile_admins);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        arrayList = new ArrayList<>();

        ADMIN_PROFILEViewModel requestsViewModel = new ADMIN_PROFILEViewModel( "jj33jfjh");
        arrayList.add(requestsViewModel);
        ADMIN_PROFILEViewModel requestsViewModel1 = new ADMIN_PROFILEViewModel( "jjj8h");
        arrayList.add(requestsViewModel1);
        ADMIN_PROFILEViewModel requestsViewModel2 = new ADMIN_PROFILEViewModel( "j7jjh");
        arrayList.add(requestsViewModel2);

        recyclerView.setAdapter(new ADMIN_PROFILEAdapter(arrayList));
        return v;
    }
}
