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
    void testImproviseArguments()
    {
        //Arrange
        List<ArgumentLimit> argumentLimits = new ArrayList<>();
        argumentLimits.add(new ArgumentLimit(-10, 10));
        argumentLimits.add(new ArgumentLimit(-1, 5));
        solutionGenerator.setArgumentGenerationLimits(argumentLimits);

        HarmonyMemory harmonyMemory = new HarmonyMemory(3);
        solutionGenerator.setHarmonyMemory(harmonyMemory);
        for (int i = 0; i < harmonyMemory.getMaxCapacity(); i++)
        {
            Solution randomSolution = solutionGenerator.generateRandomSolution();
            harmonyMemory.add(randomSolution);
        }

        //Act
        double[] result = solutionGenerator.improviseArguments();

        //Assert
        Assertions.assertEquals(argumentLimits.size(), result.length);
        Assertions.assertEquals(solutionGenerator.getArgumentsCount(), result.length);
        Assertions.assertTrue(argumentLimits.get(0).IsWithinLimits(result[0]));
        Assertions.assertTrue(argumentLimits.get(1).IsWithinLimits(result[1]));
    }

    @Test
    void testImproviseSolution()
    {
        //Arrange
        List<ArgumentLimit> argumentLimits = new ArrayList<>();
        argumentLimits.add(new ArgumentLimit(-10, 10));
        argumentLimits.add(new ArgumentLimit(-1, 5));
        solutionGenerator.setArgumentGenerationLimits(argumentLimits);

        HarmonyMemory harmonyMemory = new HarmonyMemory(3);
        solutionGenerator.setHarmonyMemory(harmonyMemory);
        for (int i = 0; i < harmonyMemory.getMaxCapacity(); i++)
        {
            Solution randomSolution = solutionGenerator.generateRandomSolution();
            harmonyMemory.add(randomSolution);
        }

        //Act
        Solution result = solutionGenerator.improviseSolution();

        //Assert
        Assertions.assertEquals(solutionGenerator.calculateSolution(result.getArguments()).getValue(), result.getValue());
        Assertions.assertEquals(argumentLimits.size(), result.getArguments().length);
    }

    @Test
    void testUseMemoryConsideration()
    {
        //Arrange
        HarmonyMemory harmonyMemory = new HarmonyMemory(3);
        solutionGenerator.setHarmonyMemory(harmonyMemory);
        for (int i = 0; i < harmonyMemory.getMaxCapacity(); i++)
        {
            Solution randomSolution = solutionGenerator.generateRandomSolution();
            harmonyMemory.add(randomSolution);
        }
        int argumentIndex = 0;

        //Act
        double result = solutionGenerator.useMemoryConsideration(argumentIndex);

        //Assert
        Assertions.assertTrue(harmonyMemory.getArgumentsByIndex(argumentIndex).contains(result));
    }

    @Test
    void testUsePitchAdjusting()
    {
        //Arrange
        HarmonyMemory harmonyMemory = new HarmonyMemory(3);
        solutionGenerator.setHarmonyMemory(harmonyMemory);
        for (int i = 0; i < harmonyMemory.getMaxCapacity(); i++)
        {
            Solution randomSolution = solutionGenerator.generateRandomSolution();
            harmonyMemory.add(randomSolution);
        }
        int argumentIndex = 0;

        //Act
        double result = solutionGenerator.usePitchAdjustment(argumentIndex);

        //Assert
        Assertions.assertFalse(harmonyMemory.getArgumentsByIndex(argumentIndex).contains(result));
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
        Assertions.assertEquals(ArgumentGenerationRules.PitchAdjustement, result);
    }

    @Test
    void testEstablishArgumentGenerationRuleForMemoryConsideration()
    {
        //Arrange
        double value = DEFAULT_HARMONY_MEMORY_CONSIDERATION_RATIO * (1 - DEFAULT_PITCH_ADJUSTMENT_RATIO);

        //Act
        ArgumentGenerationRules result = solutionGenerator.establishArgumentGenerationRule(value);

        //Assert
        Assertions.assertEquals(ArgumentGenerationRules.MemoryConsideration, result);
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