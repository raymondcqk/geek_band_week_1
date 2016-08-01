package com.raymondqck.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by 陈其康 raymondchan on 2016/7/13 0013.
 *
 * 延时跳过的启动画面
 */
public class SplashActivity extends Activity {

    public static String SPLASH_TAG = "SPLASH_TAG";
    //注意，是android.os的handler ---- 延时执行任务
    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //延时执行一个线程
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //延时执行的任务
                Intent intent = new Intent(SplashActivity.this, LaunchActivity.class);

                //Activity间传数据
                String value = "Hello\nRaymondCQK";
                intent.putExtra(SPLASH_TAG, value);
                startActivity(intent);
                finish();
            }
        }, 1500);//delay 2000ms
    }
}
