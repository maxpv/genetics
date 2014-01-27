package group2.genetics.engine;

import group2.genetics.inhabitants.Population;
import group2.genetics.miscellaneous.ArrayUtils;
import group2.genetics.miscellaneous.ProblemInitializable;
import group2.genetics.miscellaneous.Resetable;
import group2.genetics.operators.crossover.CrossOver;
import group2.genetics.operators.mutation.Mutation;
import group2.genetics.operators.selection.Rank;
import group2.genetics.operators.selection.Selection;
import group2.genetics.operators.selection.Tournament;
import group2.genetics.operators.selection.WheelOfFortune;
import group2.genetics.operators.stop.InfinityGrowth;
import group2.genetics.operators.stop.Stop;
import group2.genetics.operators.stop.StopGrowth;
import group2.genetics.operators.stop.StopIterations;
import group2.genetics.problem.BeingProcess;
import group2.genetics.problem.PopulationProcess;
import group2.genetics.problem.Problem;

/*
 * La configuration contient les données génériques du système
 * Elle définit les valeurs par défaut du processus de selection
 * Elle génère la première génération à partir de la méthode de création fournie dans le problème
 */
public class Configuration implements ProblemInitializable, Resetable {

    private static Configuration INSTANCE;
    private int populationSize = 50;
    private int stopIterations = 10000;
    private Problem problem;
    private Selection selection = new Selection();
    private Class[] selections = {WheelOfFortune.class,Rank.class,Tournament.class};
    private Mutation mutation = new Mutation();
    private Class[] mutations = {};
    private CrossOver crossOver = new CrossOver();
    private Class[] crossOvers = {};
    private Stop stop = new Stop();
    private Class[] stops = {InfinityGrowth.class, StopIterations.class};

    public static Configuration getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Configuration();
        }
        return INSTANCE;
    }

    private Configuration() {
    }

    @Override
    public void initialize(Problem p) {
        this.problem = p;

        this.selection.initialize(p);
        if (p.getSelectProcess() != null) {
            this.selections = ArrayUtils.add(selections, p.getSelectProcess().getClass());
        }

        this.mutation.initialize(p);
        if (p.getMutateProcess() != null) {
            this.mutations = ArrayUtils.add(mutations, p.getMutateProcess().getClass());
        }

        this.crossOver.initialize(p);
        if (p.getCrossProcess() != null) {
            this.crossOvers = ArrayUtils.add(crossOvers, p.getCrossProcess().getClass());
        }

        this.stop.initialize(p);
        if (p.getSelectProcess() != null) {
            this.stops = ArrayUtils.add(stops, p.getSelectProcess().getClass());
        }
    }
    
    public void reset() {
        this.selection.reset();
        this.mutation.reset();
        this.crossOver.reset();
        this.stop.reset();
    }

    public Population getFirstGeneration() throws UnsupportedOperationException {
        if (this.problem == null) {
            throw new UnsupportedOperationException("No problem is defined");
        }

        Population population = new Population(populationSize);
        for (int i = 0; i < populationSize; i++) {
            population.add(this.problem.getBeing());
        }
        return population;
    }

    public Selection getSelection() {
        return this.selection;
    }

    public void setSelection(Selection selection) {
        this.selection = selection;
    }
    
    public void setSelectionProcess(Class c) {
        try {
            PopulationProcess select = (PopulationProcess) c.newInstance();
            this.getSelection().setProcess(select);
        } catch (InstantiationException | IllegalAccessException ex) {
        }
    }

    public Class[] getAvailableSelectionProcesses() {
        return this.selections;
    }

    public Mutation getMutation() {
        return this.mutation;
    }

    public void setMutation(Mutation mutation) {
        this.mutation = mutation;
    }
    
    public void setMutationProcess(Class c) {
        try {
            BeingProcess mut = (BeingProcess) c.newInstance();
            this.getMutation().setProcess(mut);
        } catch (InstantiationException | IllegalAccessException ex) {
        }
    }

    public Class[] getAvailableMutationProcesses() {
        return this.mutations;
    }

    public CrossOver getCrossOver() {
        return this.crossOver;
    }

    public void setCrossOver(CrossOver crossOver) {
        this.crossOver = crossOver;
    }
    
    public void setCrossOverProcess(Class c) {
        try {
            PopulationProcess cross = (PopulationProcess) c.newInstance();
            this.getCrossOver().setProcess(cross);
        } catch (InstantiationException | IllegalAccessException ex) {
        }
    }

    public Class[] getAvailableCrossOverProcesses() {
        return this.crossOvers;
    }

    public Stop getStop() {
        return this.stop;
    }

    public void setStop(Stop stop) {
        this.stop = stop;
    }
    
    public void setStopProcess(Class c) {
        try {
            StopGrowth stop = (StopGrowth) c.newInstance();
            this.getStop().setProcess(stop);
        } catch (InstantiationException | IllegalAccessException ex) {
        }
    }

    public Class[] getAvailableStopProcesses() {
        return this.stops;
    }

    public int getPopulationSize() {
        return this.populationSize;
    }

    public void setPopulationSize(int size) {
        if (size > 0) {
            this.populationSize = size;
        }
    }

    public int getCrossOverProbability() {
        return this.crossOver.getProbability();
    }

    public void setCrossOverProbability(int prob) {
        this.crossOver.setProbability(prob);
    }

    public int getMutationProbability() {
        return this.mutation.getProbability();
    }

    public void setMutationProbability(int prob) {
        this.mutation.setProbability(prob);
    }

    public int getStopIterations() {
        return stopIterations;
    }

    public void setStopIterations(int stopIterations) {
        if (stopIterations > 0) {
            this.stopIterations = stopIterations;
        }
    }
    
    public Class[] getViews() {
        if (this.problem != null) {
            return this.problem.getViews();
        } else {
            return new Class[0];
        }
    }
}