package edu.macalester.cs124.critters;

public final class CritterUtils {
    
    public static double blend(double a, double b, double w) {
        return a * w + b * (1-w);
    }

}
