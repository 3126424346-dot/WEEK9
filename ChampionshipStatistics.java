import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class ChampionshipStatistics {

    private ChampionshipStatistics() {
    }

    public static double calculateAveragePointsPerDriver(List<Driver> drivers) {
        if (drivers == null || drivers.isEmpty()) {
            return 0.0;
        }

        int totalPoints = 0;
        for (Driver driver : drivers) {
            totalPoints += driver.getPoints();
        }
        return (double) totalPoints / drivers.size();
    }

    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        if (drivers == null || drivers.isEmpty()) {
            return "N/A";
        }

        Map<String, Integer> countryPoints = new HashMap<>();
        for (Driver driver : drivers) {
            countryPoints.put(driver.getCountry(),
                    countryPoints.getOrDefault(driver.getCountry(), 0) + driver.getPoints());
        }

        String bestCountry = "N/A";
        int maxPoints = -1;
        for (Map.Entry<String, Integer> entry : countryPoints.entrySet()) {
            if (entry.getValue() > maxPoints) {
                bestCountry = entry.getKey();
                maxPoints = entry.getValue();
            }
        }
        return bestCountry;
    }

    public static int countTotalRacesHeld() {
        return ChampionshipManager.getTotalRaces();
    }
}
