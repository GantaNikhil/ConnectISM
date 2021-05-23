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
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class RequestsFragment extends Fragment {
    RecyclerView recyclerView;
    /*ArrayList<RequestsViewModel> arrayList;*/
    private FirebaseFirestore fstore;
   /* private String userID;
    private FirebaseAuth auth;*/
    myadapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_requests, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerrequest);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        fstore = FirebaseFirestore.getInstance();
        Query query = fstore.collection("request").whereEqualTo("visibility","Public");


        FirestoreRecyclerOptions<RequestsViewModel> options = new FirestoreRecyclerOptions.Builder<RequestsViewModel>()
                .setQuery(query,RequestsViewModel.class)
                .build();


        adapter =new myadapter(options);
        recyclerView.setAdapter(adapter);

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