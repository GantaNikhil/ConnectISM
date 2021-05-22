package com.example.myapplication.admins.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.ui.profile.ProfileAdapter;
import com.example.myapplication.ui.profile.ProfileViewModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class ADMIN_PROFILE extends Fragment {
    TextView name,desg,mprofile;
    String uid;
    RecyclerView recyclerView;
    ArrayList<ADMIN_PROFILEViewModel> arrayList;
    FirebaseFirestore fstore;
    FirebaseAuth firebaseAuth;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout._admins_fragment_profile, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerprofile_admins);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        arrayList = new ArrayList<>();


        ADMIN_PROFILEViewModel requestsViewModel = new ADMIN_PROFILEViewModel( "Open College");
        arrayList.add(requestsViewModel);
        ADMIN_PROFILEViewModel requestsViewModel1 = new ADMIN_PROFILEViewModel( "Reopen College");
        arrayList.add(requestsViewModel1);
        ADMIN_PROFILEViewModel requestsViewModel2 = new ADMIN_PROFILEViewModel( "Room not clean");
        arrayList.add(requestsViewModel2);

        recyclerView.setAdapter(new ADMIN_PROFILEAdapter(arrayList));
        fstore = FirebaseFirestore.getInstance();
        firebaseAuth= FirebaseAuth.getInstance();
        name=v.findViewById(R.id.profilename_admin);
        desg=v.findViewById(R.id.designation);
        mprofile=v.findViewById(R.id.profileTv);
        uid=firebaseAuth.getCurrentUser().getUid();
        DocumentReference documentReference = fstore.collection("administrators").document(uid);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()){  name.setText(documentSnapshot.getString("Name"));
                    desg.setText(documentSnapshot.getString("Designation"));
                    mprofile.setText(documentSnapshot.getString("email"));
                }
                else {
                    name.setText("Name");
                    desg.setText("Designation");
                    mprofile.setText("email");
                }
            }
        });
        return v;
    }
}
