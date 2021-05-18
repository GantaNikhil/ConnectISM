package com.example.myapplication.ui.profile;

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

public class ProfileFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<ProfileViewModel> arrayList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerprofile);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        arrayList = new ArrayList<>();

        ProfileViewModel requestsViewModel = new ProfileViewModel( "jj33jfjh");
        arrayList.add(requestsViewModel);
        ProfileViewModel requestsViewModel1 = new ProfileViewModel( "jjj8h");
        arrayList.add(requestsViewModel1);
        ProfileViewModel requestsViewModel2 = new ProfileViewModel( "j7jjh");
        arrayList.add(requestsViewModel2);

        recyclerView.setAdapter(new ProfileAdapter(arrayList));
        return v;
    }
}