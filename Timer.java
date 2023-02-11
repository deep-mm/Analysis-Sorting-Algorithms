/**
 * for timers to be used for profiling the amount of time used by
 * different parts of a program
 */

public class Timer {
    /**
     * name of this timer, used for printing
     */
    String name;
  
    /**
     * cumulative time in milliseconds
     */
    long cumulativeTime = 0;

    /**
     * time of checkpoint, i.e., time of last start() call
     */
    long startTime;

    public Timer(String name) {
        this.name = name;
        cumulativeTime = 0;
    }
  
    /**
     * @return cumulative time in seconds
     */
    public double getTotalTime() {
        return cumulativeTime / 1000.0;
    }

    /**
     * starts counting time at this point
     */
    public void start() {
        startTime = System.currentTimeMillis();
    }

    /**
     * adds the time since the last start to the cumulative time
     */
    public void stop() {
        cumulativeTime += System.currentTimeMillis() - startTime;
    }

    /**
     * @return String representation of the timer, which is [name] [tab] [time]
     */
    public String toString() {
        return String.format("%s\t%8.1f", name, getTotalTime());
    }
}

//  [Last modified: 2021 02 25 at 14:56:38 GMT]