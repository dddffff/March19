package com.iaovy;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity{
    private RecyclerView channelList;
    private ChannelListAdapter listAdapter;
    private List<com.iaovy.Channel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        channelList = findViewById(R.id.channelList);
        listAdapter = new ChannelListAdapter(this.data, new ChannelClickListener() {
            @Override
            public void onClick(View view, int position) {
                Log.i("FFPLAY", "Clicked "+view+" on "+position);
                if (position < data.size()) {
                    Channel c = data.get(position);
                    Intent intent = new Intent(MainActivity.this, LIve.class);
                    intent.putExtra("channel", c);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "无效的频道",Toast.LENGTH_SHORT);
                }
            }
        });
        channelList.setAdapter((RecyclerView.Adapter) listAdapter);
        channelList.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        DataLab lab = new DataLab(this);
        this.data = lab.getChannels("data.json");
    }

}
