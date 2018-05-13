package com.blag.harmonysearch.gui;

import com.blag.harmonysearch.contants.HarmonySearchConstants;
import com.blag.harmonysearch.core.ArgumentLimit;
import com.blag.harmonysearch.core.Solution;
import com.blag.harmonysearch.helpers.BoundedTreeSet;
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
import org.jzy3d.plot3d.primitives.Shape;
import org.jzy3d.plot3d.primitives.vbo.builders.VBOBuilderListCoord3d;
import org.jzy3d.plot3d.primitives.vbo.drawable.ScatterVBO;
import org.jzy3d.plot3d.rendering.canvas.Quality;
import org.mariuszgromada.math.mxparser.Function;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Plot
{
    private Mapper mapper;
    private JavaFXChartFactory factory;
    private double origin;
    private double bound;
    private BoundedTreeSet<Solution> solutions;
    private Shape surface;
    private AWTChart chart;
    private ImageView imageView;
    private Function function;

    public Plot()
    {
        this.function = new Function("0", "0", "x1");
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
    }


    public ImageView getImageView()
    {
        Quality quality = Quality.Advanced;
        quality.setSmoothPolygon(true);
        quality.setAnimated(true);

        AWTChart chart = (AWTChart) factory.newChart(quality, "offscreen");
        chart.getScene().getGraph().add(this.getSurface());
        //chart.getScene().getGraph().add(this.getDemoChartVBO());
        imageView = factory.bindImageView(chart);
        return imageView;
    }

    public void setParameters(Function function, ObservableList<ArgumentLimit> argumentLimits)
    {
        if (argumentLimits.size() <= 2)
        {
            this.function = function;

            for (int i = 0; i < argumentLimits.size(); i++)
            {
                this.origin = Math.min(this.origin, argumentLimits.get(i).getOrigin());
                this.bound = Math.max(this.bound, argumentLimits.get(i).getBound());
            }
        }
        else
        {
            this.function = new Function("0", "0", "x1");
        }
    }

    private Shape getSurface()
    {
        int steps = (int) (this.bound - this.origin) * 5;
        surface = Builder.buildOrthonormal(this.mapper, new Range((float) origin, (float) bound), steps);
        surface.setColorMapper(new ColorMapper(new ColorMapRainbow(), surface.getBounds().getZmin(), surface.getBounds().getZmax(), new Color(1, 1, 1, .5f)));
        surface.setFaceDisplayed(true);
        surface.setWireframeDisplayed(false);
        return surface;
    }

    private ScatterVBO getDemoChartVBO()
    {

        int size = 100;
        System.out.println(size);
        List<Coord3d> coords = new ArrayList<Coord3d>(size);
        for (int i = 0; i < size; i++)
        {
            coords.add(new Coord3d(i, i, i));
        }
        return new ScatterVBO(new VBOBuilderListCoord3d(coords));
    }
}