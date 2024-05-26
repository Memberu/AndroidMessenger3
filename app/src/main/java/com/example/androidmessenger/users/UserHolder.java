package com.example.androidmessenger.users;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidmessenger.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserHolder extends RecyclerView.ViewHolder {

    CircleImageView profileImage_iv;
    TextView username_tv;

    public UserHolder(@NonNull View itemView) {
        super(itemView);

        profileImage_iv = itemView.findViewById(R.id.profile_iv);
        username_tv = itemView.findViewById(R.id.username_tv);
    }
}
