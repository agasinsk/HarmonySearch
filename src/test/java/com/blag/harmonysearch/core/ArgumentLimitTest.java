package com.blag.harmonysearch.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArgumentLimitTest {

    @Test
    void testIsWithinLimits() {

        //Arrange
        double number = 11.22;
        ArgumentLimit limit = new ArgumentLimit(-10, 15);

        //Act
        boolean result = limit.IsWithinLimits(number);

        //Assert
        Assertions.assertTrue(result);
    }

    @Test
    void testIsOutOfLimits() {

        //Arrange
        double number = 11.22;
        ArgumentLimit limit = new ArgumentLimit(14, 15);

        //Act
        boolean result = limit.IsWithinLimits(number);

        //Assert
        Assertions.assertFalse(result);
    }

}