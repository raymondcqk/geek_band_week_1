package com.raymondqck.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.raymondqck.myapplication.R;
import com.raymondqck.myapplication.model.UserInfo;

import java.util.List;

/**
 * Created by 陈其康 raymondchan on 2016/7/19 0019.
 */
public class MyAdapter extends BaseAdapter {

    //上下文 -- 用于引用对应的Activity对象，获得布局解析服务：LAYOUT_INFLATER_SERVICE
    private Context mContext;
    //布局解析器  -- 用于将layout.xml文件，解析成为一个view对象，从而操作该布局中的控件，如使用findViewById获取控件对象
    private LayoutInflater mLayoutInflater;
    //数据源 -- 这里只以 联系人姓名 为例，一般需要多个数据源，构成一个复杂而丰富的list列表
    private List<UserInfo> mUserInfoList;

    public MyAdapter(Context context,List<UserInfo> userInfoList){
        /*构造器初始化*/
        //初始化 上下文
        mContext = context;
        //初始化布局解析器
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //从外部（activity）获取数据源
        mUserInfoList = userInfoList;
    }
    @Override
    public int getCount() {
        // 列表listview的数量
        //返回 数据源 数组的数量（长度）
        return mUserInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        //返回 对应位置 的 数据项 对象
        return mUserInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // 返回 列表项 id 一般直接返回position即可
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        /*返回列表项的布局：该回调函数是让listview每一个列表项绑上数据的*/
        /*
        //获得我们定义的列表项的布局文件，通过layoutinflater将布局文件解析成view对象
        view = mLayoutInflater.inflate(R.layout.item,null);
        //通过layout的view对象，使用findViewById函数，获取其布局内的控件
        TextView tv_name = (TextView) view.findViewById(R.id.item_name);
        //为控件添加（绑定）数据 ---根据position从数据源获得对应数据
        tv_name.setText(mUserInfoList.get(position).getName());
        TextView tv_age = (TextView) view.findViewById(R.id.item_age);
        tv_age.setText(mUserInfoList.get(position).getAge());
        ImageView img_avatar = (ImageView) view.findViewById(R.id.item_avatar);
        img_avatar.setImageResource(R.drawable.head);
        //完成控件数据绑定，返回该view，呈现一个列表项内容

        */
        ViewHolder viewHolder;
        if (view==null){
            viewHolder = new ViewHolder();
            view = mLayoutInflater.inflate(R.layout.item,null);
            viewHolder.name = (TextView) view.findViewById(R.id.item_name);
            viewHolder.age = (TextView) view.findViewById(R.id.item_age);
            viewHolder.avatar = (ImageView) view.findViewById(R.id.item_avatar);

            view.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.name.setText(mUserInfoList.get(position).getName());
        viewHolder.age.setText(mUserInfoList.get(position).getAge()+"");
        viewHolder.avatar.setImageResource(R.drawable.head);

        return view;
    }

    private class ViewHolder {
        private TextView name;
        private TextView age;
        private ImageView avatar;
    }

    public void refleshData(List<UserInfo> list){
        mUserInfoList = list;
        notifyDataSetChanged();
    }
}


