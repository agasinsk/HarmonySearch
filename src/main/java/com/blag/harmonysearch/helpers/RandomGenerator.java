package com.blag.harmonysearch.helpers;

import com.blag.harmonysearch.core.ArgumentLimit;

import java.util.Random;

public class RandomGenerator extends Random{

    public double nextBoundedDouble(ArgumentLimit limit) {
        return nextBoundedDouble(limit.getOrigin(), limit.getBound());
    }

    private double nextBoundedDouble(double origin, double bound) {
        double r = nextDouble();
        r = r * (bound - origin) + origin;
        if (r >= bound) // correct for rounding
            r = Math.nextDown(bound);
        return r;
    }
}
