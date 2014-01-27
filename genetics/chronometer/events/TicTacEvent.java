package group2.genetics.chronometer.events;

import group2.genetics.events.Event;

/**
 *
 * @author Corentin Haidon <corentin.haidon@gmail.com> / Maxence Prevost
 * <maxence.prevost@isen-lille.fr>
 */

public class TicTacEvent extends Event {
   protected long time;
    
    public TicTacEvent(long i) {
        super(String.valueOf(i));
        this.time = i;
    }
    
    public int getSeconds() {
        return (int) this.time / 1000;
    }
    
    public float getDeciSeconds() {
        return (float) this.time / 1000;
    }
}
