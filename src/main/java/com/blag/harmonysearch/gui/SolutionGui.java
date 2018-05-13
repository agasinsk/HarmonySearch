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

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("f(x) = ")
                .append(String.valueOf(value))
                .append("\n");


        for (int i = 0; i < arguments.length; i++)
        {
            builder.append("x")
                    .append(String.valueOf(i + 1))
                    .append(" = ")
                    .append(String.valueOf(arguments[i]))
                    .append("\n");
        }

        return builder.toString();
    }
}
