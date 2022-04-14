package com.company.Motocycles.Honda;

import com.company.Motocycles.IHarleyDavidson;
import com.company.Motocycles.IYamaha;

public class TurismoMotocyclesFactory implements IMotocycles {
    @Override
    public IHonda getHonda() {
        return new TurismoHonda();
    }

    @Override
    public IYamaha getYamaha() {
        return new TurismoYamaha();
    }

    @Override
    public IHarleyDavidson getHarleyDavidson() {
        return new TurismoHarley();
    }
}
