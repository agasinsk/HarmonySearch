package com.blag.harmonysearch.core;

import java.util.Comparator;

class SolutionValueComparator implements Comparator<Solution>
{
    @Override
    public int compare(Solution first, Solution other)
    {
        return Double.compare(first.getValue(), other.getValue());
    }
}
