package com.jikexueyuan.baiduwaimaicopy;


import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * 自定义组合控件，用于显示减、券、免的不同状态
 */
public class ThreeCircleView extends LinearLayout {

    private ImageView imageViewJian;
    private ImageView imageViewQuan;
    private ImageView imageViewMian;

    private boolean isListJian;
    private boolean isListQuan;
    private boolean isListMian;

    public ThreeCircleView(Context context) {
        this(context, null);
    }

    public ThreeCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //加载父布局，得到子控件
        LayoutInflater.from(context).inflate(R.layout.threecircle_view, this, true);
        imageViewJian = (ImageView) this.findViewById(R.id.image_home_jian);
        imageViewQuan = (ImageView) this.findViewById(R.id.image_home_quan);
        imageViewMian = (ImageView) this.findViewById(R.id.image_home_mian);
        //得到自定义属性，并根据自定义属性（是否高亮显示）来设置子控件不同的图片
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ThreeCircleView);
        isListJian = typedArray.getBoolean(R.styleable.ThreeCircleView_isListJian, true);
        isListQuan = typedArray.getBoolean(R.styleable.ThreeCircleView_isListQuan, true);
        isListMian = typedArray.getBoolean(R.styleable.ThreeCircleView_isListMian, true);

        setListJianIcon(isListJian);
        setListQuanIcon(isListQuan);
        setListMianIcon(isListMian);
        typedArray.recycle();
    }

    /**
     * 用于显示减
     *
     * @param isListJian 是否高亮显示减
     */
    public void setListJianIcon(boolean isListJian) {
        if (isListJian) {
            imageViewJian.setImageResource(R.drawable.icon_jian);
        } else {
            imageViewJian.setImageResource(R.drawable.icon_jian_grey);
        }
    }

    /**
     * 用于显示券
     *
     * @param isListQuan 是否高亮显示券
     */
    public void setListQuanIcon(boolean isListQuan) {
        if (isListQuan) {
            imageViewQuan.setImageResource(R.drawable.icon_quan);
        } else {
            imageViewQuan.setImageResource(R.drawable.icon_quan_grey);
        }
    }

    /**
     * 用于显示免
     *
     * @param isListMian 是否高亮显示免
     */
    public void setListMianIcon(boolean isListMian) {
        if (isListMian) {
            imageViewMian.setImageResource(R.drawable.icon_mian);
        } else {
            imageViewMian.setImageResource(R.drawable.icon_mian_grey);
        }
    }

}
