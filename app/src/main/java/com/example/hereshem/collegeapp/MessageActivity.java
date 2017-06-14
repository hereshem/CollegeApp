package com.example.hereshem.collegeapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MessageActivity extends AppCompatActivity {

    List<MessageModel> messages = new ArrayList<>();

    ProgressDialog dialog;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        //messages = MessageModel.parseJSON(json);

        MessageAdapter adapter = new MessageAdapter(this, messages);

        // make vertical listview
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // add divider layout
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        // make fixed size (increases performance)
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapter);

        if(ServerRequest.isNetworkConnected(this)) {
            fetchAndShowData();
        }
    }

    private void fetchAndShowData() {
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... params) {
                // fetch
                HashMap<String,String> map = new HashMap();
                map.put("action","get_news");
                String response = ServerRequest.httpPostData("http://api.mantraideas.com",map);

                // parsing
                messages = MessageModel.parseJSON(response);
                return null;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                dialog = new ProgressDialog(MessageActivity.this);
                dialog.show();
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                dialog.dismiss();
                recyclerView.setAdapter(new MessageAdapter(MessageActivity.this, messages));
            }
        }.execute();
    }


}
