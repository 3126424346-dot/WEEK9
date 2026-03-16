import java.util.List;


public class Main {
    public static void main(String[] args) {
        ChampionshipManager manager = ChampionshipManager.getInstance();

        RallyCar gravelToyota = new GravelCar("Toyota", "Yaris Rally1", 280, 20.5);
        RallyCar gravelHyundai = new GravelCar("Hyundai", "i20 N Rally1", 285, 19.0);
        RallyCar asphaltFord = new AsphaltCar("Ford", "Puma Rally1", 290, 18.0);
        RallyCar asphaltToyota = new AsphaltCar("Toyota", "Yaris Rally1", 290, 18.0);

        Driver ogier = new Driver("Sebastien Ogier", "France", gravelToyota);
        Driver rovanpera = new Driver("Kalle Rovanpera", "Finland", asphaltToyota);
        Driver tanak = new Driver("Ott Tanak", "Estonia", gravelHyundai);
        Driver neuville = new Driver("Thierry Neuville", "Belgium", asphaltFord);

        manager.registerDriver(ogier);
        manager.registerDriver(rovanpera);
        manager.registerDriver(tanak);
        manager.registerDriver(neuville);

        RallyRaceResult finlandRally = new RallyRaceResult("Rally Finland", "Jyvaskyla");
        finlandRally.recordResult(ogier, 1, 25);
        finlandRally.recordResult(tanak, 2, 18);
        finlandRally.recordResult(rovanpera, 3, 15);
        finlandRally.recordResult(neuville, 4, 12);
        manager.addRaceResult(finlandRally);

        ogier.setCar(asphaltToyota);
        rovanpera.setCar(asphaltFord);
        tanak.setCar(gravelToyota);
        neuville.setCar(asphaltToyota);

        RallyRaceResult monteCarlo = new RallyRaceResult("Monte Carlo Rally", "Monaco");
        monteCarlo.recordResult(rovanpera, 1, 25);
        monteCarlo.recordResult(neuville, 2, 18);
        monteCarlo.recordResult(ogier, 3, 15);
        monteCarlo.recordResult(tanak, 4, 12);
        manager.addRaceResult(monteCarlo);

        List<Driver> standings = ChampionshipManager.getChampionshipStandings();
        for (int i = 0; i < standings.size(); i++) {
            System.out.println((i + 1) + ". " + standings.get(i));
        }

        System.out.println("===== CHAMPIONSHIP LEADER =====");
        Driver leader = ChampionshipManager.getLeadingDriver();
        if (leader != null) {
            System.out.println(leader.getName() + " with " + leader.getPoints() + " points");
        }

        System.out.println("===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + Driver.getTotalDrivers());
        System.out.println("Total Races: " + ChampionshipStatistics.countTotalRacesHeld());
        System.out.printf("Average Points Per Driver: %.2f%n",
                ChampionshipStatistics.calculateAveragePointsPerDriver(manager.getDrivers()));
        System.out.println("Most Successful Country: "
                + ChampionshipStatistics.findMostSuccessfulCountry(manager.getDrivers()));
        System.out.println("Total Championship Points: "
                + ChampionshipManager.getTotalChampionshipPoints());

        System.out.println("===== RACE RESULTS =====");
        for (RallyRaceResult race : manager.getRaces()) {
            race.printResults();
        }

        System.out.println("===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: " + gravelToyota.calculatePerformance());
        System.out.println("Asphalt Car Performance: " + asphaltFord.calculatePerformance());
    }
}
