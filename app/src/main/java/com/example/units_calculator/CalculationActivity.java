package com.example.units_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class CalculationActivity extends AppCompatActivity {
    private UnitCalculator m_unitCalculator;
    private Spinner currentUnit;
    private Spinner newUnit;
    private EditText valueEditText;
    private EditText newValueEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);
        m_unitCalculator = new UnitCalculator(UnitMapCollections.getCurrentUnitKind());

        currentUnit = (Spinner) findViewById(R.id.currentUnitSpinner);
        newUnit = (Spinner) findViewById(R.id.newUnitSpinner);
        valueEditText = (EditText) findViewById(R.id.editTextNumber);
        newValueEditText = (EditText) findViewById(R.id.editTextResult);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, m_unitCalculator.GetUnits().toArray(new String[0]));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currentUnit.setAdapter(adapter);
        newUnit.setAdapter(adapter);


        currentUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        newUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
        valueEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Calculate();
            }
        });
    }
    private void Calculate(){

        double x;
        try{
            x = Double.parseDouble(valueEditText.getText().toString());
        }
        catch(Exception e){
            x =0.0;
        }
        String y =currentUnit.getSelectedItem().toString();
        String j = newUnit.getSelectedItem().toString();
        newValueEditText.setText(String.valueOf(m_unitCalculator.Calculate(x,y,j)));
    }
}