package com.blag.harmonysearch.gui;

import com.blag.harmonysearch.core.Solution;
import lombok.Getter;
import lombok.Setter;

import java.util.Observable;

@Getter
@Setter
public class SolutionObservable extends Observable
{
    private Solution solution;

    public SolutionObservable()
    {
        super();
    }

    public SolutionObservable(Solution solution)
    {
        this.solution = solution;
    }

    void update(int count)
    {
        setChanged();
        notifyObservers(count);
    }
}

