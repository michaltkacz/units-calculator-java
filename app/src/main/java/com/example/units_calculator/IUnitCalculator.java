package com.example.units_calculator;

import java.util.Set;

public interface IUnitCalculator {
    Set<String> GetUnits();
    double Calculate(double value, String oldUnitKey, String newUnitKey);
}
