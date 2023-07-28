package com.example.aksubmobilepertemuan5.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.aksubmobilepertemuan5.R;
import com.example.aksubmobilepertemuan5.fragments.CharactersFragment;
import com.example.aksubmobilepertemuan5.fragments.FavoritesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navbar);
        initBottomNavigationView();
    }

    private void initBottomNavigationView(){
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.characters:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new CharactersFragment()).commit();
                    return true;

                case R.id.favorites:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new FavoritesFragment()).commit();
                    return true;
            }
            return false;
        });
        bottomNavigationView.setSelectedItemId(R.id.characters);
    }
}