package com.jikexueyuan.baiduwaimaicopy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * 订单详情页
 */
public class DingdanFragment extends Fragment {
    private Button btnLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //得到根布局
        View rootView = inflater.inflate(R.layout.fragment_dingdan, container, false);
        //得到其中的登录/注册按钮，并设置事件监听
        btnLogin = (Button) rootView.findViewById(R.id.btn_dingdan_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "打开登录/注册页", Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }
}
