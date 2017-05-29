package com.example.hereshem.collegeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.register).setOnClickListener(this);
        findViewById(R.id.list).setOnClickListener(this);
        findViewById(R.id.message).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register:
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                break;
            case R.id.list:
                startActivity(new Intent(getApplicationContext(), ListActivity.class));
                break;
            case R.id.message:
                startActivity(new Intent(getApplicationContext(), MessageActivity.class));
                break;

        }
    }
}
