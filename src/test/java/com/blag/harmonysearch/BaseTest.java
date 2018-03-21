package com.blag.harmonysearch;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {

    @BeforeEach
    public abstract void setUp();

    @AfterEach
    public abstract void cleanUp();
}


