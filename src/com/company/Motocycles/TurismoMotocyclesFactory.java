package com.company.Motocycles;

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
