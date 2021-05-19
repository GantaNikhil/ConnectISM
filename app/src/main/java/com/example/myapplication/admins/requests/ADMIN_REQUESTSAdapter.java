package com.example.myapplication.admins.requests;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class ADMIN_REQUESTSAdapter extends RecyclerView.Adapter<ADMIN_REQUESTSAdapter.MyViewHolder> {

    ArrayList<ADMIN_REQUESTSViewModel> dataholder;

    public ADMIN_REQUESTSAdapter(ArrayList<ADMIN_REQUESTSViewModel> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout._admins_requestlist, parent, false);
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
            Rollno =(TextView)itemView.findViewById(R.id.rollnostu_admins);
            Requests=(TextView)itemView.findViewById(R.id.requests_admins);
        }
    }
}
