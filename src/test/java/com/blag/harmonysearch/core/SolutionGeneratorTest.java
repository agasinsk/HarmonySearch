package com.blag.harmonysearch.core;

import com.blag.harmonysearch.BaseTest;
import org.junit.jupiter.api.*;
import org.mariuszgromada.math.mxparser.Function;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SolutionGeneratorTest {

    private SolutionGenerator solutionGenerator;

    @Test
    void testGenerateRandomSolution() {

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
    void testGenerateRandomArguments() {

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
    void testCalculateSolution() {

        //Arrange
        double x1 = 2;
        double x2 = 0.7;

        //Act
        Solution result = solutionGenerator.calculateSolution(x1, x2);

        //Assert
        Assertions.assertEquals(5.4, result.getValue());
        Assertions.assertArrayEquals(new double[]{x1, x2}, result.getArguments());
    }

    @BeforeAll
    void setUp() {

        List<ArgumentLimit> argumentLimits = new ArrayList<>();
        argumentLimits.add(new ArgumentLimit(-10, 10));
        argumentLimits.add(new ArgumentLimit(-10, 10));

        solutionGenerator = new SolutionGenerator(new Function("f(x1,x2) = x1^2+x1*x2"), argumentLimits);
    }

    @AfterAll
    public void cleanUp() {
        solutionGenerator = null;
    }
}