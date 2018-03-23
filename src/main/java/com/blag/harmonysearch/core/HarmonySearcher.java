package com.blag.harmonysearch.core;

import lombok.Getter;
import lombok.Setter;
import org.mariuszgromada.math.mxparser.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    private List<ArgumentLimit> argumentGenerationLimits;
    private SolutionGenerator solutionGenerator;
    private int improvisationCount;

    public HarmonySearcher(Function function, int harmonyMemorySize, long maxImprovisationCount, double harmonyMemoryConsiderationRatio, double pitchAdjustmentRatio)
    {
        this.maxImprovisationCount = maxImprovisationCount;

        this.harmonyMemoryConsiderationRatio = harmonyMemoryConsiderationRatio;
        this.pitchAdjustmentRatio = pitchAdjustmentRatio;

        this.function = function;
        this.argumentGenerationLimits = new ArrayList<>(function.getArgumentsNumber());
        for (int i = 0; i < function.getArgumentsNumber(); i++)
        {
            argumentGenerationLimits.add(new ArgumentLimit(-DEFAULT_ARGUMENT_LIMIT, DEFAULT_ARGUMENT_LIMIT));
        }

        harmonyMemory = new HarmonyMemory(harmonyMemorySize);
        solutionGenerator = new SolutionGenerator(function, argumentGenerationLimits);
    }

    public HarmonySearcher(Function function, int harmonyMemorySize, long maxImprovisationCount, double harmonyMemoryConsiderationRatio, double pitchAdjustmentRatio, List<ArgumentLimit> argumentGenerationLimits)
    {
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
            Solution newSolution = improviseNewSolution();

            if (newSolution.isBetterThan(worstSolution))
            {
                harmonyMemory.swapWithWorstSolution(newSolution);
            }
            improvisationCount++;
        }
        return harmonyMemory.getBestSolution();
    }

    Solution improviseNewSolution()
    {
        double[] improvisedArguments = improviseArguments();
        return solutionGenerator.calculateSolution(improvisedArguments);
    }

    double[] improviseArguments()
    {

        double[] arguments = new double[function.getArgumentsNumber()];

        for (int i = 0; i < arguments.length; i++)
        {
            arguments[i] = generateArgument();
        }

        return arguments;
    }

    private double generateArgument()
    {

        double probability = new Random().nextDouble();

        ArgumentGenerationRules generationRule = establishArgumentGenerationRuleWithProbability(probability);
        double argument = 0;
        switch (generationRule)
        {
            case MemoryConsidering:
                argument = useMemoryConsidering();
                break;
            case PitchAdjusting:
                argument = usePitchAdjusting();
                break;
            case RandomChoosing:
                argument = useRandomChoosing();
                break;
        }
        return argument;
    }

    private double useMemoryConsidering()
    {
        return 0;
    }

    private double usePitchAdjusting()
    {
        return 0;
    }

    private double useRandomChoosing()
    {
        return 0;
    }

    private ArgumentGenerationRules establishArgumentGenerationRuleWithProbability(double probability)
    {
        return ArgumentGenerationRules.MemoryConsidering;
    }

    private boolean searchingShouldContinue()
    {
        return improvisationCount < maxImprovisationCount;
    }
}
