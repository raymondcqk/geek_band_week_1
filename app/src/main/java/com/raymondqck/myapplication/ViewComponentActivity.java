package com.raymondqck.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 陈其康 raymondchan on 2016/7/14 0014.
 */
public class ViewComponentActivity extends Activity {

    private EditText mEditText;
    private TextView mTextView;
    private TextView mTvImg;
    private ImageView mImageView;

    private int[] imgs = {R.drawable.back,R.drawable.head,R.drawable.pen};
    private int img_count = 0;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);

        mTextView = (TextView) findViewById(R.id.tv_viewTest);
        mTvImg = (TextView) findViewById(R.id.text_bubble_9);
        mImageView = (ImageView) findViewById(R.id.img_bubble_origin);
        imgChange();
        mEditText = (EditText) findViewById(R.id.edt_test);
        //        mEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
        //            @Override
        //            public void onFocusChange(View view, boolean b) {
        //                if (b){
        //                    mTextView.setText("ID为："+view.getId()+" 的EditText被选中！");
        //                }else {
        //                    mTextView.setText("ID为："+view.getId()+" 的EditText未被选中！");
        //                }
        //            }
        //        });
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                /**
                 * 该函数可以实时捕获用户输入,读取输入字数，用于限制用户输入字数
                 */
                mTextView.setText(editable.toString());
                mTvImg.setText(editable.toString());
                if (editable.toString().length() > 15) {
                    Toast.makeText(ViewComponentActivity.this, "输入已经超出15个字限制", Toast.LENGTH_SHORT).show();
                    mTextView.setTextColor(getResources().getColor(R.color.red));
                    mTvImg.setTextColor(getResources().getColor(R.color.red));
                    mEditText.setTextColor(getResources().getColor(R.color.red));
                } else {
                    mTextView.setTextColor(getResources().getColor(R.color.black));
                    mEditText.setTextColor(getResources().getColor(R.color.black));
                    mTvImg.setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

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
}
