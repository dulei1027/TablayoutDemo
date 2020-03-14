package com.coderdu.tablayoutdemo;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.widget.TextView;
import com.coderdu.tablayoutdemo.adapter.ViewPagerAdater;
import com.coderdu.tablayoutdemo.fragment.MyFragment;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ViewPager viewpager;
    public TextView textView;
    public ArrayList<MyFragment> fragments;
    public ViewPagerAdater viewPagerAdater;
    public TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager = (ViewPager)findViewById(R.id.viewpager);
        textView = (TextView)findViewById(R.id.tv_title);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        //初始化数据
        fragments = new ArrayList<>();
        for(int i = 0 ; i< 12; i++){

            fragments.add( new MyFragment("标题" + i ,"内容" + i));
        }
        //设置ViewPager的适配器
        viewPagerAdater = new ViewPagerAdater(getSupportFragmentManager(),fragments);
        viewpager.setAdapter(viewPagerAdater);
        //关联 viewpager
        tabLayout.setupWithViewPager(viewpager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
     }
}
