package com.example.myapplication.ui.profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.MyViewHolder> {

    ArrayList<ProfileViewModel> dataholder;

    public ProfileAdapter(ArrayList<ProfileViewModel> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.profile_details, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.MyRequests.setText(dataholder.get(position).getMyrequests());
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView MyRequests;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            MyRequests =(TextView)itemView.findViewById(R.id.myrequests);
        }
    }
}
