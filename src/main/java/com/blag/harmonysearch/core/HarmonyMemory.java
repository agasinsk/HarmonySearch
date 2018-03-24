package com.blag.harmonysearch.core;

import com.blag.harmonysearch.helpers.BoundedTreeSet;
import lombok.Getter;
import lombok.Setter;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Stores best solutions for harmony search algorithm
 */
@Getter
@Setter
class HarmonyMemory
{
    private BoundedTreeSet<Solution> solutions;

    HarmonyMemory(int harmonyMemorySize)
    {
        solutions = new BoundedTreeSet<>(harmonyMemorySize, new SolutionValueComparator());
    }

    Solution getBestSolution()
    {
        return solutions.first();
    }

    Solution getWorstSolution()
    {
        return solutions.last();
    }

    void clear()
    {
        solutions.clear();
    }

    boolean add(Solution solution)
    {
        return solutions.add(solution);
    }

    int getSize()
    {
        return solutions.size();
    }

    int getMaxCapacity()
    {
        return solutions.getCapacity();
    }

    void swapWithWorstSolution(Solution solution)
    {
        Solution worstSolution = getWorstSolution();
        solutions.remove(worstSolution);
        solutions.add(solution);
    }

    boolean contains(Solution solution)
    {
        return solutions.contains(solution);
    }

    List<Double> getArgumentsByIndex(int argumentIndex)
    {
        return solutions.stream().map(s -> s.getArgument(argumentIndex)).collect(Collectors.toList());
    }

    double getRandomArgumentByIndex(int argumentIndex)
    {
        Optional<Double> randomArgument = solutions.stream().map(s -> s.getArgument(argumentIndex)).findAny();
        return randomArgument.orElseGet(() -> (double) 0);
    }
}
