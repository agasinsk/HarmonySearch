package com.blag.harmonysearch.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.mariuszgromada.math.mxparser.Function;

import java.util.List;

/**
 * Implements harmony search algorithm
 */
@AllArgsConstructor
@Getter
@Setter
public class HarmonySearcher {

    private final long maxImprovisationCount;

    private final double harmonyMemoryConsiderationRatio;
    private final double pitchAdjustmentRatio;

    private HarmonyMemory harmonyMemory;
    private Function function;

    public HarmonySearcher(int harmonyMemorySize, long maxImprovisationCount, double harmonyMemoryConsiderationRatio, double pitchAdjustmentRatio){

        this.maxImprovisationCount = maxImprovisationCount;

        this.harmonyMemoryConsiderationRatio = harmonyMemoryConsiderationRatio;
        this.pitchAdjustmentRatio = pitchAdjustmentRatio;

        harmonyMemory = new HarmonyMemory(harmonyMemorySize);
    }

    /**
     * Initializes harmony memory with random solutions
     */
    public void initializeHarmonyMemory(List<ArgumentLimit> argumentGenerationLimits)
    {
        harmonyMemory.setSolutionDimension(function.getArgumentsNumber());
        harmonyMemory.setArgumentGenerationLimits(argumentGenerationLimits);
        harmonyMemory.initialize();
    }

    /**
     * Calculates solution for provided arguments
     */
    Solution calculateSolution(double... arguments){

        double functionValue = function.calculate(arguments);
        return new Solution(arguments, functionValue);
    }


    public Solution search() {
        return null;
    }
}
