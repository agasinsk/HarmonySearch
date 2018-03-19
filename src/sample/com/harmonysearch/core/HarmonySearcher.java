package sample.com.harmonysearch.core;

/**
 * Implements harmony search algorithm
 */
public class HarmonySearcher {

    private final long _maxIterationCount;
    private HarmonyMemory _harmonyMemory;

    private final double _harmonyMemoryConsiderationRatio;
    private final double _pitchAdjustmentRatio;

    public HarmonySearcher(int harmonyMemorySize, long maxIterationCount, double harmonyMemoryConsiderationRatio, double pitchAdjustmentRatio){

        _harmonyMemory = new HarmonyMemory(harmonyMemorySize);
        _maxIterationCount = maxIterationCount;

        _harmonyMemoryConsiderationRatio = harmonyMemoryConsiderationRatio;
        _pitchAdjustmentRatio = pitchAdjustmentRatio;
    }

    public Solution search() {
        return null;
    }
}
