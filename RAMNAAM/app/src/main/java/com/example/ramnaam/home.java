package com.example.ramnaam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class home extends AppCompatActivity {
Button btnjaap,btnaboutus,btnleaderboard,btnmyjaap;
FirebaseAuth mAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button btnaboutus = findViewById(R.id.btnaboutus);
        Button btnmyjaap = findViewById(R.id.btnmyjaap);
        Button btnjaap = findViewById(R.id.btnjaap);
        Button btnleaderboard = findViewById(R.id.btnleaderboard);
        Button btnlogout = findViewById(R.id.btnlogout);
        final TextView tvmembers = findViewById(R.id.tvmembers);
        final TextView totaljaap = findViewById(R.id.totaljaap);
        final DatabaseReference myRef = database.getReference("users");
        final DatabaseReference myRef1 = database.getReference("JAAP");

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.getInstance().signOut();
                Intent intent = new Intent(home.this,MainActivity.class);
                startActivity(intent);
            }
        });
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = String.valueOf(dataSnapshot.getChildrenCount());
                tvmembers.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
               String values = dataSnapshot.getValue().toString();
                Integer count = 0;
               String values1 = "0"+values;
               String values2 = values1+"0";
               String[] s = values2.split("[}]|=|,|[{]");


                for(int i= 0 ; i< s.length;i++){

                    if( i%2 == 0){
                        count = count + Integer.parseInt(s[i]);
                        totaljaap.setText(String.valueOf(count*108));
                    }

                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
        btnaboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this,aboutus.class);
                startActivity(intent); }
        });
        btnmyjaap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this,myjaap.class);
                startActivity(intent);
            }
        });
        btnjaap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this,livejaap.class);
                startActivity(intent);
            }
        });
        btnleaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this,leaderboard.class);
                startActivity(intent);
            }
        });

    }

    private boolean isNumeric( final String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;

    }

}