package com.example.zhang.ueating_temp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
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

    String categories[] = new String[] { "美食", "休闲娱乐", "购物", "酒店", "丽人", "亲子",
            "生活服务" };

    String sub_categories[][] = new String[][] {
            new String[] { "全部美食", "本帮江浙菜", "川菜", "粤菜", "湘菜", "东北菜", "台湾菜",
                    "新疆/清真", "素菜", "火锅", "自助餐", "小吃快餐", "日本", "韩国料理", "东南亚菜",
                    "西餐", "面包甜点", "其他" },
            new String[] { "全部休闲娱乐", "咖啡厅", "酒吧", "茶馆", "KTV", "电影院", "游乐游艺",
                    "公园", "景点/郊游", "洗浴", "足浴按摩", "文化艺术", "DIY手工坊", "桌球馆",
                    "桌面游戏", "更多休闲娱乐" },
            new String[] { "全部购物", "综合商场", "服饰鞋包", "运动户外", "珠宝饰品", "化妆品",
                    "数码家电", "亲子购物", "家居建材", "书店", "书店", "眼镜店", "特色集市",
                    "更多购物场所", "食品茶酒", "超市/便利店", "药店" },
            new String[] { "全部酒店", "经济型酒店", "豪华酒店", "度假酒店", "公寓式酒店",
                    "客栈/青旅/民宿", "主题精品酒店", " 温泉酒店", "亲子酒店" },
            new String[] { "全部丽人", "美发", "美容/SPA", "美甲", "瘦身纤体", "个性写真",
                    "瑜伽/舞蹈", "其他" },
            new String[] { "全部亲子", "亲子游乐", "亲子摄影", "幼儿教育", "主题公园/游乐场",
                    "展览/演出/赛事", "景点郊游", "DIY手工", "农家乐" },
            new String[] { "全部生活", "商场购物劵", "汽车服务", "鲜花婚庆", "体检保健", "宠物服务",
                    "家政服务", "照片冲印", "配眼镜" },
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
    }

    private void initAdapter() {
        categoryAdapter = new CategoryAdapter(getActivity(), categories);
        listView.setAdapter(categoryAdapter);
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
        itemsAdapter = new ItemsAdapter(getActivity(), sub_categories,
                position);
        subListView.setAdapter(itemsAdapter);
        Log.v("Tony",itemsAdapter.getCount()+"");
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
    }

}
