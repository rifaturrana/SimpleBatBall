package com.example.firstapplicatio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.annotation.Annotation;

public class Splash_Activity extends AppCompatActivity {
ImageView imageView;
Animation fromTop;
TextView text;
Animation fromBottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);

imageView=findViewById(R.id.imageLogo);
fromTop= AnimationUtils.loadAnimation(this,R.anim.from_top);
imageView.setAnimation(fromTop);

text=findViewById(R.id.text);
fromBottom=AnimationUtils.loadAnimation(this,R.anim.fade);
text.setAnimation(fromBottom);

        Thread timer= new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                    super.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        timer.start();
    }
}