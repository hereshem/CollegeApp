package com.example.hereshem.collegeapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by hereshem on 5/28/17.
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageHolder> {

    Context context;
    List<MessageModel> messages;

    public MessageAdapter(Context context, List<MessageModel> messages) {
        this.context = context;
        this.messages = messages;
    }

    @Override
    public MessageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_message, parent, false);
        MessageHolder messageHolder = new MessageHolder(view);
        return messageHolder;
    }

    @Override
    public void onBindViewHolder(MessageHolder holder, int position) {
        MessageModel message = messages.get(position);
        holder.name.setText(message.getFrom());
        holder.text.setText(message.getText());
        holder.time.setText(message.getTimestamp());
        // set image
        Picasso.with(context).load(message.getImage_from()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }


    class MessageHolder extends RecyclerView.ViewHolder{

        TextView text, name, time;
        ImageView image;

        public MessageHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
            name = (TextView) itemView.findViewById(R.id.name);
            time = (TextView) itemView.findViewById(R.id.time);
            image = (ImageView) itemView.findViewById(R.id.image);

        }
    }




}
