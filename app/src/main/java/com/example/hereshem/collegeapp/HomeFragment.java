package com.example.hereshem.collegeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.activity_main, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        setContentView(R.layout.activity_main);

        getView().findViewById(R.id.register).setOnClickListener(this);
        getView().findViewById(R.id.list).setOnClickListener(this);
        getView().findViewById(R.id.message).setOnClickListener(this);
        getView().findViewById(R.id.drawer).setOnClickListener(this);
        getView().findViewById(R.id.tabbed).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register:
                startActivity(new Intent(getActivity(), RegisterActivity.class).putExtra("name", "ram"));
                break;
            case R.id.list:
                startActivity(new Intent(getActivity(), ListActivity.class));
                break;
            case R.id.message:
                startActivity(new Intent(getActivity(), MessageActivity.class));
                break;
            case R.id.drawer:
                startActivity(new Intent(getActivity(), DrawerActivity.class));
                break;
            case R.id.tabbed:
                startActivity(new Intent(getActivity(), TabbedActivity.class));
                break;

        }
    }
}
