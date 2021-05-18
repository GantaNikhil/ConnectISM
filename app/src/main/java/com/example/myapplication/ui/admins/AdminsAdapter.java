package com.example.myapplication.ui.admins;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class AdminsAdapter extends RecyclerView.Adapter<AdminsAdapter.MyViewHolder> {

    ArrayList<AdminsViewModel> dataholder;

    public AdminsAdapter(ArrayList<AdminsViewModel> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.admins_contacts, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.Phoneno.setText(dataholder.get(position).getPhoneno());
        holder.Email.setText(dataholder.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Phoneno,Email;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Phoneno =(TextView)itemView.findViewById(R.id.phone);
            Email=(TextView)itemView.findViewById(R.id.emailid);
        }
    }
}
