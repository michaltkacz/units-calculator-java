package com.example.units_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GoToLengthView(View view) {
        UnitMapCollections.setCurrentUnitKind(UnitMapCollections.lengthUnitDictionary);
        StartNewView(view);
    }

    public void GoToAreaView(View view) {
        UnitMapCollections.setCurrentUnitKind(UnitMapCollections.areaUnitDictionary);
        StartNewView(view);
    }

    public void GoToVolumeView(View view) {
        UnitMapCollections.setCurrentUnitKind(UnitMapCollections.volumeUnitDictionary);
        StartNewView(view);
    }

    public void GoToMassView(View view) {
        UnitMapCollections.setCurrentUnitKind(UnitMapCollections.massUnitDictionary);
        StartNewView(view);
    }

    public void GoToSpeedView(View view) {
        UnitMapCollections.setCurrentUnitKind(UnitMapCollections.speedUnitDictionary);
        StartNewView(view);
    }

    public void GoToTimeView(View view) {
        UnitMapCollections.setCurrentUnitKind(UnitMapCollections.timeUnitDictionary);
        StartNewView(view);
    }
    public void StartNewView(View view){
        Intent intent = new Intent(this, CalculationActivity.class);
        startActivity(intent);
    }
}