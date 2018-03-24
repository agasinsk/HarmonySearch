package com.blag.harmonysearch.core;

import com.blag.harmonysearch.BaseTest;
import org.junit.jupiter.api.*;
import org.mariuszgromada.math.mxparser.Function;

import static com.blag.harmonysearch.contants.HarmonySearchConstants.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HarmonySearcherTest extends BaseTest
{
    private HarmonySearcher harmonySearcher;

    @Test
    void testInitializeHarmonyMemory()
    {
        //Arrange

        //Act
        harmonySearcher.initializeHarmonyMemory();
        HarmonyMemory harmonyMemory = harmonySearcher.getHarmonyMemory();

        //Assert
        Assertions.assertEquals(DEFAULT_HARMONY_MEMORY_SIZE, harmonyMemory.getSize());
        Assertions.assertTrue(harmonyMemory.getBestSolution().getValue() <= harmonyMemory.getWorstSolution().getValue());
    }

    @Test
    void testSearchForHarmony()
    {
        //Arrange

        //Act
        Solution solution = harmonySearcher.searchForHarmony();

        //Assert
        Assertions.assertEquals(harmonySearcher.getMaxImprovisationCount(), harmonySearcher.getImprovisationCount());
        Assertions.assertEquals(0, solution.getValue(), 10E-5);
    }

    @BeforeAll
    @Override
    public void setUp()
    {
        harmonySearcher = new HarmonySearcher(new Function("f(x) = x^2"), DEFAULT_HARMONY_MEMORY_SIZE, DEFAULT_MAX_IMPROVISATION_COUNT, DEFAULT_HARMONY_MEMORY_CONSIDERATION_RATIO, DEFAULT_PITCH_ADJUSTMENT_RATIO);
    }

    @AfterAll
    @Override
    public void cleanUp()
    {
        harmonySearcher = null;
    }
}