package com.company.Motocycles.Honda;

import com.company.Motocycles.IHarleyDavidson;

public class SportHarley implements IHarleyDavidson {
    @Override
    public void drive() {
        System.out.println("Harley sport");
    }
}
