package com.example.recyclerviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> nameList=new ArrayList<String>(Arrays.asList("Abdullah","Tusar","Noman","Avijit","Robi","Redoy"));
    ArrayList<String> locationList=new ArrayList<String>(Arrays.asList("Dhaka","Dhaka","Dhaka","Dhaka","Dhaka","Dhaka"));
    ArrayList<String> phoneList=new ArrayList<String>(Arrays.asList("01994215664","01994215664","01994215664","01994215664","01994215664","01994215664"));

    ArrayList<Integer> personImageList=new ArrayList<Integer>(Arrays.asList(R.drawable.person,R.drawable.person,R.drawable.person,
            R.drawable.person,R.drawable.person,R.drawable.person));
    ArrayList<Integer> callImageList=new ArrayList<Integer>(Arrays.asList(R.drawable.phone,R.drawable.phone,R.drawable.phone,
            R.drawable.phone,R.drawable.phone,R.drawable.phone));
    ArrayList<Integer> messageImageList=new ArrayList<Integer>(Arrays.asList(R.drawable.message,R.drawable.message,R.drawable.message,
            R.drawable.message,R.drawable.message,R.drawable.message));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerViewId);
        MyAdapter myAdapter=new MyAdapter(getApplicationContext(), nameList,locationList,phoneList,personImageList,callImageList,messageImageList);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myAdapter);
    }
}
