package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.net.URI;

public class choice extends AppCompatActivity {

    Button Add;
    ImageView Car_Image;
    EditText name, model, year, phone;
    private static final int PICK_IMAGE_REQUEST = 99;
    private URI imagepath;
    private Bitmap ImagetoStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        Add = findViewById(R.id.signUpBtn);
        Car_Image = findViewById(R.id.carimage);
        name = findViewById(R.id.userName);
        model = findViewById(R.id.email);
        year = findViewById(R.id.password);
        phone = findViewById(R.id.Phone);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(name.getText().toString())){
                    name.setError("Please Enter Name");
                    return;
                }
                if(TextUtils.isEmpty(model.getText().toString())){
                    model.setError("Please Enter Error");
                    return;
                }
                if(TextUtils.isEmpty(year.getText().toString())){
                    year.setError("Please Enter Year");
                    return;
                }
                if(TextUtils.isEmpty(phone.getText().toString())){
                    phone.setError("Please Enter Phone Number");
                    return;
                }
                Toast.makeText(choice.this,"Car ADDED",  Toast.LENGTH_SHORT).show();//IN THIS LINE ADD CODE TO SWITCH TO DASHBOARD ACTIVITY
            }
        });

        Car_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent iGallary = new Intent(Intent.ACTION_PICK);
                iGallary.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGallary, PICK_IMAGE_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(resultCode==RESULT_OK){

            if(requestCode==PICK_IMAGE_REQUEST){

                Car_Image.setImageURI(data.getData());
            }
        }
    }
}