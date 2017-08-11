package com.fengniao.myblibli;

import android.os.Bundle;

import com.fengniao.myblibli.base.BaseActivity;
import com.fengniao.myblibli.util.UIUtils;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    long lastTime;

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - lastTime > 2000) {
            UIUtils.showToast("再按一次退出");
            lastTime = System.currentTimeMillis();
            return;
        }
        super.onBackPressed();

    }
}
