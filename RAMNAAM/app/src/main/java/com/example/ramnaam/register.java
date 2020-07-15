package com.example.ramnaam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    EditText etmail,etpass,etname;
    Button btnregister;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText etmail = findViewById(R.id.etmail);
        final EditText etpass = findViewById(R.id.etpass);
        final EditText etname = findViewById(R.id.etname);
        final Button btnregister = findViewById(R.id.btnregister);
        final DatabaseReference myRef = database.getReference("users");

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etmail.getText().toString().trim();
                String password = etpass.getText().toString().trim();
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information

                                    FirebaseUser user = mAuth.getCurrentUser();
                                    myRef.child(user.getUid()).setValue(etname.getText().toString().trim());
                                    startActivity(new Intent(register.this, MainActivity.class));
                                } else {
                                    Toast.makeText(register.this, "Authentication failed.",Toast.LENGTH_SHORT).show();

                                }

                                // ...
                            }
                        });

            }
        });

    }
}