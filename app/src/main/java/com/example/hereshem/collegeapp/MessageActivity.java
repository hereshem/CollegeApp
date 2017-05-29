package com.example.hereshem.collegeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends AppCompatActivity {

    List<MessageModel> messages = new ArrayList<>();

    String json = "  [{\n" +
            "    \"id\": 510678,\n" +
            "    \"from\": \"Me\",\n" +
            "    \"image_from\":\"http://square.github.io/picasso/static/sample.png\",\n" +
            "    \"to\" :\"User2\",\n" +
            "    \"text\":\"hello there\",\n" +
            "    \"timestamp\":\"5 mins ago\"\n" +
            "  },  {\n" +
            "    \"id\": 510678,\n" +
            "    \"from\": \"Me\",\n" +
            "    \"image_from\":\"http://square.github.io/picasso/static/sample.png\",\n" +
            "    \"to\" :\"User2\",\n" +
            "    \"text\":\"hello there2\",\n" +
            "    \"timestamp\":\"25 mins ago\"\n" +
            "  },  {\n" +
            "    \"id\": 510678,\n" +
            "    \"from\": \"Me\",\n" +
            "    \"image_from\":\"http://square.github.io/picasso/static/sample.png\",\n" +
            "    \"to\" :\"User23\",\n" +
            "    \"text\":\"hello there3\",\n" +
            "    \"timestamp\":\"35 mins ago\"\n" +
            "  },  {\n" +
            "    \"id\": 510678,\n" +
            "    \"from\": \"Me\",\n" +
            "    \"image_from\":\"http://square.github.io/picasso/static/sample.png\",\n" +
            "    \"to\" :\"User24\",\n" +
            "    \"text\":\"hello there4\",\n" +
            "    \"timestamp\":\"45 mins ago\"\n" +
            "  }]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        messages = MessageModel.parseJSON(json);

        MessageAdapter adapter = new MessageAdapter(this, messages);

        // make vertical listview
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // add divider layout
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        // make fixed size (increases performance)
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapter);

    }
}
