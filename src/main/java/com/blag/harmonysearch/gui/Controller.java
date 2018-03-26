package com.blag.harmonysearch.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.mariuszgromada.math.mxparser.Function;

import static com.blag.harmonysearch.contants.HarmonySearchConstants.*;

public class Controller {

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private CheckBox defaultParameterValuesCheckBox;

    @FXML
    private TableView<Integer> argumentLimitsTableView;

    @FXML
    private TextField functionTextBox;

    @FXML
    private Button startButton;

    @FXML
    private Spinner<Integer> harmonyMemorySizeSpinner;

    @FXML
    private Spinner<Integer> iterationCountSpinner;

    @FXML
    private Spinner<Double> harmonyMemoryConsiderationRatioSpinner;

    @FXML
    private Spinner<Double> pitchAdjustingRatioSpinner;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    private Function function;
    private int harmonyMemorySize = DEFAULT_HARMONY_MEMORY_SIZE;
    private int maxIterationCount = DEFAULT_MAX_IMPROVISATION_COUNT;
    private double harmonyMemoryConsiderationRatio = DEFAULT_HARMONY_MEMORY_CONSIDERATION_RATIO;
    private double pitchAdjustingRatio = DEFAULT_PITCH_ADJUSTMENT_RATIO;

    @FXML
    void setHarmonyMemoryConsiderationRatio(InputMethodEvent event) {

        this.harmonyMemoryConsiderationRatio = harmonyMemoryConsiderationRatioSpinner.getValue();
    }

    @FXML
    void setHarmonyMemorySize(InputMethodEvent event) {

    }

    @FXML
    void setIterationCount(InputMethodEvent event) {

    }

    @FXML
    void setPitchAdjustingRatio(InputMethodEvent event) {

    }

    @FXML
    void startHarmonySearcher(ActionEvent event) {

    }

    @FXML
    void switchDefaultParameterValues(MouseEvent event) {

        harmonyMemoryConsiderationRatioSpinner.getValueFactory().setValue(DEFAULT_HARMONY_MEMORY_CONSIDERATION_RATIO);
        harmonyMemoryConsiderationRatioSpinner.setDisable(true);

        harmonyMemorySizeSpinner.getValueFactory().setValue(DEFAULT_HARMONY_MEMORY_SIZE);
        harmonyMemorySizeSpinner.setDisable(true);

        iterationCountSpinner.getValueFactory().setValue(DEFAULT_MAX_IMPROVISATION_COUNT);
        iterationCountSpinner.setDisable(true);

        pitchAdjustingRatioSpinner.getValueFactory().setValue(DEFAULT_PITCH_ADJUSTMENT_RATIO);
        pitchAdjustingRatioSpinner.setDisable(true);
    }

    @FXML
    void tryValidateFunctionString(ActionEvent event) {

    }

}
