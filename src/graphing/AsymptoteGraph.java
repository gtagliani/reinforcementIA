package graphing;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;

public class AsymptoteGraph {

    public static void main(String[] args) {
        // Create a dataset for the function
        XYSeries functionSeries = new XYSeries("f(x) = (2x + 1)/(x + 3)");

        // Define the function
        for (double x = -10; x <= 10; x += 0.1) {
            if (x != -3) { // Avoid division by zero
                double y = (2 * x + 1) / (x + 3);
                functionSeries.add(x, y);
            }
        }

        // Create a dataset for the horizontal asymptote (y = 2)
        XYSeries horizontalAsymptoteSeries = new XYSeries("Horizontal Asymptote (y = 2)");
        horizontalAsymptoteSeries.add(-10, 2);
        horizontalAsymptoteSeries.add(10, 2);

        // Create a dataset for the vertical asymptote (x = -3)
        XYSeries verticalAsymptoteSeries = new XYSeries("Vertical Asymptote (x = -3)");
        verticalAsymptoteSeries.add(-3, -100); // Extend below the graph
        verticalAsymptoteSeries.add(-3, 100);  // Extend above the graph

        // Add all series to a dataset
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(functionSeries);
        dataset.addSeries(horizontalAsymptoteSeries);
        dataset.addSeries(verticalAsymptoteSeries);

        // Create the chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Graph of f(x) with Asymptotes", // Chart title
                "x",                             // X-axis label
                "f(x)",                          // Y-axis label
                dataset,                         // Dataset
                PlotOrientation.VERTICAL,        // Plot orientation
                true,                            // Show legend
                true,                            // Show tooltips
                false                            // Show URLs
        );

        // Customize the plot
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();

        // Set colors and styles for the series
        renderer.setSeriesPaint(0, Color.BLUE);   // Function (blue)
        renderer.setSeriesPaint(1, Color.GREEN);  // Horizontal asymptote (green)
        renderer.setSeriesPaint(2, Color.RED);    // Vertical asymptote (red)

        // Set dashed lines for asymptotes
        renderer.setSeriesStroke(1, new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, new float[]{5.0f, 5.0f}, 0.0f)); // Dashed green line
        renderer.setSeriesStroke(2, new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, new float[]{5.0f, 5.0f}, 0.0f)); // Dashed red line

        // Display the chart in a frame
        ChartFrame frame = new ChartFrame("Asymptote Graph", chart);
        frame.pack();
        frame.setVisible(true);
    }
}