package com.raymondqck.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.raymondqck.myapplication.R;

/**
 * Created by 陈其康 raymondchan on 2016/7/22 0022.
 */
public class AboutWeiXinListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private String[] mContents;

    public AboutWeiXinListAdapter(Context context, String[] contents) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mContents = contents;
    }

    @Override
    public int getCount() {
        return mContents.length;
    }

    @Override
    public Object getItem(int i) {
        return mContents[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if (view == null){
            viewHolder = new ViewHolder();
            view = mLayoutInflater.inflate(R.layout.item_list_weixin,null);
            viewHolder.tv_content = (TextView) view.findViewById(R.id.item_weixin_about);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tv_content.setText(mContents[i]);
        return view;
    }

    private class ViewHolder{
        private TextView tv_content;
    }
}
