package com.example.ramnaam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.text.format.Time;
import java.util.Calendar;
import java.util.Date;

public class myjaap extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private FirebaseAuth mAuth;
    EditText etmyjaap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myjaap);
        mAuth = FirebaseAuth.getInstance();
        final EditText etmyjaap = findViewById(R.id.etmyjaap);
        final TextView tvjaap = findViewById(R.id.tvjaap);
        final TextView tvmaala = findViewById(R.id.tvmaala);
        final TextView tvjaaptoday = findViewById(R.id.tvjaaptoday);
        final TextView tvjaapmala = findViewById(R.id.tvjaapmala);
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final DatabaseReference myRef = database.getReference("JAAP");


        final Button btnsub = findViewById(R.id.btnsub);
        etmyjaap.setText("0");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                if( dataSnapshot.child(user.getUid()).getValue() == null){
                    myRef.child(user.getUid()).setValue("0");
                }
                else{String value =  dataSnapshot.child(user.getUid()).getValue().toString();
                    tvjaap.setText(value.toString());
                    tvmaala.setText(String.valueOf(Integer.parseInt(value)*108));
                    Time time = new Time();
                    time.setToNow();
                    Integer val1 = Integer.parseInt(value.toString());
                    Integer maala = val1*108;
                    String mala = maala.toString();
                     if(time.hour == 24){
                        tvjaaptoday.setText("0");
                        tvjaapmala.setText("0");
                    }
                    else{
                        tvjaaptoday.setText(value.toString());
                        tvjaapmala.setText(mala);
                    }
                    btnsub.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String jaap = etmyjaap.getText().toString().trim();
                            Integer val = Integer.parseInt(String.valueOf(value));
                            Integer val1 = Integer.parseInt(etmyjaap.getText().toString().trim());
                            Integer total = val+val1;
                            String totalvalue = total.toString().trim();
                            myRef.child(user.getUid()).setValue(totalvalue);
                            etmyjaap.setText("0");
                            Toast.makeText(myjaap.this, "SUBMITTED", Toast.LENGTH_SHORT).show();
                        }
                    });
                }


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                String TAG="";
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }
}