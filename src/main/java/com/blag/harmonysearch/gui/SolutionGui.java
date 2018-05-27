package com.blag.harmonysearch.gui;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SolutionGui
{
    private float value;
    private double[] arguments;
    private int iterationNumber;

    public SimpleFloatProperty getArgument(int whichOne)
    {
        return new SimpleFloatProperty((float) arguments[whichOne]);
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("f(x) = ")
                .append(String.valueOf((float) value))
                .append("\n");


        for (int i = 0; i < arguments.length; i++)
        {
            builder.append("x");

            if (arguments.length > 1)
            {
                builder.append(String.valueOf(i + 1));
            }
            builder.append(" = ")
                    .append(String.valueOf((float) arguments[i]))
                    .append("\n");
        }

        return builder.toString();
    }
}
