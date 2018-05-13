package com.blag.harmonysearch.gui;

import com.blag.harmonysearch.contants.DefaultFunctionStrings;
import com.blag.harmonysearch.core.ArgumentLimit;
import com.blag.harmonysearch.helpers.FunctionStringValidator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
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
    private TableColumn<ArgumentLimit, String> argumentName;
    @FXML
    private TableColumn<ArgumentLimit, Double> argumentMinValue;
    @FXML
<<<<<<< HEAD
    private TableColumn<ArgumentLimit, Double> ArgumentMaxValue;
    @FXML
    private TableView<SolutionGui> SolutionTableView;
=======
    private TableColumn<ArgumentLimit, Double> argumentMaxValue;

    @FXML
    private TableView<SolutionGui> solutionTableView;

>>>>>>> 52ae50572a7149e416db5d06a3bc6f1aead591e2
    @FXML
    private TableColumn<SolutionGui, Integer> solutionIteration;
    @FXML
<<<<<<< HEAD
    private TableColumn<SolutionGui, Double> SolutionValue;
    @FXML
    private TableColumn<SolutionGui, String> SolutionArguments;
=======
    private TableColumn<SolutionGui, Double> solutionValue;


>>>>>>> 52ae50572a7149e416db5d06a3bc6f1aead591e2
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
    @FXML
    private Label leftStatusLabel;
    @FXML
    private Label rightStatusLabel;
    @FXML
    private StackPane pane;

    private Function function;
    private FunctionStringValidator functionValidator;
    private ObservableList<ArgumentLimit> argumentLimits;
    private HarmonySearcherGui harmonySearcher;
    private ObservableList<String> defaultFunctions;
    private Plot plot;

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
        defaultFunctions.add(DefaultFunctionStrings.ZangwillFunction);
        defaultFunctions.add(DefaultFunctionStrings.GoldSteinPriceFunction);
        defaultFunctions.add(DefaultFunctionStrings.sinFunction);
        defaultFunctions.add(DefaultFunctionStrings.sinExpFunction);
        functionComboBox.setItems(defaultFunctions);

        functionValidator = new FunctionStringValidator();

        // Argument limits table
        argumentLimits = FXCollections.observableArrayList();

        argumentLimitsTableView.setEditable(true);
        argumentName.setCellValueFactory(new PropertyValueFactory<>("argumentName"));
        argumentMinValue.setCellValueFactory(new PropertyValueFactory<>("origin"));
        argumentMaxValue.setCellValueFactory(new PropertyValueFactory<>("bound"));

        argumentMinValue.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        argumentMinValue.setOnEditCommit(t ->
        {
            Double newValue = t.getNewValue();
            if (newValue > argumentMaxValue.getCellData(t.getRowValue()))
            {
                showAlert(Alert.AlertType.ERROR, "Blad", "Mininum argumentu wieksze od maximum!");
                t.getTableView().refresh();
            }
            else
            {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setOrigin(t.getNewValue());
            }
        });

        argumentMaxValue.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        argumentMaxValue.setOnEditCommit(t ->
        {
            Double newValue = t.getNewValue();
            if (newValue < argumentMinValue.getCellData(t.getRowValue()))
            {
                showAlert(Alert.AlertType.ERROR, "Blad", "Maximum argumentu mniejsze od minimum!");
                t.getTableView().refresh();
            }
            else
            {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setBound(t.getNewValue());
            }
        });

        // Solutions table view
        solutionValue.setCellValueFactory(new PropertyValueFactory<>("value"));
        solutionIteration.setCellValueFactory(new PropertyValueFactory<>("iterationNumber"));

<<<<<<< HEAD
        SolutionValue.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        SolutionIteration.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        plot = new Plot();
        pane.getChildren().add(plot.getImageView());

=======
        solutionValue.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        solutionIteration.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
