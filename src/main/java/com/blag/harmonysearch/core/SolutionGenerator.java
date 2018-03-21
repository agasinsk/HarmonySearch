package com.blag.harmonysearch.core;

import com.blag.harmonysearch.helpers.RandomGenerator;
import lombok.AllArgsConstructor;
import org.mariuszgromada.math.mxparser.Function;

import java.util.List;

/**
 * Generates solutions
 */
@AllArgsConstructor
public class SolutionGenerator {

    private RandomGenerator randomGenerator = new RandomGenerator();
    private Function function;
    private List<ArgumentLimit> argumentGenerationLimits;

    private int argumentsCount;

    SolutionGenerator(Function function, List<ArgumentLimit> argumentGenerationLimits){
        this.function = function;
        this.argumentGenerationLimits = argumentGenerationLimits;
        argumentsCount = function.getArgumentsNumber();
    }

    /**
     * Generates solution from random arguments
     */
    Solution generateRandomSolution(){
        double[] arguments = generateRandomArguments();
        return calculateSolution(arguments);
    }

    /**
     * Generates random arguments within limits
     */
    private double[] generateRandomArguments(){

        double[] randomArguments = new double[argumentsCount];

        for (int i = 0; i < argumentsCount; i++) {
            double randomArgument = randomGenerator.nextBoundedDouble(argumentGenerationLimits.get(i));
            randomArguments[i] = randomArgument;
        }

        return randomArguments;
    }

    /**
     * Calculates solution for provided arguments
     */
    private Solution calculateSolution(double... arguments){

        double functionValue = function.calculate(arguments);
        return new Solution(functionValue, arguments);
    }

}
