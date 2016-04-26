package com.wudayu.demo.animationset;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView ivDota = null;
    boolean animating = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ivDota = (ImageView) findViewById(R.id.iv_dota);

        // 无限旋转
        findViewById(R.id.btn_infinity_rotation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (animating) {
                    ivDota.clearAnimation();
                    animating = false;
                    return;
                }

                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.infinity_rotation);
                // 是否匀速旋转
//                LinearInterpolator liInter = new LinearInterpolator();
//                anim.setInterpolator(liInter);
                ivDota.startAnimation(anim);

                animating = true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
