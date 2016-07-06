package com.jikexueyuan.baiduwaimaicopy;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 图像文字按钮控件
 */
public class ImageTextButton extends LinearLayout {

    private ImageView imageView;
    private TextView textView;
    private int backgroundNomal;
    private int backgroundPressed;
    private String imageText;
    private StateListDrawable stateListDrawable;

    public ImageTextButton(Context context) {
        this(context, null);
    }

    public ImageTextButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        //得到能显示不同状态下drawable图片的对象
        stateListDrawable = new StateListDrawable();
        //加载父布局，得到子控件
        LayoutInflater.from(context).inflate(R.layout.image_text_button, this, true);
        imageView = (ImageView) this.findViewById(R.id.image_text_imageView);
        textView = (TextView) this.findViewById(R.id.image_text_textView);
        //得到自定义的属性值
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ImageTextButton);
        backgroundNomal = typedArray.getResourceId(R.styleable.ImageTextButton_backgroundNomal, R.drawable.icon_default);
        backgroundPressed = typedArray.getResourceId(R.styleable.ImageTextButton_backgroundPressed, R.drawable.icon_default);
        imageText = typedArray.getString(R.styleable.ImageTextButton_imageText);
        typedArray.recycle();
        //为imageView设置点击选中和正常状态下不同的图片
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, this.getResources().getDrawable(backgroundPressed));
        stateListDrawable.addState(new int[]{}, this.getResources().getDrawable(backgroundNomal));
        imageView.setBackground(stateListDrawable);
        //为textView设置要显示的文字
        textView.setText(imageText);
    }

}
