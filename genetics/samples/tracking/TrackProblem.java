package group2.genetics.samples.tracking;

import group2.genetics.inhabitants.Being;
import group2.genetics.operators.stop.StopGrowth;
import group2.genetics.problem.BeingProcess;
import group2.genetics.problem.PopulationProcess;
import group2.genetics.problem.Problem;
import group2.genetics.samples.tracking.ui.TrackUI;
import group2.genetics.samples.tracking.ui.TracksLayer;
import group2.genetics.samples.tracking.ui.VideoFiles;
import java.awt.Dimension;
import java.awt.Point;


public class TrackProblem implements Problem {
    private final int CROSS = 82;
    private final PopulationProcess CROSSP = new TrackCross();
    private final int MUTATE = 20;
    private final BeingProcess MUTATEP = new TrackMutate();
    private final StopGrowth STOP = null;
    private final Class[] VIEWS = { TrackUI.class };
    
    public static final VideoFiles videoFile = VideoFiles.ANT_MAZE;
    public static Dimension dim = videoFile.getDim();
    private static Point refPoint = new Point(dim.width/2, dim.height/2);
    
    private static double glueCoeff = 0.6;
    private static int colorDelay = 13;
    
    @Override
    public int getCrossProbability() {
        return this.CROSS;
    }

    public static int getColorDelay() {
        return colorDelay;
    }
    
    public static double getGlueCoeff() {
        return glueCoeff;
    }
    
    public static Point getRefPoint() {
        return refPoint;
    }
    
    public static void setRefPoint(Point p) {
        refPoint.x = p.x;
        refPoint.y = p.y;
    }
    
    public static boolean isNear(int x, int y) {
        return TracksLayer.isNear(x, y);
    }
    
    @Override
    public PopulationProcess getCrossProcess() {
        return this.CROSSP;
    }

    @Override
    public int getMutateProbability() {
        return this.MUTATE;
    }

    @Override
    public BeingProcess getMutateProcess() {
        return this.MUTATEP;
    }

    @Override
    public StopGrowth getStopGrowth() {
        return this.STOP;
    }

    @Override
    public PopulationProcess getSelectProcess() {
        return null;
    }

    @Override
    public Class[] getViews() {
        return VIEWS;
    }

    @Override
    public Being getBeing() {
        return new TrackBeing();
    }
}
