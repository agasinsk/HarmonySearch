package com.blag.harmonysearch.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Comparator;

/**
 * Represents single problem solution (e.g. a vector of x)
 */
@AllArgsConstructor
@Getter
public class Solution {

    private double[] arguments;
    private double value;
}


class SolutionValueComparator implements Comparator<Solution> {

    @Override
    public int compare(Solution a, Solution b) {
        return a.getValue() < b.getValue() ? -1 : a.getValue() == b.getValue() ? 0 : 1;
    }
}