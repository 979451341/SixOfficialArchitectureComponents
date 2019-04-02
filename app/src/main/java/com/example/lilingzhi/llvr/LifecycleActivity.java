package com.example.lilingzhi.llvr;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class LifecycleActivity extends AppCompatActivity {

    /*


    Lifecycle.State 是一个枚举类，用于描述当前 生命周期拥有者 的状态，与onStop之类的有点不一样，更加宽泛点 ，
    通过此函数获取getLifecycle().getCurrentState()，

    DESTROYED：onDestroy执行后    INITIALIZED ： onCreate执行前包括执行时   CREATED：onCreate与onStop之间
    STARTED：onStart与onPause之间  RESUMED：onResume

    还有一个特殊的比较方法，getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)，这个比较的当前值的等级是否等于或高于给的值，
    也就是说State枚举类里的值越往后面，值越大，如果当前是 RESUMED ，那上面这个判断是 true
    */

    public final  static String TAG="LifecycleActivity";

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_lifecycle);
        getSupportActionBar().setTitle("Lifecycle");

        getLifecycle().addObserver(new IPresenter());

        tv=(TextView)findViewById(R.id.tv);

    }


    class IPresenter implements LifecycleObserver {


        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        void onCreate( LifecycleOwner owner){
            tv.setText(tv.getText()+"onCreate\n");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        void onStart( LifecycleOwner owner){
            tv.setText(tv.getText()+"onStart\n");
        }


        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        void onResume( LifecycleOwner owner){
            tv.setText(tv.getText()+"onResume\n");
        }


        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        void onPause( LifecycleOwner owner){
            tv.setText(tv.getText()+"onPause\n");
        }


        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        void onStop( LifecycleOwner owner){
            tv.setText(tv.getText()+"onStop\n");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        void onDestroy( LifecycleOwner owner){
            tv.setText(tv.getText()+"onDestroy\n");
        }




    }

}
