package com.example.recyclerviewfirebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DeviceAdapter deviceAdapter;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        databaseReference = FirebaseDatabase.getInstance().getReference("users/Aditya Khawale /Devices");
        FirebaseRecyclerOptions<DeviceModel> options =
                new FirebaseRecyclerOptions.Builder<DeviceModel>()
                        .setQuery(databaseReference, DeviceModel.class)
                        .build();

        deviceAdapter = new DeviceAdapter(options);
        recyclerView.setAdapter(deviceAdapter);



    }

    @Override protected void onStart()
    {
        super.onStart();
        deviceAdapter.startListening();
    }

    // Function to tell the app to stop getting
    // data from database on stopping of the activity
    @Override protected void onStop()
    {
        super.onStop();
        deviceAdapter.stopListening();
    }

}
