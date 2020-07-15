package com.example.ramnaam;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;
import java.util.List;

public class leaderboard extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        final DatabaseReference myRef1 = database.getReference("JAAP");
        final DatabaseReference myRef2 = database.getReference("users");
        TextView top1 = findViewById(R.id.top1);
        TextView top2 = findViewById(R.id.top2);
        TextView top3 = findViewById(R.id.top3);
        TextView top4 = findViewById(R.id.top4);
        TextView top5 = findViewById(R.id.top5);
        TextView top6 = findViewById(R.id.top6);
        TextView top7 = findViewById(R.id.top7);
        TextView top8 = findViewById(R.id.top8);
        TextView top9 = findViewById(R.id.top9);
        TextView top10 = findViewById(R.id.top10);
        TextView top11 = findViewById(R.id.top11);
        TextView top12 = findViewById(R.id.top12);
        TextView top13 = findViewById(R.id.top13);
        TextView top14 = findViewById(R.id.top14);
        TextView top15 = findViewById(R.id.top15);
        TextView top16 = findViewById(R.id.top16);
        TextView top17 = findViewById(R.id.top17);
        TextView top18 = findViewById(R.id.top18);
        TextView top19 = findViewById(R.id.top19);
        TextView top20 = findViewById(R.id.top20);
        TextView op1 = findViewById(R.id.op1);
        TextView op2 = findViewById(R.id.op2);
        TextView op3 = findViewById(R.id.op3);
        TextView op4 = findViewById(R.id.op4);
        TextView op5 = findViewById(R.id.op5);
        TextView op6 = findViewById(R.id.op6);
        TextView op7 = findViewById(R.id.op7);
        TextView op8 = findViewById(R.id.op8);
        TextView op9 = findViewById(R.id.op9);
        TextView op10 = findViewById(R.id.op10);
        TextView op11 = findViewById(R.id.op11);
        TextView op12 = findViewById(R.id.op12);
        TextView op13 = findViewById(R.id.op13);
        TextView op14 = findViewById(R.id.op14);
        TextView op15 = findViewById(R.id.op15);
        TextView op16 = findViewById(R.id.op16);
        TextView op17 = findViewById(R.id.op17);
        TextView op18 = findViewById(R.id.op18);
        TextView op19 = findViewById(R.id.op19);
        TextView op20 = findViewById(R.id.op20);
        final String[] k = {""};
        final String[] k1 = {""};
        final String[] k2 = {""};
        final String[] k3 = {""};
        final String[] k4 = {""};
        final String[] k5 = {""};
        final String[] k6 = {""};
        final String[] k7 = {""};
        final String[] k8 = {""};
        final String[] k9 = {""};
        final String[] k10 = {""};
        final String[] k11 = {""};
        final String[] k12 = {""};
        final String[] k13 = {""};
        final String[] k14 = {""};
        final String[] k15 = {""};
        final String[] k16 = {""};
        final String[] k17 = {""};
        final String[] k18 = {""};
        final String[] k19 = {""};
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
                String x = "";
                String temp = "";
                String finaltemp = "";
                for(int i= 0 ; i<s.length;i++){
                    if( i%2 == 0){
                         x = s[i];
                         temp =  x +","+temp;
                    }
                }
                finaltemp = temp+"0";
                String[] b = finaltemp.split(",");
                int size1 = b.length;
                int [] arr = new int [size1];
                for(int i=0; i<size1; i++) {
                    arr[i] = Integer.parseInt(b[i]);
                }
                Arrays.sort(arr);
                op1.setText(String.valueOf(arr[size1-1]));
                op2.setText(String.valueOf(arr[size1-2]));
                op3.setText(String.valueOf(arr[size1-3]));
                op4.setText(String.valueOf(arr[size1-4]));
                op5.setText(String.valueOf(arr[size1-5]));
                op6.setText(String.valueOf(arr[size1-6]));
                op7.setText(String.valueOf(arr[size1-7]));
                op8.setText(String.valueOf(arr[size1-8]));
                op9.setText(String.valueOf(arr[size1-9]));
                op10.setText(String.valueOf(arr[size1-10]));
                op11.setText(String.valueOf(arr[size1-11]));
                op12.setText(String.valueOf(arr[size1-12]));
                op13.setText(String.valueOf(arr[size1-13]));
                op14.setText(String.valueOf(arr[size1-14]));
                op15.setText(String.valueOf(arr[size1-15]));
                op16.setText(String.valueOf(arr[size1-16]));
                op17.setText(String.valueOf(arr[size1-17]));
                op18.setText(String.valueOf(arr[size1-18]));
                op19.setText(String.valueOf(arr[size1-19]));
                op20.setText(String.valueOf(arr[size1-20]));
                //beggining of name display
                for(int i = 0 ;i<s.length;i++){
                    if(s[i].equals(String.valueOf(arr[size1-1])) ){//add -1 and so on
                        k[0] =s[i-1];//add +1 in k
                    }
                    else
                        if(s[i].equals(String.valueOf(arr[size1-2]))){
                            k1[0] =s[i-1];
                        }
                        else
                        if(s[i].equals(String.valueOf(arr[size1-3]))){
                            k2[0] =s[i-1];
                        }
                        else
                        if(s[i].equals(String.valueOf(arr[size1-4]))){
                            k3[0] =s[i-1];
                        }
                        else
                        if(s[i].equals(String.valueOf(arr[size1-5]))){
                            k4[0] =s[i-1];
                        }
                        else
                        if(s[i].equals(String.valueOf(arr[size1-6]))){
                            k5[0] =s[i-1];
                        }
                        else
                        if(s[i].equals(String.valueOf(arr[size1-7]))){
                            k6[0] =s[i-1];
                        }
                        else
                        if(s[i].equals(String.valueOf(arr[size1-8]))){
                            k7[0] =s[i-1];
                        }
                        else
                        if(s[i].equals(String.valueOf(arr[size1-9]))){
                            k8[0] =s[i-1];
                        }
                        else
                        if(s[i].equals(String.valueOf(arr[size1-10]))){
                            k9[0] =s[i-1];
                        }
                        else
                        if(s[i].equals(String.valueOf(arr[size1-11]))){
                            k10[0] =s[i-1];
                        }
                        else
                        if(s[i].equals(String.valueOf(arr[size1-12]))){
                            k11[0] =s[i-1];
                        }
                        else
                        if(s[i].equals(String.valueOf(arr[size1-13]))){
                            k12[0] =s[i-1];
                        }
                        else
                        if(s[i].equals(String.valueOf(arr[size1-14]))){
                            k13[0] =s[i-1];
                        }
                        else
                        if(s[i].equals(String.valueOf(arr[size1-15]))){
                            k14[0] =s[i-1];
                        }
                        else
                        if(s[i].equals(String.valueOf(arr[size1-16]))){
                            k15[0] =s[i-1];
                        }
                        else
                        if(s[i].equals(String.valueOf(arr[size1-17]))){
                            k16[0] =s[i-1];
                        }
                        else
                        if(s[i].equals(String.valueOf(arr[size1-18]))){
                            k17[0] =s[i-1];
                        }
                        else
                        if(s[i].equals(String.valueOf(arr[size1-19]))){
                            k18[0] =s[i-1];
                        }
                        else
                        if(s[i].equals(String.valueOf(arr[size1-20]))){
                            k19[0] =s[i-1];
                        }
                }
              myRef2.addValueEventListener(new ValueEventListener() {
                  @Override
                  public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                      String data = dataSnapshot.getValue().toString();
                      String data1 = "0"+data;
                      String data2 = data1+"0";
                      String[] s = data2.split("[}]|=|,|[{]");
                      for(int i= 0 ; i<s.length;i++){
                          if( s[i].equals( k[0])){//add 1 to k
                              top1.setText(s[i+1]);//top +1
                          }
                          else
                              if( s[i].equals( k1[0])){
                                  top2.setText(s[i+1]);
                              }
                              else
                              if( s[i].equals( k2[0])){
                                  top3.setText(s[i+1]);
                              }
                              else
                              if( s[i].equals( k3[0])){
                                  top4.setText(s[i+1]);
                              }
                              else
                              if( s[i].equals( k4[0])){
                                  top5.setText(s[i+1]);
                              }
                              else
                              if( s[i].equals( k5[0])){
                                  top6.setText(s[i+1]);
                              }
                              else
                              if( s[i].equals( k6[0])){
                                  top7.setText(s[i+1]);
                              }
                              else
                              if( s[i].equals( k7[0])){
                                  top8.setText(s[i+1]);
                              }
                              else
                              if( s[i].equals( k8[0])){
                                  top9.setText(s[i+1]);
                              }
                              else
                              if( s[i].equals( k9[0])){
                                  top10.setText(s[i+1]);
                              }
                              else
                              if( s[i].equals( k10[0])){
                                  top11.setText(s[i+1]);
                              }
                              else
                              if( s[i].equals( k11[0])){
                                  top12.setText(s[i+1]);
                              }
                              else
                              if( s[i].equals( k12[0])){
                                  top13.setText(s[i+1]);
                              }
                              else
                              if( s[i].equals( k13[0])){
                                  top14.setText(s[i+1]);
                              }
                              else
                              if( s[i].equals( k14[0])){
                                  top15.setText(s[i+1]);
                              }
                              else
                              if( s[i].equals( k15[0])){
                                  top16.setText(s[i+1]);
                              }
                              else
                              if( s[i].equals( k16[0])){
                                  top17.setText(s[i+1]);
                              }
                              else
                              if( s[i].equals( k17[0])){
                                  top18.setText(s[i+1]);
                              }
                              else
                              if( s[i].equals( k18[0])){
                                  top19.setText(s[i+1]);
                              }
                              else
                              if( s[i].equals( k19[0])){
                                  top20.setText(s[i+1]);
                              }
                      }

                  }

                  @Override
                  public void onCancelled(@NonNull DatabaseError databaseError) {

                  }
              });



            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
    }
}