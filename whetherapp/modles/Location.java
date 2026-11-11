package modles;

public class Location {
    private String name;
    private String region;
    private String country;
    private String localTime;

    public Location(String name, String region, String country, String localTime) {
        this.name = name;
        this.region = region;
        this.country = country;
        this.localTime = localTime;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public String getLocalTime() {
        return localTime;
    }

}
