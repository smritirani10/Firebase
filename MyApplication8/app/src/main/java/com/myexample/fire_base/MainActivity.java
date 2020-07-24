package com.myexample.fire_base;
import androidx.annotation.NonNull;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends Activity {
    EditText name, roll_no, add, email, branch;
    Button register, show_data;
    FirebaseDatabase fd;
    DatabaseReference dbr;
    int maxid = 0;


    Student s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roll_no = findViewById(R.id.roll_no);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        add= findViewById(R.id.add);
        branch = findViewById(R.id.branch);
        register = findViewById(R.id.register);
        show_data = findViewById(R.id.show_data);
        s = new Student();
        dbr = FirebaseDatabase.getInstance().getReference().child("Student");
        dbr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    maxid = (int) snapshot.getChildrenCount();
                } else {

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s.setRoll_no(Integer.parseInt(roll_no.getText().toString()));
                s.setName(name.getText().toString());
                s.setAdd(add.getText().toString());
                s.setBranch(branch.getText().toString());
                s.setEmail(email.getText().toString());
                dbr.child(String.valueOf(maxid+1)).setValue(s);
                //dbr.setValue(s);
            }
        });
        show_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowData.class);
                startActivity(intent);
            }
        });
    }
}
