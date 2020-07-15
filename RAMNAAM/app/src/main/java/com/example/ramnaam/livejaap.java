package com.example.ramnaam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class livejaap extends AppCompatActivity {
    Integer count = 0;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("JAAP");
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livejaap);
        TextView tvlive = findViewById(R.id.tvlive);
        Button btnlive = findViewById(R.id.btnlive);
        mAuth = FirebaseAuth.getInstance();
        final Vibrator vibe = (Vibrator)
                livejaap.this.getSystemService(Context.VIBRATOR_SERVICE);
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        LayoutInflater li = getLayoutInflater();
        View layout = li.inflate(R.layout.customtoast,(ViewGroup) findViewById(R.id.custom_toast_layout));
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                if(dataSnapshot.child(user.getUid()).getValue() == null){
                    myRef.child(user.getUid()).setValue("0");
                }
                else{String value =  dataSnapshot.child(user.getUid()).getValue().toString();
                    btnlive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       /* Toast toast = new Toast(getApplicationContext());
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                        toast.setView(layout);
                        toast.show();*/
                        Integer totalval = Integer.parseInt(String.valueOf(value))*108+count;
                        if(count.equals(108) || count/108 == 0) {
                            Integer value4 = totalval / 108;
                            myRef.child(user.getUid()).setValue(value4);
                        }
                        tvlive.setText(totalval.toString());
                        vibe.vibrate(80);
                        count++;
                    }
                });

                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });


    }
}