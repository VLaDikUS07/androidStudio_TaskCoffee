package com.example.practiccoffee;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practiccoffee.databinding.ActivityMainscreenBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainscreenBinding binding;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainscreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new MainScreen());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.home) {
                replaceFragment(new MainScreen());
            }
            else if(item.getItemId() == R.id.heart){
                replaceFragment(new SecondActivity());
            }
            else if(item.getItemId() == R.id.bag){
                replaceFragment(new ThirdActivity());
            }
            else if(item.getItemId() == R.id.notification){
                replaceFragment(new FourthActivity());
            }

            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}