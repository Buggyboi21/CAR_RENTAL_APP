package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Loginpage extends AppCompatActivity {
    ImageView image;
    EditText username,password;
    TextView logoText;

    Button callSignUp,login_btn;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loginpage);
        //Hooks
        callSignUp = findViewById(R.id.signUpBtn);
        image = findViewById(R.id.logo_image);
        logoText = findViewById(R.id.logo_name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login_btn = findViewById(R.id.login_btn);


        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Loginpage.this, Sginup.class);
                Pair[] pairs = new Pair[7];
                pairs[0] = new Pair<View, String>(image, "logo_image");
                pairs[1] = new Pair<View, String>(logoText, "logo_text");
                pairs[2] = new Pair<View, String>(username, "username_tran");
                pairs[3] = new Pair<View, String>(password, "password_tran");
                pairs[4] = new Pair<View, String>(login_btn, "button_tran");
                pairs[5] = new Pair<View, String>(callSignUp, "login_signup_tran");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Loginpage.this, pairs);
                    startActivity(intent, options.toBundle());
                }
            }
        });
    }
    }
