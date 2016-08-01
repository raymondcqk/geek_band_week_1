package com.raymondqck.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.raymondqck.myapplication.adapters.MyAdapter;
import com.raymondqck.myapplication.model.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈其康 raymondchan on 2016/7/19 0019.
 */
public class ListActivity extends Activity {

    private ListView mLv;
    //数据源
    private List<UserInfo> mUserInfoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        //初始化数据源
        mUserInfoList = new ArrayList<>();
        mUserInfoList.add(new UserInfo("陈其康",23));
        mUserInfoList.add(new UserInfo("ccc",23));
        mUserInfoList.add(new UserInfo("ddd",23));
        mUserInfoList.add(new UserInfo("dsdasd",23));
        mUserInfoList.add(new UserInfo("vvvvv",23));
        mUserInfoList.add(new UserInfo("qqqq",23));
        mUserInfoList.add(new UserInfo("eeee",23));
        mUserInfoList.add(new UserInfo("wwww",2333));
        mUserInfoList.add(new UserInfo("dsadasd",53));
        mUserInfoList.add(new UserInfo("dsdddd",343));
        mUserInfoList.add(new UserInfo("12212",13));
        mUserInfoList.add(new UserInfo("3231245",3));
        mUserInfoList.add(new UserInfo("4546546",22));
        mUserInfoList.add(new UserInfo("陈其康",23));
        mUserInfoList.add(new UserInfo("陈其康",23));
        mUserInfoList.add(new UserInfo("陈其康",23));
        mUserInfoList.add(new UserInfo("陈其康",23));
        mUserInfoList.add(new UserInfo("陈其康",23));
        mUserInfoList.add(new UserInfo("陈其康",23));
        mUserInfoList.add(new UserInfo("陈其康",23));
        mUserInfoList.add(new UserInfo("陈其康",23));
        //初始化Adapter
                final MyAdapter myAdapter = new MyAdapter(ListActivity.this,mUserInfoList);
        //获取listView对象引用
        mLv = (ListView) findViewById(R.id.lv_mylist);
        //给listview 装载 adapter
        mLv.setAdapter(myAdapter);

        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = mUserInfoList.get(i).getName();
                mUserInfoList.get(i).setName(mUserInfoList.get(i).getName()+" 被点击了！");
//                mLv.deferNotifyDataSetChanged();
//                myAdapter.refleshData(mUserInfoList);
                myAdapter.notifyDataSetChanged();
            }
        });
        mLv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                mUserInfoList.remove(i);
                myAdapter.notifyDataSetChanged();

                return true;
            }
        });
//        mLv.addHeaderView();
    }
}
