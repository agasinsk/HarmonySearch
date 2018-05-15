package com.blag.harmonysearch.gui;

import com.blag.harmonysearch.contants.HarmonySearchConstants;
import com.blag.harmonysearch.core.ArgumentLimit;
import com.blag.harmonysearch.core.Solution;
import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;
import lombok.Getter;
import lombok.Setter;
import org.jzy3d.chart.AWTChart;
import org.jzy3d.colors.Color;
import org.jzy3d.colors.ColorMapper;
import org.jzy3d.colors.colormaps.ColorMapRainbow;
import org.jzy3d.javafx.JavaFXChartFactory;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.maths.Range;
import org.jzy3d.plot3d.builder.Builder;
import org.jzy3d.plot3d.builder.Mapper;
import org.jzy3d.plot3d.primitives.Scatter;
import org.jzy3d.plot3d.primitives.Shape;
import org.jzy3d.plot3d.rendering.canvas.Quality;
import org.mariuszgromada.math.mxparser.Function;

import java.util.List;

@Getter
@Setter
public class Plot
{
    private Mapper mapper;
    private JavaFXChartFactory factory;
    private double origin;
    private double bound;
    private Shape shape;
    private Scatter scatter;
    private AWTChart chart;
    private ImageView imageView;
    private Function function;
    private ObservableList<SolutionGui> observableList;

    public Plot()
    {
        this.function = null;
        this.mapper = new Mapper()
        {
            @Override
            public double f(double x1, double x2)
            {
                return function.calculate(x1, x2);
            }
        };
        this.factory = new JavaFXChartFactory();
        this.origin = -HarmonySearchConstants.DEFAULT_ARGUMENT_LIMIT;
        this.bound = HarmonySearchConstants.DEFAULT_ARGUMENT_LIMIT;
        this.scatter = new Scatter();
        this.observableList = null;
        shape = new Shape();
    }

    public ImageView getImageView()
    {
        Quality quality = Quality.Advanced;
        quality.setSmoothPolygon(true);
        quality.setAnimated(true);

        AWTChart chart = (AWTChart) factory.newChart(quality, "offscreen");
        chart.getScene().getGraph().add(this.getShape());
        //chart.getScene().getGraph().add(this.getScatter());
        chart.getScene().getGraph().add(this.scatter);
        imageView = factory.bindImageView(chart);
        return imageView;
    }

    public void setParameters(Function function, List<ArgumentLimit> argumentLimits)
    {
        if (argumentLimits.size() <= 2)
        {
            this.function = function;
            this.origin=0;
            this.bound=0;
            for (ArgumentLimit argumentLimit : argumentLimits)
            {
                this.origin = Math.min(this.origin, argumentLimit.getOrigin());
                this.bound = Math.max(this.bound, argumentLimit.getBound());
            }
        }
        else
        {
            this.function = new Function("0", "0", "x1");
        }
    }

    private Shape getShape()
    {
        int steps = 100;
        shape = Builder.buildOrthonormal(this.mapper, new Range((float) origin, (float) bound), steps);
        shape.setColorMapper(new ColorMapper(new ColorMapRainbow(), shape.getBounds().getZmin(), shape.getBounds().getZmax(), new Color(1, 1, 1, .5f)));
        shape.setFaceDisplayed(true);
        shape.setWireframeDisplayed(false);
        return shape;
    }

    private Scatter getScatter()
    {
        if (observableList == null)
            return this.scatter;

        int size = observableList.size();
        float x;
        float y;
        float z;
        Coord3d[] coordinates = new Coord3d[size];
        for (int i = 0; i < size; i++)
        {
            SolutionGui solutionGui = observableList.get(i);
            x = solutionGui.getArgument(1).floatValue();
            y = solutionGui.getArgument(2).floatValue();
            z = (float) solutionGui.getValue();
            coordinates[i] = new Coord3d(x, y, z);
        }

        scatter.setData(coordinates);
        scatter.setWidth(5);
        return this.scatter;
    }

    public void drawPoint(Solution currentBestSolution)
    {
        float x = (float) currentBestSolution.getArguments()[0];
        float y = (float) currentBestSolution.getArguments()[1];
        float z = (float) currentBestSolution.getValue();
        Coord3d[] coordinates = new Coord3d[]{
                new Coord3d(x, y, z)
        };

        scatter.setData(coordinates);
        scatter.setWidth(5);
    }
}