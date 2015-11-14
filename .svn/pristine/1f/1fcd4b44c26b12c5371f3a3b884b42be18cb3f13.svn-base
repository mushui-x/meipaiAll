package com.gzw.mp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gzw.mp.R;
import com.gzw.mp.bean.FindBean;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * coder by 背离记 on 2015/11/13.
 */
public class FindTopicAdapter extends BaseAdapter{
    private Context context;
    private List<FindBean.Data> list;

    public FindTopicAdapter(Context context, List<FindBean.Data> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FindBean.Data data =list.get(position);
        ViewHolder holder;
        if(convertView==null){
            holder =new ViewHolder();
            convertView =View.inflate(context,R.layout.item_find_topic,null);
            ViewUtils.inject(holder,convertView);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.topic.setText(data.getName());

        return convertView;
    }

    class ViewHolder{
        @ViewInject(R.id.text_find_topic)
        TextView topic;
    }
}
