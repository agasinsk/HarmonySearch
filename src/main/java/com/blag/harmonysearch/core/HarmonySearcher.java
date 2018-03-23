package com.blag.harmonysearch.core;

import lombok.Getter;
import lombok.Setter;
import org.mariuszgromada.math.mxparser.Function;

import java.util.ArrayList;
import java.util.List;

import static com.blag.harmonysearch.contants.HarmonySearchConstants.DEFAULT_ARGUMENT_LIMIT;

/**
 * Implements harmony search algorithm
 */
@Getter
@Setter
public class HarmonySearcher
{
    private final long maxImprovisationCount;
    private final double harmonyMemoryConsiderationRatio;
    private final double pitchAdjustmentRatio;

    private HarmonyMemory harmonyMemory;
    private Function function;

    private SolutionGenerator solutionGenerator;
    private int improvisationCount;

    public HarmonySearcher(Function function, int harmonyMemorySize, long maxImprovisationCount, double harmonyMemoryConsiderationRatio, double pitchAdjustmentRatio)
    {
        this.maxImprovisationCount = maxImprovisationCount;

        this.harmonyMemoryConsiderationRatio = harmonyMemoryConsiderationRatio;
        this.pitchAdjustmentRatio = pitchAdjustmentRatio;

        this.function = function;

        harmonyMemory = new HarmonyMemory(harmonyMemorySize);
        solutionGenerator = new SolutionGenerator(function, harmonyMemory, harmonyMemoryConsiderationRatio, pitchAdjustmentRatio);
    }

    public HarmonySearcher(Function function, int harmonyMemorySize, long maxImprovisationCount, double harmonyMemoryConsiderationRatio, double pitchAdjustmentRatio, List<ArgumentLimit> argumentGenerationLimits)
    {
        this.maxImprovisationCount = maxImprovisationCount;

        this.harmonyMemoryConsiderationRatio = harmonyMemoryConsiderationRatio;
        this.pitchAdjustmentRatio = pitchAdjustmentRatio;

        this.function = function;

        harmonyMemory = new HarmonyMemory(harmonyMemorySize);
        solutionGenerator = new SolutionGenerator(function, harmonyMemory, argumentGenerationLimits, harmonyMemoryConsiderationRatio, pitchAdjustmentRatio);
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
     * Looks for optimal solution of function
     */
    public Solution searchForHarmony()
    {
        initializeHarmonyMemory();

        improvisationCount = 0;

        while (searchingShouldContinue())
        {
            Solution worstSolution = harmonyMemory.getWorstSolution();
            Solution newSolution = solutionGenerator.improviseNewSolution();

            if (newSolution.isBetterThan(worstSolution))
            {
                harmonyMemory.swapWithWorstSolution(newSolution);
            }
            improvisationCount++;
        }
        return harmonyMemory.getBestSolution();
    }

    private boolean searchingShouldContinue()
    {
        return improvisationCount < maxImprovisationCount;
    }
}
