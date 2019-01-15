package com.example.mehed.heterogeneousrecyclerview.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mehed.heterogeneousrecyclerview.R;
import com.example.mehed.heterogeneousrecyclerview.models.Car;

import java.util.ArrayList;


public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHoder> {

    private Context context;
    private ArrayList<Car> carArrayList;


    public CarAdapter(Context context, ArrayList<Car> carArrayList) {
        this.context = context;
        this.carArrayList = carArrayList;
    }

    @NonNull
    @Override
    public CarViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =LayoutInflater.from(context).inflate(R.layout.car_single_row, viewGroup, false);
        return new CarViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHoder carViewHoder, int i) {
        carViewHoder.carImage.setImageResource(carArrayList.get(i).getCarImage());
        carViewHoder.carName.setText(carArrayList.get(i).getName());
        carViewHoder.carCompanany.setText(carArrayList.get(i).getCompanyName());
    }

    @Override
    public int getItemCount() {
        return carArrayList.size();
    }

    static class CarViewHoder extends RecyclerView.ViewHolder {
        ImageView carImage;
        TextView carName;
        TextView carCompanany;

        CarViewHoder(@NonNull View itemView) {
            super(itemView);
            carImage=itemView.findViewById(R.id.ivbmw);
            carName=itemView.findViewById(R.id.tvBmw);
            carCompanany=itemView.findViewById(R.id.tvCompanany);
        }
        public interface onClickListener{
            public void Onclick();
        }
    }
}


