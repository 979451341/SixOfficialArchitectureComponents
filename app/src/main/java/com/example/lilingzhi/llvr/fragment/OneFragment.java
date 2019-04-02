package com.example.lilingzhi.llvr.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lilingzhi.llvr.bean.MyViewModel;
import com.example.lilingzhi.llvr.R;


public class OneFragment extends Fragment {

    MyViewModel viewModel;
    Button btn_add;

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =inflater.inflate(R.layout.fragment_one, container, false);

        viewModel= ViewModelProviders.of(getActivity()).get(MyViewModel.class);
        btn_add=(Button)view.findViewById(R.id.btn_add);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setNum(viewModel.getNum().getValue()+1);
            }
        });

        return view;
    }




}
