package com.example.units_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.transition.platform.SlideDistanceProvider;

import java.util.HashMap;
import java.util.Map;

public class CalculationActivity extends AppCompatActivity {

    private String defaultUnit;
    private String selectedUnit;
    private Spinner spinner;
    private EditText editText;
    private double value = 0;
    private HashMap<String,TextView> editTextArray;
    private UnitCalculator unitCalculator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        unitCalculator = new UnitCalculator(UnitMapCollections.getCurrentUnitKind());
        setContentView(R.layout.activity_calculation);
        AddTitle();
        AddLayoutsPerUnit();

    }

    public void GoToMainPage(View view){
        finish();
    }
    private void AddTitle() {
        TextView textView = (TextView) findViewById(R.id.Title);
        textView.setText(UnitMapCollections.getTitle());
        textView.invalidate();
    }

    private void UpdateAllTextValues(){
        for (Map.Entry<String,TextView> unit : editTextArray.entrySet()){
            unit.getValue().setText(String.format("%.8f",CalculateNewValue(value,defaultUnit, String.valueOf(unit.getKey()))));
        }
    }

    private double CalculateNewValue(double currentValue,String oldValue, String newValue){
        if(UnitMapCollections.getTitle() == "Temperature")
            return unitCalculator.CalculateTemp(currentValue,oldValue,newValue);

        return unitCalculator.Calculate(currentValue,oldValue,newValue);
    }

    private void AddListenerToSpinner(Spinner spinner){
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                selectedUnit = UnitMapCollections.getCurrentUnitKind().keySet().toArray()[position].toString();
                try {
                     value = CalculateNewValue(Double.parseDouble(String.valueOf(editText.getText())),selectedUnit,defaultUnit);

                } catch (Exception e) {
                    value = 0;
                    System.out.println(e.getMessage());
                }
                UpdateAllTextValues();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                return;
            }
        });
    }

    private void AddListenerToEditText(EditText editText){
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    value = CalculateNewValue(Double.parseDouble(String.valueOf(editText.getText())),selectedUnit,defaultUnit);
                } catch (Exception e) {
                    value = 0;
                    System.out.println(e.getMessage());
                }
                UpdateAllTextValues();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void AddLayoutsPerUnit(){
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.CalculationLayout);
        editTextArray = new HashMap<String,TextView>();

        spinner = (Spinner)findViewById(R.id.spinner);
        AddListenerToSpinner(spinner);
        spinner.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,UnitMapCollections.getCurrentUnitKind().keySet().toArray()));
        editText = (EditText) findViewById(R.id.editUnitText);
        AddListenerToEditText(editText);

        if(linearLayout == null)
            return;

        for (Map.Entry<String,Double> unit : UnitMapCollections.getCurrentUnitKind().entrySet()) {
            if(unit.getValue() == 1){
                defaultUnit = unit.getKey();
            }
            LinearLayout newUnitLayout = new LinearLayout(this);
            newUnitLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            TextView valueView = new MyUnitTextValue(this, String.valueOf(value));
            editTextArray.put(unit.getKey(),valueView);
            newUnitLayout.addView(valueView);

            TextView unitView = new MyUnitTextView(this,unit.getKey());
            unitView.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT,0.3f));
            newUnitLayout.addView(unitView);

            linearLayout.addView(newUnitLayout);
        }
        linearLayout.invalidate();
    }
}
