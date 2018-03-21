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
public class HarmonySearcher {

    private final long maxImprovisationCount;

    private final double harmonyMemoryConsiderationRatio;
    private final double pitchAdjustmentRatio;

    private HarmonyMemory harmonyMemory;
    private Function function;

    private List<ArgumentLimit> argumentGenerationLimits;
    private SolutionGenerator solutionGenerator;

    public HarmonySearcher(Function function, List<ArgumentLimit> argumentGenerationLimits, int harmonyMemorySize, long maxImprovisationCount, double harmonyMemoryConsiderationRatio, double pitchAdjustmentRatio){

        this.maxImprovisationCount = maxImprovisationCount;

        this.harmonyMemoryConsiderationRatio = harmonyMemoryConsiderationRatio;
        this.pitchAdjustmentRatio = pitchAdjustmentRatio;

        this.function = function;
        this.argumentGenerationLimits = argumentGenerationLimits;

        harmonyMemory = new HarmonyMemory(harmonyMemorySize);
        solutionGenerator = new SolutionGenerator(function, argumentGenerationLimits);
    }

    /**
     * Initializes harmony memory with random solutions
     */
    private void initializeHarmonyMemory()
    {
        for (int i = 0; i < function.getArgumentsNumber(); i++) {
            Solution randomSolution = solutionGenerator.generateRandomSolution();
            harmonyMemory.add(randomSolution);
        }
    }

    /**
     * Looks for optimal solution of function
     */
    public Solution searchForHarmony() {

        initializeHarmonyMemory();

        return null;
    }
}
