package com.example.myapplication;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity3 extends AppCompatActivity {
    ListView lsvCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lsvCar = findViewById(R.id.lsvCar);

        ArrayList<Car> arr= new ArrayList<>();

        Random r = new Random();

        arr.add(new Car(R.drawable.corolla,r.nextInt(10)*1,"Corolla"));
        arr.add(new Car(R.drawable.civic,r.nextInt(10)*1,"Civic"));
        arr.add(new Car(R.drawable.cultus,r.nextInt(10)*1,"Cultus"));
        arr.add(new Car(R.drawable.alto,r.nextInt(10)*1,"Alto"));
        arr.add(new Car(R.drawable.hiace,r.nextInt(10)*1,"Hiace"));
        arr.add(new Car(R.drawable.bmwm2,r.nextInt(10)*1,"BMW M2 Series"));
        arr.add(new Car(R.drawable.swift,r.nextInt(10)*1,"Swift"));
        arr.add(new Car(R.drawable.cruiser,r.nextInt(10)*1,"Cruiser-V8"));
        arr.add(new Car(R.drawable.prado,r.nextInt(10)*1,"Prado"));
        arr.add(new Car(R.drawable.revo,r.nextInt(10)*1,"Hilux Revo"));


        CarAdapter adapter =  new CarAdapter(this, 0,arr);
        lsvCar.setAdapter(adapter);
    }
}