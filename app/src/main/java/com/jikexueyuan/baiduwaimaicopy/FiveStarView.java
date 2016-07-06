package com.jikexueyuan.baiduwaimaicopy;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于显示五星评价条
 */
public class FiveStarView extends LinearLayout {

    private ImageView starImageViewLeft;
    private ImageView starImageViewSecond;
    private ImageView starImageViewThird;
    private ImageView starImageViewForth;
    private ImageView starImageViewRight;

    private int brightStarNum;
    private int selfStarNum;
    private int dimStarNum;

    private List<ImageView> imageViewList;

    public FiveStarView(Context context) {
        this(context, null);
    }

    public FiveStarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //得到五星图片列表
        imageViewList = new ArrayList<>();
        //加载父布局，得到子控件，并将子控件放入列表中
        LayoutInflater.from(context).inflate(R.layout.fivestar_view, this, true);
        starImageViewLeft = (ImageView) this.findViewById(R.id.star_imageview_left);
        imageViewList.add(starImageViewLeft);
        starImageViewSecond = (ImageView) this.findViewById(R.id.star_imageview_second);
        imageViewList.add(starImageViewSecond);
        starImageViewThird = (ImageView) this.findViewById(R.id.star_imageview_third);
        imageViewList.add(starImageViewThird);
        starImageViewForth = (ImageView) this.findViewById(R.id.star_imageview_forth);
        imageViewList.add(starImageViewForth);
        starImageViewRight = (ImageView) this.findViewById(R.id.star_imageview_right);
        imageViewList.add(starImageViewRight);
        //得到自定义属性，并根据自定义属性设置亮星、半星、暗星的个数
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.FiveStarView);
        brightStarNum = typedArray.getInteger(R.styleable.FiveStarView_brightStarNum, 0);
        selfStarNum = typedArray.getInteger(R.styleable.FiveStarView_selfStarNum, 0);
        dimStarNum = typedArray.getInteger(R.styleable.FiveStarView_dimStarNum, 0);
        if (brightStarNum + selfStarNum + dimStarNum != 5) {
            brightStarNum = 5;
            selfStarNum = 0;
            dimStarNum = 0;
        }
        typedArray.recycle();
        //通过外界传回来的属性值进行五星状态设置
        setStarNum(brightStarNum, selfStarNum, dimStarNum);

    }

    /**
     * 公开的外界设置五星状态的方法
     *
     * @param brightStarNum 亮星个数
     * @param selfStarNum   半星个数
     * @param dimStarNum    暗星个数
     */
    public void setStarNum(int brightStarNum, int selfStarNum, int dimStarNum) {

        for (int i = 0; i < brightStarNum; i++) {
            imageViewList.get(i).setImageResource(R.drawable.icon_bright_star);
        }
        for (int i = brightStarNum; i < brightStarNum + selfStarNum; i++) {
            imageViewList.get(i).setImageResource(R.drawable.icon_self_star);
        }
        for (int i = brightStarNum + selfStarNum; i < 5; i++) {
            imageViewList.get(i).setImageResource(R.drawable.icon_dim_star);
        }
    }

}
