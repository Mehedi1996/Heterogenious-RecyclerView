package com.example.mehed.heterogeneousrecyclerview.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mehed.heterogeneousrecyclerview.adapters.MovieAdapter;
import com.example.mehed.heterogeneousrecyclerview.models.Car;
import com.example.mehed.heterogeneousrecyclerview.models.Movie;
import com.example.mehed.heterogeneousrecyclerview.adapters.CarAdapter;
import com.example.mehed.heterogeneousrecyclerview.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MovieAdapter.MyOnClik {

    private RecyclerView recyclerView;
    private CarAdapter carAdapter;
    private MovieAdapter movieAdapter;

    private ArrayList<Car> carArrayList;
    private ArrayList<Movie> movieArrayList;

    private Button btnCar, btnMovie;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        btnCar = findViewById(R.id.btnCar);
        btnMovie = findViewById(R.id.btnMovie);

        carArrayList = new ArrayList<>();
        movieArrayList = new ArrayList<>();

        setUpUi();

    }

    private void setUpUi() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(manager);

        carArrayList.add(new Car("BMW1", "Telsa", R.drawable.bmw));
        carArrayList.add(new Car("BMW2", "Telsa", R.drawable.bmw));
        carArrayList.add(new Car("BMW3", "Telsa", R.drawable.bmw));

        movieArrayList.add(new Movie("Lagan1", "Telsa", R.drawable.thor));
        movieArrayList.add(new Movie("Lagan2", "Telsa", R.drawable.thor));
        movieArrayList.add(new Movie("Lagan2", "Telsa", R.drawable.thor));

        btnMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movieAdapter = new MovieAdapter(MainActivity.this, movieArrayList);
                recyclerView.setAdapter(movieAdapter);
                movieAdapter.setMyOnClik(MainActivity.this);
            }
        });

        btnCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carAdapter = new CarAdapter(MainActivity.this, carArrayList);
                recyclerView.setAdapter(carAdapter);
            }
        });
    }

    @Override
    public void onClick(int position) {
        Toast.makeText(this, movieArrayList.get(position).getMovieName(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, movieArrayList.get(position).getCompanyName(), Toast.LENGTH_SHORT).show();
    }
}




