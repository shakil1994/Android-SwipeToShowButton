package com.example.shakil.androidswipetoshowbutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.shakil.androidswipetoshowbutton.Adapter.MyAdapter;
import com.example.shakil.androidswipetoshowbutton.Helper.MyButtonClickListener;
import com.example.shakil.androidswipetoshowbutton.Helper.MySwipeHelper;
import com.example.shakil.androidswipetoshowbutton.Model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter adapter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init
        recyclerView = findViewById(R.id.recycler_test);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MySwipeHelper swipeHelper = new MySwipeHelper(this, recyclerView, 200) {
            @Override
            public void instantiateMyButton(RecyclerView.ViewHolder viewHolder, List<MySwipeHelper.MyButton> buffer) {
                buffer.add(new MyButton(MainActivity.this,
                        "Delete",
                        30,
                        0,
                        Color.parseColor("#FF3C30"),
                        new MyButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                Toast.makeText(MainActivity.this, "Delete Click", Toast.LENGTH_SHORT).show();
                            }
                        }));

                buffer.add(new MyButton(MainActivity.this,
                        "Update",
                        30,
                        R.drawable.ic_edit_white_24dp,
                        Color.parseColor("#FF9502"),
                        new MyButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                Toast.makeText(MainActivity.this, "Delete Click", Toast.LENGTH_SHORT).show();
                            }
                        }));
            }
        };

        generateItem();
    }

    private void generateItem() {
        List<Item> itemList = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            itemList.add(new Item("Natural Beauty 0" + (++i),
                    "100.00$",
                    "https://images.unsplash.com/photo-1500622944204-b135684e99fd?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1001&q=80"));
        }

        adapter = new MyAdapter(this, itemList);
        recyclerView.setAdapter(adapter);
    }
}
