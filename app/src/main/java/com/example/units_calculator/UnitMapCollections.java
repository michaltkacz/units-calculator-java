package com.example.units_calculator;

import java.util.HashMap;
import java.util.Map;

public class UnitMapCollections {

    private static HashMap<String, Double> currentSelectedUnit;

    public static HashMap<String,Double> getCurrentUnitKind(){
        return currentSelectedUnit;
    }

    public static void setCurrentUnitKind(HashMap<String,Double> unitKind){
        currentSelectedUnit = unitKind;
    }

    public static HashMap<String,Double> lengthUnitDictionary = new HashMap<String,Double>() {
        {
            put("km", 1000.0);
            put("m", 1.0);
            put("cm", 0.01);
            put("mm", 0.001);
            put("μm", 0.0000001);
            put("nm", 0.0000000001);
            put("Mile", 1609.34);
            put("Yard", 0.9144);
            put("Foot", 0.3048);
            put("Inch", 0.0254);

        }
    };
    public static HashMap<String,Double> massUnitDictionary = new HashMap<String,Double>() {
        {
            put("ton", 1000000.0);
            put("kg", 1000.0);
            put("g", 1.0);
            put("mg", 0.001);
            put("μg", 0.0000001);
            put("US ton", 907185.0);
            put("Stone", 6350.29);
            put("Pound", 453.592);
            put("Ounce", 28.3495);

        }
    };
    public static HashMap<String,Double> speedUnitDictionary = new HashMap<String,Double>() {
        {
            put("m/s", 1.0);
            put("miles/h", 0.44704);
            put("km/h", 0.277778);
            put("foot/s", 0.30480024384);
            put("knot", 0.514444855556);
        }
    };
    public static HashMap<String,Double> volumeUnitDictionary = new HashMap<String,Double>() {
        {
            put("l", 1.0);
            put("Cubic km", 1000000000000.0);
            put("Cubic m", 1000.0);
            put("Cubic dm", 1.0);
            put("Cubic cm", 0.001);
            put("ml", 0.001);
            put("Gallon", 3.78541);
            put("Quart", 0.9463525);
            put("Pint", 0.47317625);
            put("Cup", 0.236588125);
        }
    };

    public static HashMap<String,Double> timeUnitDictionary = new HashMap<String,Double>() {
        {
            put("s", 1.0);
            put("ms", 0.0001);
            put("μs", 0.0000001);
            put("ns", 1.0000000001);
            put("Min", 60.0);
            put("Hour", 3600.0);
            put("Day", 86400.0);
            put("Week", 604800.0);
            put("Month", 2629800.0);
            put("Month", 31557600.0);
        }
    };

    public static HashMap<String,Double> areaUnitDictionary = new HashMap<String,Double>() {
        {
            put("Square m", 1.0);
            put("Square km", 1000000.0);
            put("Are", 100.0);
            put("Acre", 4046.86);
            put("Hectare", 10000.0);
            put("Square mile",  2589990.0);
            put("Square yard",  0.836127);
            put("Square foot",  0.092903);
            put("Square inch",  0.00064516);
        }
    };
}
