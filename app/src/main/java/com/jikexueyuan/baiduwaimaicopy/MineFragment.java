package com.jikexueyuan.baiduwaimaicopy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MineFragment extends Fragment {
    private ListView listView;
    private List<MineModel> mineModelList;
    private List<MineModel> tagList;
    private MineAdapter mineAdapter;
    private MainActivity mainActivity;
    private Button btnLogin;
    private Button btnGongju;

    private String minePhone;
    private String openLoginText;
    private String openUtilText;

    public MineFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //生成我的页数据列表
        mineModelList = new ArrayList<>();
        //生成我的页空标签列表（事实上就是列表项中的灰色间隔项，可当做列表项处理）
        tagList = new ArrayList<>();
        //初始化数据列表
        mineModelList.addAll(initMineModelList(MineItemData.length, MineItemData.imageLeftResource,
                MineItemData.text, MineItemData.imageRightResource));
        //得到我的页列表数据适配器
        mineAdapter = new MineAdapter();
        //得到除了列表项外待显示的文字
        minePhone = getResources().getString(R.string.mine_phone);
        openLoginText = getResources().getString(R.string.openLoginText);
        openUtilText = getResources().getString(R.string.openUtilText);
    }

    /**
     * 为mineModelList列表项赋值
     *
     * @param length             列表长度
     * @param imageLeftResource  左图资源
     * @param text               文本资源
     * @param imageRightResource 右图资源
     * @return mineModels
     */
    private List<MineModel> initMineModelList(int length, int[] imageLeftResource,
                                              String[] text, int imageRightResource) {
        List<MineModel> mineModels = new ArrayList<>();
        int tagIndex = 0;
        for (int i = 0; i < length; i++) {
            MineModel mineModel = new MineModel();
            if (isTagIndex(i)) {
                mineModel.setText("" + i);
                tagList.add(mineModel);
                tagIndex++;
            } else {
                mineModel.setResLeftResource(imageLeftResource[i - tagIndex]);
                mineModel.setText(text[i - tagIndex]);
                mineModel.setResRightResource(imageRightResource);
            }
            mineModels.add(mineModel);
        }
        return mineModels;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //得到我的页根视图
        View rootView = inflater.inflate(R.layout.fragment_mine, container, false);
        //得到listView
        listView = (ListView) rootView.findViewById(R.id.listView_mine);
        //得到listView的headView
        View headView = inflater.inflate(R.layout.list_head_mine, null);
        //得到headView上的登录/注册按钮，并设置事件监听
        btnLogin = (Button) headView.findViewById(R.id.btn_mine_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(openLoginText);
            }
        });
        //得到headView上的工具按钮，并设置事件监听
        btnGongju = (Button) headView.findViewById(R.id.btn_mine_gongju);
        btnGongju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(openUtilText);
            }
        });
        //为工具按钮设置触摸动画
        final Animation startAlphaChange = AnimationUtils.loadAnimation(getContext(), R.anim.start_alpha_change);
        final Animation stopAlphaChange = AnimationUtils.loadAnimation(getContext(), R.anim.stop_alpha_change);
        btnGongju.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        btnGongju.startAnimation(startAlphaChange);
                        break;
                    case MotionEvent.ACTION_UP:
                        btnGongju.startAnimation(stopAlphaChange);
                        break;
                }
                return false;
            }
        });
        //为listView设置headView
        listView.addHeaderView(headView, null, false);
        //为listView设置数据适配器
        listView.setAdapter(mineAdapter);
        //得到listView的footView
        View footView = inflater.inflate(R.layout.list_foot_mine, null);
        //为listView设置footView
        listView.addFooterView(footView);
        //为listView设置数据项点击事件监听
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position <= mineModelList.size()) {
                    showToast(mineModelList.get(position - 1).getText());
                } else {
                    showToast(minePhone);
                }
            }
        });
        return rootView;
    }

    /**
     * 自定义数据适配器
     */
    private class MineAdapter extends BaseAdapter {
        //得到数据列表长度
        @Override
        public int getCount() {
            return mineModelList.size();
        }

        //得到数据项本身
        @Override
        public Object getItem(int position) {
            return mineModelList.get(position);
        }

        //得到数据项的id
        @Override
        public long getItemId(int position) {
            return position;
        }

        //得到要显示的数据项的视图
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //如果列表项position可用，就加载列表项子控件并设置要显示的资源
            if (isEnabled(position)) {

                ViewHolder viewHolder = new ViewHolder();
                convertView = mainActivity.getLayoutInflater().inflate(R.layout.list_item_mine, null);
                viewHolder.imageLeft = (ImageView) convertView.findViewById(R.id.image_mine_left);
                viewHolder.imageLeft.setImageResource(mineModelList.get(position).getResLeftResource());
                viewHolder.textView = (TextView) convertView.findViewById(R.id.text_mine);
                viewHolder.textView.setText(mineModelList.get(position).getText());
                viewHolder.imageRight = (ImageView) convertView.findViewById(R.id.image_mine_right);
                viewHolder.imageRight.setImageResource(mineModelList.get(position).getResRightResource());

            } else {//如果position不可用，就显示间隔项的视图
                convertView = mainActivity.getLayoutInflater().inflate(R.layout.list_tag_mine, null);
            }
            return convertView;
        }

        //判断列表项position是否可用
        @Override
        public boolean isEnabled(int position) {
            return !tagList.contains(mineModelList.get(position));
        }
    }

    /**
     * 自定义的ViewHolder类，用于优化加载过程
     */
    private class ViewHolder {
        ImageView imageLeft;//列表项最左边的ImageView
        TextView textView;//列表项中的TextView
        ImageView imageRight;//列表项最右边的ImageView
    }

    /**
     * 判断是否是需要显示的数据项（即是否是标签项）
     *
     * @param index
     * @return
     */
    private boolean isTagIndex(int index) {
        for (int i = 0; i < MineItemData.tagLength; i++) {
            if (MineItemData.tagIndex[i] == index) {
                return true;
            }
        }
        return false;
    }

    /**
     * 用于显示指定的Toast
     *
     * @param str 要显示的文字
     */
    public void showToast(String str) {
        Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
    }
}
