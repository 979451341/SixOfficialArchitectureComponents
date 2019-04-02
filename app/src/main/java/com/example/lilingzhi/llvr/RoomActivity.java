package com.example.lilingzhi.llvr;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lilingzhi.llvr.bean.TestBean;
import com.example.lilingzhi.llvr.db.TestDao;
import com.example.lilingzhi.llvr.db.TestDataBase;

import java.util.List;

public class RoomActivity extends AppCompatActivity {

    Button btn_insert,btn_update,btn_delete,btn_get;
    TextView tv;
    TestDataBase dataBase;
    TestDao testDao;

    MutableLiveData<List<TestBean>>  data=new MutableLiveData<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        btn_insert=(Button)findViewById(R.id.btn_insert);
        btn_update=(Button)findViewById(R.id.btn_update);
        btn_delete=(Button)findViewById(R.id.btn_delete);
        btn_get=(Button)findViewById(R.id.btn_get);
        tv=(TextView)findViewById(R.id.tv);

        getSupportActionBar().setTitle("Room");


        dataBase=Room.databaseBuilder(getApplicationContext(), TestDataBase.class,"test")
                .addCallback(new RoomDatabase.Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                    }

                    @Override
                    public void onOpen(@NonNull SupportSQLiteDatabase db) {
                        super.onOpen(db);
                    }
                })
                .allowMainThreadQueries()//允许在主线程查询数据
                .addMigrations()//迁移数据库使用
                .fallbackToDestructiveMigration()//迁移数据库如果发生错误，将会重新创建数据库，而不是发生崩溃
                .build();
        testDao=dataBase.testDao();

        data.observe(this, new Observer<List<TestBean>>() {
            @Override
            public void onChanged(@Nullable List<TestBean> testBeans) {
                if(testBeans==null||testBeans.size()==0){
                    return;
                }
                String str="";
                for(TestBean testBean:testBeans){
                    str=str+testBean.getId()+" "+testBean.getName()+"\n";
                }
                tv.setText(str);
            }
        });

        getAll();



        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sum;
                List<TestBean> datas= testDao.getAll();
                if(datas==null||datas.size()==0){
                    sum=0;
                }else{
                    sum=datas.size();
                }

                TestBean testBean=new TestBean();
                testBean.setId(sum+1);
                testDao.insert(testBean);
                getAll();

            }
        });

        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getAll();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<TestBean> datas= testDao.getAll();
                if(datas==null||datas.size()==0){
                    return;
                }
                TestBean testBean= datas.get(datas.size()-1);
                testDao.delete(testBean);
                getAll();
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<TestBean> datas= testDao.getAll();
                if(datas==null||datas.size()==0){
                    return;
                }
                TestBean testBean= datas.get(datas.size()-1);
                testBean.setName("zzw");
                testDao.update(testBean);

                getAll();
            }
        });


    }

    public void getAll(){

        data.setValue(testDao.getAll());
    }

}
