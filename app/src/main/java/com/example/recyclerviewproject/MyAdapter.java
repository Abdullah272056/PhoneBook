package com.example.recyclerviewproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
   ArrayList <String>nameList,locationList,phoneNumberList;
    ArrayList <Integer> personImageList,callImageList,messageImageList;
    Intent intent;

    public MyAdapter(Context context, ArrayList<String> nameList, ArrayList<String> locationList, ArrayList<String> phoneNumberList, ArrayList<Integer> personImageList, ArrayList<Integer> callImageList, ArrayList<Integer> messageImageList) {
        this.context = context;
        this.nameList = nameList;
        this.locationList = locationList;
        this.phoneNumberList = phoneNumberList;
        this.personImageList = personImageList;
        this.callImageList = callImageList;
        this.messageImageList = messageImageList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);
      View view= layoutInflater.inflate(R.layout.sample_item,parent,false);
      MyViewHolder viewHolder =new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        //text View Value set
        holder.name.setText(nameList.get(position));
        holder.location.setText(locationList.get(position));
        holder.phoneNumber.setText(phoneNumberList.get(position));

        //image View Value set
        holder.personimage.setImageResource(personImageList.get(position));
        holder.callImage.setImageResource(callImageList.get(position));
        holder.messageImage.setImageResource(messageImageList.get(position));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked Item", Toast.LENGTH_SHORT).show();
            }
        });




        holder.callImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber=phoneNumberList.get(position);

                String s="tel:"+phoneNumber;
                 intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(s));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);


                Toast.makeText(context, phoneNumber, Toast.LENGTH_SHORT).show();
            }
        });
        holder.messageImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_VIEW);
                String number = phoneNumberList.get(position);
                intent.setData(Uri.parse("sms:"+number));
                String message="It's my sms";
                intent.putExtra("sms_body",message);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });




    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }
}
