package com.raymondqck.myapplication.model;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.raymondqck.myapplication.R;
import com.raymondqck.myapplication.adapters.AboutWeiXinListAdapter;

/**
 * Created by 陈其康 raymondchan on 2016/7/22 0022.
 * 关于 微信 页面
 */
public class WeiXinListActivity extends AppCompatActivity {

    ListView mListViewlv;
    String[] mMenus;

    SeekBar mSeekBar;
    ProgressBar mProgressBar;
    TextView mTextView;

    RelativeLayout mLayout;

    AboutWeiXinListAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weixin_about);
        setTitle("关于微信");
        iniView();

        mTextView = (TextView) findViewById(R.id.tv_weixin);
        mLayout = (RelativeLayout) findViewById(R.id.layout_weixin);
        mSeekBar = (SeekBar) findViewById(R.id.seekbar);
        mSeekBar.setMax(400);
        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);
        mProgressBar.setMax(4095);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mLayout.setBackgroundColor(i*10);
//                Toast.makeText(WeiXinListActivity.this,i*10+"",Toast.LENGTH_SHORT).show();
                mTextView.setText(i*10+"");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                mTextView.setText("onStartTrackingTouch()");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                mTextView.setText("onStopTrackingTouch()");
                mProgressBar.setProgress(mSeekBar.getProgress());
            }
        });

    }

    private void dataSet() {
        mMenus = new String[]{"去评分", "功能介绍", "系统通知", "帮助与反馈", "检查新版本"};
    }

    private void iniView() {
        dataSet();

        mListViewlv = (ListView) findViewById(R.id.lv_weixin_about);

        mAdapter = new AboutWeiXinListAdapter(WeiXinListActivity.this, mMenus);

        mListViewlv.setAdapter(mAdapter);
    }
}
