package com.example.lilingzhi.llvr.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lilingzhi.llvr.bean.MyViewModel;
import com.example.lilingzhi.llvr.R;


public class TwoFragment extends Fragment {

    MyViewModel viewModel;
    TextView tv;

    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =inflater.inflate(R.layout.fragment_two, container, false);

        viewModel= ViewModelProviders.of(getActivity()).get(MyViewModel.class);
        tv=(TextView)view.findViewById(R.id.tv);
        viewModel.getNum().observe(this,new MyObserver());

        return view;
    }

    class MyObserver implements Observer<Integer> {

        @Override
        public void onChanged(@Nullable Integer integer) {
            tv.setText(""+integer);
        }
    }


}
