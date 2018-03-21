package com.blag.harmonysearch.core;

import java.util.ArrayList;

/**
 * Stores best solutions for harmony search algorithm
 */
public class HarmonyMemory {

    private ArrayList<Solution> _solutions;

    public HarmonyMemory(int harmonyMemorySize){

        _solutions = new ArrayList<>(harmonyMemorySize);
    }

    public Solution getSolution(int index){
        return _solutions.get(index);
    }

    public void clear(){
        _solutions.clear();
    }
}
