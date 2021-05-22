package com.example.myapplication.ui.requests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class RequestsFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<RequestsViewModel> arrayList;
    private FirebaseFirestore fstore;
    private String userID;
    private FirebaseAuth auth;
    myadapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_requests, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerrequest);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirestoreRecyclerOptions<RequestsViewModel> options =
                new FirestoreRecyclerOptions.Builder<RequestsViewModel>()
                .setQuery(FirebaseFirestore.getInstance().collection("request"),RequestsViewModel.class)
                .build();

        adapter = new myadapter(options);
        recyclerView.setAdapter(adapter);
      /*  arrayList = new ArrayList<>();

        auth = FirebaseAuth.getInstance();
        userID = auth.getCurrentUser().getUid();
        fstore = FirebaseFirestore.getInstance();
        RequestsViewModel requestsViewModel = new RequestsViewModel("20JE0000", "Cancel Online Exams");
        arrayList.add(requestsViewModel);
        RequestsViewModel requestsViewModel1 = new RequestsViewModel("20JE0030", "Reopen College");
        arrayList.add(requestsViewModel1);
        RequestsViewModel requestsViewModel2 = new RequestsViewModel("20JE0093", "Reduce class timings");
        arrayList.add(requestsViewModel2);
        RequestsViewModel requestsViewModel3 = new RequestsViewModel("20JE0788", "Reduce college timings");
        arrayList.add(requestsViewModel3);
        RequestsViewModel requestsViewModel4 = new RequestsViewModel("20JE1056", "Hostel issues");
        arrayList.add(requestsViewModel4);
        RequestsViewModel requestsViewModel5 = new RequestsViewModel("20JE0485", "Mess problems");
        arrayList.add(requestsViewModel5);

        recyclerView.setAdapter(new ReqAdapter(arrayList));*/
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}