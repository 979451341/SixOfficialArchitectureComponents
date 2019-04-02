package com.example.lilingzhi.llvr.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.lilingzhi.llvr.bean.TestBean;

@Database(entities = {TestBean.class},version = 1)
public abstract class TestDataBase extends RoomDatabase{

    public abstract TestDao testDao();


}
