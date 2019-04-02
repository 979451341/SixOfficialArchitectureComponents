package com.example.lilingzhi.llvr.workmanager;


import android.support.annotation.NonNull;
import android.util.Log;

import androidx.work.Worker;

public class TestWorker extends Worker {
    @NonNull
    @Override
    public WorkerResult doWork() {
        Log.v("workmanager","任务开始执行");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.v("workmanager","任务执行完");

        //不能返回为空，会崩溃的
        return WorkerResult.SUCCESS;
    }
}