>>>>>>> 52ae50572a7149e416db5d06a3bc6f1aead591e2
    }

    @FXML
    void startHarmonySearcher(ActionEvent event)
    {
        if (this.function == null)
        {
            showAlert(Alert.AlertType.ERROR, "Brak funkcji", "Nie wprowadzono poprawnej funkcji.");
            return;
        }

        int HMS = harmonyMemorySizeSpinner.getValue();
        int iterCount = iterationCountSpinner.getValue();

        double HMCR = harmonyMemoryConsiderationRatioSpinner.getValue();
        double PAR = pitchAdjustingRatioSpinner.getValue();

        harmonySearcher = new HarmonySearcherGui(this.function, HMS, iterCount, HMCR, PAR, argumentLimits);

<<<<<<< HEAD
        SolutionTableView.setItems(harmonySearcher.getBestSolutions());
        plot.setParameters(this.function,argumentLimits);
        pane.getChildren().add(plot.getImageView());

=======
        solutionTableView.setItems(harmonySearcher.getBestSolutions());
>>>>>>> 52ae50572a7149e416db5d06a3bc6f1aead591e2
        leftStatusLabel.setText("Busy");

        harmonySearcher.searchForHarmony();

        showAlert(Alert.AlertType.INFORMATION, "Koniec dzialania", "Znaleziono rozwiazanie:\n" + solutionTableView.getItems().get(0).toString());

        leftStatusLabel.setText("Waiting for input");
    }

    private void showAlert(Alert.AlertType alertType, String alertTitle, String alertContent)
    {
        Alert alert = new Alert(alertType);
        alert.setTitle(alertTitle);
        alert.setContentText(alertContent);
        alert.showAndWait();
    }

    @FXML
    void tryValidateFunctionString(ActionEvent event)
    {
        String functionString = functionComboBox.getValue();
        function = functionValidator.validateFunctionString(functionString);

        if (function == null)
        {
            showAlert(Alert.AlertType.ERROR, "Bład walidacji", "Funkcja nie jest poprawnie zdefiniowana.");
            return;
        }

        if (!function.checkSyntax())
        {
            showAlert(Alert.AlertType.ERROR, "Bład walidacji", "Funkcja nie jest poprawnie zdefiniowana: " + function.getErrorMessage());
            return;
        }

        showArgumentLimitsTableView();
    }

    private void showArgumentLimitsTableView()
    {
        argumentLimitsTableView.getItems().clear();
        if (solutionTableView.getColumns().size() > 2)
        {
            resetSolutionTableView();
        }

        for (int i = 0; i < function.getArgumentsNumber(); i++)
        {
            argumentLimits.add(new ArgumentLimit(function.getArgument(i).getArgumentName()));
            addArgumentColumnToSolutionTableView(i);
        }

        argumentLimitsTableView.setItems(argumentLimits);
    }

    private void resetSolutionTableView()
    {
        solutionTableView.getItems().clear();
        solutionTableView.getColumns().clear();
        TableColumn<SolutionGui, Integer> solutionIterationColumn = new TableColumn<>("Iteracja");
        solutionIterationColumn.setCellValueFactory(new PropertyValueFactory<>("iterationNumber"));
        solutionIterationColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        solutionTableView.getColumns().add(solutionIterationColumn);

        TableColumn<SolutionGui, Double> solutionValueColumn = new TableColumn<>("f(x)");
        solutionValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        solutionValueColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        solutionTableView.getColumns().add(solutionValueColumn);
    }

    private void addArgumentColumnToSolutionTableView(int argumentIndex)
    {
        TableColumn<SolutionGui, Double> solutionArgumentColumn = new TableColumn<>(function.getArgument(argumentIndex).getArgumentName());
        solutionTableView.getColumns().add(solutionArgumentColumn);
        final int fixedArgumentIndex = argumentIndex;
        solutionArgumentColumn.setCellValueFactory(cellData -> cellData.getValue().getArgument(fixedArgumentIndex).asObject());
        solutionArgumentColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
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
