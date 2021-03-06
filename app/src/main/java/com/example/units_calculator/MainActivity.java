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
        UnitMapCollections.setTitle("Length");
        StartNewView(view);
    }

    public void GoToAreaView(View view) {
        UnitMapCollections.setCurrentUnitKind(UnitMapCollections.areaUnitDictionary);
        UnitMapCollections.setTitle("Area");
        StartNewView(view);
    }

    public void GoToVolumeView(View view) {
        UnitMapCollections.setCurrentUnitKind(UnitMapCollections.volumeUnitDictionary);
        UnitMapCollections.setTitle("Volume");
        StartNewView(view);
    }

    public void GoToMassView(View view) {
        UnitMapCollections.setCurrentUnitKind(UnitMapCollections.massUnitDictionary);
        UnitMapCollections.setTitle("Mass");
        StartNewView(view);
    }

    public void GoToSpeedView(View view) {
        UnitMapCollections.setCurrentUnitKind(UnitMapCollections.speedUnitDictionary);
        UnitMapCollections.setTitle("Speed");
        StartNewView(view);
    }

    public void GoToTimeView(View view) {
        UnitMapCollections.setCurrentUnitKind(UnitMapCollections.timeUnitDictionary);
        UnitMapCollections.setTitle("Time");
        StartNewView(view);
    }
    public void GoToTemperatureView(View view) {
        UnitMapCollections.setCurrentUnitKind(UnitMapCollections.temperatureUnitDictionary);
        UnitMapCollections.setTitle("Temperature");
        StartNewView(view);
    }
    public void StartNewView(View view){
        Intent intent = new Intent(this, CalculationActivity.class);
        startActivity(intent);
    }
}