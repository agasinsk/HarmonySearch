package com.blag.harmonysearch.gui;

import com.blag.harmonysearch.core.HarmonySearcher;
import javafx.beans.property.DoubleProperty;
import lombok.AllArgsConstructor;
import org.mariuszgromada.math.mxparser.Function;


public class HarmonySearcherGui extends HarmonySearcher
{
    private DoubleProperty currentBestSolution;

    public HarmonySearcherGui(Function function, int harmonyMemorySize, long maxImprovisationCount, double harmonyMemoryConsiderationRatio, double pitchAdjustmentRatio)
    {
        super(function, harmonyMemorySize, maxImprovisationCount, harmonyMemoryConsiderationRatio, pitchAdjustmentRatio);
    }
}
