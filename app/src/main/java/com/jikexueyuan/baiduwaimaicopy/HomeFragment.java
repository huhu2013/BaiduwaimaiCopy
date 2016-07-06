package com.jikexueyuan.baiduwaimaicopy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private ListView listView;
    private List<HomeModel> homeModelList;
    private HomeAdapter homeAdapter;
    private MainActivity mainActivity;

    private String yishouText;
    private String fenText;
    private String qisongText;
    private String peisongText;
    private String pingjunText;
    private String fenzhongText;
    private String footText;
    private String canyinText;
    private String tuhaoText;
    private String qidaiText;

    public HomeFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //得到各种待显示的文字
        yishouText = getResources().getString(R.string.yishou_text);
        fenText = getResources().getString(R.string.fen_texxt);
        qisongText = getResources().getString(R.string.qisong_text);
        peisongText = getResources().getString(R.string.peisong_text);
        pingjunText = getResources().getString(R.string.pingjun_text);
        fenzhongText = getResources().getString(R.string.fenzhong_text);
        footText = getResources().getString(R.string.homeFoot);
        canyinText = getResources().getString(R.string.canyin);
        tuhaoText = getResources().getString(R.string.tuhao);
        qidaiText = getResources().getString(R.string.qidai);
        //得到数据列表以及数据适配器，并初始化数据列表
        homeModelList = new ArrayList<>();
        homeAdapter = new HomeAdapter();
        homeModelList.addAll(initHomeModelList());

    }

    /**
     * 初始化数据列表的方法
     *
     * @return homeModels 数据列表
     */
    public List<HomeModel> initHomeModelList() {
        List<HomeModel> homeModels = new ArrayList<>();
        for (int i = 0; i < HomeItemData.listNum; i++) {
            HomeModel homeModel = new HomeModel();
            homeModel.setLeftResResource(HomeItemData.leftResResource[i]);
            homeModel.setShopName(HomeItemData.textShopName[i]);

            homeModel.setBrightStarNum(HomeItemData.brightStarNum[i]);
            homeModel.setSelfStarNum(HomeItemData.selfStarNum[i]);
            homeModel.setDimStarNum(HomeItemData.dimStarNum[i]);

            homeModel.setSalesCondition(yishouText + HomeItemData.saleNum[i] + fenText);
            homeModel.setTransportCondition(qisongText + HomeItemData.startPrice[i] + "|" +
                    peisongText + HomeItemData.transPortPrice[i] + "|" +
                    pingjunText + HomeItemData.transPortTime[i] + fenzhongText);

            homeModel.setIsListJian(HomeItemData.isListJian[i]);
            homeModel.setIsListQuan(HomeItemData.isListQuan[i]);
            homeModel.setIsListMian(HomeItemData.isListMian[i]);

            homeModel.setDistance(HomeItemData.distance[i]);

            homeModels.add(homeModel);
        }
        return homeModels;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //加载首页的父布局视图
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        //得到listView
        listView = (ListView) rootView.findViewById(R.id.listView_home);
        //得到listView的headView
        View headView = inflater.inflate(R.layout.list_head_home, null);
        //初始化headView上的各个ImageTextButton
        initTextImageButton(headView);
        //为listView设置headView
        listView.addHeaderView(headView, null, false);
        //为listView设置数据适配器
        listView.setAdapter(homeAdapter);
        //得到listView的footView
        View footView = inflater.inflate(R.layout.list_foot_home, null);
        //为listView设置footView
        listView.addFooterView(footView);
        //为listView设置列表项点击事件监听
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position <= homeModelList.size()) {
                    showToast(homeModelList.get(position - 1).getShopName());
                } else {
                    showToast(footText);
                }
            }
        });
        return rootView;
    }

    /**
     * 初始化TextImageButton
     *
     * @param headView 首页列表的headView
     */
    public void initTextImageButton(View headView) {

        tiCanyin = (ImageTextButton) headView.findViewById(R.id.text_image_canyin);
        tiChaoshi = (ImageTextButton) headView.findViewById(R.id.text_image_chaoshigou);
        tiShuiguo = (ImageTextButton) headView.findViewById(R.id.text_image_shuiguo);
        tiXiawucha = (ImageTextButton) headView.findViewById(R.id.text_image_xiawucha);
        tiTuhao = (ImageTextButton) headView.findViewById(R.id.text_image_tuhao);
        tiXindian = (ImageTextButton) headView.findViewById(R.id.text_image_xindian);
        tiPeisong = (ImageTextButton) headView.findViewById(R.id.text_image_peisong);
        tiSongyao = (ImageTextButton) headView.findViewById(R.id.text_image_songyao);

        tiCanyin.setOnClickListener(this);
        tiChaoshi.setOnClickListener(this);
        tiShuiguo.setOnClickListener(this);
        tiXiawucha.setOnClickListener(this);
        tiTuhao.setOnClickListener(this);
        tiXindian.setOnClickListener(this);
        tiPeisong.setOnClickListener(this);
        tiSongyao.setOnClickListener(this);
    }

    //点击ImageTextButton后所触发的事件响应
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.text_image_canyin:
                showToast(canyinText);
                break;
            case R.id.text_image_tuhao:
                showToast(tuhaoText);
                break;
            default:
                showToast(qidaiText);
                break;
        }
    }

    /**
     * 自定义的数据适配器
     */
    private class HomeAdapter extends BaseAdapter {
        //得到列表的长度
        @Override
        public int getCount() {
            return homeModelList.size();
        }

        //得到列表项本身
        @Override
        public Object getItem(int position) {
            return homeModelList.get(position);
        }

        //得到列表项的id
        @Override
        public long getItemId(int position) {
            return position;
        }

        //得到要加载的列表项视图
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //得到ViewHolder
            ViewHolder viewHolder;
            //如果没有生成视图，就加载视图，并得到其上的子控件
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = mainActivity.getLayoutInflater().inflate(R.layout.list_item_home, null);
                viewHolder.imageViewLeft = (ImageView) convertView.findViewById(R.id.image_home_left);
                viewHolder.textShopName = (TextView) convertView.findViewById(R.id.text_home_shopName);
                viewHolder.fiveStarView = (FiveStarView) convertView.findViewById(R.id.five_star_view);
                viewHolder.textSalsesCondition = (TextView) convertView.findViewById(R.id.text_home_salesCondition);
                viewHolder.textTransportCondition = (TextView) convertView.findViewById(R.id.text_home_transportCondition);
                viewHolder.threeCircleView = (ThreeCircleView) convertView.findViewById(R.id.three_circle_view);
                viewHolder.textDistance = (TextView) convertView.findViewById(R.id.text_home_distance);
                convertView.setTag(viewHolder);
            } else {//如果已经生成视图了，就直接拿来用
                viewHolder = (ViewHolder) convertView.getTag();
            }
            //设置子控件的各种资源
            viewHolder.imageViewLeft.setImageResource(homeModelList.get(position).getLeftResResource());
            viewHolder.textShopName.setText(homeModelList.get(position).getShopName());

            viewHolder.fiveStarView.setStarNum(homeModelList.get(position).getBrightStarNum(),
                    homeModelList.get(position).getSelfStarNum(),
                    homeModelList.get(position).getDimStarNum());

            viewHolder.textSalsesCondition.setText(homeModelList.get(position).getSalesCondition());
            viewHolder.textTransportCondition.setText(homeModelList.get(position).getTransportCondition());

            viewHolder.threeCircleView.setListJianIcon(homeModelList.get(position).isListJian());
            viewHolder.threeCircleView.setListQuanIcon(homeModelList.get(position).isListQuan());
            viewHolder.threeCircleView.setListMianIcon(homeModelList.get(position).isListMian());

            viewHolder.textDistance.setText(homeModelList.get(position).getDistance());
            return convertView;
        }
    }

    /**
     * 自定义的ViewHolder类，用于优化加载过程
     */
    private class ViewHolder {
        ImageView imageViewLeft;
        TextView textShopName;
        FiveStarView fiveStarView;
        TextView textSalsesCondition;
        TextView textTransportCondition;
        ThreeCircleView threeCircleView;
        TextView textDistance;
    }

    //得到所有的ImageTextButton
    private ImageTextButton tiCanyin, tiChaoshi, tiShuiguo, tiXiawucha,
            tiTuhao, tiXindian, tiPeisong, tiSongyao;

    /**
     * 得到显示指定文字的Toast
     *
     * @param str 待显示的文字
     */
    public void showToast(String str) {
        Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
    }
}
