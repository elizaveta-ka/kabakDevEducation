package com.company.Motocycles.Honda;

import com.company.Motocycles.IHarleyDavidson;
import com.company.Motocycles.IYamaha;

public class SportMotocyclesFactory implements IMotocycles {
    @Override
    public IHonda getHonda() {
       return new SportHonda();
    }

    @Override
    public IYamaha getYamaha() {
        return new SportYamaha();
    }

    @Override
    public IHarleyDavidson getHarleyDavidson() {
        return new SportHarley();
    }
}
