package com.blag.harmonysearch.core;

import com.blag.harmonysearch.BaseTest;
import com.blag.harmonysearch.helpers.RandomGenerator;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RandomGeneratorTest extends BaseTest {
    private RandomGenerator randomGenerator;

    @Test
    void testNextBoundedDoubleWithArgumentLimit() {

        //Arrange
        ArgumentLimit limit = new ArgumentLimit(2, 4);

        //Act
        double result = randomGenerator.nextBoundedDouble(limit);

        //Assert
        Assertions.assertTrue(result >= limit.getOrigin());
        Assertions.assertTrue(result <= limit.getBound());
    }

    @Test
    void testNextBoundedDoubleWithBounds() {

        //Arrange
        double origin = -10;
        double bound = -9;

        //Act
        double result = randomGenerator.nextBoundedDouble(origin, bound);

        //Assert
        Assertions.assertTrue(result >= origin);
        Assertions.assertTrue(result <= bound);
    }

    @BeforeAll
    @Override
    public void setUp() {
        randomGenerator = new RandomGenerator();
    }

    @AfterAll
    @Override
    public void cleanUp() {
        randomGenerator = null;
    }
}