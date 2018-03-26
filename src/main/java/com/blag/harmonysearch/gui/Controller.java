package com.blag.harmonysearch.gui;

import com.blag.harmonysearch.contants.DefaultFunctionStrings;
import com.blag.harmonysearch.core.ArgumentLimit;
import com.blag.harmonysearch.core.Solution;
import com.blag.harmonysearch.core.HarmonySearcher;
import com.blag.harmonysearch.helpers.FunctionStringValidator;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import org.mariuszgromada.math.mxparser.Function;

import java.net.URL;
import java.util.ResourceBundle;

import static com.blag.harmonysearch.contants.HarmonySearchConstants.*;

public class Controller implements Initializable
{
    @FXML
    private ComboBox<String> functionComboBox;

    @FXML
    private TableView<ArgumentLimit> argumentLimitsTableView;
    @FXML
    private TableColumn<ArgumentLimit, String> ArgumentName;
    @FXML
    private TableColumn<ArgumentLimit, Double> ArgumentMinValue;
    @FXML
    private TableColumn<ArgumentLimit, Double> ArgumentMaxValue;

    @FXML
    private Button startButton;
    @FXML
    public Button defaultParameterValuesButton;

    @FXML
    private Spinner<Integer> harmonyMemorySizeSpinner;
    @FXML
    private Spinner<Integer> iterationCountSpinner;
    @FXML
    private Spinner<Double> harmonyMemoryConsiderationRatioSpinner;
    @FXML
    private Spinner<Double> pitchAdjustingRatioSpinner;

    private Function function;
    private FunctionStringValidator functionValidator;
    private ObservableList<ArgumentLimit> argumentLimits;
    private HarmonySearcher harmonySearcher;
    private ObservableValue<Solution> optimalSolution;
    private ObservableList<String> defaultFunctions;

    /**
     * Initializes the controller class.
     */
    @Override

    public void initialize(URL url, ResourceBundle bundle)
    {
        harmonyMemorySizeSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, DEFAULT_HARMONY_MEMORY_SIZE));
        iterationCountSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000000, DEFAULT_MAX_IMPROVISATION_COUNT));
        harmonyMemoryConsiderationRatioSpinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 1, DEFAULT_HARMONY_MEMORY_CONSIDERATION_RATIO, 0.01));
        pitchAdjustingRatioSpinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 1, DEFAULT_PITCH_ADJUSTMENT_RATIO, 0.01));

        defaultFunctions = FXCollections.observableArrayList();
        defaultFunctions.add(DefaultFunctionStrings.FourMinFunction);
        defaultFunctions.add(DefaultFunctionStrings.GeemFunction);
        defaultFunctions.add(DefaultFunctionStrings.GimmelblauFunction);
        defaultFunctions.add(DefaultFunctionStrings.RosenbrockFunction);
        defaultFunctions.add(DefaultFunctionStrings.ThreeDimensionalFunction);
        functionComboBox.setItems(defaultFunctions);

        functionValidator = new FunctionStringValidator();
        argumentLimits = FXCollections.observableArrayList();

        argumentLimitsTableView.setEditable(true);
        ArgumentName.setCellValueFactory(new PropertyValueFactory<>("argumentName"));
        ArgumentMinValue.setCellValueFactory(new PropertyValueFactory<>("origin"));
        ArgumentMaxValue.setCellValueFactory(new PropertyValueFactory<>("bound"));

        ArgumentMinValue.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        ArgumentMinValue.setOnEditCommit(t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setOrigin(t.getNewValue()));

        ArgumentMaxValue.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        ArgumentMaxValue.setOnEditCommit(t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setBound(t.getNewValue()));
    }

    @FXML
    void startHarmonySearcher(ActionEvent event)
    {
        int HMS = harmonyMemorySizeSpinner.getValue();
        int iterCount = iterationCountSpinner.getValue();

        double HMCR = harmonyMemoryConsiderationRatioSpinner.getValue();
        double PAR = pitchAdjustingRatioSpinner.getValue();

        harmonySearcher = new HarmonySearcher(this.function, HMS, iterCount, HMCR, PAR, argumentLimits);
    }

    @FXML
    void tryValidateFunctionString(ActionEvent event)
    {
        String functionString = functionComboBox.getValue();
        this.function = functionValidator.validateFunctionString(functionString);

        showArgumentLimitsTableView();
    }

    private void showArgumentLimitsTableView()
    {
        argumentLimitsTableView.getItems().clear();

        for (int i = 0; i < function.getArgumentsNumber(); i++)
        {
            argumentLimits.add(new ArgumentLimit(function.getArgument(i).getArgumentName()));
        }

        argumentLimitsTableView.setItems(argumentLimits);
    }

    @FXML
    public void resetDefaultParameterValues(ActionEvent actionEvent)
    {
        harmonyMemoryConsiderationRatioSpinner.getValueFactory().setValue(DEFAULT_HARMONY_MEMORY_CONSIDERATION_RATIO);
        harmonyMemorySizeSpinner.getValueFactory().setValue(DEFAULT_HARMONY_MEMORY_SIZE);
        iterationCountSpinner.getValueFactory().setValue(DEFAULT_MAX_IMPROVISATION_COUNT);
        pitchAdjustingRatioSpinner.getValueFactory().setValue(DEFAULT_PITCH_ADJUSTMENT_RATIO);
    }

    @FXML
    public void selectFunction(ActionEvent actionEvent)
    {
        tryValidateFunctionString(actionEvent);
    }
}
