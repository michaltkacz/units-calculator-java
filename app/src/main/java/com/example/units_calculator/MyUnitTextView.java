package com.example.units_calculator;

import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;


public class MyUnitTextView extends androidx.appcompat.widget.AppCompatTextView {
    public MyUnitTextView(Context context,String value) {
        super(context);
        this.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT,0.3f));
        this.setTextSize(20);
        this.setText(value);
        this.setGravity(Gravity.CENTER_VERTICAL);
    }
}

