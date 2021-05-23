package com.example.myapplication.ui.profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import org.jetbrains.annotations.NotNull;

public class ProfilerequestAdapter extends FirestoreRecyclerAdapter<ProfileViewModel,ProfilerequestAdapter.myviewrequestholder> {

    public ProfilerequestAdapter(@NonNull @NotNull FirestoreRecyclerOptions<ProfileViewModel> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull @NotNull myviewrequestholder holder, int position, @NonNull @NotNull ProfileViewModel model) {
        holder.rollnostu.setText(model.getSubject());
        holder.requests.setText(model.getContent());

    }

    @NonNull
    @NotNull
    @Override
    public myviewrequestholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout,parent,false);
        return new myviewrequestholder(view);
    }

    public class myviewrequestholder extends RecyclerView.ViewHolder
    {
        TextView rollnostu,requests;
        String visibility;
        public myviewrequestholder(@NonNull @NotNull View itemView) {
            super(itemView);

            rollnostu = itemView.findViewById(R.id.rollnostu);
            requests = itemView.findViewById(R.id.requests);
        }
    }
}
