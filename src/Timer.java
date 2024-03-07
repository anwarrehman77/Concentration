package src;
import org.apache.commons.lang3.time.StopWatch;
public class Timer {
    private StopWatch stopwatch;

    public Timer() {
        stopwatch = new StopWatch();
        stopwatch.start();
    }

    public long getTime() {
        return stopwatch.getTime();
    }
    public void stopTime() {
        stopwatch.stop();
    } 
}
