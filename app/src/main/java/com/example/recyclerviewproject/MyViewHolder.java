package com.example.recyclerviewproject;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView name,location,phoneNumber;
    ImageView personimage,callImage,messageImage;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        //text view finding
        name=itemView.findViewById(R.id.nameTextViewId);
        location=itemView.findViewById(R.id.locationTextViewId);
        phoneNumber=itemView.findViewById(R.id.phoneNumberTextViewId);
        //image view finding
        personimage=itemView.findViewById(R.id.personImageViewId);
        callImage=itemView.findViewById(R.id.callImageViewId);
        messageImage=itemView.findViewById(R.id.messageImageViewId);

    }
}
