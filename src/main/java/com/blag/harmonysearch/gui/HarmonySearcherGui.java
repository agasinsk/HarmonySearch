package com.blag.harmonysearch.gui;

import com.blag.harmonysearch.core.ArgumentLimit;
import com.blag.harmonysearch.core.HarmonyMemory;
import com.blag.harmonysearch.core.HarmonySearcher;
import com.blag.harmonysearch.core.Solution;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;
import org.mariuszgromada.math.mxparser.Function;

import java.util.List;

@Getter
public class HarmonySearcherGui extends HarmonySearcher
{
    private ObservableList<SolutionGui> bestSolutions;
    private Plot plot;

    public HarmonySearcherGui(Function function, int harmonyMemorySize, long maxImprovisationCount, double harmonyMemoryConsiderationRatio, double pitchAdjustmentRatio)
    {
        super(function, harmonyMemorySize, maxImprovisationCount, harmonyMemoryConsiderationRatio, pitchAdjustmentRatio);
        bestSolutions = FXCollections.observableArrayList();
        plot = new Plot();
        plot.setFunction(function);

    }

    public HarmonySearcherGui(Function function, int harmonyMemorySize, long maxImprovisationCount, double harmonyMemoryConsiderationRatio, double pitchAdjustmentRatio, List<ArgumentLimit> argumentGenerationLimits)
    {
        super(function, harmonyMemorySize, maxImprovisationCount, harmonyMemoryConsiderationRatio, pitchAdjustmentRatio, argumentGenerationLimits);
        bestSolutions = FXCollections.observableArrayList();
        plot = new Plot();
        plot.setParameters(function, argumentGenerationLimits);
    }

    /**
     * Looks for optimal solution of  function
     */
    @Override
    public Solution searchForHarmony()
    {
        initializeHarmonyMemory();

        improvisationCount = 0;
        while (searchingShouldContinue())
        {
            Solution worstSolution = harmonyMemory.getWorstSolution();
            Solution newSolution = solutionGenerator.improviseSolution();
            if (newSolution.isBetterThan(worstSolution))
            {
                harmonyMemory.swapWithWorstSolution(newSolution);
            }

            // update current best solution and the list on the JavaFx Application Thread
            Platform.runLater(() ->
            {
                if (harmonyMemory.count() > 0 && !harmonyMemory.getBestSolution().equals(currentBestSolution))
                {
                    currentBestSolution = harmonyMemory.getBestSolution();
                    bestSolutions.add(0, new SolutionGui((float) currentBestSolution.getValue(), currentBestSolution.getArguments(), improvisationCount));
                    plot.drawPoint(currentBestSolution);
                }

            });

            improvisationCount++;
        }
        return harmonyMemory.getBestSolution();
    }

    public HarmonyMemory getHarmonyMemory()
    {
        return harmonyMemory;
    }

}
