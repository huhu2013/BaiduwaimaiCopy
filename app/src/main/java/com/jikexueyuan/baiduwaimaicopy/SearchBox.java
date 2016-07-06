package com.jikexueyuan.baiduwaimaicopy;


import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 自定义搜索框控件
 */
public class SearchBox extends LinearLayout {

    private EditText editText;
    private LinearLayout searchLinearLayout;
    private int textLength;
    private Button buttonClear;

    private TextView textNouse;

    public SearchBox(Context context) {
        this(context, null);
    }

    public SearchBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        //加载父布局，得到子控件
        LayoutInflater.from(context).inflate(R.layout.search_box_view, this, true);
        editText = (EditText) this.findViewById(R.id.edt_search);
        searchLinearLayout = (LinearLayout) this.findViewById(R.id.layout_home_search);
        buttonClear = (Button) this.findViewById(R.id.btn_home_search);
        textNouse = (TextView) this.findViewById(R.id.text_nouse);
        //设置刚开始进入首页时的焦点在textNouse上，避免焦点落在搜索框上而弹出键盘
        textNouse.requestFocus();
        //为其中的editText控件设置输入文字变化事件监听
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //当输入框呢有文字，则删除图标显示，否则隐藏
                textLength = editText.getText().length();
                if (textLength > 0) {
                    searchLinearLayout.setVisibility(VISIBLE);
                } else {
                    searchLinearLayout.setVisibility(GONE);
                }
            }
        });

        //为editText设置键盘事件监听
        editText.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //如果按下回车键，则进行搜索工作，并且在搜索完成之后隐藏软键盘
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    Toast.makeText(v.getContext(), "搜索完成", Toast.LENGTH_SHORT).show();
                    InputMethodManager inputMethodManager = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (inputMethodManager.isActive()) {
                        inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
                    }
                }
                return false;
            }
        });
        //为清除按钮添加点击事件监听，清除文字并隐藏清除图标
        buttonClear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                searchLinearLayout.setVisibility(GONE);
            }
        });
    }

}
