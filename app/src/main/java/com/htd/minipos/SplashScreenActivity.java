package com.htd.minipos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!DetectConnection.checkInternetConnection(SplashScreenActivity.this)) {
                    AlertDialog alertDialog = new AlertDialog.Builder(SplashScreenActivity.this).create();
                    alertDialog.setTitle("Tidak ada koneksi internet");
                    alertDialog.setMessage("Cek koneksi internet anda dan coba lagi!");
                    alertDialog.setButton(DialogInterface.BUTTON_POSITIVE,"Coba Lagi" , new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            startActivity(getIntent());
                        }
                    });
                    alertDialog.setCancelable(false);
                    alertDialog.show();
                } else {
                    Intent intent = new Intent(SplashScreenActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },1000);
    }
}