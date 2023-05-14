package com.example.chat_library;


import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.google.android.material.textfield.TextInputEditText;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;


public class Activity_chat extends AppCompatActivity {

    private CircleImageView sendButton_IMG_send;
    private TextInputEditText speaking_TIETL_msg;
    private AppCompatActivity activity;

    private RecyclerView chatFragment_RCYC_LST;
    private ArrayList<Message> messagesArrayList;
    private Adapter_chat adapter_chat;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

    Date date;

    public Activity_chat() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        messagesArrayList = new ArrayList<>();
        findViews();
        initAdapter();

        sendButton_IMG_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public synchronized void onClick(View view) {
                if (speaking_TIETL_msg.getText().toString() == null || speaking_TIETL_msg.getText().toString().isEmpty())
                    return;
                long currentTimeMillis = System.currentTimeMillis();
                Date date = new Date(currentTimeMillis);
                String dateTimeString = dateFormat.format(date);
                String sender = "yuval";
                Message msg = new Message(dateTimeString ,speaking_TIETL_msg.getText().toString(), sender);
                messagesArrayList.add(msg);
                speaking_TIETL_msg.setText("");
                initAdapter();
                adapter_chat.notifyDataSetChanged();
            }
        });

    }


    private void findViews() {
        chatFragment_RCYC_LST = findViewById(R.id.chatFragment_RCYC_LST);
        sendButton_IMG_send = findViewById(R.id.sendButton_IMG_send);
        speaking_TIETL_msg = findViewById(R.id.speaking_TIETL_msg);

    }
    private void initAdapter(){
        adapter_chat = new Adapter_chat(activity, messagesArrayList);
        chatFragment_RCYC_LST.setLayoutManager(new LinearLayoutManager(activity));
        chatFragment_RCYC_LST.setHasFixedSize(true);
        chatFragment_RCYC_LST.setItemAnimator(new DefaultItemAnimator());
        chatFragment_RCYC_LST.setAdapter(adapter_chat);
    }


}