package com.example.lilingzhi.llvr;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LiveDataActivity extends AppCompatActivity {

    Button btn_add;
    TextView tv,tv_mediator;

    MutableLiveData<Integer> num=new MutableLiveData<>();
    MyObserver observer;

    MediatorLiveData<Integer> mediatorLiveData=new MediatorLiveData<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);

        btn_add=(Button)findViewById(R.id.btn_add);
        tv=(TextView)findViewById(R.id.tv);
        tv_mediator=(TextView)findViewById(R.id.tv_mediator);
        getSupportActionBar().setTitle("LiveData");

        num.setValue(0);
        //子线程
        //num.postValue(0);
        observer=new MyObserver();
        num.observe(this,observer);

        MediatorObserver mediatorObserver=new MediatorObserver();
        mediatorLiveData.observe(this,mediatorObserver);


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num.setValue(num.getValue()+1);
            }
        });




        mediatorLiveData.addSource(num,mediatorLiveData::setValue);




    }


    class DataBean extends MutableLiveData<Integer> {
    }

    class MyObserver implements Observer<Integer> {

        @Override
        public void onChanged(@Nullable Integer integer) {
            tv.setText(""+integer);
        }
    }
    class MediatorObserver implements Observer<Integer> {

        @Override
        public void onChanged(@Nullable Integer integer) {
            tv_mediator.setText(""+integer);
        }
    }
}
