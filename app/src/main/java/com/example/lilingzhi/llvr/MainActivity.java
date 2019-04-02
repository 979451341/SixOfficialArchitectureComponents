package com.example.lilingzhi.llvr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button btn_lifecycle,btn_livedata,btn_viewmodel,btn_room,btn_paging,btn_navigation,btn_workmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_lifecycle=(Button)findViewById(R.id.btn_lifecycle);
        btn_lifecycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LifecycleActivity.class);
                startActivity(intent);
            }
        });

        btn_livedata=(Button)findViewById(R.id.btn_livedata);
        btn_livedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LiveDataActivity.class);
                startActivity(intent);
            }
        });

        btn_viewmodel=(Button)findViewById(R.id.btn_viewmodel);
        btn_viewmodel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ViewModelActivity.class);
                startActivity(intent);
            }
        });

        btn_room=(Button)findViewById(R.id.btn_room);
        btn_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RoomActivity.class);
                startActivity(intent);
            }
        });

        btn_paging=(Button)findViewById(R.id.btn_paging);
        btn_paging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,PagingActivity.class);
                startActivity(intent);
            }
        });

        btn_navigation=(Button)findViewById(R.id.btn_navigation);
        btn_navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NavigationActivity.class);
                startActivity(intent);
            }
        });
        btn_workmanager=(Button)findViewById(R.id.btn_workmanager);
        btn_workmanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //因为这个WorkManager bug太多就不弄了，其中就有些bug，你重启应用，还是报那个bug
                //问题是，我刚启动啊，没执行那些代码啊，这个bug太可怕了，不建议大家用这个API，再等等吧
/*                Intent intent=new Intent(MainActivity.this,WorkManagerActivity.class);
                startActivity(intent);*/
            }
        });



    }
}
