package com.example.units_calculator;

import java.util.Map;
import java.util.Set;

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
}
