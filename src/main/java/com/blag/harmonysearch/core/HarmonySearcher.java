package com.blag.harmonysearch.core;

import lombok.Getter;
import lombok.Setter;
import org.mariuszgromada.math.mxparser.Function;

import java.util.List;

/**
 * Implements harmony search algorithm
 */
@Getter
@Setter
public class HarmonySearcher
{
    private final long maxImprovisationCount;

    private HarmonyMemory harmonyMemory;
    private Function function;

    private SolutionGenerator solutionGenerator;
    private int improvisationCount;
    private Solution currentBestSolution;

    public HarmonySearcher(Function function, int harmonyMemorySize, long maxImprovisationCount, double harmonyMemoryConsiderationRatio, double pitchAdjustmentRatio)
    {
        this.maxImprovisationCount = maxImprovisationCount;

        this.function = function;

        harmonyMemory = new HarmonyMemory(harmonyMemorySize);
        solutionGenerator = new SolutionGenerator(function, harmonyMemory, harmonyMemoryConsiderationRatio, pitchAdjustmentRatio);
    }

    public HarmonySearcher(Function function, int harmonyMemorySize, long maxImprovisationCount, double harmonyMemoryConsiderationRatio, double pitchAdjustmentRatio, List<ArgumentLimit> argumentGenerationLimits)
    {
        this.maxImprovisationCount = maxImprovisationCount;

        this.function = function;

        harmonyMemory = new HarmonyMemory(harmonyMemorySize);
        solutionGenerator = new SolutionGenerator(function, harmonyMemory, argumentGenerationLimits, harmonyMemoryConsiderationRatio, pitchAdjustmentRatio);
    }

    public double getHarmonyMemoryConsiderationRatio()
    {
        return solutionGenerator.getHarmonyMemoryConsiderationRatio();
    }

    public double getPitchAdjustmentRatio()
    {
        return solutionGenerator.getPitchAdjustmentRatio();
    }

    /**
     * Looks for optimal solution of  function
     */
    public Solution searchForHarmony()
    {
        initializeHarmonyMemory();

        improvisationCount = 0;
        while (searchingShouldContinue())
        {
            Solution worstSolution = harmonyMemory.getWorstSolution();
            Solution newSolution = solutionGenerator.improviseSolution();

            if (newSolution.isBetterThan(worstSolution))
            {
                harmonyMemory.swapWithWorstSolution(newSolution);
            }
            currentBestSolution = harmonyMemory.getBestSolution();
            improvisationCount++;
        }
        return harmonyMemory.getBestSolution();
    }

    /**
     * Initializes harmony memory with random solutions
     */
    void initializeHarmonyMemory()
    {
        for (int i = 0; i < harmonyMemory.getMaxCapacity(); i++)
        {
            Solution randomSolution = solutionGenerator.generateRandomSolution();
            harmonyMemory.add(randomSolution);
        }
    }

    /**
     * Checks if algorithm should continue working
     */
    private boolean searchingShouldContinue()
    {
        return improvisationCount < maxImprovisationCount;
    }
}
