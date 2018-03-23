package com.blag.harmonysearch.core;

import lombok.Getter;

import java.util.Comparator;

/**
 * Represents single problem solution (e.g. a vector of x)
 */
@Getter
class Solution
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


class SolutionValueComparator implements Comparator<Solution>
{
    @Override
    public int compare(Solution first, Solution other)
    {
        return Double.compare(first.getValue(), other.getValue());
    }
}