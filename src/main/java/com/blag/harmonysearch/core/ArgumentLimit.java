package com.blag.harmonysearch.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.blag.harmonysearch.contants.HarmonySearchConstants.DEFAULT_ARGUMENT_LIMIT;

@AllArgsConstructor
@Getter
public class ArgumentLimit
{
    private double origin;
    private double bound;
    private String argumentName;

    public ArgumentLimit(String argumentName)
    {
        origin = -DEFAULT_ARGUMENT_LIMIT;
        bound = DEFAULT_ARGUMENT_LIMIT;
        this.argumentName = argumentName;
    }

    boolean IsWithinLimits(double number)
    {
        return origin <= number && number <= bound;
    }

    public ArgumentLimit()
    {
        origin = -DEFAULT_ARGUMENT_LIMIT;
        bound = DEFAULT_ARGUMENT_LIMIT;
    }

    public ArgumentLimit(double origin, double bound)
    {
        this.origin = origin;
        this.bound = bound;
    }
}
