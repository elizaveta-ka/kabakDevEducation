package com.company.Motocycles;

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
