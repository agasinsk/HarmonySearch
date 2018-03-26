package com.blag.harmonysearch.helpers;

import com.blag.harmonysearch.BaseTest;
import org.junit.jupiter.api.*;
import org.mariuszgromada.math.mxparser.Function;

class FunctionStringValidatorTest extends BaseTest
{
    private FunctionStringValidator functionValidator;

    @Test
    void testValidateFunctionArgumentsWhenArgumentsAreCorrect()
    {
        //Arrange
        String functionString = "x1+x2+x4";

        //Act
        boolean result = functionValidator.matchFunctionArguments(functionString);

        //Assert
        Assertions.assertTrue(result);
    }

    @Test
    void testValidateFunctionArgumentsWhenArgumentsAreUpperAndLowerCase()
    {
        //Arrange
        String functionString = "X1+X2+x4";

        //Act
        boolean result = functionValidator.matchFunctionArguments(functionString);

        //Assert
        Assertions.assertTrue(result);
    }

    @Test
    void testValidateFunctionArgumentsWhenArgumentsAreWithoutNumbers()
    {
        //Arrange
        String functionString = "X+X^2-sqrt(x)";

        //Act
        boolean result = functionValidator.matchFunctionArguments(functionString);

        //Assert
        Assertions.assertTrue(result);
    }

    @Test
    void testValidateFunctionArgumentsWhenArgumentsAreInvalid()
    {
        //Arrange
        String functionString = "y1+11+y2";

        //Act
        boolean result = functionValidator.matchFunctionArguments(functionString);

        //Assert
        Assertions.assertFalse(result);
    }

    @Test
    void testValidateFunctionArgumentsWhenAllLettersAllowed()
    {
        //Arrange
        functionValidator = new FunctionStringValidator(ArgumentMatching.AllLettersAllowed);
        String functionString = "x1+y1+y2+Z44";

        //Act
        boolean result = functionValidator.matchFunctionArguments(functionString);

        //Assert
        Assertions.assertTrue(result);
    }

    @Test
    void testValidateFunctionStringWhenFunctionIsValid()
    {
        //Arrange
        String functionString = "x1^2 + x2^2";

        //Act
        Function result = functionValidator.validateFunctionString(functionString);

        //Assert
        Assertions.assertEquals(functionString, result.getFunctionExpressionString());
        Assertions.assertEquals(2, result.getArgumentsNumber());
    }

    @Test
    void testValidateFunctionStringWhenFunctionIsComplex()
    {
        //Arrange
        String functionString = "x1^2+x2^2+x1*x2+0.5/x1";

        //Act
        Function result = functionValidator.validateFunctionString(functionString);

        //Assert
        Assertions.assertEquals(functionString, result.getFunctionExpressionString());
        Assertions.assertEquals(2, result.getArgumentsNumber());
    }

    @BeforeEach
    @Override
    public void setUp()
    {
        functionValidator = new FunctionStringValidator();
    }

    @AfterAll
    @Override
    public void cleanUp()
    {
        functionValidator = null;
    }
}