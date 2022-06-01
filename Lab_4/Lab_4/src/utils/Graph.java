package utils;

import functions.Function;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.*;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;
import org.knowm.xchart.style.theme.GGPlot2Theme;

import java.awt.*;

public class Graph {
    static int W = 1000;
    static int H = 600;

    public static void draw(Function f, double[] xPoint, double[] yPoint, double[] xLine, double[] yLine,
                            double[] newXPoint, double[] newYPoint) {
        XYChart chart = new XYChartBuilder()
                .width(W)
                .height(H)
                .title("Approximation")
                .xAxisTitle("X")
                .yAxisTitle("Y")
                .build();

        XYSeries pointsDraw = chart.addSeries("Points", xPoint, yPoint);
        pointsDraw.setMarkerColor(Color.RED);
        pointsDraw.setLineStyle(SeriesLines.NONE);

        XYSeries ApPoint = chart.addSeries("PolyNewton", newXPoint, newYPoint);
        ApPoint.setMarker(SeriesMarkers.NONE);
        ApPoint.setLineStyle(SeriesLines.SOLID);
        ApPoint.setLineColor(Color.BLUE);

        XYSeries functionDraw = chart.addSeries(f.showFunction(), xLine, yLine);
        functionDraw.setMarker(SeriesMarkers.NONE);
        functionDraw.setLineStyle(SeriesLines.SOLID);
        functionDraw.setLineColor(Color.RED);

        chart.getStyler().setTheme(new GGPlot2Theme());
        new SwingWrapper(chart).displayChart();
    }

}
