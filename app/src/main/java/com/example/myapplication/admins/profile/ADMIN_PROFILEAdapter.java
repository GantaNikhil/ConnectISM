package com.example.myapplication.admins.profile;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.ui.profile.ProfileViewModel;

import java.util.ArrayList;

public class ADMIN_PROFILEAdapter extends RecyclerView.Adapter<ADMIN_PROFILEAdapter.MyViewHolder> {

    ArrayList<ADMIN_PROFILEViewModel> dataholder;

    public ADMIN_PROFILEAdapter(ArrayList<ADMIN_PROFILEViewModel> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public ADMIN_PROFILEAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout._admins_profile_details, parent, false);
        return new ADMIN_PROFILEAdapter.MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ADMIN_PROFILEAdapter.MyViewHolder holder, int position) {
        holder.MyRequests.setText(dataholder.get(position).getMyrequests());
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView MyRequests;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            MyRequests =(TextView)itemView.findViewById(R.id.myrequests_admins);
        }
    }
}
