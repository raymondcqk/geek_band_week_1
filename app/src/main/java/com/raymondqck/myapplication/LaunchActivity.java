package com.raymondqck.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.raymondqck.myapplication.model.UserInfo;

/**
 * Created by 陈其康 raymondchan on 2016/7/13 0013.
 */
public class LaunchActivity extends Activity {

    private static final int REQUEST_CODE = 3030;

    public static String TAG_TITLE = "TITLE";
    public static String TAG_LIFE = "LIFE";
    private int life_sequence = 0;

    private Button mBtn_clik_enter_a;
    private Button mBtn_clik_enter_b;
    private Button mBtn_clik_enter_c;
    private Button mBtn_clik_enter_d;

    private Button mBtn_clik_enter_object;

    private TextView mTv_title;
    private TextView mTv_result;

    private ImageView mImageView;
    private int[] imgs = {R.drawable.back,R.drawable.head,R.drawable.pen};
    private int img_count = 0;

    private Handler mHandler = new Handler();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG_LIFE,"==== onCreate() 次序："+(++life_sequence));
        setContentView(R.layout.activity_launch);

        viewInit();
        Intent i = getIntent();
        mTv_title.setText(i.getStringExtra(SplashActivity.SPLASH_TAG));



    }

    private void viewInit() {
        mTv_title = (TextView) findViewById(R.id.tv_launch_title);
        mTv_result = (TextView) findViewById(R.id.tv_result);

        mBtn_clik_enter_a = (Button) findViewById(R.id.btn_enter_A);
        mBtn_clik_enter_b = (Button) findViewById(R.id.btn_enter_B);
        mBtn_clik_enter_c = (Button) findViewById(R.id.btn_enter_C);
        mBtn_clik_enter_d = (Button) findViewById(R.id.btn_enter_D);

        mBtn_clik_enter_object = (Button) findViewById(R.id.btn_enter_object);

        mBtn_clik_enter_a.setOnClickListener(mOnClickListener);
        mBtn_clik_enter_b.setOnClickListener(mOnClickListener);
        mBtn_clik_enter_c.setOnClickListener(mOnClickListener);
        mBtn_clik_enter_d.setOnClickListener(mOnClickListener);

        mBtn_clik_enter_object.setOnClickListener(mOnClickListener);

        mImageView = (ImageView) findViewById(R.id.img_bubble_origin);
        imgChange();
    }

    private void imgChange() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mImageView.setImageResource(imgs[img_count % imgs.length]);
                img_count++;
                imgChange();
            }
        }, 2000);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Bundle data = new Bundle();
            switch (view.getId()){
                case R.id.btn_enter_A:

                    Intent ia = new Intent(LaunchActivity.this,MainActivity.class);
                    data.putString(TAG_TITLE,"界面A");
                    ia.putExtra(TAG_TITLE,data);
                    startActivity(ia);
                    Toast.makeText(LaunchActivity.this,"View ID: "+"R.id.btn_enter_A",Toast.LENGTH_SHORT).show();

                    break;
                case R.id.btn_enter_B:
                    Intent ib = new Intent(LaunchActivity.this,ViewComponentActivity.class);
                    data.putString(TAG_TITLE,"ViewsTest");
                    ib.putExtra(TAG_TITLE,data);
                    startActivity(ib);
                    Toast.makeText(LaunchActivity.this,"View ID: "+"R.id.btn_enter_B",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_enter_C:
                    Intent ic = new Intent(LaunchActivity.this,MainActivity.class);
                    data.putString(TAG_TITLE,"界面C");
                    ic.putExtra(TAG_TITLE,data);
                    startActivity(ic);
                    Toast.makeText(LaunchActivity.this,"View ID: "+"R.id.btn_enter_C",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_enter_D:
                    Intent id = new Intent(LaunchActivity.this,MainActivity.class);
                    data.putString(TAG_TITLE,"请求目标界面，结果由此生成并返回");
                    id.putExtra(TAG_TITLE,data);
                    startActivityForResult(id,REQUEST_CODE);
//                    Toast.makeText(LaunchActivity.this,"View ID: "+"R.id.btn_enter_D",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_enter_object:
                    Intent intent = new Intent(LaunchActivity.this,MainActivity.class);
                    UserInfo uChan = new UserInfo("陈其康",23);
                    intent.putExtra(TAG_TITLE,uChan);
                    startActivity(intent);
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("MainActivity","onActivityResult()");
        //判断是否为所需的数据请求返回交互
        if (requestCode == REQUEST_CODE && resultCode == MainActivity.RESULT_CODE){
            Log.i("MainActivity","请求回复确认！");

            String string = data.getStringExtra(TAG_TITLE);
            mTv_result.setVisibility(View.VISIBLE);
            mTv_result.setText(string);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG_LIFE,"==== onStart() 次序："+(++life_sequence));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG_LIFE,"==== onResume() 次序："+(++life_sequence));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG_LIFE,"==== onPause() 次序："+(++life_sequence));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG_LIFE,"==== onStop() 次序："+(++life_sequence));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG_LIFE,"==== onDestroy() 次序："+(++life_sequence));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG_LIFE,"==== onRestart() 次序："+(++life_sequence));
    }
}

