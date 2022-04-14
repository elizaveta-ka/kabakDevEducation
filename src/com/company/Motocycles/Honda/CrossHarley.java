package com.company.Motocycles.Honda;

import com.company.Motocycles.IHarleyDavidson;

public class CrossHarley implements IHarleyDavidson {
    @Override
    public void drive() {
        System.out.println("Harley cross");
    }
}
