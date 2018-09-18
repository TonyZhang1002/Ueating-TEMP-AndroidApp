package com.example.zhang.ueating_temp;

import android.app.Fragment;
import android.os.Bundle;
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


    String categories[] = new String[] { "美食" };

    String sub_categories[][] = new String[][] {
            new String[] { "全部美食", "本帮江浙菜","川菜", "粤菜", "湘菜", "东北菜", "台湾菜",
                    "新疆/清真", "素菜", "火锅", "自助餐" }
    };

    String pic_urls[][] = new String[][] {
            new String[] { "http://img.mp.itc.cn/upload/20170424/18a44f374651414a91485b8470e34385_th.jpeg",
                    "https://cdn2.ettoday.net/images/2597/d2597858.jpg",
                    "https://media-cdn.tripadvisor.com/media/daodao/photo-s/10/4c/94/d1/caption.jpg",
                    "http://img3.meichubang.com/d/file/201706/19/30178bf46db4ce045c632cb90143a3c9.jpeg",
                    "http://www.skrf.nu/wp-content/uploads/2016/06/%E9%A4%90%E9%A3%B26.jpg",
                    "http://pic.baike.soso.com/p/20090714/20090714010147-1836681475.jpg",
                    "http://food.chinesecio.com/image/attachement/jpg/site2/20091214/0023aea9e73e0c903e7714.jpg",
                    "http://img.mp.itc.cn/upload/20170504/03b13ea7d9604c628132cfacefc809b8_th.jpeg",
                    "http://static.chinacaipu.com/d/file/menu/sushishipu/2015-06-02/b7a451115c297fe20e56caf07b24e545.jpg",
                    "http://recipe0.hoto.cn/pic/recipe/l/b0/3d/343472_59d92f.jpg",
                    "http://m1.aboluowang.com/uploadfile/2018/0130/20180130015943591.jpg"}
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

        //Log.v("Tony",subListView.findViewWithTag(default_pic)+"");
    }

}
