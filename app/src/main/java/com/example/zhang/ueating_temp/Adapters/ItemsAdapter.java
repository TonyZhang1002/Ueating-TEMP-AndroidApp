package com.example.zhang.ueating_temp.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.zhang.ueating_temp.R;

/**
 * Created by TonyZhang on 2018/9/16.
 */

public class ItemsAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    String[][] sub_categories;
    public int categoryPosition;

    public ItemsAdapter(Context context, String[][] sub_categories, int position) {
        this.context = context;
        this.sub_categories = sub_categories;
        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.categoryPosition = position;
    }

    @Override
    public int getCount() {
        return sub_categories[categoryPosition].length;
    }

    @Override
    public Object getItem(int position) {
        return getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.items_item, null);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) convertView
                    .findViewById(R.id.itemTextView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(sub_categories[categoryPosition][position]);
        viewHolder.textView.setTextColor(Color.BLACK);
        return convertView;
    }

    public static class ViewHolder {
        public TextView textView;
    }


}
