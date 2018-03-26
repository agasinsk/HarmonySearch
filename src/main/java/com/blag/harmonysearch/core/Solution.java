package com.blag.harmonysearch.core;

import lombok.Getter;

import java.util.Comparator;

/**
 * Represents single problem solution (arguments and corresponding function value)
 */
@Getter
public class Solution
{
    private double[] arguments;
    private double value;

    Solution(double value, double... arguments)
    {
        this.value = value;
        this.arguments = arguments;
    }

    boolean isBetterThan(Solution otherSolution)
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