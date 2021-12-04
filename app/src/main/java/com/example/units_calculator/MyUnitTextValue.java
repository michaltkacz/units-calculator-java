package com.example.units_calculator;

import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;

public class MyUnitTextValue extends androidx.appcompat.widget.AppCompatTextView {
    public MyUnitTextValue(Context context, String value) {
        super(context);
        this.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT,0.7f));
        this.setTextSize(20);
        this.setGravity(Gravity.RIGHT);
        this.setText(value);
        this.setPadding(0,0,20,0);
    }
}