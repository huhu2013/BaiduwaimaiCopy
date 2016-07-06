package com.jikexueyuan.baiduwaimaicopy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {
    private ImageView imageHome;
    private ImageView imageDingdan;
    private ImageView imageMine;
    private TextView textHome;
    private TextView textDingdan;
    private TextView textMine;
    private ViewPager viewPager;
    private List<Fragment> fragments;
    private FragmentStatePagerAdapter fragmentStatePagerAdapter;
    private int selectedColor;
    private HomeFragment homeFragment;
    private DingdanFragment dingdanFragment;
    private MineFragment mineFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//设置要显示的视图

        initBottomView();//初始化底部菜单栏
        initFragments();//初始化Fragments
    }

    /**
     * 初始化底部菜单栏
     */
    private void initBottomView() {
        //得到底部菜单栏的各个子控件
        imageHome = (ImageView) this.findViewById(R.id.image_home);
        imageDingdan = (ImageView) this.findViewById(R.id.image_dingdan);
        imageMine = (ImageView) this.findViewById(R.id.image_mine);
        textHome = (TextView) this.findViewById(R.id.text_home);
        textDingdan = (TextView) this.findViewById(R.id.text_dingdan);
        textMine = (TextView) this.findViewById(R.id.text_mine);

        //设置初始状态底部菜单栏要显示的图片和文字颜色
        selectedColor = Constant.SELECTED_COLOR;
        imageHome.setImageResource(R.drawable.icon_home_selected);
        textHome.setTextColor(selectedColor);

    }

    /**
     * 初始化Fragments
     */
    private void initFragments() {

        //得到ViewPager控件
        viewPager = (ViewPager) this.findViewById(R.id.viewPager);

        //得到fragments列表
        fragments = new ArrayList<>();
        //得到各个fragment
        homeFragment = new HomeFragment(MainActivity.this);
        dingdanFragment = new DingdanFragment();
        mineFragment = new MineFragment(MainActivity.this);
        //将各个fragment加入fragments中
        fragments.add(homeFragment);
        fragments.add(dingdanFragment);
        fragments.add(mineFragment);

        //初始化FragmentStatePagerAdapter
        fragmentStatePagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            //得到每个fragment项
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            //得到需要viewPager展示的Fragment个数
            @Override
            public int getCount() {
                return fragments.size();
            }
        };

        //为viewPager设置适配器
        viewPager.setAdapter(fragmentStatePagerAdapter);
        //为viewPager设置翻页事件监听
        viewPager.addOnPageChangeListener(this);

        //一开始进入首页
        viewPager.setCurrentItem(0);
        //设置当前需要缓存的页面数，阻止viewPager销毁页面
        viewPager.setOffscreenPageLimit(3);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //首先将底部菜单栏状态设为未选中时的状态
        setUnselected();
        //得到所有的ListView,用于自动返回页面顶部
        ListView listViewHome = (ListView) getSupportFragmentManager().getFragments().get(0).getActivity().findViewById(R.id.listView_home);
        ListView listViewMine = (ListView) getSupportFragmentManager().getFragments().get(2).getActivity().findViewById(R.id.listView_mine);
        //对当前viewPager呈现的页面进行判断，用于设置底部菜单栏状态，其中setSelection(0)方法用于其他页面返回顶部
        switch (viewPager.getCurrentItem()) {
            case 0:
                listViewMine.setSelection(0);
                imageHome.setImageResource(R.drawable.icon_home_selected);
                textHome.setTextColor(Constant.SELECTED_COLOR);
                break;
            case 1:
                listViewHome.setSelection(0);
                listViewMine.setSelection(0);
                imageDingdan.setImageResource(R.drawable.icon_dingdan_selected);
                textDingdan.setTextColor(Constant.SELECTED_COLOR);
                break;
            case 2:
                listViewHome.setSelection(0);
                imageMine.setImageResource(R.drawable.icon_me_selected);
                textMine.setTextColor(Constant.SELECTED_COLOR);
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    /**
     * 在布局文件中直接调用该方法名，从而在点击底部菜单栏某项时做出相应动作
     *
     * @param v 被点击的菜单栏视图
     */
    public void bottomOnClick(View v) {
        //首先将底部菜单栏状态设为未选中时的状态
        setUnselected();
        //对当前的点击事件进行判断，从而选择当前要显示的页面以及底部菜单栏的状态
        switch (v.getId()) {
            case R.id.linear_home:
                viewPager.setCurrentItem(Constant.HOME_STATE, false);
                textHome.setTextColor(Constant.SELECTED_COLOR);
                imageHome.setImageResource(R.drawable.icon_home_selected);
                break;
            case R.id.linear_dingdan:
                viewPager.setCurrentItem(Constant.DINGDAN_STATE, false);
                textDingdan.setTextColor(Constant.SELECTED_COLOR);
                imageDingdan.setImageResource(R.drawable.icon_dingdan_selected);
                break;
            case R.id.linear_mine:
                viewPager.setCurrentItem(Constant.MINE_STATE, false);
                textMine.setTextColor(Constant.SELECTED_COLOR);
                imageMine.setImageResource(R.drawable.icon_me_selected);
                break;
        }
    }

    /**
     * 设置未进入该页面时底部菜单栏的状态
     */
    private void setUnselected() {
        //设置未选中时的图片背景
        imageHome.setImageResource(R.drawable.icon_home);
        imageDingdan.setImageResource(R.drawable.icon_dingdan);
        imageMine.setImageResource(R.drawable.icon_me);
        //设置未选中时的字体颜色
        textHome.setTextColor(Constant.UNSELECTED_COLOR);
        textDingdan.setTextColor(Constant.UNSELECTED_COLOR);
        textMine.setTextColor(Constant.UNSELECTED_COLOR);
    }

}
