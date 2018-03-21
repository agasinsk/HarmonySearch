package com.blag.harmonysearch.core;

import com.blag.harmonysearch.helpers.BoundedTreeSet;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

/**
 * Stores best solutions for harmony search algorithm
 */
@Getter
@Setter
public class HarmonyMemory {

    private int solutionDimension;
    private SortedSet<Solution> solutions;
    private List<ArgumentLimit> argumentGenerationLimits;
    private Random randomGenerator;

    public HarmonyMemory(int harmonyMemorySize){

        solutions = new TreeSet<>(new SolutionValueComparator());
        randomGenerator = new Random();
    }

    public HarmonyMemory(int harmonyMemorySize, List<ArgumentLimit> argumentGenerationLimits){

        this.argumentGenerationLimits = argumentGenerationLimits;
        solutions = new BoundedTreeSet<>(harmonyMemorySize, new SolutionValueComparator());
        randomGenerator = new Random();
    }

    /**
     * Initializes harmony memory by generating random solutions
     */
    public void initialize(){

        List<Double> randomArguments = new ArrayList<>(solutionDimension);

        for (int i = 0; i < solutionDimension; i++) {
            double randomArgument = nextBoundedDouble(argumentGenerationLimits.get(i));
            randomArguments.add(randomArgument);
        }

        Solution solution = new Solution(randomArguments, );

        solutions.add(solution);
    }

    public Solution getBestSolution()
    {
        return solutions.first();
    }

    public Solution getWorstSolution()
    {
        return solutions.last();
    }

    public void clear(){
        solutions.clear();
    }

    private double nextBoundedDouble(ArgumentLimit limit) {
        return nextBoundedDouble(limit.getOrigin(), limit.getBound());
    }

    private double nextBoundedDouble(double origin, double bound) {
        double r = randomGenerator.nextDouble();
        r = r * (bound - origin) + origin;
        if (r >= bound) // correct for rounding
            r = Math.nextDown(bound);
        return r;
    }
}
