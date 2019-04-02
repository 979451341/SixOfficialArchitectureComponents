package com.example.lilingzhi.llvr.db;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.lilingzhi.llvr.bean.TestBean;

import java.util.List;

@Dao
public interface TestDao {

    @Query("SELECT * FROM test")
    List<TestBean> getAll();

    @Query("SELECT * FROM test WHERE id = (:id)")
    TestBean getById(int id);

    @Insert
    void insert(TestBean testBean);

    @Delete
    void delete(TestBean testBean);

    @Update
    void update(TestBean testBean);




}
