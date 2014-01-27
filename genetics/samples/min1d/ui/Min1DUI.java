package group2.genetics.samples.min1d.ui;

import com.panayotis.gnuplot.dataset.DataSet;
import com.panayotis.gnuplot.plot.DataSetPlot;
import com.panayotis.gnuplot.style.PlotStyle;
import com.panayotis.gnuplot.style.Style;
import com.panayotis.gnuplot.swing.JPlot;
import group2.genetics.events.PopulationEvent;
import group2.genetics.inhabitants.Population;
import group2.genetics.samples.min1d.Min1DBeing;
import group2.genetics.samples.min1d.Min1DProblem;
import group2.genetics.ui.JView;
import javax.swing.JComponent;

public class Min1DUI extends JPlot implements JView<PopulationEvent> {

    private PlotStyle plotStyle;
    private DataSetPlot generation;
    private DataSetPlot best;
    private Population pop;
    
    public Min1DUI() {
        this(Min1DProblem.getLowerBound()-1, Min1DProblem.getUpperBound()+1);
    }

    public Min1DUI(int min, int max) {
        super();
        initGraphs(min, max);
        initStyles();
    }

    private void initGraphs(int min, int max) {
        this.getJavaPlot().getAxis("x").setBoundaries(min-1, max+1);
        this.getJavaPlot().getAxis("y").setBoundaries(min - 2, max + 5);
        this.generation = new DataSetPlot();
        this.best = new DataSetPlot();
        this.getJavaPlot().addPlot(Min1DProblem.getFExpression().replace("^", "**"));
        this.getJavaPlot().addPlot(this.best);
        this.getJavaPlot().addPlot(this.generation);
    }

    private void initStyles() {
        this.plotStyle = new PlotStyle();
        this.plotStyle.setStyle(Style.POINTS);
        this.plotStyle.setPointSize(2);
    }

    private void drawAll() {
        int popSize = this.pop.size();
        if(popSize == 0) {
            return;
        }
        Min1DBeing b;
        double[][] e = new double[popSize][2];
        double maxEval = -1;
        double[][] bestPoint = new double[1][2];
        for (int i = 0; i < popSize; i++) {
            b = (Min1DBeing) this.pop.get(i);
            e[i][0] = b.getAbscissa();
            e[i][1] = Min1DProblem.f(e[i][0]);
            if(maxEval < b.evaluate()) {
                bestPoint[0][0] = e[i][0];
                bestPoint[0][1] = e[i][1];
                maxEval = b.evaluate();
            }
        }
        
        this.best = new DataSetPlot(bestPoint);
        this.best.setPlotStyle(this.plotStyle);
        this.generation = new DataSetPlot(e);
        this.addPlot(2, this.generation, "Being");
        this.addPlot(1, this.best, "Best found @x="+bestPoint[0][0]);
        this.plot();
    }

    private void addPlot(int index, DataSetPlot dataPlot, String title) {
        dataPlot.setTitle(title);
        this.getJavaPlot().getPlots().remove(index);
        this.getJavaPlot().addPlot(dataPlot);
    }
    
    @Override
    public void refresh(PopulationEvent ev) {
        this.pop = ev.getPopulation();
        this.repaint();
        drawAll();
    }

    @Override
    public JComponent toJComponent() {
        return this;
    }
}
