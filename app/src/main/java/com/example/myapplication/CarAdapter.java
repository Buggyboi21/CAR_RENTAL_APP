package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CarAdapter extends ArrayAdapter<Car> {
    private Context ct;
    private ArrayList<Car> arr;

    public CarAdapter(@NonNull Context context, int resource, @NonNull List<Car> objects) {
        super(context, resource, objects);
        this.ct = context;
        this.arr = new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            LayoutInflater i = (LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = i.inflate(R.layout.awanitem_car,null);

        }
        if (arr.size()>0){
            Car c = arr.get(position);
            ImageView ImgCar = convertView.findViewById(R.id.Image);
            ImgCar.setImageResource(c.Image);
            TextView Cname = convertView.findViewById(R.id.Cname);
            Cname.setText(c.name);
            TextView yearC = convertView.findViewById(R.id.yearC);
            yearC.setText(c.numItem+ " Cars");
        }
        return convertView;
    }
}
