package com.example.myapplication.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.MemberStu;
import com.example.myapplication.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {
    TextView name,admno;
    RecyclerView recyclerView;
    ArrayList<ProfileViewModel> arrayList;
    //firebase auth
    FirebaseFirestore fstore;
    FirebaseAuth firebaseAuth;
    DatabaseReference reff;
    TextView mProfileTv;
    String uid;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerprofile);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        arrayList = new ArrayList<>();

        ProfileViewModel requestsViewModel = new ProfileViewModel( "jj33jfjh");
        arrayList.add(requestsViewModel);
        ProfileViewModel requestsViewModel1 = new ProfileViewModel( "jjj8h");
        arrayList.add(requestsViewModel1);
        ProfileViewModel requestsViewModel2 = new ProfileViewModel( "j7jjh");
        arrayList.add(requestsViewModel2);

        recyclerView.setAdapter(new ProfileAdapter(arrayList));

        firebaseAuth= FirebaseAuth.getInstance();
        mProfileTv= v.findViewById(R.id.profileTv);
        name=v.findViewById(R.id.profilename);
        admno=v.findViewById(R.id.profileadmno);
        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        uid=user.getUid();
        DocumentReference documentReference = fstore.collection("students").document(uid);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
            name.setText(documentSnapshot.getString("Name"));
            admno.setText(documentSnapshot.getString("admissionno"));
            }
        });
        reff= FirebaseDatabase.getInstance().getReference().child("Member").child(uid.toString());
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String stuname=snapshot.child("name").getValue().toString();
                //String stuno=snapshot.child("adm").getValue().toString();
                name.setText(stuname);
                //name.setText(uid);
                //admno.setText(stuno);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return v;
    }
    private void checkUserStatus(){
        //get current user
        FirebaseUser user= firebaseAuth.getCurrentUser();
        if(user !=null){
            //user is signed in stay here
            //set email of logged in user
            mProfileTv.setText(user.getEmail());
        }
    }
    @Override
    public void onStart() {
        //check on start of app
        checkUserStatus();
        super.onStart();
    }
}

