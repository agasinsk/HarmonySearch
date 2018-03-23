package com.blag.harmonysearch.core;

import com.blag.harmonysearch.BaseTest;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HarmonyMemoryTest extends BaseTest
{
    private HarmonyMemory harmonyMemory;
    private int harmonyMemoryTestSize;

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
    void testGetSolution()
    {
        //Arrange
        Solution newBest = new Solution(-7, 3, 3);
        harmonyMemory.add(new Solution(2, 1, 3));
        harmonyMemory.add(new Solution(-2, -1, 3));
        harmonyMemory.add(newBest);

        //Act
        Solution best = harmonyMemory.getSolution(2);

        //Assert
        Assertions.assertEquals(newBest, best);
    }

    @Test
    void testAddSolutionIfMemoryIsFull()
    {
        //Arrange
        harmonyMemory.add(new Solution(2, 1, 3));
        harmonyMemory.add(new Solution(-2, -1, 3));
        harmonyMemory.add(new Solution(-4, -1, 3));

        Solution testSolution = new Solution(-7, 3, 3);

        //Act
        boolean result = harmonyMemory.add(testSolution);

        //Assert
        Assertions.assertFalse(result);
        Assertions.assertTrue(!harmonyMemory.contains(testSolution));
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
    void testGetSizeIfEmpty()
    {
        //Arrange

        //Act
        int size = harmonyMemory.getSize();

        //Assert
        Assertions.assertEquals(0, size);
    }

    @Test
    void testGetSizeIfNotEmpty()
    {
        //Arrange
        harmonyMemory.add(new Solution(22, 0, 11));

        //Act
        int size = harmonyMemory.getSize();

        //Assert
        Assertions.assertEquals(1, size);
    }

    @Test
    void testGetMaxCapacity()
    {
        //Arrange

        //Act
        int capacity = harmonyMemory.getMaxCapacity();

        //Assert
        Assertions.assertEquals(harmonyMemoryTestSize, capacity);
    }

    @Test
    void testSwapWithWorstSolutionForNewMiddleSolution()
    {
        //Arrange
        Solution oldWorstSolution = new Solution(4, 3, 3);
        harmonyMemory.add(new Solution(2, 1, 3));
        harmonyMemory.add(new Solution(-2, -1, 3));
        harmonyMemory.add(oldWorstSolution);

        Solution newSolution = new Solution(0, 2, 2.5);

        //Act
        harmonyMemory.swapWithWorstSolution(newSolution);

        //Assert
        Assertions.assertTrue(harmonyMemory.contains(newSolution));
        Assertions.assertTrue(!harmonyMemory.contains(oldWorstSolution));
    }

    @Test
    void testSwapWithWorstSolutionForNewBestSolution()
    {
        //Arrange
        Solution oldWorstSolution = new Solution(4, 3, 3);
        harmonyMemory.add(new Solution(2, 1, 3));
        harmonyMemory.add(new Solution(-2, -1, 3));
        harmonyMemory.add(oldWorstSolution);

        Solution newSolution = new Solution(-10, 2, 2.5);

        //Act
        harmonyMemory.swapWithWorstSolution(newSolution);

        //Assert
        Assertions.assertEquals(newSolution, harmonyMemory.getBestSolution());
        Assertions.assertTrue(!harmonyMemory.contains(oldWorstSolution));
    }

    @Test
    void testSwapWithWorstSolutionForNewWorstSolution()
    {
        //Arrange
        Solution oldWorstSolution = new Solution(4, 3, 3);
        harmonyMemory.add(new Solution(2, 1, 3));
        harmonyMemory.add(new Solution(-2, -1, 3));
        harmonyMemory.add(oldWorstSolution);

        Solution newSolution = new Solution(3, 2, 2.5);

        //Act
        harmonyMemory.swapWithWorstSolution(newSolution);

        //Assert
        Assertions.assertEquals(newSolution, harmonyMemory.getWorstSolution());
        Assertions.assertTrue(!harmonyMemory.contains(oldWorstSolution));
    }

    @BeforeEach
    @Override
    public void setUp()
    {
        harmonyMemoryTestSize = 3;
        harmonyMemory = new HarmonyMemory(harmonyMemoryTestSize);
    }

    @AfterAll
    @Override
    public void cleanUp()
    {
        harmonyMemory = null;
    }
}