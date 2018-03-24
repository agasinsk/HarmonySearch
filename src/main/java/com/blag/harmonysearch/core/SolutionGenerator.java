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
    @Getter
    private final double harmonyMemoryConsiderationRatio;
    @Getter
    private final double pitchAdjustmentRatio;

    @Setter
    @Getter
    private HarmonyMemory harmonyMemory;

    @Setter
    @Getter
    private List<ArgumentLimit> argumentGenerationLimits;

    private RandomGenerator randomGenerator = new RandomGenerator();
    private Function function;

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

    /**
     * Improvises new solution based on algorithm parameters
     */
    Solution improviseSolution()
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
            arguments[i] = improviseArgument(i);
        }

        return arguments;
    }

    /**
     * Generates arguments based on the algorithm parameters
     */
    private double improviseArgument(int argumentIndex)
    {
        double randomValue = randomGenerator.nextDouble();
        ArgumentGenerationRules generationRule = establishArgumentGenerationRule(randomValue);

        switch (generationRule)
        {
            case MemoryConsideration:
                return useMemoryConsideration(argumentIndex);
            case PitchAdjustement:
                return usePitchAdjustment(argumentIndex);
            case RandomChoosing:
                return useRandomChoosing(argumentIndex);
            default:
                return 0;
        }
    }

    double useMemoryConsideration(int argumentIndex)
    {
        return harmonyMemory.getRandomArgumentByIndex(argumentIndex);
    }

    double usePitchAdjustment(int argumentIndex)
    {
        double existingArgument = useMemoryConsideration(argumentIndex);

        ArgumentLimit limit = argumentGenerationLimits.get(argumentIndex);
        double pitchAdjustment = randomGenerator.nextBoundedDouble(limit);

        return existingArgument + pitchAdjustment;
    }

    private double useRandomChoosing(int argumentIndex)
    {
        ArgumentLimit limit = argumentGenerationLimits.get(argumentIndex);
        return randomGenerator.nextBoundedDouble(limit);
    }

    /**
     * Chooses argument generation rule by their probabilities
     */
    ArgumentGenerationRules establishArgumentGenerationRule(double probability)
    {
        if (probability > harmonyMemoryConsiderationRatio)
        {
            return ArgumentGenerationRules.RandomChoosing;
        }
        else if (probability <= harmonyMemoryConsiderationRatio * pitchAdjustmentRatio)
        {
            return ArgumentGenerationRules.PitchAdjustement;
        }
        else
        {
            return ArgumentGenerationRules.MemoryConsideration;
        }
    }
}
