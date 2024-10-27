package com.mintdevspro.resumemaker;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class SplashActivity extends AppCompatActivity {

    String var;
    int check = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 5000);

    }

    private void refreshItem() {

            final Dialog dialog = new Dialog(SplashActivity.this, R.style.DialogTheme);
            dialog.setContentView(R.layout.no_internet);
            dialog.setCancelable(false);

            CardView imgRefresh = (CardView) dialog.findViewById(R.id.refresh);
            CardView imgExit = (CardView) dialog.findViewById(R.id.exit);
            ImageView imgNoInternet = (ImageView) dialog.findViewById(R.id.img);

            final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);
            imgNoInternet.startAnimation(animShake);

            imgNoInternet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgNoInternet.startAnimation(animShake);
                }
            });
            imgRefresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    refreshItem();
                    dialog.dismiss();
                }
            });
            imgExit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    finish();
                    System.exit(0);
                }
            });
            dialog.show();


    }



    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

}
