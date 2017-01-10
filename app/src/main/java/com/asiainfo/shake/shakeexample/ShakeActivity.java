package com.asiainfo.shake.shakeexample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 摇一摇功能页
 */
public class ShakeActivity extends Activity implements ShakeSensor.onShakeListener {

    private static final int MSG__COUNT_END = 0X01;//次数使用结束
    private static final int MSG__COUNT_CONUTINUE = 0X02;//次数继续
    private ShakeSensor mShakeSensor;//传感器
    private MediaPlayer mPlayer;//音乐效果
    private Vibrator mVibrator;//震动效果
    private ImageView mImgHandle;//视图
    private TextView mTxtCount;//显示的次数
    private static int count = 3;//记录次数
    private boolean isStart;//判断是否是开始进入

    @Override
    protected void onResume() {
        super.onResume();
        if (count == 0) {
            count = 0;
        } else {
            if (isStart) {
                count--;
            }
        }
        isStart = true;
        mTxtCount.setText("今天还可以摇" + count + "次");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);
        mImgHandle = (ImageView) this.findViewById(R.id.shake_faild);
        mTxtCount = (TextView) this.findViewById(R.id.txt_show_count);
        mShakeSensor = new ShakeSensor(this);
        //注册回调事件
        mShakeSensor.setOnShakeListener(this);
        mShakeSensor.init();

        mVibrator = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);

        //启动动画
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.main_img_handle);
        mImgHandle.startAnimation(animation);
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == MSG__COUNT_END) {
                //音效
                startVibrator();
            } else {
                //震动,音乐效果
                startAudioWithVibrator();
                Intent show = new Intent(ShakeActivity.this, ShowActivity.class);
                startActivity(show);
            }
        }
    };

    public void startVibrator() {
        //震动效果
        long pattern[] = {500, 300, 500, 300};//周期多长震动:500毫秒
        mVibrator.vibrate(pattern, -1);
    }

    @Override
    public void onShake() {
        if (count == 0) {
            //次数已经使用完成
            mHandler.sendEmptyMessage(MSG__COUNT_END);
        } else {
            //还有次数
            mHandler.sendEmptyMessage(MSG__COUNT_CONUTINUE);
        }
        //实现操作


        //添加跳转时showActivity进入动画
        overridePendingTransition(R.anim.main_set_in, 0);
    }

    private void startAudioWithVibrator() {
        mPlayer = MediaPlayer.create(this, R.raw.jd);//建一个raw文件件放一个音频文件
        //播放
        mPlayer.start();
        startVibrator();
    }
}
