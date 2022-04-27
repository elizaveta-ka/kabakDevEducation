package com.company.Motocycles;

public class Main {
    public static void main(String[] args) {
        IMotocycles moto = getFactoryByTypeOfMotocycles("Sport");
        IHonda honda = moto.getHonda();
        IYamaha yamaha = moto.getYamaha();
        IHarleyDavidson harley = moto.getHarleyDavidson();
        honda.drive();
        yamaha.drive();
        harley.drive();
    }

    private static IMotocycles getFactoryByTypeOfMotocycles(String typeOfMotocycles) {
        switch (typeOfMotocycles) {
            case "Sport":
                return new SportMotocyclesFactory();
            case "Cross":
                return new CrossMotocyclesFactory();
            case "Turismo":
                return new TurismoMotocyclesFactory();
            default:
                throw new RuntimeException("Unknown type " + typeOfMotocycles);
        }
    }
}
