
public class Driver {
    private static int totalDrivers = 0;

    private String name;
    private String country;
    private int points;
    private RallyCar car;

    public Driver(String name, String country, RallyCar car) {
        this.name = name;
        this.country = country;
        this.car = car;
        this.points = 0;
        totalDrivers++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPoints() {
        return points;
    }

    public RallyCar getCar() {
        return car;
    }

    public void setCar(RallyCar car) {
        this.car = car;
    }

    public void addPoints(int points) {
        if (points > 0) {
            this.points += points;
        }
    }

    public static int getTotalDrivers() {
        return totalDrivers;
    }

    @Override
    public String toString() {
        return name + " (" + country + "): " + points + " points";
    }
}
