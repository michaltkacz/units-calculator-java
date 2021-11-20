package com.example.units_calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class UnitCalculator implements IUnitCalculator{

    private Map<String, Double> m_unitMap;

    UnitCalculator(Map<String, Double> dictionary){
        this.m_unitMap = dictionary;
    }


    @Override
    public Set<String> GetUnits() {
        return m_unitMap.keySet();
    }

    @Override
    public double Calculate(double value, String oldUnitKey, String newUnitKey) {
        return value*m_unitMap.get(oldUnitKey)/ m_unitMap.get(newUnitKey);
    }

    public double CalculateTemp(double value, String oldUnitKey, String newUnitKey){
        switch(oldUnitKey+newUnitKey) {
            case "FK":
                return FahrenheitToKelvin(value);
            case "KF":
                return KelvinToFahrenheit(value);
            case "CF":
                return CelsiusToFahrenheit(value);
            case "FC":
                return FahrenheitToCelsius(value);
            case "KC":
                return KelvinToCelsius(value);
            case "CK":
                return CelsiusToKelvin(value);
        }
        return value;
    }
    private double CelsiusToKelvin(double value){
        return value + 273.15;
    }
    private double KelvinToCelsius(double value){
        return value - 273.15;
    }
    private double CelsiusToFahrenheit(double value){
        return value * 9/5 + 32;
    }
    private double FahrenheitToCelsius(double value){
        return (value-32) * 5/9;
    }
    private double KelvinToFahrenheit(double value){
        return CelsiusToFahrenheit(KelvinToCelsius(value));
    }
    private double FahrenheitToKelvin(double value){
        return FahrenheitToCelsius(CelsiusToKelvin(value));
    }
}
