package com.blag.harmonysearch.core;

import com.blag.harmonysearch.BaseTest;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HarmonyMemoryTest extends BaseTest
{
    private HarmonyMemory harmonyMemory;

    @Test
    void testGetBestSolution()
    {
        //Arrange
        Solution newBest = new Solution(-7, 3, 3);
        harmonyMemory.add(new Solution(2, 1, 3));
        harmonyMemory.add(new Solution(-2, -1, 3));
        harmonyMemory.add(newBest);

        //Act
        Solution best = harmonyMemory.getBestSolution();

        //Assert
        Assertions.assertEquals(newBest, best);
    }

    @Test
    void testGetWorstSolution()
    {
        //Arrange
        Solution newWorst = new Solution(4, 3, 3);
        harmonyMemory.add(new Solution(2, 1, 3));
        harmonyMemory.add(new Solution(-2, -1, 3));
        harmonyMemory.add(newWorst);

        //Act
        Solution worst = harmonyMemory.getWorstSolution();

        //Assert
        Assertions.assertEquals(newWorst, worst);
    }

    @Test
    void testGetSize()
    {
        //Arrange

        //Act

        //Assert
    }

    @Test
    void testGetMaxCapacity()
    {
        //Arrange

        //Act

        //Assert
    }

    @Test
    void swapForWorstSolution()
    {
        //Arrange
        harmonyMemory.add(new Solution(2, 1, 3));
        harmonyMemory.add(new Solution(-2, -1, 3));
        harmonyMemory.add(new Solution(4, 3, 3));


        //Act

        //Assert
    }

    @BeforeAll
    @Override
    public void setUp()
    {
        harmonyMemory = new HarmonyMemory(3);
    }

    @AfterAll
    @Override
    public void cleanUp()
    {
        harmonyMemory = null;
    }
}