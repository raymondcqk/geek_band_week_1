package com.raymondqck.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.raymondqck.myapplication.model.UserInfo;

public class MainActivity extends AppCompatActivity {

    private int life_sequence = 0;

    public static final int RESULT_CODE = 1231;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(LaunchActivity.TAG_LIFE,"==== onCreate() 次序："+(++life_sequence));
        setContentView(R.layout.activity_main);
        InitView();
        getIntentExtra();

        Intent intent = new Intent();
        intent.putExtra(LaunchActivity.TAG_TITLE,"从目标Activity返回数据来了！");
        setResult(RESULT_CODE,intent);

        EditText editText = new EditText(this);



    }

    private void getIntentExtra() {
        String title = "未接受到数据";
        Intent i = getIntent();
        if (i != null) {
            Bundle data = i.getBundleExtra(LaunchActivity.TAG_TITLE);
            if (data != null) {
                title = data.getString(LaunchActivity.TAG_TITLE);
            }
            UserInfo userInfo = (UserInfo) i.getSerializableExtra(LaunchActivity.TAG_TITLE);

            if (userInfo != null) {
                title = "姓名："+userInfo.getName()+" 年龄："+userInfo.getAge();
            }

            tv.setText(title);
            setTitle(title);


        }
    }

    private void InitView() {
        tv = (TextView) findViewById(R.id.main_text);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LaunchActivity.TAG_LIFE,"==== onStart() 次序："+(++life_sequence));
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LaunchActivity.TAG_LIFE,"==== onResume() 次序："+(++life_sequence));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(LaunchActivity.TAG_LIFE,"==== onPause() 次序："+(++life_sequence));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LaunchActivity.TAG_LIFE,"==== onStop() 次序："+(++life_sequence));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LaunchActivity.TAG_LIFE,"==== onDestroy() 次序："+(++life_sequence));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(LaunchActivity.TAG_LIFE,"==== onRestart() 次序："+(++life_sequence));
    }
}
