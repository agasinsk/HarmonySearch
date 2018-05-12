package com.blag.harmonysearch.core;

import lombok.Getter;

/**
 * Represents single problem solution (arguments and corresponding function value)
 */
@Getter
public class Solution
{
    private double[] arguments;
    private double value;

    public Solution(double value, double... arguments)
    {
        this.value = value;
        this.arguments = arguments;
    }

    public boolean isBetterThan(Solution otherSolution)
    {
        return getValue() < otherSolution.getValue();
    }

    double getArgument(int argumentIndex)
    {
        if (argumentIndex > arguments.length)
        {
            throw new ArrayIndexOutOfBoundsException();
        }

        return arguments[argumentIndex];
    }
}