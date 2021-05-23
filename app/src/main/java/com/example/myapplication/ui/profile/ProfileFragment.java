package com.example.myapplication.ui.profile;

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
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class ProfileFragment extends Fragment {
    TextView name,admno;
    RecyclerView recyclerView;
    //ArrayList<ProfileViewModel> arrayList;
    //firebase auth
    FirebaseFirestore fstore;
    FirebaseAuth firebaseAuth;
   // DatabaseReference reff;
    TextView mProfileTv;
    String uid;
    ProfilerequestAdapter adapter2;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerprofile);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        fstore = FirebaseFirestore.getInstance();
        firebaseAuth= FirebaseAuth.getInstance();
        mProfileTv= v.findViewById(R.id.profileTv);
        name=v.findViewById(R.id.profilename);
        admno=v.findViewById(R.id.profileadmno);

        uid=firebaseAuth.getCurrentUser().getUid();
        fstore = FirebaseFirestore.getInstance();
        String userID;

        DocumentReference documentReference = fstore.collection("students").document(uid);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

              name.setText(documentSnapshot.getString("Name"));
              admno.setText(documentSnapshot.getString("admissionno"));



            }
        });
        userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Query query = fstore.collection("request").whereEqualTo("uid",userID);


        FirestoreRecyclerOptions<ProfileViewModel> options = new FirestoreRecyclerOptions.Builder<ProfileViewModel>()
                .setQuery(query,ProfileViewModel.class)
                .build();

        adapter2 =new ProfilerequestAdapter(options);
        recyclerView.setAdapter(adapter2);



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
        adapter2.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter2.stopListening();
    }
}

