package com.blag.harmonysearch.core;

import com.blag.harmonysearch.helpers.RandomGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.mariuszgromada.math.mxparser.Function;

import java.util.ArrayList;
import java.util.List;

import static com.blag.harmonysearch.contants.HarmonySearchConstants.DEFAULT_ARGUMENT_LIMIT;

/**
 * Generates solutions
 */
@AllArgsConstructor
class SolutionGenerator
{
    private final double harmonyMemoryConsiderationRatio;
    private final double pitchAdjustmentRatio;
    private RandomGenerator randomGenerator = new RandomGenerator();
    private Function function;
    private HarmonyMemory harmonyMemory;

    @Setter
    @Getter
    private List<ArgumentLimit> argumentGenerationLimits;

    @Getter
    private int argumentsCount;

    SolutionGenerator(Function function, HarmonyMemory harmonyMemory, List<ArgumentLimit> argumentGenerationLimits, double harmonyMemoryConsiderationRatio, double pitchAdjustmentRatio)
    {
        this.harmonyMemoryConsiderationRatio = harmonyMemoryConsiderationRatio;
        this.pitchAdjustmentRatio = pitchAdjustmentRatio;

        this.function = function;
        this.harmonyMemory = harmonyMemory;
        this.argumentGenerationLimits = argumentGenerationLimits;
        argumentsCount = function.getArgumentsNumber();
    }

    SolutionGenerator(Function function, HarmonyMemory harmonyMemory, double harmonyMemoryConsiderationRatio, double pitchAdjustmentRatio)
    {
        this.harmonyMemoryConsiderationRatio = harmonyMemoryConsiderationRatio;
        this.pitchAdjustmentRatio = pitchAdjustmentRatio;

        this.function = function;
        this.harmonyMemory = harmonyMemory;
        this.argumentGenerationLimits = new ArrayList<>(function.getArgumentsNumber());
        for (int i = 0; i < function.getArgumentsNumber(); i++)
        {
            argumentGenerationLimits.add(new ArgumentLimit(-DEFAULT_ARGUMENT_LIMIT, DEFAULT_ARGUMENT_LIMIT));
        }

        argumentsCount = function.getArgumentsNumber();
    }

    /**
     * Generates solution from random arguments
     */
    Solution generateRandomSolution()
    {
        double[] arguments = generateRandomArguments();
        return calculateSolution(arguments);
    }

    /**
     * Generates random arguments within limits
     */
    double[] generateRandomArguments()
    {

        double[] randomArguments = new double[argumentsCount];

        for (int i = 0; i < argumentsCount; i++)
        {
            double randomArgument = randomGenerator.nextBoundedDouble(argumentGenerationLimits.get(i));
            randomArguments[i] = randomArgument;
        }

        return randomArguments;
    }

    /**
     * Calculates solution for provided arguments
     */
    Solution calculateSolution(double... arguments)
    {
        double functionValue = function.calculate(arguments);
        return new Solution(functionValue, arguments);
    }

    Solution improviseNewSolution()
    {
        double[] improvisedArguments = improviseArguments();
        return calculateSolution(improvisedArguments);
    }

    /**
     * Generates arguments based on the algorithm parameters
     */
    double[] improviseArguments()
    {
        double[] arguments = new double[argumentsCount];

        for (int i = 0; i < argumentsCount; i++)
        {
            arguments[i] = generateArgument(i);
        }

        return arguments;
    }

    /**
     * Generates arguments based on the algorithm parameters
     */
    private double generateArgument(int argumentIndex)
    {
        double randomValue = randomGenerator.nextDouble();
        ArgumentGenerationRules generationRule = establishArgumentGenerationRule(randomValue);

        switch (generationRule)
        {
            case MemoryConsidering:
                return useMemoryConsidering(argumentIndex);
            case PitchAdjusting:
                return usePitchAdjusting(argumentIndex);
            case RandomChoosing:
                return useRandomChoosing(argumentIndex);
            default:
                return 0;
        }
    }

    private double useMemoryConsidering(int argumentIndex)
    {
        int randomIndex = randomGenerator.nextInt(harmonyMemory.getMaxCapacity());
        Solution solution = harmonyMemory.getSolution(randomIndex);
        return solution.getArgument(argumentIndex);
    }

    private double usePitchAdjusting(int argumentIndex)
    {
        return 0;
    }

    private double useRandomChoosing(int argumentIndex)
    {
        ArgumentLimit limit = argumentGenerationLimits.get(argumentIndex);
        return randomGenerator.nextBoundedDouble(limit);
    }

    /**
     * Chooses argument generation rule by their probabilities
     *
     * @return Appropriate argument generation rule
     */
    ArgumentGenerationRules establishArgumentGenerationRule(double probability)
    {
        if (probability > harmonyMemoryConsiderationRatio)
        {
            return ArgumentGenerationRules.RandomChoosing;
        }
        else if (probability <= harmonyMemoryConsiderationRatio * pitchAdjustmentRatio)
        {
            return ArgumentGenerationRules.PitchAdjusting;
        }
        else
        {
            return ArgumentGenerationRules.MemoryConsidering;
        }
    }
}
