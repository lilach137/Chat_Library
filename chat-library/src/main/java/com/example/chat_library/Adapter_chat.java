package com.example.chat_library;


import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class Adapter_chat extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Activity activity;
    private ArrayList<Message> messages;


    public Adapter_chat(Activity activity, ArrayList<Message> messages) {
        this.activity = activity;
        this.messages = messages;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_chat, parent, false);
        MessageHolder holder = new MessageHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        final MessageHolder holder = (MessageHolder) viewHolder;
        Message message = getResult(position);


        holder.listMessage_LBL_msg.setText(message.getContent());
        holder.listMessage_LBL_date.setText(String.valueOf(message.getDateTime()));
        if (message.getSender().equals("Lilach")) {
            holder.listMessage_card.setCardBackgroundColor(Color.GRAY);
            holder.listMessage.setGravity(Gravity.START);
        } else {
            holder.listMessage_card.setCardBackgroundColor(Color.WHITE);
            holder.listMessage.setGravity(Gravity.END);
        }

    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public Message getResult(int position){
        return messages.get(position);
    }

    static class MessageHolder extends RecyclerView.ViewHolder {

        private MaterialTextView listMessage_LBL_msg;
        private MaterialTextView listMessage_LBL_date;
        private LinearLayout listMessage;
        private CardView listMessage_card;

        public MessageHolder(@NonNull View itemView) {
            super(itemView);
            listMessage_LBL_date =itemView.findViewById(R.id.listMessage_LBL_date);
            listMessage_LBL_msg = itemView.findViewById(R.id.listMessage_LBL_msg);
            listMessage_card = itemView.findViewById(R.id.listMessage_card);
            listMessage = itemView.findViewById(R.id.listMessage);

        }
    }
}