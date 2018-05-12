package com.blag.harmonysearch.gui;

import javafx.beans.property.SimpleDoubleProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SolutionGui
{
    private double value;
    private double[] arguments;
    private int iterationNumber;


    public SimpleDoubleProperty getArgument(int whichOne)
    {
        return new SimpleDoubleProperty(arguments[whichOne]);
    }

}
