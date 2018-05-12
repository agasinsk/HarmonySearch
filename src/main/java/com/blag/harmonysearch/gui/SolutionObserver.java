package com.blag.harmonysearch.gui;

import com.blag.harmonysearch.core.Solution;
import lombok.Getter;
import lombok.Setter;

import java.util.Observable;
import java.util.Observer;

@Getter
@Setter
public class SolutionObserver implements Observer
{
    private Solution solution;

    public SolutionObserver()
    {
        super();
    }

    public SolutionObserver(Solution solution)
    {
        super();
        this.solution = solution;
    }


    @Override
    public void update(Observable o, Object newsolution)
    {
        System.out.println(solution + " got " +
                newsolution + " s");
    }

}

