package com.example.hereshem.collegeapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterFragment extends Fragment {

    EditText name, email, pass, phone, address;
    Button button;

    DbHelper db;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_register, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //setContentView(R.layout.activity_register);

        db = new DbHelper(getActivity());

        name = (EditText) getView().findViewById(R.id.name);
        email = (EditText) getView().findViewById(R.id.email);
        phone = (EditText) getView().findViewById(R.id.phone);
        address = (EditText) getView().findViewById(R.id.address);
        pass = (EditText) getView().findViewById(R.id.pass);
        button = (Button) getView().findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();

                Users u = new Users(n, pass.getText().toString(),
                        email.getText().toString(),
                        address.getText().toString(),
                        phone.getText().toString());

                db.addUsers(u);

                Toast.makeText(getActivity(), "Data inserted", Toast.LENGTH_SHORT).show();
                //finish();
            }
        });


    }
}
