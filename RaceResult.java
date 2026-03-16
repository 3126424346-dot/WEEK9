import java.util.Map;

public interface RaceResult {
    void recordResult(Driver driver, int position, int points);
    Map<Driver, Integer> getResults();
}
