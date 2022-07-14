package com.example.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    ArrayList<Landmark> landmarkArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        ////////////////////////////////////////
        //Data
        landmarkArrayList = new ArrayList<>();
        Landmark pisa = new Landmark("Pisa" , "Italy" , R.drawable.pisa);
        Landmark eiffel = new Landmark("Eifell" , "France" , R.drawable.eiffel);
        Landmark colleseum = new Landmark("Colleseum" , "Italy" , R.drawable.colesseo);
        Landmark londonBridge = new Landmark("London Bridge" , "Uk" , R.drawable.londonbridge);
        landmarkArrayList.add(pisa);
        landmarkArrayList.add(eiffel);
        landmarkArrayList.add(colleseum);
        landmarkArrayList.add(londonBridge);
        binding.recylerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landmarkArrayList);
        binding.recylerView.setAdapter(landmarkAdapter);
        ///////////////////////////////////////
        /*
        ArrayAdapter arrayAdapter = new ArrayAdapter(this ,
                android.R.layout.simple_list_item_1 ,
                landmarkArrayList.stream().map(landmark -> landmark.name).collect(Collectors.toList())
        );
        binding.listView.setAdapter(arrayAdapter);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this , DetailsActivity.class);
                intent.putExtra("landmark" , landmarkArrayList.get(position));
                startActivity(intent);
            }
        });*/
    }
}