package com.asiainfo.shake.shakeexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * 最终要显示的Activity
 */

public class ShowActivity extends Activity implements View.OnClickListener {
    private ImageView mShowImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        mShowImg = (ImageView) this.findViewById(R.id.image_show);
        mShowImg.setOnClickListener(this);
        //设置显示界面退出的动画
        overridePendingTransition(0, R.anim.main_set_out);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_show:
                finish();
                break;
            default:
                break;
        }
    }
}
