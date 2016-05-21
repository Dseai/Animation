package com.example.animation;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity implements OnClickListener {
    private ImageView image;
    private Button scale;
    private Button rotate;
    private Button translate;
    //private Button mix;
    private Button alpha;
    private Button continue_btn;
    private Button continue_btn2;
    private Button flash;
    private Button move;
    private Button change;
    private Button layout;
    private Button frame;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.image = (ImageView)this.findViewById(R.id.image);
        this.scale = (Button)this.findViewById(R.id.scale);
        this.rotate = (Button)this.findViewById(R.id.rotate);
        this.translate = (Button)this.findViewById(R.id.translate);
        this.alpha = (Button)this.findViewById(R.id.alpha);
        this.continue_btn = (Button)this.findViewById(R.id.continue_btn);
        this.continue_btn2 = (Button)this.findViewById(R.id.continue_btn2);
        this.flash = (Button)this.findViewById(R.id.flash);
        this.move = (Button)this.findViewById(R.id.move);
        this.change = (Button)this.findViewById(R.id.change);
        this.layout = (Button)this.findViewById(R.id.layout);
        this.frame = (Button)this.findViewById(R.id.frame);
        this.scale.setOnClickListener(this);
        this.rotate.setOnClickListener(this);
        this.translate.setOnClickListener(this);
        this.alpha.setOnClickListener(this);
        this.continue_btn.setOnClickListener(this);
        this.continue_btn2.setOnClickListener(this);
        this.flash.setOnClickListener(this);
        this.move.setOnClickListener(this);
        this.change.setOnClickListener(this);
        this.layout.setOnClickListener(this);
        this.frame.setOnClickListener(this);
    }

    public void onClick(View view) {
        Animation loadAnimation;
        Intent intent;
        switch(view.getId()) {
            case R.id.alpha:
                loadAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
                this.image.startAnimation(loadAnimation);
                break;
            case R.id.translate:
                loadAnimation = AnimationUtils.loadAnimation(this, R.anim.translate);
                this.image.startAnimation(loadAnimation);
                break;
            case R.id.scale:
                loadAnimation = AnimationUtils.loadAnimation(this, R.anim.scale);
                this.image.startAnimation(loadAnimation);
                break;
            case R.id.rotate:
                loadAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
                this.image.startAnimation(loadAnimation);
                break;
            case R.id.continue_btn:
                loadAnimation = AnimationUtils.loadAnimation(this, R.anim.translate);
                this.image.startAnimation(loadAnimation);
                final Animation intent3 = AnimationUtils.loadAnimation(this, R.anim.rotate);
                loadAnimation.setAnimationListener(new AnimationListener() {
                    public void onAnimationStart(Animation arg0) {
                    }

                    public void onAnimationRepeat(Animation arg0) {
                    }

                    public void onAnimationEnd(Animation arg0) {
                        MainActivity.this.image.startAnimation(intent3);
                    }
                });
                break;
            case R.id.continue_btn2:
                loadAnimation = AnimationUtils.loadAnimation(this, R.anim.continue_anim);
                this.image.startAnimation(loadAnimation);
                break;
            case R.id.flash:
                AlphaAnimation intent2 = new AlphaAnimation(0.1F, 1.0F);
                intent2.setDuration(100);
                intent2.setRepeatCount(10);
                //倒序重复
                intent2.setRepeatMode(Animation.REVERSE);
                this.image.startAnimation(intent2);
                break;
            case R.id.move:
                TranslateAnimation intent1 = new TranslateAnimation(-50, 50, 0, 0);
                intent1.setDuration(1000);
                intent1.setRepeatCount(Animation.INFINITE);
                intent1.setRepeatMode(Animation.REVERSE);
                this.image.startAnimation(intent1);
                break;
            case R.id.change:
                intent = new Intent(this, MainActivity2.class);
                this.startActivity(intent);
                this.overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
                break;
            case R.id.layout:
                intent = new Intent(MainActivity.this, ListActivity.class);
                this.startActivity(intent);
                break;
            case R.id.frame:
                this.image.setImageResource(R.drawable.anim_list);
        }

    }
}

