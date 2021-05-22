package com.example.myapplication.ui.requests;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import org.jetbrains.annotations.NotNull;

public class myadapter extends FirebaseRecyclerAdapter<RequestsViewModel,myadapter.myviewholder> {

    public myadapter(@NonNull @NotNull FirestoreRecyclerOptions<RequestsViewModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull myviewholder holder, int position, @NonNull @NotNull RequestsViewModel model) {
        holder.rollnostu.setText(model.getSubject());
        holder.requests.setText(model.getContent());
    }

    @NonNull
    @NotNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder
    {
        TextView rollnostu,requests;
        public myviewholder(@NonNull @NotNull View itemView) {
            super(itemView);

            rollnostu = itemView.findViewById(R.id.rollnostu);
            requests = itemView.findViewById(R.id.requests);
        }
    }
}
