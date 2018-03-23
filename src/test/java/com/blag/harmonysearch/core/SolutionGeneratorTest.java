package com.blag.harmonysearch.core;

import com.blag.harmonysearch.BaseTest;
import org.junit.jupiter.api.*;
import org.mariuszgromada.math.mxparser.Function;

import java.util.ArrayList;
import java.util.List;

import static com.blag.harmonysearch.contants.HarmonySearchConstants.DEFAULT_HARMONY_MEMORY_CONSIDERATION_RATIO;
import static com.blag.harmonysearch.contants.HarmonySearchConstants.DEFAULT_HARMONY_MEMORY_SIZE;
import static com.blag.harmonysearch.contants.HarmonySearchConstants.DEFAULT_PITCH_ADJUSTMENT_RATIO;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SolutionGeneratorTest extends BaseTest
{
    private SolutionGenerator solutionGenerator;

    @Test
    void testGenerateRandomSolution()
    {
        //Arrange
        List<ArgumentLimit> argumentLimits = new ArrayList<>();
        argumentLimits.add(new ArgumentLimit(-10, 10));
        argumentLimits.add(new ArgumentLimit(-1, 5));
        solutionGenerator.setArgumentGenerationLimits(argumentLimits);

        //Act
        Solution result = solutionGenerator.generateRandomSolution();

        //Assert
        Assertions.assertEquals(argumentLimits.size(), result.getArguments().length);
        Assertions.assertEquals(solutionGenerator.getArgumentsCount(), result.getArguments().length);
        Assertions.assertTrue(argumentLimits.get(0).IsWithinLimits(result.getArguments()[0]));
        Assertions.assertTrue(argumentLimits.get(1).IsWithinLimits(result.getArguments()[1]));
        Assertions.assertEquals(solutionGenerator.calculateSolution(result.getArguments()).getValue(), result.getValue());
    }

    @Test
    void testGenerateRandomArguments()
    {
        //Arrange
        List<ArgumentLimit> argumentLimits = new ArrayList<>();
        argumentLimits.add(new ArgumentLimit(-10, 10));
        argumentLimits.add(new ArgumentLimit(-1, 5));
        solutionGenerator.setArgumentGenerationLimits(argumentLimits);

        //Act
        double[] result = solutionGenerator.generateRandomArguments();

        //Assert
        Assertions.assertEquals(argumentLimits.size(), result.length);
        Assertions.assertEquals(solutionGenerator.getArgumentsCount(), result.length);
        Assertions.assertTrue(argumentLimits.get(0).IsWithinLimits(result[0]));
        Assertions.assertTrue(argumentLimits.get(1).IsWithinLimits(result[1]));
    }

    @Test
    void testCalculateSolution()
    {
        //Arrange
        double x1 = 2;
        double x2 = 0.7;

        //Act
        Solution result = solutionGenerator.calculateSolution(x1, x2);

        //Assert
        Assertions.assertEquals(5.4, result.getValue());
        Assertions.assertArrayEquals(new double[]{x1, x2}, result.getArguments());
    }

    @Test
    void testEstablishArgumentGenerationRuleForRandomChoosing()
    {
        //Arrange
        double value = 0.96;

        //Act
        ArgumentGenerationRules result = solutionGenerator.establishArgumentGenerationRule(value);

        //Assert
        Assertions.assertEquals(ArgumentGenerationRules.RandomChoosing, result);
    }

    @Test
    void testEstablishArgumentGenerationRuleForPitchAdjusting()
    {
        //Arrange
        double value = DEFAULT_HARMONY_MEMORY_CONSIDERATION_RATIO * DEFAULT_PITCH_ADJUSTMENT_RATIO - 0.01;

        //Act
        ArgumentGenerationRules result = solutionGenerator.establishArgumentGenerationRule(value);

        //Assert
        Assertions.assertEquals(ArgumentGenerationRules.PitchAdjusting, result);
    }

    @Test
    void testEstablishArgumentGenerationRuleForMemoryConsideration()
    {
        //Arrange
        double value = DEFAULT_HARMONY_MEMORY_CONSIDERATION_RATIO * (1 - DEFAULT_PITCH_ADJUSTMENT_RATIO);

        //Act
        ArgumentGenerationRules result = solutionGenerator.establishArgumentGenerationRule(value);

        //Assert
        Assertions.assertEquals(ArgumentGenerationRules.MemoryConsidering, result);
    }

    @Override
    @BeforeAll
    public void setUp()
    {
        List<ArgumentLimit> argumentLimits = new ArrayList<>();
        argumentLimits.add(new ArgumentLimit(-10, 10));
        argumentLimits.add(new ArgumentLimit(-10, 10));

        HarmonyMemory harmonyMemory = new HarmonyMemory(DEFAULT_HARMONY_MEMORY_SIZE);

        solutionGenerator = new SolutionGenerator(new Function("f(x1,x2) = x1^2+x1*x2"), harmonyMemory, argumentLimits, DEFAULT_HARMONY_MEMORY_CONSIDERATION_RATIO, DEFAULT_PITCH_ADJUSTMENT_RATIO);
    }

    @Override
    @AfterAll
    public void cleanUp()
    {
        solutionGenerator = null;
    }
}