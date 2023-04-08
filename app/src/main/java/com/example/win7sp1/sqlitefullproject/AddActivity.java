package com.example.win7sp1.sqlitefullproject;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    EditText edit1;
    EditText edit2;
    Button button;
    MyHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        edit1=findViewById(R.id.editname);
        edit2=findViewById(R.id.editphone);
        button=findViewById(R.id.btn);

        db =new MyHelper(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edit1.getText().toString();
                String phone=edit2.getText().toString();
                Contact contact=new Contact(name,phone);
                db.addContact(contact);
                Toast.makeText(AddActivity.this,"Data added",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
