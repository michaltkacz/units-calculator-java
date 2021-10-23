package com.example.units_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class CalculationActivity extends AppCompatActivity {

    private String defaultValue;
    private double value = 0;
    private HashMap<String,EditText> editTextArray;
    private UnitCalculator unitCalculator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        unitCalculator = new UnitCalculator(UnitMapCollections.getCurrentUnitKind());
        setContentView(R.layout.activity_calculation);
        AddTitle();
        AddLayoutsPerUnit();

    }

    private void AddTitle() {
        TextView textView = (TextView) findViewById(R.id.Title);
        textView.setText(UnitMapCollections.getTitle());
        textView.invalidate();
    }

    private void UpdateAllTextEdits(){
        for (Map.Entry<String,EditText> unit : editTextArray.entrySet()){
            if(!unit.getValue().hasFocus())
                unit.getValue().setText(String.valueOf(unitCalculator.Calculate(value,defaultValue, String.valueOf(unit.getKey()))));
        }
    }

    private void AddListenerToEditText(EditText editText,String unit){
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (editText.hasFocus()) {
                    value = unitCalculator.Calculate(Double.parseDouble(String.valueOf(editText.getText())),unit,defaultValue);
                    UpdateAllTextEdits();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void AddLayoutsPerUnit(){
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.CalculationLayout);
        editTextArray = new HashMap<String,EditText>();
        if(linearLayout == null)
            return;

        for (Map.Entry<String,Double> unit : UnitMapCollections.getCurrentUnitKind().entrySet()) {
            if(unit.getValue() == 1){
                defaultValue = unit.getKey();
            }
            LinearLayout newUnitLayout = new LinearLayout(this);
            newUnitLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            EditText editText = new EditText(this);
            editText.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT,0.8f));
            editText.setMinHeight(48);
            editText.setTextSize(18);
            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
            editText.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            editText.setText(String.valueOf(value));
            editTextArray.put(unit.getKey(),editText);
            AddListenerToEditText(editText,unit.getKey());
            newUnitLayout.addView(editText);

            TextView titleView = new TextView(this);
            titleView.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT,0.2f));
            titleView.setTextSize(20);
            titleView.setText(unit.getKey());
            titleView.setGravity(Gravity.CENTER_VERTICAL);
            newUnitLayout.addView(titleView);

            linearLayout.addView(newUnitLayout);
        }
        linearLayout.invalidate();
    }
}
