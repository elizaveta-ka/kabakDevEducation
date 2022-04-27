package com.company.Motocycles;

public class CrossMotocyclesFactory implements IMotocycles {
    @Override
    public IHonda getHonda() {
        return new CrossHonda();
    }

    @Override
    public IYamaha getYamaha() {
        return new CrossYamaha();
    }

    @Override
    public IHarleyDavidson getHarleyDavidson() {
        return new CrossHarley();
    }
}
