package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Animation topanim, bottomanim;
    ImageView image;
    TextView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        topanim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        image = findViewById(R.id.imageView);
        logo = findViewById(R.id.textView);

        image.setAnimation(topanim);
        logo.setAnimation(bottomanim);

        int SPLASH_SCREEN = 1000;
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, Loginpage.class);

            Pair[] pairs = new Pair[2];
            pairs[0] = new Pair<>(image, "logo_image");
            pairs[1] = new Pair<>(logo, "logo_text");

            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, pairs);
            startActivity(intent, options.toBundle());
            finish();
        }, SPLASH_SCREEN);
    }
}
