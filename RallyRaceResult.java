import java.util.LinkedHashMap;
import java.util.Map;


public class RallyRaceResult implements RaceResult {
    private String raceName;
    private String location;
    private Map<Driver, Integer> results;

    public RallyRaceResult(String raceName, String location) {
        this.raceName = raceName;
        this.location = location;
        this.results = new LinkedHashMap<>();
    }

    public String getRaceName() {
        return raceName;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public void recordResult(Driver driver, int position, int points) {
        results.put(driver, points);
        driver.addPoints(points);
    }

    @Override
    public Map<Driver, Integer> getResults() {
        return results;
    }

    public void printResults() {
        System.out.println("Race: " + raceName + " (" + location + ")");
        int position = 1;
        for (Map.Entry<Driver, Integer> entry : results.entrySet()) {
            System.out.println(" Position " + position + ": "
                    + entry.getKey().getName() + " - "
                    + entry.getValue() + " points");
            position++;
        }
    }
}
