package com.example.androidmessenger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import com.example.androidmessenger.buttonnavigation.chats.FragmentChats;
import com.example.androidmessenger.buttonnavigation.new_chat.FragmentNewChats;
import com.example.androidmessenger.buttonnavigation.profile.Fr4agmentProfile;
import com.example.androidmessenger.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(FirebaseAuth.getInstance().getCurrentUser()==null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
        getSupportFragmentManager().beginTransaction().replace(binding.fragmentContainer.getId(),new FragmentChats()).commit();
        binding.buttonNavigat.setSelectedItemId(R.id.chats);
        Map<Integer, Fragment> fragmentMap = new HashMap<>();
        fragmentMap.put(R.id.chats, new FragmentChats());
        fragmentMap.put(R.id.new_chat, new FragmentNewChats());
        fragmentMap.put(R.id.profile, new Fr4agmentProfile());

        binding.buttonNavigat.setOnItemSelectedListener(item -> {
            Fragment fragment = fragmentMap.get(item.getItemId());
            getSupportFragmentManager().beginTransaction().replace(binding.fragmentContainer.getId(), fragment).commit();



            return true;
        });

    }
}