package com.example.zhang.ueating_temp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.View;
import android.widget.Toast;

import com.example.zhang.ueating_temp.Adapters.CategoryAdapter;
import com.example.zhang.ueating_temp.Adapters.ItemsAdapter;

/**
 * Created by TonyZhang on 2018/9/16.
 */

public class HomeFragment extends Fragment {

    View view;
    public ListView listView;
    public ListView subListView;
    CategoryAdapter categoryAdapter;
    ItemsAdapter itemsAdapter;
    private LruCacheImageLoader lruCacheImageLoader;
    private int mStart,mEnd;

    private boolean mFirstIn ;

    String categories[] = new String[] { "美食" };

    String sub_categories[][] = new String[][] {
            new String[] { "全部美食", "本帮江浙菜", "川菜", "粤菜", "湘菜", "东北菜", "台湾菜",
                    "新疆/清真", "素菜", "火锅", "自助餐", "小吃快餐", "日本", "韩国料理", "东南亚菜",
                    "西餐", "面包甜点", "其他" }
    };

    String default_pic = "http://img0.sc115.com/uploads1/sc/jpgs/1510/apic15069_sc115.com.jpg";
    String pic_urls[][] = new String[][] {
            new String[] { default_pic, "123", default_pic, default_pic, default_pic, default_pic, default_pic,
                    default_pic, default_pic, default_pic, default_pic, default_pic, default_pic, default_pic, default_pic,
                    default_pic, default_pic, default_pic }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment, container, false);
        initView();
        initAdapter();
        return view;
    }

    private void initView(){
        listView = (ListView) view.findViewById(R.id.listView);
        subListView = (ListView) view.findViewById(R.id.subListView);
        lruCacheImageLoader = LruCacheImageLoader.getInstance(getActivity());
    }

    private void initAdapter() {
        categoryAdapter = new CategoryAdapter(getActivity(), categories);
        listView.setAdapter(categoryAdapter);
        mFirstIn = true;
        setSubList(0);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {
                setSubList(position);
            }
        });
    }

    public void setSubList(int position) {
        final int location = position;
        categoryAdapter.setSelectedPosition(position);
        categoryAdapter.notifyDataSetInvalidated();
        itemsAdapter = new ItemsAdapter(getActivity(), sub_categories, pic_urls,
                position);
        subListView.setAdapter(itemsAdapter);
        subListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {
                // TODO Auto-generated method stub
                Toast.makeText(getActivity(),
                        sub_categories[location][position], Toast.LENGTH_SHORT)
                        .show();
            }
        });

        Log.v("Tony",subListView.findViewWithTag(default_pic)+"");
        /*
        subListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if(i==SCROLL_STATE_IDLE){
                    lruCacheImageLoader.loadTagImageViewInListView(mStart,mEnd,pic_urls[location],subListView);
                }else {
                    lruCacheImageLoader.cancelAllTask();
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                mStart = i;
                mEnd = i + i1;
                if(mFirstIn && i1 >0){
                    lruCacheImageLoader.loadTagImageViewInListView(mStart,mEnd,pic_urls[location],subListView);
                    mFirstIn = false;
                }
            }
        });
        */
    }

}
