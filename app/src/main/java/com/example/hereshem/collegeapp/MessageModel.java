package com.example.hereshem.collegeapp;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hereshem on 5/28/17.
 */
public class MessageModel {
    int id;



    public MessageModel(String from, String image_from, String to, String text) {
        this.from = from;
        this.image_from = image_from;
        this.to = to;
        this.text = text;
    }

    public MessageModel(JSONObject jsonObject) {
        this.setId(jsonObject.optInt("id"));
        this.setTo(jsonObject.optString("to", "Guest"));
        this.setFrom(jsonObject.optString("title", "Guest"));
        this.setImage_from(jsonObject.optString("image", ""));
        this.setText(jsonObject.optString("description"));
        this.setTimestamp(jsonObject.optString("pubDate", "4 mins ago"));

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String from, image_from, to, text, timestamp;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getImage_from() {
        return image_from;
    }

    public void setImage_from(String image_from) {
        this.image_from = image_from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public static List<MessageModel> parseJSON(String json) {
        List<MessageModel> list = new ArrayList<>();

        try{
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                MessageModel m = new MessageModel(jsonObject);
                list.add(m);
            }
        }
        catch (Exception e){e.printStackTrace();}

        return list;
    }



}
