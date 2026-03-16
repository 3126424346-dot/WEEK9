import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ChampionshipManager {
    private static ChampionshipManager instance;
    private static int totalRaces = 0;

    private List<Driver> drivers;
    private List<RallyRaceResult> races;

    private ChampionshipManager() {
        drivers = new ArrayList<>();
        races = new ArrayList<>();
    }

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        if (driver != null) {
            drivers.add(driver);
        }
    }

    public void addRaceResult(RallyRaceResult raceResult) {
        if (raceResult != null) {
            races.add(raceResult);
            totalRaces++;
        }
    }

    public List<Driver> getDrivers() {
        return new ArrayList<>(drivers);
    }

    public List<RallyRaceResult> getRaces() {
        return new ArrayList<>(races);
    }

    public static int getTotalRaces() {
        return totalRaces;
    }

    public static Driver getLeadingDriver() {
        ChampionshipManager manager = getInstance();
        return manager.drivers.stream()
                .max(Comparator.comparingInt(Driver::getPoints))
                .orElse(null);
    }

    public static int getTotalChampionshipPoints() {
        ChampionshipManager manager = getInstance();
        return manager.drivers.stream()
                .mapToInt(Driver::getPoints)
                .sum();
    }

    public static List<Driver> getChampionshipStandings() {
        ChampionshipManager manager = getInstance();
        List<Driver> standings = new ArrayList<>(manager.drivers);
        standings.sort((d1, d2) -> Integer.compare(d2.getPoints(), d1.getPoints()));
        return standings;
    }
}
