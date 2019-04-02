package com.example.lilingzhi.llvr.fragment;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lilingzhi.llvr.LifecycleActivity;
import com.example.lilingzhi.llvr.R;

public class LifecycleFragment extends Fragment {

    TextView tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_lifecycle,container,false);
        tv=view.findViewById(R.id.tv);

        getLifecycle().addObserver(new IPresenter());

        return view;
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
