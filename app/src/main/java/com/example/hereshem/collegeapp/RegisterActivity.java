package com.example.hereshem.collegeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    EditText name, email, pass, phone, address;
    Button button;

    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DbHelper(getApplicationContext());

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        address = (EditText) findViewById(R.id.address);
        pass = (EditText) findViewById(R.id.pass);
        button = (Button) findViewById(R.id.button);

        name.setText(getIntent().getStringExtra("name"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();

                Users u = new Users(n, pass.getText().toString(),
                        email.getText().toString(),
                        address.getText().toString(),
                        phone.getText().toString());

                db.addUsers(u);

                Toast.makeText(RegisterActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}
