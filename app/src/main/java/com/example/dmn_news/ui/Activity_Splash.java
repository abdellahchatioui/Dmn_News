package com.example.dmn_news.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.dmn_news.MainActivity;
import com.example.dmn_news.R;

public class Activity_Splash extends AppCompatActivity {
    private static final int SPLASH_DURATION = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        // Hide Action Bar
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        // Logo Animation
        ImageView logo = findViewById(R.id.imgLogo);

        logo.setAlpha(0f);
        logo.animate()
                .alpha(1f)
                .setDuration(3000)
                .start();

        // Delay Before Moving to Home
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent intent = new Intent(Activity_Splash.this, HomeActivity.class);
            startActivity(intent);
            finish();
        },SPLASH_DURATION);

    }


}