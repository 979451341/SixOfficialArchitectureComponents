package com.example.lilingzhi.llvr.bean;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {


    private MutableLiveData<Integer> num;

    public MutableLiveData<Integer> getNum() {
        if(num==null){
            num=new MutableLiveData<>();
            num.setValue(0);
        }
        return num;
    }

    public void setNum(int num) {
        this.num.setValue(num);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        this.num=null;
    }
}