package com.example.units_calculator;


import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Map;

public class CalculationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);
        //AddLayoutsPerUnit();

        AddLayoutsPerUnit();
    }





    private void AddLayoutsPerUnit(){
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.CalculationLayout);
        if(linearLayout == null)
            return;

        for (Map.Entry<String,Double> unit : UnitMapCollections.getCurrentUnitKind().entrySet()) {
            LinearLayout newUnitLayout = new LinearLayout(this);
            newUnitLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 120));

            EditText editText = new EditText(this);
            editText.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT,0.8f));
            editText.setMinHeight(48);
            editText.setTextSize(20);
            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
            editText.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            newUnitLayout.addView(editText);

            TextView titleView = new TextView(this);
            titleView.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT,0.2f));
            titleView.setTextSize(20);
            titleView.setText(unit.getKey());
            newUnitLayout.addView(titleView);

            linearLayout.addView(newUnitLayout);
        }
        linearLayout.invalidate();
    }
}
