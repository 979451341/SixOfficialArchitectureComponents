package com.example.lilingzhi.llvr;

import android.arch.lifecycle.Observer;
import android.provider.SyncStateContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lilingzhi.llvr.workmanager.TestWorker;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import androidx.work.Constraints;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkStatus;

public class WorkManagerActivity extends AppCompatActivity {


    Button btn_one,btn_constraint,btn_cancel,btn_period;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_manager);

        btn_one=(Button)findViewById(R.id.btn_one);
        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //只执行一次,如果worker返回 FAILURE，将会再执行几次，这个几次不固定，
                //其他情况只执行一次，worker不能返回空
                OneTimeWorkRequest oneTimeWorkRequest=new OneTimeWorkRequest.Builder(TestWorker.class).build();
                WorkManager.getInstance().enqueue(oneTimeWorkRequest);

                //监听任务执行情况
                WorkManager.getInstance().getStatusById(oneTimeWorkRequest.getId())
                        .observe(WorkManagerActivity.this, new Observer<WorkStatus>() {
                            @Override
                            public void onChanged(@Nullable WorkStatus workStatus) {
                                if(workStatus!=null&&workStatus.getState().isFinished()){

                                }
                            }
                        });
            }
        });

        btn_constraint=(Button)findViewById(R.id.btn_constraint);

        btn_constraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Constraints constraints=new Constraints.Builder()
                        .setRequiresCharging(true)//在充电的情况，才执行，如果不是则等待，到开始充电时，再执行（其实就是用了JobService）
                        .build();

                OneTimeWorkRequest oneTimeWorkRequest=new OneTimeWorkRequest
                        .Builder(TestWorker.class)
                        .setConstraints(constraints)
                        .build();
                WorkManager.getInstance().enqueue(oneTimeWorkRequest);
            }
        });

        btn_cancel=(Button)findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OneTimeWorkRequest oneTimeWorkRequest=new OneTimeWorkRequest.Builder(TestWorker.class).build();
                WorkManager.getInstance().enqueue(oneTimeWorkRequest);

                UUID uuid=oneTimeWorkRequest.getId();
                //这个取消只能取消未开始执行的任务，如果已经开始执行或者执行完成，就无能为力
                WorkManager.getInstance().cancelWorkById(uuid);
            }
        });


        btn_period=(Button)findViewById(R.id.btn_period);

        btn_period.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //这个有问题的，这个时间间隔不能小于 15 分钟，想要循环执行可以 通过 在执行完 一次性任务，回调时
                //再执行任务
     /*           PeriodicWorkRequest periodicWorkRequest=new PeriodicWorkRequest.Builder(TestWorker.class,2,TimeUnit.SECONDS).build();
                WorkManager.getInstance().enqueue(periodicWorkRequest);*/
            }
        });

    }
}
