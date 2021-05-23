package com.example.myapplication.ui.requests;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
/*
public class ReqAdapter extends RecyclerView.Adapter<ReqAdapter.MyViewHolder> {

    ArrayList<RequestsViewModel> dataholder;

    public ReqAdapter(ArrayList<RequestsViewModel> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.Rollno.setText(dataholder.get(position).getRollno());
        holder.Requests.setText(dataholder.get(position).getArrayList());
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Rollno,Requests;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Rollno =(TextView)itemView.findViewById(R.id.rollnostu);
            Requests=(TextView)itemView.findViewById(R.id.requests);
        }
    }
}
*/