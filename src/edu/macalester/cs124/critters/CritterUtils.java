package edu.macalester.cs124.critters;

public final class CritterUtils {
    
    /**
     * Weighted average: w=1 returns a; w=0 returns b.
     */
    public static double blend(double a, double b, double w) {
        return a * w + b * (1-w);
    }

}
